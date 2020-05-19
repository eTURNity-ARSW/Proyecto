/*Poblado USUARIO */

insert into usuario values ('sarahvieda','sarah','camila_vieda04@hotmail.com','1032502827','sarah1234');
insert into usuario values ('julianagarzon','juliana','juligardu@gmail.com','1023455669','juliana1234');
insert into usuario values ('juangarcia','juan','juancho@gmail.com','1029485687','juancho1234');
insert into usuario values ('prueba','prueba','prueba@gmail.com','1234566098','prueba1234');
insert into usuario values ('prueba','prueba','prueba@gmail.com','1234566098','prueba1234');
insert into usuario values ('juanda','juanda','juanda@hotmail.com','1022415774','juan1234');
insert into usuario values ('hackeados','hackeados','hackeados@hotmail.com','1022415774','juan1234');
insert into usuario values ('mariameza','maria','maria@mail.com','213242','maria1234');
insert into usuario values ('anaperez','Ana Perez','anaperez@mail.com','124244','ana1234');
insert into usuario values ('martinvargas','martin','martin@mail.com','2414','martin123');
insert into usuario values ('simonvargas','simon','simon@mail.com','131412','simon1234');
insert into usuario values ('felipetorres','felipe','felipe@mail.com','243522','felipe1234');
insert into usuario values ('felipe_g','Felipe Gomez','felipe@gmail.com','231312','felipe1234');

/*Poblado ENTIDAD */

insert into entidad values('A123','Bancolombia','Calle 32 no 10-31', 'Medellin', '2331840');
insert into entidad values('A124', 'BBVA','Calle 19 no 13-65', 'Bogota', '6557867');
insert into entidad values('A125','Banco Caja Social','Calle 100 no 13-54','Bogotá','2340958');
insert into entidad values('A135','Itau','calle 12#45-6','Bogota','623814');
insert into entidad values('B2567','CityBank','e12ei12e','Medellin','231244');
insert into entidad values('D345','Davivienda','Cra. 75 #Nº 23G- 40','Bogotá','3383838');
insert into entidad values('G876','AV Villas','Cra. 100 Bis #80','Bogotá','01-800-0518000');
insert into entidad values('G345','Banco de Occidente','Avenida El Dorado # 84A - 55, Local E-10 C.E. Dorado Plaza','Bogotá','01-800-0514652');
insert into entidad values('G346','Banco Popular','Av. El Dorado ## 75-25','Bogotá','6063456');
insert into entidad values('C123','Colpatria','CL 20 NO 82-20 LC 111 Y 112 CC Hayuelos','Bogotá','2543024');

/*Poblado SEDE */
insert into sede values ('S1','Bogota','Calle 13 no 15-64', '8-5','A123','C.C. Santa Fe');
insert into sede values ('S3','Medellin','Calle 52 no 54-28','8-4','A123','El Poblado');
insert into sede values ('S4','Bogota','Calle 52 no 54-28','8-4','A124','Cedritos');
insert into sede values ('5ec05f434b0504878ca73567','Cali','Avenida Cañas Gordas','10-3','A123','Pance');
insert into sede values ('5ec30ac42049d9158ccf93ad','Santa Marta','Calle 12 no 54-28','8-12','A123','Prado Plaza');
insert into sede values ('5ec31dd72049d9397c6be658','Santa Marta','Av. Del Ferrocarril','8-4','A123','Ocean mall');
insert into sede values ('5ec3222041097a0004d18c73','Ibague','calle 12#4-5','8-6','A123','El Bosque');



