(ns my-api.controllers.code)

(defn list-of-codes
  [{:keys [path-params]}]
  (println path-params)
  (let [quantity (Integer. (:quantity path-params))
        codes    (take quantity (repeat {:code "(defn teste [] 1)"
                                         :complexity {:time :constant
                                                      :space :constant}}))]
    {:status 200
     :body {:codes codes}}))

