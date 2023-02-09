create schema if not exists `servlets` default character set utf8 ;
use `servlets` ;

drop table if exists lugar_parqueadero;
drop table if exists parqueaderos_disponibles;
drop table if exists usuario;
drop table if exists tipo_usuario;


create table lugar_parqueadero(
    id                              int  not null auto_increment,
    nombre_usuario                  varchar(100) default null,
    tipo_vehiculo                   varchar(100) default null,
    tiempo                          varchar(100) default null,
    placa                           varchar(100) default null,
    color                           varchar(100) default null,
    marca                           varchar(100) default null,
    descripcion_adicional           varchar(100) default null,
    primary key (id)
);

create table parqueaderos_disponibles(
    id                              int  not null auto_increment,
    cantidad_ocupados               int not null,
    cantidad_disponibles            int not null,
    primary key (id)
);

create table tipo_usuario(
    id                              int  not null auto_increment,
    tipo                            varchar(100) default null,
    primary key (id)
);

create table usuario(
    id                              int  not null auto_increment,
    nombre                          varchar(100) default null,
    clave                           varchar(100) default null,
    correo                          varchar(100) default null,
    fecha_nacimiento                varchar(100) default null,
    direccion                       varchar(100) default null,
    tipo_usuario                    int  not null,
    primary key (id),
    constraint fk_tipo_usuario      foreign key (tipo_usuario) references tipo_usuario(id)
);
