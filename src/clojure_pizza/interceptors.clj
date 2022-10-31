(ns clojure-pizza.interceptors)

; TODO
; - incluir endereco apos pedido
; - status (so altera se tiver endereco cadastrado)
; - auth token

; o /order/:id já retorna um user específico, você pode usar ele para retornar o da pessoa



(def delivered
  (i/interceptor {:name :delivered
                  :enter (fn [context]
                             (let [id]))}))
