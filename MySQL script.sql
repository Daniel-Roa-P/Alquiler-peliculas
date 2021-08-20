CREATE SCHEMA `tienda` ;

CREATE TABLE tienda.peliculas (
nombre VARCHAR(100) PRIMARY KEY,
urlImagen VARCHAR(1000) NOT NULL,
descripcion VARCHAR(2000) NOT NULL,
categoria VARCHAR(100) NOT NULL,
disponibles INT(4) NOT NULL,
precio INT(6) NOT NULL
);

CREATE TABLE tienda.usuarios (
nombre VARCHAR(100) PRIMARY KEY,
deuda INT(6) NOT NULL,
prestadas VARCHAR(10000) NOT NULL
);

INSERT tienda.peliculas (nombre,urlImagen,descripcion,categoria,disponibles,precio)

VALUES ('Rapidos y Furiosos 9'
,'https://spoiler.bolavip.com/__export/1624372370670/sites/bolavip/img/2021/06/22/490827891_contest_1010968_standard_1623951222_crop1624369952765.jpg_72598852.jpg'
,'Dom Toretto vive una vida tranquila junto a Letty y su hijo, pero el peligro siempre regresa a su vida. En esta ocasión, el equipo se enfrenta a un complot mundial orquestado por el asesino más temible del mundo: el hermano de Dom.'
,'Accion'
,10
,10000)
,
('Escuadron suicida 2'
,'https://es.web.img3.acsta.net/pictures/21/03/30/15/41/3645913.jpg'
,'Con tal de salir de una prisión infernal, los supervillanos más peligrosos del mundo aceptan una misión del Gobierno: viajar a una remota isla, enemiga de los Estados Unidos y repleta de soldados, para destruir un laboratorio de alta tecnología.'
,'Accion'
,5
,12000)
, ('Monster Haunter'
,'https://pics.filmaffinity.com/Monster_Hunter_La_cacer_a_comienza-171950842-large.jpg'
,'En un mundo extraño, la teniente Artemis y su equipo de soldados de élite deben unir fuerzas con un misterioso cazador para luchar contra poderosos monstruos.'
,'Accion'
,7
,8000)
, ('Bad Boys para siempre'
,'https://es.web.img3.acsta.net/pictures/19/12/19/12/29/3194366.jpg'
,'Los veteranos agentes Mike Lowery y Marcus Burnett vuelven a colaborar para detener a Armando Armas. En esta ocasión, los apoya el equipo AMMO, un grupo de élite del Departamento de Policía de Miami.'
,'Accion'
,3
,9000)
, ('Mortal Kombat'
,'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQaAU_52egCuqLrxqrRCWtU1KO7_TMgkI0gLJRDRMm-8yZczOOC'
,'Cole Young, luchador de MMA, desconoce su ascendencia y tampoco sabe por qué el emperador Shang Tsung ha enviado a su mejor guerrero para atraparlo. Ante esta situación, Cole busca a Sonya Blade siguiendo las indicaciones de Jax.'
,'Accion'
,20
,5000)
, ('El Vinculo'
,'https://pics.filmaffinity.com/il_legame-609630553-large.jpg'
,'Una mujer va a visitar a la familia de su prometido y experimenta una serie de extraños sucesos. Pronto se enfrenta a una maldición que tiene la intención de destruir a su hija.'
,'Terror'
,10
,10500)
, ('Su Casa'
,'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSN2-ByPB00D1Eg0OVRWhsrrdHluqQwEbDLSMU5zG0s2ostcuqb'
,'Una pareja de refugiados huye de Sudán del Sur, país devastado por la guerra. Ellos luchan por adaptarse a su nueva vida en una ciudad inglesa.'
,'Terror'
,17
,6000)
, ('Voces'
,'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcS1STclpcL5q-ILkfJjNDVx8J8bVRVlpKzmT8s0AYm4-2dyydk-'
,'Sara, Daniel y su hijo llegan a su casa nueva sin saber las historias que contiene. La propiedad es conocida como "la casa de las voces". El niño, Eric, es el primero en escuchar extraños sonidos y voces que parece que intentan comunicarse.'
,'Terror'
,4
,7500)
, ('La cacería'
,'https://pics.filmaffinity.com/La_caza-579956868-large.jpg'
,'Doce desconocidos despiertan en el claro de un bosque. No se conocen, pero tienen algo en común: un grupo de millonarios los ha elegido para divertirse cazándolos como si fueran animales salvajes. No obstante, algunos venderán cara su piel.'
,'Terror'
,14
,6200)
, ('El conjuro 3'
,'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTwr3f0XDPFVH7ulQpC7lB38R6WQAFdxwPhSxN-cVjWUMbIjoHZ'
,'Los investigadores de fenómenos paranormales Ed y Lorraine Warren se enfrentan a un nuevo caso: el de un hombre acusado de un terrible asesinato, que asegura haber sido poseído por un demonio.'
,'Terror'
,5
,11000)
, ('Zootopia'
,'https://lumiere-a.akamaihd.net/v1/images/movie_poster_zootopia_866a1bf2.jpeg?region=0%2C0%2C300%2C450'
,'La metrópoli Zootopía es una ciudad de mamíferos. Allí, la optimista agente Judy Hopps se convierte en la primera conejita de un cuerpo policial. Judy está decidida a demostrar su valentía y se mete en un caso con Nick Wilde, un zorro.'
,'Animada'
,14
,13600)
, ('Shrek'
,'https://r4.abcimg.es/resizer/resizer.php?imagen=https%3A%2F%2Fstatic4.abc.es%2Fmedia%2Fpeliculas%2F000%2F004%2F509%2Fshrek-1.jpg&nuevoancho=683&medio=abc'
,'Shrek es un ogro verde, gruñón y altamente territorial que ama la soledad. Todos están en su contra, por lo que asusta a los aldeanos que entran al pantano en el que vive. Un día conoce a un burro parlante que huía de su dueña.'
,'Animada'
,18
,14000)
, ('Ratatoille'
,'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSGV_MQqXkMDDVfukpukQWkUjf-t5St659AtNWolVSuSzjAA2Ko'
,'Remy es un residente de París que aprecia la buena comida y tiene un paladar bastante sofisticado. Él desea convertirse en un chef para crear y disfrutar de diversas obras de arte culinarias. El único problema es que Remy es una rata.'
,'Animada'
,11
,18000)
, ('Kung Fu Panda'
,'https://static.wikia.nocookie.net/cine/images/b/be/Kung_Fu_Panda_HA.jpg/revision/latest/top-crop/width/360/height/450?cb=20210422191953'
,'El panda Po sueña en convertirse en un maestro del kung-fu. Su sueño se hace una realidad cuando es inesperadamente elegido para cumplir una antigua profecía y debe estudiar artes marciales con sus ídolos, los Cinco Furiosos.'
,'Animada'
,5
,8200)
, ('El rey leon'
,'https://es.web.img3.acsta.net/medias/nmedia/18/68/20/31/19785394.jpg?coixp=47&coiyp=41'
,'Tras la muerte de su padre, Simba vuelve a enfrentar a su malvado tío, Scar, y reclamar el trono de rey.'
,'Animada'
,19
,9400)
, ('1917'
,'https://es.web.img3.acsta.net/pictures/20/01/09/15/10/0234685.jpg'
,'Durante la Primera Guerra Mundial, dos jóvenes soldados británicos reciben una orden, aparentemente, imposible de ejecutar: en una carrera contra el reloj.'
,'Drama'
,17
,19700)
, ('Paternidad'
,'https://m.media-amazon.com/images/M/MV5BMzU5YWYzZGMtNTE2My00NDE0LTgxNWYtZDYzYjI2YzM3OWJlXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg'
,'Un padre viudo se enfrenta a dudas, miedos, angustias y pañales sucios mientras cría solo a su hija tras la muerte de su esposa.'
,'Drama'
,3
,10000)
, ('Life in a year'
,'https://es.web.img2.acsta.net/pictures/20/12/02/15/57/1426320.jpg'
,'Daryn, de 17 años, se entera de que su novia se está muriendo y se propone brindarle las experiencias de toda una vida en el año que le queda por vivir.'
,'Drama'
,1
,3000)
, ('Diecisiete'
,'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcT7fqMLEUfvvhzWrQPW_qPvlAJ2gADH1X5E0ZjLhTGxCzK2gXx2'
,'Héctor es un joven de 17 años poco comunicativo que se encuentra internado en un centro de menores. Durante una terapia con perros, establece un vínculo especial con uno de ellos, pero todo cambia cuando la perra es adoptada.'
,'Drama'
,6
,6000)
, ('Contra lo imposible'
,'https://www.mundopeliculas.tv/wp-content/uploads/2019/09/Ford-v-Ferrari.jpg'
,'El visionario Carroll Shelby y el conductor británico Ken Miles reciben la misión de construir un nuevo automóvil con el fin de derrocar el dominio de Ferrari en el Campeonato del Mundo de Le Mans de 1966.'
,'Drama'
,10
,14800);

INSERT tienda.usuarios (nombre,deuda,prestadas)

VALUES ('Andres'
,29700
,'1917,Paternidad')
, 
('Laura'
,11000
,'El conjuro 3')
,
('Emil'
,24000
,'Rapidos y Furiosos 9,Mortal Kombat,Bad Boys para siempre')
,
('Daniel'
,45600
,'Zootopia,Shrek,Ratatoille');