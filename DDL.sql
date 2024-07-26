CREATE DATABASE sgpzf;

USE sgpzf;

CREATE TABLE sgpzf.stack (
	
	id 	INT 	AUTO_INCREMENT PRIMARY KEY,
	name 	VARCHAR(50)
);

CREATE TABLE sgpzf.skill (
	id 	INT 	AUTO_INCREMENT PRIMARY KEY,
	name 	VARCHAR(50)
);

CREATE TABLE sgpzf.gender (
	id 	INT 	AUTO_INCREMENT PRIMARY KEY,
	name 	VARCHAR(50)
);

CREATE TABLE sgpzf.country (
	id 	INT 	AUTO_INCREMENT PRIMARY KEY,
	name 	VARCHAR(50)
);

CREATE TABLE sgpzf.region (
	id 	INT 	AUTO_INCREMENT PRIMARY KEY,
	name 	VARCHAR(50),
	idcountry INT,
	FOREIGN KEY (idcountry) REFERENCES country(id)
);

CREATE TABLE sgpzf.city (
	id 	INT 	AUTO_INCREMENT PRIMARY KEY,
	name 	VARCHAR(50),
	idregion INT,
	FOREIGN KEY (idregion) REFERENCES region(id)
);

CREATE TABLE sgpzf.stack_skill (
	idskill INT,
	idstack INT,
	idstatus INT,
	FOREIGN KEY (idskill) REFERENCES skill(id),
	FOREIGN KEY (idstack) REFERENCES stack(id)
);

CREATE TABLE sgpzf.persons(
	id 	INT 	AUTO_INCREMENT PRIMARY KEY,
	name 	VARCHAR(50),
	lastname VARCHAR (50),
	idcity INT,
	address VARCHAR (50),
	age INT,
	email VARCHAR(100),
	idgender INT,
	FOREIGN KEY (idcity) REFERENCES city(id),
	FOREIGN KEY (idgender) REFERENCES gender(id)
);

CREATE TABLE sgpzf.persons_skill(
	id 	INT 	AUTO_INCREMENT PRIMARY KEY,
	registration_date DATE,
	iperson INT,
	idskill INT,
	FOREIGN KEY (iperson) REFERENCES persons(id),
	FOREIGN KEY (idskill) REFERENCES skill(id)
);
	
