(ns clojure-pizza.database
  (:require [com.stuartsierra.component :as component]))

(defrecord Database [config]
  component/Lifecycle

  (start [this]
    (let [_ (println config)
          file (-> (-> config :config :db-file )
                      slurp
                      read-string)]
      (assoc this :pizzaria (atom file))))

  (stop [this]
    (assoc this :pizzaria nil)))

(defn new-database []
  (->Database {}))
