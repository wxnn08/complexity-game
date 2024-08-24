(ns complexity-game.controllers.hello
  (:require
   [schema.core :as s]))

(s/defn hello-world [request]
  {:status 200
   :body "oii"})
