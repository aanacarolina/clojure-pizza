(ns clojure-pizza.controller.order
  (:require [schema.core :as s]
            [clojure-pizza.schema.order :as s.order]))

(s/defn create-order! :- s.order/OrderAtom
  [order-id :- s/Uuid
   order :- s.order/OrderSchema
   orders-atom :- s.order/OrderAtom]
        (let [order-to-update (get @orders-atom order-id {:id order-id})
              new-order (merge order-to-update order)
              SIDE-EFFECT! (swap! orders-atom assoc order-id new-order)]
          SIDE-EFFECT!))

(s/defn status-order :- s/Str
  [id :- s/Uuid
  orders-atom :- s.order/OrderAtom]
  (let [orders-val @orders-atom
        target-order (get orders-val id)]
    (get target-order :status)))

(s/defn delete-order :- s.order/OrderAtom
        [order :- s.order/OrderSchema
         orders-atom :- s.order/OrderAtom]
        (swap! orders-atom disj (:id order)))

(s/defn orders :- [s.order/OrderSchema]
  [orders-atom :- s.order/OrderAtom]
  @orders-atom)
