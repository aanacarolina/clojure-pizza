(ns clojure-pizza.schema.user
  (:require [schema.core :as s])
  (:import (clojure.lang Atom)))

(s/defschema UserSchema
  {:user-name s/Str
   :password s/Str})

(s/defschema UsersAtom (s/pred #(instance? Atom %)))
