### BinList Integration

This program integrates with api:
```bash
https://lookup.binlist.net
```
First of all, it tries to find the credit/debit card data in its own DB (PostgreSQL). 
If it is unable to find such a card, it calls binlist api and saves the card data into db.

### How to run

You need JDK8 or later, maven 3.2.5 or later, available port 8080 on your machine

Command:
```bash
mvn clean package
```
will build project and launch unit tests.
As a result, you will have jar to run: "binlist.integration-1.0.jar"
```bash
java -jar <path-to-jar>
```
for example:
```bash
java -jar target/binlist.integration-1.0.jar
```
