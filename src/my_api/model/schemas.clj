(ns my-api.model.schemas
  (:require [schema.core :as s]))

(s/defschema Vehicle
  {:plate s/Str
   :model s/Str})
