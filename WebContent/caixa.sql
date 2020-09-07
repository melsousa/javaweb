create database caixa;
use caixa;
create table usuario(id int primary key not null auto_increment, nome varchar(60) , senha varchar(60));
create table imageUm(id int primary key not null auto_increment, imagem varchar(256), titulo varchar(256), texto TEXT);
create table tabelaUm(id int primary key not null auto_increment, tituloUm varchar(256), paragrafoUm TEXT);
create table tabelaDois(id int primary key not null auto_increment, tituloDois varchar(256), paragrafoDois TEXT);
create table tabelaTres(id int primary key not null auto_increment, tituloTres varchar(256), paragrafoTres TEXT);
create table Video(id int primary key not null auto_increment, video varchar(256), titulo varchar(256), texto TEXT);