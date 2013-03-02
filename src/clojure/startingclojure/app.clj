(ns startingclojure.app
  (:use [clojure.pprint] (compojure handler
                                    [core :only (GET POST defroutes)]) 
        
        [datomic.api :only [q db] :as d])
  (:require
    compojure.route
    [ring.adapter.jetty :as jetty]
    [ring.util.response :as response]
    [net.cgrand.enlive-html :as en]
    ))
(def uri "datomic:mem://url")
;(def server (jetty/run-jetty #'app {:port 8080 :join? false}))
(defonce conn (d/connect uri))
(defonce counter (atom 999))
(defonce urls (atom {}))
(defn shorten
  [url]
  (let [id (swap! counter inc)
        id (Long/toString id 36)]
    (swap! urls assoc id url)
    id))




(en/deftemplate homepage
  (en/xml-resource "homepage.html")
  [request]
  [:#listing :li] (en/clone-for [[id url] @urls]
	                  [:a] (comp 
                          
                          (en/content (format "%s : %s" id url)) 
                          (en/set-attr :href (str \/ id)))))

(defn redirect
  [id]
  (response/redirect (@urls id)))

(defroutes app*
  (compojure.route/resources "/")
  (GET "/" request (homepage request))
  (POST "/shorten" request 
        #_(with-out-str (pprint request))
        (let [id (shorten (-> request :params :url))]
          (response/redirect "/")))
  (GET "/:id" [id] (redirect id)))

(def app (compojure.handler/site app*))