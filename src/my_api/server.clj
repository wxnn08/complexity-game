(ns my-api.server
  (:gen-class) ; for -main method in uberjar
  (:require [io.pedestal.http :as http]
            [my-api.service :as service]))

(defn service-prod []
  {:env :prod
   ::http/routes (service/routes)
   ::http/resource-path "/public"
   ::http/type :jetty
   ::http/port 8080
   ::http/host "0.0.0.0"
   ::http/container-options {:h2c? true
                             :h2? false
                             :ssl? false}})

(defn service-dev []
  (-> (service-prod)
      (merge {::http/join? false})))

(defonce server (atom nil))

(defn start-server! [server-env]
  (reset! server (http/start server-env)))

(defn stop-server! []
  (http/stop @server)
  (reset! server nil))

(defn restart-server! [server-env]
  (stop-server!)
  (start-server! server-env))

(defn start! [env]
  (let [service (if (= :prod env)
                  (service-prod)
                  (service-dev))
        custom-server (http/create-server (-> service
                                              http/default-interceptors
                                              (update ::http/interceptors into [http/json-body])))]
    (if (nil? @server)
      (start-server! custom-server)
      (restart-server! custom-server))))

(defn -main
  "The entry-point for 'lein run'"
  [& args]
  (println "\nCreating your server...")
  (start! :prod))

(start! :dev)
