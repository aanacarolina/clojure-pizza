(ns clojure-pizza.interceptors
  (:require [io.pedestal.interceptor :as interceptor]
            [schema.core :as s]
            [clojure-pizza.schema.order]))


(def delivered
  (i/interceptor {:name :delivered
                  :enter (fn [context]
                             (let [id]))}))
(def check-user-id
  (interceptor/interceptor
    {:name  ::check-user-id
     :enter (fn [context]
              (let [id (= (-> context :request :query-params :id))]
                (if (= id nil))
                    (assoc context :response {:status 404
                                              :body "User not found."})
              context))}))

