## Aplicativo de tarefas
Site: https://desafio-esig-tarefa.herokuapp.com/index.jsf

## Usando o sistema

Assim que for realizada a conexão com o Banco de dados PostgreSQL, cadastre um usuário para conseguir criar uma tarefa, pois a tarefa só pode ser criada se atribuida a um responsável.
Também é possível filtrar utilizando o mesmo campo de cadastro e clicando no botão "Pesquisar Tarefa", bem como filtrar pelo botão de filtro.

## Tecnológias utilizadas

- Bootstrap 4.3.1
- Primefaces 6.2
- SpringBoot 2.1.8
- SpringFramework 5.1.6
- Flyway 5.0.0
- Hibernate 5.2.17
- PostgreSQL 42.3.3
- JDA 3.8.3_462
- Lombok 1.18.8
- Junit Jupiter 5.8.2

### Itens complementados 

- A, B, C, D, E, F

## Sobre

O aplicativo utiliza SpringBoot e o SpringFramework como framework e Hibernate como persistência junto com o PostgreSQL. Front_end em JSF com PrimeFaces e bootstrap. TDD em Junit Jupiter.

## Editar código localmente

- Para editar o código em seu computador utilize o plugin do lombok disponível no marketplace da IDE escolhida
- Para executar o TDD utilize o plugin Junit Jupiter disponível em Maven Repository
- lembre-se de pegar a última versão com sucesso no actions CI do github

## Execução local

- Para gerar uma jar executável utilize o comando do maven `$ mvn clean install`
- Para executar a jar gerada utilize no cmd  `$ java -jar tarefa.jar`


## Requisitos para execução

- Configurar um banco de dados utilizando PostgreSQL
- Configure as variáveis de ambiemte em application-dev.properties na seção #Editar
- Verifique dentro do arquivo application.properties se a variável ambiente está setado para dev
