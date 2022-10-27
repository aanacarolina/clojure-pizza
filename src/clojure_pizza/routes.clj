(ns clojure-pizza.routes
    [io.pedestal.http.route :as route])


(defn routes
    ["user/:id/delivery_address/" :post new-address]
)
TODO
- Ver readme


/order/:id                    | devolver o pedido pelo id 
/user/:id/delivery_address/   | cadastra um endereço extra de entrega e vincula ao usuario 
/status/:id                   | devolve se EM PREPARO | EM ROTA | ENTREGUE
/order/                       | todos se nao passar id 
/order/:id                    | cria ou atualiza um pedido  (pode selecionar o endereco que quiser, se tiver mais do que 1)
/order/:id                    | deleta um ou todos os pedidos
/user/                        | cria pessoa usuária