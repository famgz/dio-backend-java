# Spring Boot

https://glysns.gitbook.io/spring-framework

https://github.com/digitalinnovationone/dio-springboot

https://docs.google.com/presentation/d/1jS5Ov8UCSnzgW3TLBcAsGrXo__kL6FOG/edit#slide=id.p1

Spring vs Java EE

Inversão de Controle
  trata-se do redirecionamento do fluxo de execução de um código retirando parcialmente o controle sobre ele e delegando para um container.
  o principal propósito é minimizar o acoplamento do código

Injeção de dependência
  é um padrão de desenvolvimento com a finalidade de manter baixo o nível de acoplamento entre módulos de um sistema

Beans
  objeto que é instanciado, montado e gerenciado por um container através do princípio da inversão de controle

Singleton
  conteiner do Spring IoC que defina apenas uma instância do objeto para toda aplicação

Prototype
  será criado um novo objeto a cada solicitação ao container

HTTPs Request
  um bean será criado para cada requisição HTTP (os objetos existirão enquanto a requisição estiver em execução)

HTTP Session
  um bean será criado para cada sessão de usuário (precisamos acessar a mesma solicitação 2x para testar os escopos da web)

HTTP Global
  cria um bean para o ciclo de vida do contexto da aplicação (objetos compartilhados por toda aplicação)

Autowired
  anotação onde deverá ocorrer uma injeção automática de dependência (byName, byType, byConstructor)



Enquanto o Spring Framework é baseado no padrão de injeção de dependências, o Springboot foca na configuração automática


Antes do Springboot

Desafios com configuração do projeto:
  dependêndia individual
  verbosidade
  incompatibilidade de versões
  complexidade de gestão
  configurações complexas e repetitivas

Starters
  benefícios:
    coesão
    versões compatíveis
    otimização do tempo
    configuração simples
    foco no negócio

  mais utilizados:
    Spring-boot-starter-*
      data-jpa: integração ao banco de dados via JPA - Hibernate
      data-mongodb: integração com bancos de dados MogonDB
      web: inclusão do container Tomcat para aplicações REST
      web-services: baseados na arquitetura SOAP
      batch: implementação de JOBs de processos
      test: recursos para teste unitários como JUnit
      openfeign: client HTTP baseado em interfaces
      actuator: gerenciamento de monitoramento da aplicação


## Primeiros passos

https://start.spring.io/


@Autowired substitui instanciação direta

@Bean para criar objetos injetáveis -> criá-los na classe principal, se forem muitos, criar um arquivo Beans.java 



## ORM
Object-Relational Mapping
  recurso para aproximar o paradigma da orientação a objetos ao contexto de banco de dados relacional
  realizado através do mapeamento de objetos para uma tabela por uma biblioteca ou framework

JPA
  especificação baseada em interfaces, que através de um framework realiza operações de persistência de objetos em Java
  implementações:
    Hibernate
    Eclipse link
    Top link
    Open JPA


Mapeamento na prática

```java
@Entity
@Table(name="tb_usuario")
public class Usuario {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id_usuario")
  private Long id;

  private String nome; // quando nome for o mesmo da coluna, nao precisa anotacao

  @Column(name="login_usuario")
  private String login;

  @Column(name="senha_usuario")
  private String senha;
}
```


### Spring Data JPA
  adiciona camada sobre o JPA

Interfaces:
  CrudRepository
  JPARepository
  PagingAndSortingRepository

Anotacoes:
  @Query
  @Param


JPA Repository
principais métodos:
  save
  findById
  existsById
  findAll
  delete
  count

Consultas Cutomizadas:
  Query Method:
    o Spring Data JPA se encarrega de interpretar a assinatura de um método para montar a JPQL correspondente.
    ex.: `List<User> findByEmailAddressAndLastname(String emailAddress, String lastname)`
  
  Query Override:
    quando há necessidades de queries mais avançadas, onde o query method se torna inviável
    ex.: `@Query("SELECT u FROM User u WHERE u.name LIKE %:name%")`
