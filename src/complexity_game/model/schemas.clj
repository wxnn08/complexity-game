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
   :score s/Int
   :group s/Str
   :timestamp s/Str})

(s/defschema RankingResponse
  {:status s/Int
   :body {:ranking [RankingEntry]}})
