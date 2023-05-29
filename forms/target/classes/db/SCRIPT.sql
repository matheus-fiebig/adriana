create database adriana;
use adriana;

create table lugar(
	id int auto_increment primary key,
    city varchar(100),
    country varchar(100),
    description varchar(100),
    state varchar(100)
);

create table pessoa(
	id int auto_increment primary key,
	cpf varchar(100),
    first_Name varchar(100),
    last_Name varchar(100),
    birthDate date
);


create table veiculo(
	id int auto_increment primary key,
	color varchar(100),
    brand varchar(100),
    fabricationYear int,
    licensePlate varchar(100),
    model varchar(100)
);