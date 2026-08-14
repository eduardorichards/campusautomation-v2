# Automated Tests For EPAM Campus Web App

## How to run

Default — full suite, local:
mvn clean test -Denv=local

Smoke suite, CI, Firefox:
mvn clean test -Denv=ci -Dsuite.xml.file=testng-smoke.xml -Dbrowser=firefox

Regression suite, CI, Chrome headless (from config-ci.properties):
mvn clean test -Denv=ci -Dsuite.xml.file=testng-regression.xml