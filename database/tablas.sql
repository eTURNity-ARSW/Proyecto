CREATE TABLE usuario (
	username varchar NOT NULL,
	nombre varchar NOT NULL,
	correo varchar NOT NULL,
	documento varchar NOT NULL,
	contrasena varchar NOT NULL
);

CREATE TABLE turno (
	identifier varchar NOT NULL,
	tipo varchar NOT NULL,
	valido bool NOT NULL,
	fecha date NOT NULL,
	turnousuario varchar NOT NULL,
	turnosede varchar NOT NULL
);


CREATE TABLE servicio (
	typeservicio varchar NOT NULL,
	description varchar NOT NULL,
	serviciosede varchar NOT NULL
);


CREATE TABLE sede (
	id varchar NOT NULL,
	ciudad varchar NOT NULL,
	direccion varchar NOT NULL,
	horario varchar NOT NULL,
	entidad varchar NOT NULL,
	sedesentidad varchar NOT NULL
);




CREATE TABLE entidad (
	nit varchar NOT NULL,
	nombre varchar NOT NULL,
	direccion varchar NOT NULL,
	ciudad varchar NOT NULL,
	telefono varchar NOT NULL
);

