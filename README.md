### Movie Advisor
![diagrama-movieadvisor](https://user-images.githubusercontent.com/93687744/191080100-05eede7b-fbe6-4719-953a-c7c75a9bdb0f.png)

### Sintaxis: java -jar movieadvisor.jar [OPCIONES]

	-lg
	Lista los diferentes géneros de películas de la colección.
	No se pueden utilizar más parámetros.
	
	-ag genero1,genero2,genero...
	Lista aquellas películas que pertenecen a al menos uno de los géneros 
	que se indican.	El listado de géneros no puede incluir espacios.
	
	-tg genero1,genero2,genero...
	Lista aquellas películas que pertenecen a todos y cada uno de los 
	géneros que se 	indican. El listado de géneros no puede incluir espacios. 
	
	-y año
	Lista aquellas películas que se estrenaron en el año indicado.
	El año debe expresarse con 4 cifras.
	
	-b desde,hasta
	Lista aquellas películas que se estrenaron entre los años DESDE y HASTA.
	Los años indicados están incluidos. Deben expresarse con 4 cifras.
	
	-t titulo
	Lista aquellas películas cuyo título contiene la cadena proporcionada.
	Se ignorará el uso de mayúsculas/minúsculas en la comparación.
	
	-h
	Muestra este mensaje de ayuda.
	
### EJEMPLOS DE USO

- java -jar movieadvisor.jar -y 2018 -ag Action,Comedy
*Muestra las películas estrenadas de 2018 de acción y/o de comedia.*

- java -jar movieadvisor.jar -t heart
*Muestra las películas cuyo título contiene la palabra heart.*

- java -jar movieadvisor.jar -td Action,Sci-Fi -b 1990,2010 -t star
*Muestra las películas cuyo título contiene la palabra star, pertenecen al 
género de acción y ciencia ficción y fueron estrenadas entre 1990 y 2010.*   

- java -jar movieadvisor.jar -lg
*Muestra un listado con todos los géneros.*


LICENCIAS

Los datos utilizados sobre películas utilizados en este ejemplo son
reales y están sacados del sitio web www.imdb.com. Ten en cuenta
<<<<<<< HEAD
que solo puede ser usada con fines personales y no comerciales.
=======
que solo puede ser usada con fines personales y no comerciales.
>>>>>>> a5a3850c2642b6330fcd9a60ae08277fc5997acb
