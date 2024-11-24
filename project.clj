(defproject complexity-game "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [io.pedestal/pedestal.service "0.6.3"]
                 [io.pedestal/pedestal.jetty "0.6.3"]
                 [ring/ring-servlet "1.12.2"]
                 [prismatic/schema "1.4.1"]
                 [com.stuartsierra/component "1.1.0"]
                 [ch.qos.logback/logback-classic "1.2.10" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.35"]
                 [org.slf4j/jcl-over-slf4j "1.7.35"]
                 [org.slf4j/log4j-over-slf4j "1.7.35"]
                 [clj-http "3.13.0"]
                 [google-apps-clj "0.6.1"]
                 [environ "1.2.0"]]
                 
  :plugins [[lein-environ "1.2.0"]]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "complexity-game.server/run-dev"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.6.3"]]}
             :uberjar {:aot [complexity-game.server]}}
  :env {:local-url1 "http://localhost:3000"
        :local-url2 "http://192.168.0.9:3000"
        :url-1 "https://complexity-game-website.onrender.com"
        :url-2 "https://bigobattle.online"}
  :main ^{:skip-aot true} complexity-game.server)
