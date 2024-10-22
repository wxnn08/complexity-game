(ns complexity-game.misc.google-sheets
  (:require
   [google-apps-clj.credentials :as c]
   [google-apps-clj.google-sheets-v4 :as sheetsv4]
   [complexity-game.adapter.database :refer [database->internal]]
   [clojure.string :as str]))

(def sheets-id "1WEVeZFkf3SVBx5bqrJXqhLsxr-KllYvTwyia7gobq84")

(defn get-service []
  (let [scopes    ["https://www.googleapis.com/auth/spreadsheets"]
        creds     (c/default-credential scopes)]
    (sheetsv4/build-service creds)))

(defn code-data! []
  (let [service (get-service)]
    (sheetsv4/get-cells service sheets-id ["data!A:E"])))

(defn complexity-cost-data! []
  (let [service (get-service)]
    (sheetsv4/get-cells service sheets-id ["complexity-types!A:B"])))

(defn ranking-data! []
  (let [service (get-service)]
    (sheetsv4/get-cells service sheets-id ["ranking!A:D"])))

(defn get-ranking-data [group]
  (let [data    (ranking-data!)
        ranking (database->internal (first data))]
    (->> ranking
         (remove empty?)
         (filter #(= group (:group % "general")))
         (map (fn [entry]
                (-> entry
                    (update :score #(Integer/parseInt % 10)))))
         (sort-by :score >))))

(defn append-ranking-data! [entry]
  (let [service (get-service)
        sheet-id (sheetsv4/obtain-sheet-id service sheets-id "ranking")
        values   [[(:name entry) (str (:score entry)) (:group entry) (:timestamp entry)]]]

    (sheetsv4/append-sheet service sheets-id sheet-id values)))
