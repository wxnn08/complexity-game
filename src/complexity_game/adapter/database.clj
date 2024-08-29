(ns complexity-game.adapter.database)

(defn- extract-line [line]
  (try
    (map #(some-> % (get "effectiveValue") first val) line)
    (catch Exception _ nil)))


(defn database->internal [data]
  (let [keys   (->> data
                    first
                    extract-line
                    (map keyword))
        values (->> data
                    rest
                    (map #(extract-line %))
                    (remove (partial some nil?)))]
    (map (partial zipmap keys) values)))
