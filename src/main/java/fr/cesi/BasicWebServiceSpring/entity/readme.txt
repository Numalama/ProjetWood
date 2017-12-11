Créer une nouvelle base de données vide dans le serveur.

Ces fichiers sont a placer dans le package entity du projet (ex : com.idoine.entity)
Un ctrl replace massif sera surement necessaire pour mettre à jour les package dans chaque classe d'entité pour le faire correspondre au projet.

Le pom.xml doit contenir ces dépendances (si pas déja fait) :
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>

Confirguration hibernate :
Le fichier properties d'accés aux données (ex : hibernate.properties) doit contenir les lignes suivantes en plus des lignes url,username,password :

spring.datasource.url = jdbc:mysql://localhost:3306/NEW_DB_NAME
spring.jpa.show-sql = true
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.hibernate.ddl-auto = update

si la base n'est pas générée au lancement de l'appli alors changer la valeur de spring.jpa.hibernate.ddl-auto = create, puis repasser a "update"

Voici un tutoriel pour apprendre à les implémenter : https://spring.io/guides/gs/accessing-data-jpa/
La section "Define a simple entity" montre comment créer une entité. Pas besoin ici puisqu'elle sont deja crées.
La section "Create simple queries" montre comment utiliser les entités, c'est cette section qui est intérréssante.

Pour coder en live avec spring boot :
Ajouter cette dépendance maven au pom.xml : https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html
lancer ensuite la commande "mvn spring-boot:run" a la racine du projet. Cette commande lance un serveur local et est censée compiler le code on the fly.