/*Poblado TURNO */
insert into turno values ('1','CAJA',true,'2020/04/12','julianagarzon','S1','2',0);
insert into turno values ('2','ASESORIA',true,'2020/04/12','sarahvieda','S1','1',1);
insert into turno values ('3','CAJA',true,'2020/04/12','julianagarzon','S3','2',0);
insert into turno values ('4','CAJA',true,'2020/04/12','julianagarzon','S4','2',0);
insert into turno values ('5','CAJA',true,'2020/04/12','sarahvieda','S4','2',1);
insert into turno values ('6','CAJA',true,'2020/04/12','juanda','S4','2',2);
insert into turno values ('5ebde62c6c2008400c6726f8','RECLAMOS',true,'2020/05/14','juanda','S3','2',2);
insert into turno values ('5ec05ba54b05047a8c4c95f0','CAJA',true,'2020/04/12','juanda','S3','3',3);
insert into turno values ('5ec062bab9a3cc40547f4380','ATENCION AL CLIENTE',true,'2020/05/11','sarahvieda','S1','3',5);
insert into turno values ('5ec0bb514b050445107707b2',' Caja',true,'2020-05-27','juanda','5ec05f434b0504878ca73567','2',1);
insert into turno values ('5ec0bc024b050445107707b3',' Asesoria ',true,'2020-12-28','julianagarzon','5ec05f434b0504878ca73567','7',2);
insert into turno values ('5ec0c5432049d9490058a224',' Solicitud',true,'2020-03-02','julianagarzon','5ec05f434b0504878ca73567','1',3);
insert into turno values ('5ec0c6ce23957d000412ce6d',' Caja',true,'2020-05-21','julianagarzon','S1','9',6);
insert into turno values ('5ebda7906c200809ec2b55e7','SEGUROS',true,'2020/05/14','juanda','S1','4',2);
insert into turno values ('5ebda7906c200809ec2b55e7','SEGUROS',true,'2020/05/14','juanda','S1','4',2);
insert into turno values ('5ebdb2466c20080908b67aef','RECLAMOS',true,'2020/05/14','sarahvieda','S1','4',4);
insert into turno values ('5ebdb24f6c20080908b67af1','RECLAMOS',true,'2020/05/14','sarahvieda','S3','4',1);
insert into turno values ('5ebda7906c200809ec2b55e7','SEGUROS',true,'2020/05/14','juanda','S1','4',2);
insert into turno values ('5ebda7b66c200809ec2b55e8','SEGUROS',true,'2020/05/14','julianagarzon','S1','1',3);
insert into turno values ('5ebdb2466c20080908b67aef','RECLAMOS',true,'2020/05/14','sarahvieda','S1','4',4);
insert into turno values ('5ebdb24f6c20080908b67af1','RECLAMOS',true,'2020/05/14','sarahvieda','S3','4',1);
insert into turno values ('5ec1c1662049d9446824ed60',' Caja',true,'2021-12-01','julianagarzon','5ec05f434b0504878ca73567','7',4);
insert into turno values ('5ec1c30d2049d91a1c76f342',' Asesoria ',true,'2020-05-17','julianagarzon','5ec05f434b0504878ca73567','9',5);
insert into turno values ('5ec1c41b2049d9486c7ebad6',' Caja',true,'','julianagarzon','5ec05f434b0504878ca73567','1',6);
insert into turno values ('5ec1c42b2049d9486c7ebad7',' Caja',true,'2020-05-17','julianagarzon','5ec05f434b0504878ca73567','9',7);
insert into turno values ('5ec1c79f2049d909b4b1b30d',' Asesoria ',true,'2020-05-17','julianagarzon','5ec05f434b0504878ca73567','3',8);
insert into turno values ('5ec1c8f22049d945d834814f',' Caja',true,'2020-05-17','julianagarzon','S1','3',7);
insert into turno values ('5ec1cd8f4b05045f04412055',' Solicitud',true,'2020-05-17','juanda','S1','8',8);
insert into turno values ('5ec1cf1c4b05045f04412057',' Asesoria ',true,'2020-05-18','juanda','S3','4',4);
insert into turno values ('5ec1d3494b050438d0b35743',' Caja',true,'2020-05-20','juanda','S3','7',5);
insert into turno values ('5ec1d6324b0504869031d2bd',' Asesoria ',true,'2020-05-01','juanda','5ec05f434b0504878ca73567','2',9);
insert into turno values ('5ec1d6914b0504869031d2be',' Caja',true,'2020-05-02','juanda','5ec05f434b0504878ca73567','2',10);
insert into turno values ('5ec1d6da4b0504869031d2bf',' Caja',true,'2020-05-03','juanda','5ec05f434b0504878ca73567','10',11);
insert into turno values ('5ec1da584b05044a6c158995',' Caja',true,'2020-05-06','juanda','S1','10',9);
insert into turno values ('5ec1dabf4b050403e0fb2ffd',' Asesoria ',true,'2020-05-12','juanda','S1','8',10)
insert into turno values ('5ec1dffd2049d91064e98a44',' Caja',true,'2020-05-07','julianagarzon','S1','4',11)
insert into turno values ('5ec1e0942049d91064e98a45',' Asesoria ',true,'2020-05-17','julianagarzon','5ec05f434b0504878ca73567','2',12)
insert into turno values ('5ec21ee64b05046648cc091a',' Solicitud',true,'2020-06-10','juanda','S3','5',6);
insert into turno values ('5ec21fc74b05045210a1dc6e',' Caja',true,'2020-05-01','juanda','S3','4',7);
insert into turno values ('5ec220444b050421a03a44da',' Asesoria ',true,'2020-05-02','juanda','S3','6',8);
insert into turno values ('5ec2212d4b0504306400165d',' Caja',true,'2020-05-03','juanda','S3','3',9);
insert into turno values ('5ec2222b4b05042ff45a0fae',' Asesoria ',true,'2020-05-04','juanda','S3','4',10);
insert into turno values ('5ec222904b050414ac147483',' Solicitud',true,'2020-05-05','juanda','S3','2',11);
insert into turno values ('5ec224334b05043e0c8778e2',' Solicitud',true,'2020-05-06','juanda','S3','2',12);