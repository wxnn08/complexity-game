(ns my-api.service
  (:require
   [my-api.controllers.hello :as c]
   [io.pedestal.http.route :as route]))

(defn routes []
  (route/expand-routes
    #{["/" :get c/hello-world :route-name :hello]}))
