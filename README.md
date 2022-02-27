## Aplicativo de tarefas
Site: ---------

## Usando o sistema

Assim que for realizada a conexão com o Banco de dados PostgreSQL, cadastre um usuário para conseguir criar uma tarefa, pois a tarefa só pode ser criada se atribuida a um responsável.

## Tecnológias utilizadas

- Bootstrap 4.3.1
- Primefaces 6.2
- SpringBoot 2.1.4
- SpringFramework 5.1.6
- Flyway 5.0.0
- Hibernate 5.2.17
- PostgreSQL 42.2.5
- JDA 3.8.3_462
- Lombok 1.18.8

### Itens complementados 

- A, B, C, D, E, F

## Sobre

O aplicativo utiliza SpringBoot e o SpringFramework como framework e Hibernate como persistência junto com o PostgreSQL. Front_end em JSF com PrimeFaces e bootstrap.

## Editar código localmente

- Para editar o código em seu computador utilize o plugin do lombok disponível no marketplace da IDE escolhida
- lembre-se de pegar a última versão com sucesso no actions CI do github

## Execução local

- Para gerar uma jar executável utilize o comando do maven `$ mvn clean install`
- Para executar a jar gerada utilize no cmd  `$ java -jar tarefa.jar`


## Requisitos para execução

- Configurar um banco de dados utilizando PostgreSQL
- Configure as variáveis de ambiemte `PSQL_URL, PSQL_USER, PSQL_PASSWORD`
