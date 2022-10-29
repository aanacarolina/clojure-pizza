(ns clojure-pizza.config
  (:require [com.stuartsierra.component :as component]))

(defrecord Config []
  component/Lifecycle
  (start [this]
    (let [file (-> "resources/config.edn"
                   slurp
                   read-string)]
      (assoc this :config file)))

  (stop [this]
    (dissoc this :config)))

(defn new-config []
  (->Config))
