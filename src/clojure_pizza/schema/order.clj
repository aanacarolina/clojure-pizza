(ns clojure-pizza.schema.order
  (:require [schema.core :as s])
  (:import (clojure.lang Atom)))

(s/defschema OrderSchema
  {:id s/Uuid
   :topping s/Str
   :status s/Str
   :delivery-address s/Str})

(s/defschema OrderAtom (s/pred #(instance? Atom %)))

(s/defschema OrderAddressSchema
  {:id s/Uuid
   :street-name s/Str
   :street-number s/Int
   :suburb s/Str
   :city s/Str
   :zip-code s/Int})
