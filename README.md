# FIAP - Tech Challenge - Modulo 1
Pós Tech - Tech Challenge - Projeto de desenvolvimento de sistema para Lanchonete

## Tecnologias utilizadas
* <img height="40" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png"> Java 21
* <img height="40" src="https://user-images.githubusercontent.com/25181517/183891303-41f257f8-6b3d-487c-aa56-c497b880d0fb.png"> Spring Boot 3
* <img height="40" src="https://user-images.githubusercontent.com/25181517/117208740-bfb78400-adf5-11eb-97bb-09072b6bedfc.png"> PostgreSQL

## Executando a aplicação - Via Docker Compose
Executar o comando abaixo na raiz do projeto onde se encontra o arquivo docker-compose.yml
```
docker-compose up
```
## <img height="20" src="https://user-images.githubusercontent.com/25181517/186711335-a3729606-5a78-4496-9a36-06efcc74f800.png"> Swagger
```
http://localhost:8080/swagger-ui/index.html
```

## Fluxo de navegação
### Cliente
Para o cliente se identificar por CPF ou realizar cadastro com nome e e-mail.

```
/customers/api/v1/create
```
Response:
```
{
  "idCustomer": 0,
  "name": "string",
  "email": "string",
  "cpf": "string"
}
```

### Produtos
Cliente seleciona os produtos para montagem do combo com as seguintes categorias:
 - LANCHE
 - ACOMPANHAMENTO
 - BEBIDA
 - SOBREMESA

A visualização dos produtos é feita por categoria como parametro:
```
/products/api/v1/get-by-categorie/{categorie}
``` 
Response:
```
[
  {
    "idProduct": 0,
    "name": "string",
    "categorie": "LANCHE",
    "price": 0,
    "description": "string",
    "image": "string"
  }
]
```

### Pedido
Criação do pedido com o combo de produtos selecionado previamente.

*Caso o cliente não queira se identificar não será necessário utilizar o parametro idCustomer.
```
/order/api/v1/create
```
Response:
```
{
  "idOrder": 0,
  "customer": 0,
  "total": 0,
  "products": [
    {
      "idProduct": 0,
      "price": 0,
      "name": "string",
      "quantity": 0
    }
  ]
}
```
### Pagamento
Após o pedido gerado deverá ser feito o pagamento. 
```
/payment/api/v1/pay-order/{idOrder}
```
Response:
```
{
  "idPayment": 0,
  "idOrder": 0,
  "idCustomer": 0,
  "paymentStatus": "PAGO",
  "updatedStatus": "2024-11-01T04:07:42.303Z"
}
```

### FILA

Após o pagamento confirmado o pedido é RECEBIDO na cozinha.

Quando o pedido é iniciado o pedido é alterado para EM PREPARAÇÃO.

Assim que a cozinha termina, o pedido é alterado para PRONTO para retirada.
```
/order/api/v1/completed/{idOrder}
```

Quando ocorre a retirada do pedido pelo cliente o pedido é alterado para FINALIZADO
```
/order/api/v1/withdrawn/{idOrder}
```
