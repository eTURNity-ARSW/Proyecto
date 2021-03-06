CREATE TABLE usuario (
	username varchar NOT NULL,
	nombre varchar NOT NULL,
	correo varchar NOT NULL,
	documento varchar NOT NULL,
	contrasena varchar NOT NULL
);

CREATE TABLE turno (
	identifier varchar(50) NOT NULL,
	tipo varchar NOT NULL,
	valido bool NOT NULL,
	fecha varchar NOT NULL,
	turnouserid varchar NOT NULL,
	turnosedeid varchar NOT NULL,
	modulo varchar NOT NULL,
	id int2 NOT NULL,
	CONSTRAINT turno_pkey PRIMARY KEY (identifier)
);


CREATE TABLE sede (
	id varchar NOT NULL,
	ciudad varchar NOT NULL,
	direccion varchar NOT NULL,
	horario varchar NOT NULL,
	sedesentidadid varchar NOT NULL,
	nombre varchar NOT NULL,
	CONSTRAINT sede_pk PRIMARY KEY (id)
);


CREATE TABLE entidad (
	
	nit varchar NOT NULL,
	nombre varchar NOT NULL,
	direccion varchar NOT NULL,
	ciudad varchar NOT NULL,
	telefono varchar NOT NULL,
	CONSTRAINT entidad_pk PRIMARY KEY (nit)
);
