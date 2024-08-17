(ns my-api.controllers.hello
  (:require
   [schema.core :as s]))

(s/defn hello-world [request]
  {:status 200
   :body "oii"})

;(route/try-routing-for (service/routes) :prefix-tree "/hello" :put)
;(server/start! :dev)
