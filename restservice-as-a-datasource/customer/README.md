## Build

Maven build commands:

~~~
mvn clean install
~~~

will generate `customer-swarm.jar` under target folder.

## Start

Run runnable `customer-swarm.jar`

~~~
java -jar customer-swarm.jar
~~~

Available API Test

| **Name** | **API** |
|:---------|:--------|
|getCustomers  |http://localhost:8080/customer/customerList  |
|getCustomerList |http://localhost:8080/customer/getAll |
|getCustomerByNumber |http://localhost:8080/customer/getByNumber/{customernumber} |
|getCustomerByName |http://localhost:8080/customer/getByName/{customername} |
|getCustomerByCity |http://localhost:8080/customer/getByCity/{city} |
|getCustomerByCountry |http://localhost:8080/customer/getByCountry/{country} |

