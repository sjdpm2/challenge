Components used:

	Database: MySql 8.0.16
	Database name: challenge_database
	User: root
	Password: root
	Port:3306

	IDE: sts-3.9.10.RELEASE
	Java: JDK 1.8
	Port: 8080

Instructions:

	1.- Open heidi and import the database bk provided
	2.- Unzip the folder
	3.- Open the IDE and import the folder with the option File >> Open projects from File System
	4.- If is necessary, clean the project with the option Project >> Clean and update the dependencies clicking with the right click on the project and select the option Maven >> Update project 
	5.- Configure the connection with the database in the file "application.properties" if is needed.
	6.- Execute the project as Spring Boot App

Derivelables:
	1.- To login the app you can create an user or use:
		username: rodrigo.mejia@mail.com
		password: password
	2.- The WS is available in the URL "http://localhost:8080/api/report/candidates" and provide a Json
	3.- Apache camel if configured to sent a file with the WS data in the previous item, so if the application runs in a different port is necessary to update the URL on the file "AttachmentProcessor.java" in the package "com.telusinternational.challenge.integration"
	4.- If you want to change the time of the execution you can edit the cron in the line "from("quartz2://simpleTimer?cron=0+0+10+%3F+*+*")" in the file "AdminReport.java" from the package "com.telusinternational.challenge.integration"
	5.- The counter of visits is saved on the file "VisitCounter.txt" into "challenge" folder
	6.- The ER Diagram is into "challenge" folder and is available on png and mwb format

Description:
	The application allows you to register a new user and select a country, after the registration process you can login with the correct credentials and you will be able to see the available committees and the committees already voted.
	If you click the link "View candidates" you will see a table with the candidates of a committee and vote for one of them clicking the link "Choose me!"