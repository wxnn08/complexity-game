(ns complexity-game.controllers.code
  (:require
   [complexity-game.adapter.database :refer [database->internal]]
   [google-apps-clj.credentials :as c]
   [google-apps-clj.google-sheets-v4 :as sheetsv4]))

(defn get-sheets-data! []
  (let [scopes ["https://www.googleapis.com/auth/spreadsheets"]
        creds (c/default-credential scopes)
        service (sheetsv4/build-service creds)]
    (sheetsv4/get-cells service "1WEVeZFkf3SVBx5bqrJXqhLsxr-KllYvTwyia7gobq84" ["data!A:E"])))

(defn list-of-codes!
  [{:keys [path-params]}]
  (let [data     (database->internal (get-sheets-data!))
        quantity (min 15 (Integer. (:quantity path-params)))
        codes    (take quantity (shuffle data))]
    {:status 200
     :body {:codes codes}}))
