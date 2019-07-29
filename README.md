# Exemplo micro serviço com Spring Boot

### Para que server

Disponibilizar um endpoint para que  simular a compra de um produto.
O serviço retornar uma lista de parcelas. Quando a parcela é superior a 6 (seis), é atribuido o juros de acordo com a taxa selic.
 
### Tecnologia utilizada

* Java
* Spring boot
* Swagger
* Maven
* Junit

### Serviços externos

Para descobir a taxa selic do dia o serviço consulta o serviço do banco central.

https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json&dataInicial=01/07/2019&dataFinal=31/07/2019

### Como rodar a aplicação

Para rodar a aplicação é necessário Java 8 e Maven 3, atendendo este requisito executar os passos a seguir

1. baixar o projeto no git: git clone https://github.com/rodrigolsoares/exemplo-micro-service-spring-boot.git
2. abrir o prompt de comando, e ir até o diretório raiz do código fonte: ./exemplo-micro-service-spring-boot
3. Executar o comando mvn package
4. Apos rodar o maven, ir até o diretório ./exemplo-micro-service-spring-boot/target
5. Executar o comando java -jar exemplo-micro-service-spring-boot-0.0.1-SNAPSHOT.jar
6. abrir o navegador e executar a url de acesso a aplicação


### Url de acesso da aplicação

http://localhost:8080/swagger-ui.html

### Exemplo do Json retorno 

[
  {
    "numeroParcela": 1,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 2,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 3,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 4,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 5,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 6,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 7,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 8,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 9,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  },
  {
    "numeroParcela": 10,
    "valor": 1657.96,
    "taxaJurosAoMes": 0.02462
  }
]


### Exemplo do Json retorno de erro

{
  "timestamp": "2019-07-29T01:14:06.913+0000",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Quantidade de parcelas inválida",
  "path": "/parcelas"
}


 



