# clojure-pizza

A Clojure API designed to create, get, update and delete orders from a pizzaria ... 


Clojure Bootcamp - Module 3 final project

| Endpoint                     | HTTP        | Status Code | Description                      |
| --------------------------   | ----------- |-----------  |----------------------------------| 
| /order/:id                   | [get]       | 200 / 404   | Get order by id                  |
| /order/:id/delivery_address/ | [post]      | 200 / 404   | Get delivery address of client   |
| /order/:id/status/           | [get]       | 200 / 404   | Get order status                 |
| /order/                      | [get]       | 200 / 404   | Get all orders                   |
| /order/:id                   | [put]       | 200 / 201   | Create/Update a order            |
| /order/:id                   | [delete]    | 202         | Delete order                     |            
| /order/:id                   | [patch]     | 200         | Update an order through N fields |

## Schemas

**Order**
```
* id
* price
* delivery_address  
* status
* date
* qtd
* pizza
```

**Pizza**
```
* size
* ingredients
```

## TODO 

* Definir os componentes
    * Server
    * Database
    * Config (PORT)
* Criação dos schemas (prismatic)
* Criação dos testes (with-derefs)    

    
## Usage

FIXME

## License

Copyright © 2022 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
