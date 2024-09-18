(ns complexity-game.service
  (:require
   [io.pedestal.http.route :as route]
   [complexity-game.controllers.code :as c.code]
   [complexity-game.controllers.hello :as c.hello]
   [complexity-game.controllers.ranking :as c.ranking]))

(defn routes []
  (route/expand-routes
    #{["/"
       :get
       c.hello/hello-world
       :route-name :hello]

      ["/api/code"
       :get
       c.code/list-of-codes!
       :route-name :code]

      ["/api/code/:quantity"
       :get
       c.code/list-of-codes!
       :route-name :list-of-codes]

      ["/api/ranking"
       :get
       c.ranking/get-ranking!
       :route-name :get-ranking]

      ["/api/ranking"
       :post
       c.ranking/update-ranking!
       :route-name :update-ranking]}))
