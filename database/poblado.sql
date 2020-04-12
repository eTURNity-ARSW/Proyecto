insert into usuario values ('sarahvieda','sarah','camila_vieda04@hotmail.com','1032502827','sarah1234');
insert into usuario values ('julianagarzon','juliana','juligardu@gmail.com','1023455669','juliana1234');
insert into usuario values ('juangarcia','juan','juancho@gmail.com','1029485687','juancho1234');
insert into usuario values ('prueba','prueba','prueba@gmail.com','1234566098','prueba1234');

insert into entidad values('A123','Bancolombia','Calle 32 no 10-31', 'Medellin', '2331840');
insert into entidad values('A124', 'BBVA','Calle 19 no 13-65', 'Bogota', '6557867');

insert into sede values ('S1','Bogota','Calle 13 no 15-64', '8-5','A123');
insert into sede values ('S2', 'Bogota','Calle 59 no 39-66', '8-3', 'A123');

insert into turno values ('C1', 'CAJA',true,'2020/04/12','julianagarzon','S1');
insert into turno values('A1','ASESORIA',true,'2020/04/12','sarahvieda','S1');
insert into turno values('AC1','ATENCION AL CLIENTE', true, '2020/04/12','juangarcia','S2');
