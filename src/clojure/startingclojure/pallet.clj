(ns startingclojure.pallet
  (:require
    [pallet.actions :as actions]
     [pallet.api :as api]
     [pallet.configure :as configure]
     [pallet.crate.automated-admin-user :as admin-user]
     [pallet.phase :as phase]
     
     )
  (:use pallet.crate.java pallet.crate.datomic))

(api/converge
  (api/group-spec "mygroup"
   :extends [(pallet.crate.java/java {}) (pallet.crate.datomic/datomic {})]
   :count 0
   :node-spec (api/node-spec
               :image {:os-family :ubuntu :image-id "us-east-1/ami-3c994355"}
               )
   :phases {:bootstrap ( api/plan-fn ( admin-user/automated-admin-user))
            ;:configure (api/plan-fn (package "curl"))
            })
  :compute (configure/compute-service :aws))

(api/converge
   (api/group-spec "mygroup"
                   :count 0
                   :node-spec (api/node-spec
                               :image {:os-family :ubuntu
                                       :os-64-bit true}
                               :hardware {:hardware-id "m1.large"}
                               ;; Sao Paulo is the greenest AWS Location
                               :location {:location-id "sa-east-1b"}
                               ;; Oregon is the greenest cheap location (same price as VA)
                               ;;:location {:location-id "us-west-2b"}
                               :qos {:spot-price (float 0.50)}))
   :compute (configure/compute-service :aws))