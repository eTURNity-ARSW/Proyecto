alter table turno add constraint FK_TURNO_USUARIO foreign key (turnousuario) references usuario(username) on delete cascade; 
alter table turno add constraint FK_TURNO_SEDE foreign key (turnosede) references sede(id) on delete cascade;
alter table servicio add constraint FK_SERVICIO_SEDE foreign key (serviciosede) references sede(id) on delete cascade;
alter table sede add constraint FK_SEDE_ENTIDAD foreign key (sedesentidad) references entidad(nit) on delete cascade;
alter table tiposervicio add constraint PK_TIPO_SERVICIO primary key (sede,servicio);
alter table tiposervicio add constraint FK_TIPO_SEDE foreign key (sede) references sede(id) on delete cascade;
alter table tiposervicio add constraint FK_TIPO_SERVICIO foreign key (servicio) references servicio(typeservicio) on delete cascade;
