(ns complexity-game.model.schemas
  (:require [schema.core :as s]))

(s/defschema Code
  {:code s/Str
   :explanation s/Str
   :time_complexity s/Str
   :space_complexity s/Str
   :language s/Str})

(s/defschema ComplexityCost
  {:complexity s/Str
   :cost       s/Int})

(s/defschema CodeListResponse
  {:status s/Int
   :body {:codes [Code]
          :complexity-cost [ComplexityCost]}})

(s/defschema RankingEntry
  {:name s/Str
   :correct_answers s/Int
   :mistakes s/Int
   :timestamp_begin s/Str
   :timestamp_end s/Str
   :group s/Str})

(s/defschema RankingResponse
  {:status s/Int
   :body {:ranking [RankingEntry]}})
