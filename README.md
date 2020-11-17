# automation_bolivar

#run the automated test by comandline
mvn clean test -DdefaultSuiteFiles="src/test/java/resources/suite.xml"

#Allure Page
allure serve allure-results


