# Actividad: Desarrollar una API REST para gestionar un campeonato de Juegos
de Palabras
### El campeonato consiste en ir acumulando puntos al jugar a una serie de juegos de adivinar palabras.


Cada juego tendrá una dificultad, puede tener una longitud máxima de palabra a adivinar,
un número de intentos, una puntuación máxima, unas instrucciones...


Cada vez que se juega una partida se almacena el jugador, las partidas, el juego y la puntuación.
La competición es doble, entre equipos e individual, por lo que existen clasificaciones en ambas
categorías. Un jugador puede pertenecer a un sólo equipo.


La API gestionará el CRUD de jugadores, juegos (opcional, en cuyo caso habrá que tener en la
BBDD una serie de juegos pre cargados) y equipos.


El servidor tendrá almacenadas las palabras en ficheros2 o en base de datos. La API gestionará
la petición de palabras al servidor. Podrá pedir una o más palabras de forma aleatoria. Se podrá
indicar que la palabra empiece de cierta manera (o que termine). Se deberá poder consultar la
validez de una palabra en concreto (si está disponible se devuelve true).


Jugadores, equipo y juego deben tener una imagen identificativa. Se deben realizar test automatizados.
En cada juego es el cliente el encargado de la gestión del juego, enviando, al finalizar una partida,
el resultado de la partida, puntos, intentos... al servidor.
