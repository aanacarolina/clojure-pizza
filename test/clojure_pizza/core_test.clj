(ns clojure-pizza.core-test
  (:require [clojure.test :refer :all]
            [clojure-pizza.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))


(deftest new-address-test-interceptor
  (testing "if user-id exists"
    (is (= {:response {:status 200
                       :body {:new-address-id 4567}}}
           (new-address-interceptor {:request {:body {:street "Rua dos Bobos"}}})))))

;TODO
;- Integração
;- Unitario