(ns clojure-pizza.controller.order
  (:require [schema.core :as s]
            [clojure-pizza.schema.order :as s.order]
            [clojure-pizza.interceptors :as i]
            [clojure-pizza.database :as db]))

(s/defn create-order! :- s.order/OrderAtom
  [order :- s.order/OrderSchema
   orders-atom :- s.order/OrderAtom]
  (swap! orders-atom assoc (:id order) order))

(s/defn status-order :- s/Str
  [id :- s/Uuid
  orders-atom :- s.order/OrderAtom]
  (let [orders-val @orders-atom
        target-order (get orders-val id)]
    (get target-order :status)))

(s/defn new-address :- s.order/OrderAddressSchema
  [request :- s.order/OrderAddressSchema]
(let [address (:body request)]
    (assoc db/new-database  address {:id 123
                                    :street-name "Rua dos Bobos"
                                    :street-number 0
                                    :suburb "Jokerville"
                                    :city "Gotham"
                                    :zip-code 010101})address))