

# Proyecto ARSW
![Capture](https://user-images.githubusercontent.com/43153078/74990273-dea84100-5410-11ea-9347-56698d71c23f.PNG)

## Asignatura 

Arquitectura de Software 

## Integrantes
- Juliana Garzón Duque
- Sarah Camila Vieda Castro.

## Descripción 
Nuestra aplicación web busca resolver la problemática de los largos tiempos de espera en diferentes entidades bancarias permitiendo a los usuarios tener la posibilidad de solicitar sus turnos en la fila por medio de nuestra aplicación web, de esta manera daremos al usuario libertad en el manejo del tiempo que perdería haciendo las largas filas en la entidad, permitiendo que el tiempo sea mejor aprovechado. De igual manera buscamos ofrecer a la entidad que recibe a los usuarios mantener un registro y control de los turnos solicitados, lo cual ayudaría en el análisis de los datos obtenidos a partir de nuestra aplicación. 

Para asegurarnos de que el usuario se presente en el momento del turno, lo mantendremos informado respecto a tiempos de estimación y generando avisos o recordatorios en momentos que se consideren necesarios antes de que el usuario sea atendido. 

## Despliegue 

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://eturnity.herokuapp.com)

[![CircleCI](https://circleci.com/gh/julianagarzond/AREP-LAB4.svg?style=svg)](https://circleci.com/gh/julianagarzond/AREP-LAB4)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/acbe20c5b1e9464399a8154f1cc73b2e)](https://www.codacy.com/gh/eTURNity-ARSW/Proyecto?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=eTURNity-ARSW/Proyecto&amp;utm_campaign=Badge_Grade)


## Mockups
### Servicios del usuario
  ![proyecto1](https://user-images.githubusercontent.com/43153078/74982676-941fc800-5402-11ea-9abf-a7f5234e221e.PNG)

  ![proyecto2](https://user-images.githubusercontent.com/43153078/74982680-94b85e80-5402-11ea-9854-3256d1ef98a1.PNG)

  ![proyecto3](https://user-images.githubusercontent.com/43153078/74982682-9550f500-5402-11ea-804f-94c400802730.PNG)

  ![proyecto4](https://user-images.githubusercontent.com/43153078/74982683-9550f500-5402-11ea-9b06-f15cb1361528.PNG)

  ![proyecto5](https://user-images.githubusercontent.com/43153078/74982684-9550f500-5402-11ea-81af-b8e9e4f0ee00.PNG)
  
  
### Servicios de la empresa
<img width="494" alt="eTURNity" src="https://user-images.githubusercontent.com/49318314/75055601-52932980-54a3-11ea-945d-b38910d55d6b.png">

<img width="487" alt="Home eTURNity" src="https://user-images.githubusercontent.com/49318314/75055603-532bc000-54a3-11ea-8e82-16ffb6e164f6.png">

<img width="489" alt="Login Enterprise" src="https://user-images.githubusercontent.com/49318314/75055605-545ced00-54a3-11ea-8a13-743e24248a5e.png">



## Diagramas

## Diagrama Entidad-Relación

![diagrama entidad-relacion](https://user-images.githubusercontent.com/48154086/82403772-44fb2a80-9a25-11ea-8a68-e64eaa1ef71d.PNG)

## Diagrama Clases

![diagramaclases](https://user-images.githubusercontent.com/48154086/82404197-45e08c00-9a26-11ea-92a3-fc1dc3bcb53f.PNG)

## Diagrama Casos de Uso 

Como historias de Usuario deseamos tomar a los clientes de los bancos y los bancos mismos como parte de nuestro segmento de clientes, de esta manera podremos ofrecer un mejor servicio a los usuarios de la aplicación.

El usuario tiene los siguientes casos de uso:

![casosusuario](https://user-images.githubusercontent.com/48154086/82404470-01a1bb80-9a27-11ea-9cde-aff802ed27a5.PNG)

La entidad tiene los siguientes casos de uso:

![casosentidad](https://user-images.githubusercontent.com/48154086/82404879-04e97700-9a28-11ea-8df3-5509b6bfbfd5.PNG)


## Diagrama de Componentes

![diagrama de componentes](https://user-images.githubusercontent.com/48154086/82412043-83e6ab80-9a38-11ea-889c-9532b146f559.PNG)


## Diagrama de Despliegue

![diagramadespligue](https://user-images.githubusercontent.com/48154086/82413507-1720e080-9a3b-11ea-9462-a03c1c7ba769.PNG)


## Diagrama de Base de Datos 

![BASE DE DATOS](https://user-images.githubusercontent.com/48154086/82384180-eae27100-99f4-11ea-8453-211fd4c78375.PNG)


## Atributos no Funcionales

## Rendimiento 

Para medir el rendimiento se hizo uso de una herramienta llamada "Jmeter" la cual permite realizar peticiones de manera concurrente al recurso que se le asigne, en este caso tomamos 1000 hilos y realizamos las consultas a la información que contienen las entidades como sus turnos,sedes e información y el resultado de la ejecución es que al enviar 1000 peticiones hay un porcentaje de error de aproximadamente 9,4% lo cual quiere decir que de 1000 peticiones aproximadamente 90 no responden.

En el siguiente video queda registrada la prueba realizada

[![Watch the video](https://img.youtube.com/vi/7FnxyIx0OgM/maxresdefault.jpg)](https://www.youtube.com/watch?v=7FnxyIx0OgM)




## Manual de Usuario 
[![Watch the video](https://img.youtube.com/vi/UEPQ8RvSs3A/maxresdefault.jpg)](https://youtube.com/watch?v=UEPQ8RvSs3A)



## Manual de Entidad

[![Watch the video](https://img.youtube.com/vi/Fs-uxkFI3Gc/maxresdefault.jpg)](https://youtube.com/watch?v=Fs-uxkFI3Gc)



## Heroku 

https://eturnity.herokuapp.com/

