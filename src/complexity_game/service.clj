(ns complexity-game.service
  (:require
   [io.pedestal.http.route :as route]
   [complexity-game.controllers.code :as c.code]
   [complexity-game.controllers.hello :as c.hello]))

(defn routes []
  (route/expand-routes
    #{["/"
       :get
       c.hello/hello-world
       :route-name :hello]

      ["/api/code"
       :get
       c.code/list-of-codes
       :route-name :code]

      ["/api/code/:quantity"
       :get
       c.code/list-of-codes
       :route-name :list-of-codes]}))
