create schema if not exists `servlets` default character set utf8 ;
use `servlets` ;

drop table if exists lugar_parqueadero;

create table lugar_parqueadero(
    id                              int(3) not null auto_increment,
    nombre_usuario                  varchar(100) default null,
    tipo_vehiculo                   varchar(100) default null,
    tiempo                          varchar(100) default null,
    placa                           varchar(100) default null,
    color                           varchar(100) default null,
    marca                           varchar(100) default null,
    descripcion_adicional           varchar(100) default null,
    primary key (id)
);


drop table if exists parqueaderos_disponibles;

create table parqueaderos_disponibles(
    id                              int(3) not null auto_increment,
    cantidad                        int,
    primary key (id)
);

