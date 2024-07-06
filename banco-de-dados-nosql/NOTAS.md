# NoSQL

1998: primeira introdução do NoSQL

NoSQL = Not Only SQL

Diferenças BD Relacional x NoSQL

Escalabilidade:
  vertical | horizontal

Schema:
  tabelas, linhas, colunas, Pk Fk | Schemaless

Performance:
  depende de disco | depende de cluster

Transações:
  ACID         | BASE
  Atomicidade  | BAsically available
  Consistência | Soft-state
  Isolamento   | Eventually consistent
  Durabilidade

Principais vantagens NoSQL
-flexibilidade
-escalabilidade
-altar performance


## Tipos de banco NoSQL

- Document store
- Key-value store
- Wide-column store
- graph store


### Grafos (nodes)
comum em detecção de fraudes, mecanismos de recomendação, redes sociais, sistemas de arquivos, gamos...

#### Neo4j

https://sandbox.neo4j.com

CREATE (:Client {name: "Bob", age: 28, hobbies:['caca', 'comer']})

MATCH (Bob) RETURN Bob;

CREATE (:Client {name:"lula", age: 30, hobbies: ['tocar','brincar']}) -[:Bloqueado]->(:Client {name:"Patrick", hobbies:['cacar']})

MATCH (todos) RETURN todos;

CREATE (:Object)

MATCH (lula:Client {name:"lula"}), (patrick:Client {name: "Patrick"}) CREATE (lula)-[:Bloqueado]->(patrick)

MATCH (lula:Client {name: "lula"})-[relaciona:Bloqueado]-() DELETE relaciona

MATCH (lula:Client{name:"lula"}) DELETE lula

MATCH (patrick: Client {name:"patrick"}) SET patrick.hobbies = ['comer']

MATCH (patrick:Client {name:"patrick"}) SET patrick:Client_Premium



### Coluna/Familia de colunas
registros de transações...

#### Cassandra (cql)

https://katacoda.com/datastax/courses/cassandra-try-it-out/try-cql (não disponível)


CREATE KEYSPACE fenda_bikini WITH replicatoin = {'class': 'SimpleStrategy', 'replication_factor': 1};

use fenda_bikini;

CREAT COLUMNFAMILY clientes (name TEXT PRIMARY KEY, age int);

INSERT INTO clients (name, age) VALUES ("Bob", 38);

SELECT * FROM clientes;

INSERT INTO clients JSON '{"name": "Patrick"}';  // inserir como JSON

SELECT age, WRITETIME(age) FROM clientes; // há apenas 1 registro para age

SELECT JSON * FROM clientes; // retornar como JSON

UPDATE clientes SET age=33 WHERE name="Patrick";

ALTER COLUMMFAMILY clientes ADD hobby text;

UPDATE clientes SET hobby='caca' WHERE name='Patrick';

DELETE FROM clientes WHERE name='Bob';



### Chave-valor
armazena conjunto de dados, seja simples ou complexo, identificados por um identificados exclusivo
+bom desempenho em aplicações na nuvem
-menor capacidade de busca
uso em cache, sessao usuario, carrinhos de compra

#### Redis
alto desempenho
estrutura de dados na memória
versatilidade de uso
replicação e persistência
twitter, github, stackoverflow...

https://try.redis.io (unavailable)

https://app.redislabs.com/#/databases

https://onecompiler.com/redis/42jcrxum8 (working)


SET user1:name "Bob"

GET user1:name

SET user '{"name": "Patrick", "age": 28}'

SET user2:name "lula" EX 10 // expires in 10 sec

EXISTS user2:name // checar de chave existe

LPUSH user1:hobbies "caca"

LINDEX user1:hobbies 0

LRANGE user1:hobbies 0 1

TYPE user1:name
``
TTL user1:name  // checar tempo de expiracao em segundos

PTTL user1:name  // checar tempo de expiracao em milisegundos

PERSIST user2:name // remove valor de expiracao

DEL user2:name


### Documento
dados e documentos autocontidos e auto descritivos
permite redundância e inconsistência
livre de esquemas, podendo utilizar JSON, XML, etc


#### MongoDB
código aberto
alta performance
schema-free
utiliza JSON para armazenamento de dados
suporte a indices
auto-sharding (escalamento horizontal)
map-reduce
suporte a GridFS

Document ==> Tupla/Registro
Collection ==> Tabela
Embedding/linking ==> Join

Quando usar:
  grande volume de dados
  dados não necessariamente estruturados

Quando NÃO usar:
  necessidade de relacionamentos/joins
  propriedades ACID e transações são importantes
  

Instalacao local

https://www.docker.com/compose/compose-file

