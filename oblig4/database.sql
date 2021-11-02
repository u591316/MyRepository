DROP SCHEMA IF EXISTS oblig4 CASCADE;
CREATE SCHEMA oblig4;
SET search_path = oblig4;

CREATE TABLE deltagere 
(
   fornavn CHARACTER VARYING (40),
   etternavn character varying(40),
   mobilNr varchar (10),
	kjonn varchar(10),
   pwd_hash CHARACTER (64),
   pwd_salt CHARACTER (32),
   PRIMARY KEY (mobilNr)
);