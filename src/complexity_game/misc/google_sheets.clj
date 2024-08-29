(ns complexity-game.misc.google-sheets
  (:require
   [google-apps-clj.credentials :as c]
   [google-apps-clj.google-sheets-v4 :as sheetsv4]))

(defn sheets-data! [sheets-range]
  (let [scopes    ["https://www.googleapis.com/auth/spreadsheets"]
        creds     (c/default-credential scopes)
        service   (sheetsv4/build-service creds)
        sheets-id "1WEVeZFkf3SVBx5bqrJXqhLsxr-KllYvTwyia7gobq84"]
    (sheetsv4/get-cells service sheets-id [sheets-range])))

(defn code-data! []
  (sheets-data! "data!A:E"))

(defn complexity-cost-data! []
  (sheets-data! "complexity-types!A:B"))
