alter table turno add constraint FK_TURNO_USUARIO foreign key (turnouserid) references usuario(username) on delete cascade; 
alter table turno add constraint FK_TURNO_SEDE foreign key (turnosedeid) references sede(id) on delete cascade;
alter table sede add constraint FK_SEDE_ENTIDAD foreign key (sedesentidadid) references entidad(nit) on delete cascade;
