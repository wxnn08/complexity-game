(ns complexity-game.controllers.code)

(defn list-of-codes
  [{:keys [path-params]}]
  (let [quantity (min 15 (Integer. (:quantity path-params)))
        codes    (take quantity (repeat {:code "(defn teste [] 1)"
                                         :complexity {:time :constant
                                                      :space :constant}}))]
    {:status 200
     :body {:codes codes}}))

