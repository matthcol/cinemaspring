jboss-cli.(bat|sh) -c --command="ma commande avec des espaces entre quotes"

commandes possibles en mode standalone:
	# install driver (or install it as a module)
	deploy <SomePath>/mysql-connector-java-8.0.17.jar
	deploy <SomePath>/postgresql-42.2.8.jar

	# datasource connecté à bdd mysql
	data-source add --name=cinemaDS \
		--jndi-name=java:/jdbc/cinema \ 
		--driver-name=mysql-connector-java-8.0.17.jar \
		--connection-url=jdbc:mysql://localhost:3306/cinedev?serverTimezone=Europe/Paris \
		--password=password --user-name=cinema 
	# datasource connecté à bdd postgresql
	data-source add --name=cinemaDS \
		--jndi-name=java:/jdbc/cinema \
		--driver-name=postgresql-42.2.8.jar  \
		--connection-url=jdbc:postgresql://localhost:5432/cinedev \
		--password=password --user-name=cinema

	# test datasource
	data-source test-connection-in-pool --name=cinemaDS
 
	# enable/disable/remove datasource
	data-source disable --name=cinemaDS
	data-source enable --name=cinemaDS
	data-source remove --name=cinemaDS

	# recharger configuration
	reload
	
	# restart server
	shutdown --restart=true

	# (un)deploy app
	deploy <SomePath>/cinema.war
	undeploy cinema.war
	
	# consulter
	ls /subsystem=datasources/data-source
	ls /subsystem=datasources/jdbc-driver
	ls deployment