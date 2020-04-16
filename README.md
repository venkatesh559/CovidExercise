README: HOW TO RUN THE CODE

Setting up the Code
-------------------

1. In Eclipse, import the project

2. Add mysql-connector-java to the classpath
	- Right click on covid folder
	- Click on properties under Libraries you can find Classpath
	- Click on Classpath then ADD JARs
	- Select mysql-connector-java-8.0.19.jar in the project folder
	- Click on Apply and Close

2. Run the database setup script
	- You must run database setup script before running the application
	- The script is located in the “sql” subdirectory
	- You will find it here:
	- covid/sql/COVID-DATA.sql
	
	- You can run the SQL script using a SQL tool such as MySQL Workbench 

3. Change the database connection info
	- In the source code, update the database URL, user id and password for your local environment

4. Finally, run the program in Eclipse