* my windows image doesn't support virtualization ?

https://hub.docker.com/ >> mongo >> docker pull mongo

`docker-compose up -d`

https://robomongo.org/


MongoDB Cloud

https://www.mongodb.com/

install mongosh

connect
`mongosh "mongodb+srv://cluster0.vwtwzzp.mongodb.net/" --apiVersion 1 --username famgz`

`show databases`


### Schema Design

Embedding vs Referência

Embedding
  pros:
    consulta informações em uma única query
    atualiza o registro em uma única operação
  contras:
    limite de 16MB por documento

Referência
  pros:
    documentos pequenos
    não duplica informações
    usado quando os dados não são acessados em todas as consultas
  contras:
    duas ou mais queries ou utilização do $lookup


recomendações de acordo com os relacionamentos:

One-to-one: prefira atributos chave-valor no documento

One-to-few: prefira embedding

One-to-many/Many-to-many: prefira referência


### Boas práticas

evite documentos muitos grandes

use nome campos objetivos e curtos

analise as suas queries utilizando `explain()`

atualize apenas os campos alterados

evite negações em queries

listas/arrays dentro dos documentos não podem crescer sem limite


### JSON vs BSON

BSON:
  é uma serialização codificada em binário de documentos semelhantes a JSON
  contém extensões que permitem a representação de tipos de dados que não fazem parte da especificação JSON, por exemplo tipo Date, ObjectID


### Operações de manipulação de dados

`show databases`

criar database (basta invocar 'use', nao ha comandos para criacao)
`use fenda_bikini`

database > collection > document

criar collection "test" de forma explicita
`db.createCollection("teste", {capped: true, max: 2, size: 2});` // limitado a 2 registros

listar collections
`show collections;`

inserir dado dentro da collection
`db.test.insertOne({"name":"Teste 1"});`

listar documentos da collections
`db.test.find({});`

criar collection "test1" de forma implicita
`db.test1.insertOne({"age":10});`

inserir multiplos
`db.clients.insertMany([{"name":"Patrick", "age": 38}, {"name": "Bob"}]);`

substituir todo o conteudo ?
`db.clients.replaceOne({ _id: ObjectId("6689cd8235f8c38d88516baf")}, {name: 'Patrick', age: 40 })`

modificar campos
`db.clients.updateMany({"name": "Patrick"}, {$set: {"age": 120}})`

buscar limitando a 1 resultado
`db.clients.find({"age": 120}).limit(1)`

`db.clients.insertOne({name: "Patrick2", age: 30})`

operador in
`db.clients.find({"age": {$in: [30, 120]}})`

buscar com multiplos parametros (usa AND como padrao)
`db.clients.insertOne({name: "Patrick2", age: 30})`

buscar com OR
`db.clients.find({$or: [{name: "Patrick2"}, {age: 120}]})`

buscar com LT (lower than) | LTE (lower than equal)
`db.clients.find({age: {$lt: 55}})`

deletar o primeiro resultado encontrado | deleteMany remove todos
`db.clients.deleteOne({age: 120})`



### Performance e indices

mongo aceita comandos javascript
`for(let i=0; i<100; i++) {db.clients.insert({name: "Client" + i, age: i})}`

obter quantidade de documentos
`db.clients.countDocuments({})`

campos _id sao indexados automaticamente | explain oferece detalhes da execucao da query
`db.clients.find({"_id": ObjectId("6689cd4435f8c38d88516bae")}).explain(true)` // totalDocsExamined: 1

`db.clients.find({"name": "Client0)}).explain(true)` // totalDocsExamined: 105

criar indice para campo name
`db.clients.createIndex({name: 1}, {name: "idx_name"})`

busca, agora com o indice name
`db.clients.find({"name": "Client0)}).explain(true)` // totalDocsExamined: 1


### Agregações

procedimentos de processar dados em uma ou mais etapas, onde o resultado de cada etapa é utilizado na etapa seguinte, de modo a retornar um resultado combinado

Tipos:
  agregação de propósito único
    `count`
    `distinct`

operadores: `$group` `$addFields`

`db.collection.aggregate([{$group: {_id: "$cuisine", total: {$sum: 1}}}])` // retorna novo objeto com os campos escolhidos

`db.collection.aggregate([{$addFields: {"teste": true} }])` // retorna objetos originais com campos adicionais

funções: `$sum` `$avg` `$max` `$min`

operadores lógicos: `$and` `$or` `$not` `$nor`

`db.collection.aggregate([{$match: {$and: [{cuisine: "Americana"}, {borough: "Brooklyn"}]} }])`

operadores de comparação: `$gt` `$lt` `$nte` `$eq` `$lte` `$gte`



