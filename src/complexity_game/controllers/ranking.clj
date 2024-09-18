(ns complexity-game.controllers.ranking
  (:require
   [complexity-game.misc.google-sheets :as sheets]
   [complexity-game.model.schemas :as m.schemas]
   [schema.core :as s]))

(s/defn get-ranking! :- m.schemas/RankingResponse
  [_]
  (let [ranking-data (sheets/get-ranking-data)]
    {:status 200
     :body {:ranking ranking-data}}))

(s/defn update-ranking! :- {:status s/Int :body {:message s/Str}}
  [{:keys [json-params]}]
  (let [{:keys [name score]} json-params]
    (sheets/append-ranking-data! {:name name :score score})
    {:status 200
     :body {:message "Ranking atualizado com sucesso"}}))
