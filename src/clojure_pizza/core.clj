(ns clojure-pizza.core
  (:require [com.stuartsierra.component :as component]
            [clojure-pizza.config :as config]
            [clojure-pizza.routes :as routes]
            [clojure-pizza.database :as database]
            [clojure-pizza.server :as web-server]))

(def new-sys
  (component/system-map
    :config (config/new-config)
    :routes (routes/new-routes)
    :database (component/using
                (database/new-database)
                [:config])
    :web-server (component/using
                  (web-server/new-server)
                  [:database :routes :config])))

(def sys (atom nil))
(defn main [] (reset! sys (component/start new-sys)))

(comment
  (main)
  (visualize-system new-sys))
