# Maven

https://maven.apache.org/


create project
`mvn archetype:generate -DgroupId=one.digitalinnovation -DartifactId=quick-start-maven -Darchetype=maven-archetype-quickstart -DinteractiveMode=false`

compile to class files in target folder
`mvn compile`

run application tests
`mvn test`

create application jar file in target folder
`mvn package`

clean target folder
`mvn clean`


https://maven.apache.org/archetypes


## POM (Project Object Model)

Mandatory fields:

<project>
	<modelVersion></modelVersion>
	<groupId></groupId>
	<artifactId></artifactId>
	<version></version>
</project>

the rest of the configuration will be extended from a default Super POM


## Repository

https://mvnrepository.com

- local
- remote


## Dependency

new dependency

add to the pom.xml:


<dependencies>
  ....
  <dependency>
    <groupId></groupId>
    <artifactId></artifactId>
    <version></version>
  </dependency>
</dependencies>

execute and download new dependencies

`mvn compile`


publish the project in local repository to be used in other projects

`mvn install`



## Dependency Scopes <scope>


Classpath
- runtime
- test
- compile


Scope types
- default
- provided
- runtime
- test
- system
- import

`mvn dependency:build-classpath -DincludeScope=compile`

Optional dependency
<optional>true</optional>


## Maven Build Lifecycle

- Default lifecycle
  main cycle
  responsible for local deploy
  has 23 phases (commands), the main are:
    validate
    compile
    test-compile
    integration-test
    package
    install
    deploy

- Clean lifecycle
  intermediary cycle
  responsible for the project cleaning
  has 3 phases:
    pre-clean
    clean
    post-clean

- Site lifecycle
  final cycle
  responsible for creating project documentation site
  has 4 phases:
    pre-site
    site
    post-site
    site-deploy



## Multi Modules

create main project

`mvn archetype:generate -DgroupId=one.digitalinnovation -DartifactId=project-parent -Darchetype=maven-quick-start`

add `<packaging>pom</packaging>` to pom.xml

create core module

`mvn archetype:generate -DgroupId=one.digitalinnovation -DartifactId=core -Darchetype=maven-quick-start -DinteractiveMode=false`

create service module

`mvn archetype:generate -DgroupId=one.digitalinnovation -DartifactId=service -Darchetype=maven-quick-start -DinteractiveMode=false`

create controller module

`mvn archetype:generate -DgroupId=one.digitalinnovation -DartifactId=controller -Darchetype=maven-quick-start -DinteractiveMode=false`



## Plugins

usage
`mvn [plugin-name]:[goal-name]`

ex.:
`mvn dependency:help`

configuration
<build>
  <plugins>
    <plugin>
      <groupId></groupId>
      <artifactId></artifactId>
      <version></version>
      <configuration>
        <release></release>
      </configuration>
    </plugin>
  </plugins>
</build>

