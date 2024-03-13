# diplom_3
QA Java Project
Java 11,
junit 4.13.2,
selenium-java 4.8.1,
rest-assured 5.4.0,
gson 2.10.1,
allure 2.21.0,
maven-surefire-plugin 2.22.2,
javafaker 1.0.2

to run tests with option uncomment System.getProperty("property") in WebDriver() method in BaseTest class
to run with chrome use
```shell
mvn clean test  -Dproperty="chrome"
```
to run tests with yandex use
```shell
mvn clean test  -Dproperty="yandex"
```
to see allure report use
```shell
mvn allure:serve
```

to run manually uncomment "chrome" or "yandex" in WebDriver() method in BaseTest class

