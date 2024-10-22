(ns complexity-game.controllers.code
  (:require
   [complexity-game.adapter.database :refer [database->internal]]
   [complexity-game.misc.google-sheets :as sheets]
   [complexity-game.model.schemas :as m.schemas]
   [schema.core :as s]))

(s/defn list-of-codes! :- m.schemas/CodeListResponse
  [{:keys [path-params]}]
  (let [code-data       (database->internal (first (sheets/code-data!)))
        complexity-cost (database->internal (first (sheets/complexity-cost-data!)))
        quantity        (Integer. (:quantity path-params))
        codes           (take quantity (shuffle code-data))]
    {:status 200
     :body {:codes codes
            :complexity-cost complexity-cost}}))
