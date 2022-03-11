# UD4_PostgreSQL
El primer que hem de fer es crear un projecte amb maven, per poder introduir-hi les dependències més facilment al fitxer pom.xml. Una vegada creat el projecte anem a crear els paquets i les classes necessaries:

- La classe per controlar les excepcions.

- Dins la classe EinesCadenes tenim tots els mètodes necessaris per tractar amb els String que rebrem com a resultat dels mètodes que emprarem per rebre dades de les consultes que facem amb PostgreSQL.

- Dins la classe BaseDades hi tendrem els mètodes per obtenir la informació de les consultes que facem a la base de dades.

- Tenim un mètode per cada taula que volem obtenir, en aquest cas ens retorna la Activitat que tengui el codi que li passam per paràmetre, ho feim amb PreparedStatement.

- Ara el que farem serà modificar una assignatura, ho farem amb la classe PGConnection i amb el seu mètode conn.addDataType(); seguidament del PreparedStatement amb la consulta de UPDATE.

- En aquest cas els pojos seràn una mica diferents, al principi son iguals que amb qualsevol pojo normal però després haurem de fer extends a PGObject, el qual necessita els overrides de getValue() i de setValue().

- Anem al main i cridem als mètodes creats per rebre la informació per consola.

- Aquí el que feim es crear una instancia de la classe de Java Properties per poder passarli per paràmetre a la instància de la classe BaseDades, on dins les propietats li especificarem la url de la connexió i les credencials per accedir-hi.

- Despres dins el try catch agafant la excepció propia creada anteriorment, hi cream una instància del POJO Assignatura i li assignam l’objecte que rebrem del mètode de la classe DataBase db.getAssignatura() passantli per paràmetre el codi de la assignatura que volem recuperar.

- L’output serà el resultat de la consulta dins el mètode db.getAssignatura() amb aquell codi que li hem especificat.
