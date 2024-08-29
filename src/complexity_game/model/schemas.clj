(ns complexity-game.model.schemas
  (:require [schema.core :as s]))


(s/defschema Code
  {})

(s/defschema ComplexityCost
  {:complexity s/Str
   :cost       s/Int})

(s/defschema CodeListResponse
  {:status s/Int
   :body {:codes [Code]
          :complexity-cost [ComplexityCost]}})
