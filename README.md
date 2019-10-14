### BinList Integration

This program integrates with api:
```bash
https://lookup.binlist.net
```
First of all, it tries to find the credit/debit card data in its own DB (PostgreSQL). 
If it is unable to find such a card, it calls binlist api and saves the card data into db.

### How to run

### Prerequisites

In order to run this program, in PostgreSQL such scripts are to be executed:
```bash
CREATE DATABASE binlist;
CREATE SCHEMA binlist;
CREATE TABLE binlist.banks
(
bin_id integer primary key,
name character varying(100) COLLATE pg_catalog."default",
url character varying(100) COLLATE pg_catalog."default",
phone character varying(20) COLLATE pg_catalog."default",
city character varying(50) COLLATE pg_catalog."default"
);


CREATE TABLE binlist.card_lengths
(
bin_id integer primary key,
length varchar(10),
luhn boolean NOT NULL
);

CREATE TABLE binlist.cards
(
bin_id integer primary key,
scheme character varying(20) COLLATE pg_catalog."default",
card_type character varying(20) COLLATE pg_catalog."default",
brand character varying(50) COLLATE pg_catalog."default",
prepaid boolean NOT NULL
);

CREATE TABLE binlist.countries
(
bin_id integer primary key,
country_numeric character varying(10) COLLATE pg_catalog."default",
alpha2 character varying(10) COLLATE pg_catalog."default",
name character varying(50) COLLATE pg_catalog."default",
emoji character varying(10) COLLATE pg_catalog."default",
currency character varying(5) COLLATE pg_catalog."default",
latitude integer,
longitude integer
);
```
PostgreSQL connection URL:
```bash
jdbc:postgresql://localhost:5432/binlist?currentSchema=binlist
```

### Running application

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
