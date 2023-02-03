create schema if not exists `servlets` default character set utf8 ;
use `servlets` ;

drop table if exists employee;

create table employee(
    id  int(3) not null auto_increment,
    first_name  varchar(50) default null,
    last_name   varchar(50) default null,
    username    varchar(50) default null,
    password    varchar(50) default null,
    address     varchar(50) default null,
    contact     varchar(50) default null,
    primary key (id)
);
