(ns clojure-pizza.core-test
  (:require [clojure.test :refer :all]
            [clojure-pizza.core :as address]))

(deftest new-address-test-interceptor
  (testing "if user-id exists"
    (is (= {:response {:status 200
                       :body {:new-address-id 4567}}}
           (address/new-address-interceptor {:request {:body {:street "Rua dos Bobos"}}})))))
