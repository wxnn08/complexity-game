(ns complexity-game.adapter.database-test
  (:require
   [clojure.test :refer [is testing]]
   [complexity-game.adapter.database :as d]
   [schema.test :as s]))

(s/deftest database->internal-test
  (testing "Should return a map with database info"
    (is (= [{:a "1" :b "2"}]
           (d/database->internal [[{"effectiveValue" {"stringValue" "a"}} {"effectiveValue" {"test" "b"}}]
                                  [{"effectiveValue" {"stringValue" "1"}} {"effectiveValue" {"test" "2"}}]]))))

  (testing "Should return empty if database has the columns names and no data"
    (is (= []
           (d/database->internal [[{"effectiveValue" {"stringValue" "a"}} {"effectiveValue" {"test" "b"}}]]))))

  (testing "Should return empty if databse has no data"
    (is (= []
           (d/database->internal [])))))
