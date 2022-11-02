(ns clojure-pizza.interceptors
  (:require [schema.core :as s]
            [clojure-pizza.schema.order]))



(def delivered
  (i/interceptor {:name :delivered
                  :enter (fn [context]
                             (let [id]))}))
