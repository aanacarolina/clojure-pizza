(ns clojure-pizza.controller.user
  (:require [schema.core :as s]
            [clojure-pizza.schema.user :as s.user]))

(s/defn create-user! :- s.user/UsersAtom
  [user :- s.user/UserSchema
   users-atom :- s.user/UsersAtom]
  (swap! users-atom assoc user))

(s/defn hello [context]
  (assoc context :response
                 {:status 200
                  :headers {"Content-Type" "text/html"}
                  :body "Hello Friend!"}))
