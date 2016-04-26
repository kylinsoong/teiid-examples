## What's this

The StateService supply service for GetAllStateInfo and GetStateInfo via StateCode. The following have the steps for build, deploy.

## Start

Execute mvn build command

~~~
mvn clean install
~~~

will generate runnable jar `stateService-1.0-swarm.jar`, start StateService via

~~~
java -jar stateService-1.0-swarm.jar
~~~

NOTE: WSDL can be find through `http://localhost:8080/stateService?wsdl`
