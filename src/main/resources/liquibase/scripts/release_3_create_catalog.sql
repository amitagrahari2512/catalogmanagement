--liquibase formatted sql


--changeset amit_agrahari:1

drop table Product;


--changeset amit_agrahari:2

drop table t_catalog;


--changeset amit_agrahari:3

create table t_catalog
(
	catalogId Number GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
	catalogName varchar2(50) Not Null,
	CONSTRAINT t_catalog_pk PRIMARY KEY (catalogId)	
);

--changeset amit_agrahari:4

create table Product
(
	productId Number GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
	productName varchar2(50) Not Null,
	productPrice Number Not Null,
	catalogId Number Not Null,
	CONSTRAINT Product_pk PRIMARY KEY (productId),
	CONSTRAINT Product_fk
    FOREIGN KEY (catalogId)
    REFERENCES t_catalog(catalogId)
);