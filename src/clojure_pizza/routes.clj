(ns clojure-pizza.routes
  (:require [io.pedestal.http.route :as route]
            [io.pedestal.interceptor :as i]
            [com.stuartsierra.component :as component]
            [clojure-pizza.controller.user :as c.user]
            [clojure-pizza.controller.order :as c.order]))


(def routes
  (route/expand-routes
    #{["/" :get (i/interceptor {:name  :hello
                                :enter c.user/hello}) :route-name :hello]
      ["/user" :post
       (i/interceptor {:name  :create-user
                       :enter c.user/create-user!}) :route-name :create-user]
      ["order/:id/status" :get
       (i/interceptor {:name :status-order
                       :enter c.order/status-order}) :route-name :status-order]}))

(defrecord Routes []
  component/Lifecycle
  (start [this]
    (assoc this :routes routes))
  (stop [this]
    (dissoc this :routes)))

(defn new-routes []
  (->Routes))

;TODO
;- Ver readme


;/order/:id                    | devolver o pedido pelo id
;/user/:id/delivery_address/   | cadastra um endereço extra de entrega e vincula ao usuario
;/status/:id                   | devolve se EM PREPARO | EM ROTA | ENTREGUE
;/order/                       | todos se nao passar id
;/order/:id                    | cria ou atualiza um pedido  (pode selecionar o endereco que quiser, se tiver mais
; do que 1)
;/order/:id                    | deleta um ou todos os pedidos
;/user/                        | cria pessoa usuária

