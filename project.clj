(defproject startingclojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths      ["src/clojure"]
  :java-source-paths ["src/java"]
  :dependencies [[org.clojure/clojure "1.4.0"]
                 
                 [ring "1.1.8"]
                 [compojure "1.1.5"]
                 [enlive "1.1.1"]
                 [com.datomic/datomic-free "0.8.3826"]
                                  ;; The latest pallet
                 [com.palletops/pallet "0.8.0-beta.1"]

                 ;; The latest jclouds fun
                 [org.cloudhoist/pallet-jclouds "1.5.2"]
                 [org.jclouds/jclouds-allblobstore "1.5.5"]

                 [org.jclouds/jclouds-allcompute "1.5.5"]
                 [org.jclouds.driver/jclouds-slf4j "1.5.5"]
                 [org.jclouds.driver/jclouds-jsch "1.5.5"]
                 [org.jclouds/jclouds-compute "1.5.5"]
                 [org.jclouds/jclouds-blobstore "1.5.5"]
                 [org.slf4j/slf4j-api "1.6.1"]
                 [ch.qos.logback/logback-core "1.0.0"]
                 [ch.qos.logback/logback-classic "1.0.0"]

                 ;; Rackspace London and Greenqloud jclouds providers,
                 ;; becuase if you are going to be in the cloud you
                 ;; might as well be green. See
                 ;; https://www.mastodonc.com/dashboard for more
                 ;; information.
                 [ com.palletops/java-crate "0.8.0-beta.1"]
                 [datomic-crate "0.8.0-SNAPSHOT"]
                 [org.jclouds.labs/greenqloud-compute "1.5.5"]
                 ]
 ; :exclusions [org.jclouds/jclouds-allblobstore
  ;             org.jclouds/jclouds-allcompute
   ;            org.jclouds/jclouds-compute
    ;           org.jclouds/jclouds-blobstore
     ;          org.jclouds.driver/jclouds-slf4j
      ;         org.jclouds.driver/jclouds-jsch
       ;        org.jclouds.labs/greenqloud-compute]
  :dev-dependencies [[org.cloudhoist/pallet "0.7.1" :type "test-jar"]
                     [org.cloudhoist/pallet-lein "0.5.1"]]
  :profiles {:dev {:plugins [[org.cloudhoist/pallet-lein "0.5.1"]]}}
  :local-repo-classpath true
  :repositories
  {"sonatype-snapshots" "https://oss.sonatype.org/content/repositories/snapshots"
   "sonatype" "https://oss.sonatype.org/content/repositories/releases/"})