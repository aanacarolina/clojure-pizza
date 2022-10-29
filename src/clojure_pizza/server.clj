(ns clojure-pizza.server
 (:require [io.pedestal.http :as http]
           [io.pedestal.test :as test]
           [io.pedestal.interceptor :as i]
           [com.stuartsierra.component :as component]))

(defonce server (atom nil))

(defn start-server [service-map]
  (reset! server (http/start (http/create-server service-map))))

(defn test-request [verb url]
  (test/response-for (::http/service-fn @server) verb url))

(defn stop-server []
  (http/stop @server))

(defn restart-server [service-map]
  (stop-server)
  (start-server service-map))

(defrecord Server [database routes config]
  component/Lifecycle

  (start [this]
    (println "Start server")
    (let [assoc-store (fn [context]
                        (assoc context :contas (:contas database)))
          db-interceptor {:name  :db-interceptor
                          :enter assoc-store}
          service-map-base {::http/routes        (:routes routes)
                            ::http/port          (-> config :config :port)
                            ::http/resource-path "/resources/public"
                            ::http/type          :jetty
                            ::http/join?         false}
          service-map (-> service-map-base
                          (http/default-interceptors)
                          (update ::http/interceptors conj (i/interceptor db-interceptor)))]
      (try
        (start-server service-map)
        (println "Server Started successfully!")
        (catch Exception e
          (println "Error executing server start: " (.getMessage e))
          (println "Trying server restart..." (.getMessage e))
          (try
            (restart-server service-map)
            (println "Server Restarted successfully!")
            (catch Exception e (println "Error executing server restart: " (.getMessage e))))))
      (assoc this :test-request test-request)))

  (stop [this]
    (stop-server)))

(defn new-server []
  (->Server {} {} {}))
