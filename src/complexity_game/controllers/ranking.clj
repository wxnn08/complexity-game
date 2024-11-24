(ns complexity-game.controllers.ranking
  (:require
   [clojure.string :as str]
   [complexity-game.misc.google-sheets :as sheets]
   [complexity-game.model.schemas :as m.schemas]
   [schema.core :as s]))

(s/defn get-ranking! :- m.schemas/RankingResponse
  [{:keys [query-params]}]
  (let [group (get query-params :group "general")
        ranking-data (sheets/get-ranking-data group)]
    {:status 200
     :body {:ranking ranking-data}}))

(s/defn update-ranking! :- {:status s/Int :body {:message s/Str}}
  [{:keys [json-params]}]
  (let [{:keys [name correct_answers mistakes timestamp_begin timestamp_end group]} json-params
        group-name (if (str/blank? group) "general" group)]
    (sheets/append-ranking-data! {:name name
                                  :correct_answers correct_answers
                                  :mistakes mistakes
                                  :timestamp_begin timestamp_begin
                                  :timestamp_end timestamp_end
                                  :group group-name})
    {:status 200
     :body {:message "Ranking atualizado com sucesso"}}))
