--Create table USER
create table usuario(
	username varchar(20) not null,
	nombre varchar(50) not null,
	email varchar(50) not null,
	documento varchar(50) not null,
	contrasena varchar(20) not null
	);


--PKS
alter table usuario  add constraint pk_usuario primary key(username);

--UKs
alter table usuario  add constraint uk_usuario_username unique(username);

-- Checks
alter table usuario add constraint ck_usuario_correo check(correo like '%@%.%' and not(correo like('%.')) and not(correo like '%@.%') and not(correo like '%.@%'));

--Create table SERVICES
CREATE TABLE Servicio(
	tipo int4 not null,
	descripcion varchar(100)
);
--PKS
alter table servicio add constraint servicio_pk primary key (tipo);

--Create table ServicesXsede
create table serviciosxsede(
	sede int4 not null,
	servicio int4 not null
);

--PKS
alter table serviciosxsede add constraint sxs_pk primary key (sede,servicio);

--FKS
alter table serviciosxsede add constraint servicios_sxs_fk foreign key (servicio) references servicio(tipo);
alter table serviciosxsede add constraint sede_sxs_fk foreign key (sede) references sede(id);