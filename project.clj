(defproject startingclojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"]
  :dependencies [[org.clojure/clojure "1.5.0"] 
                 [ring "1.1.8"]
                 [compojure "1.1.5"]
                 [enlive "1.1.1"]
                 [com.datomic/datomic-free "0.8.3826"]])
