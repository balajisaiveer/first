# Banking Application
#--------------------------------------------------------------------

PREREQUISITES:
Java JRE, Tomcat, MySQL database.

#--------------------------------------------------------------------

INSTALLING :

create a new database in mysql using below command:

CREATE DATABASE assignment1;


now we have to Create a new user in mysql: 

CREATE USER 'balaji'@'localhost' IDENTIFIED BY 'balaji';
GRANT ALL PRIVILEGES ON assignment1.* TO 'balaji'@'localhost';


start the mysql service by using the below command and enter the password 'balaji':

mysql -u balaji -p;
//In case of password prompt type the password 'balaji'

Now create two tables in the assignment1 database using below commands:

use assignment1;
CREATE TABLE finalusers(username varchar(255),password varchar(255),balance int,PRIMARY KEY (username));
CREATE TABLE finaltransaction(id int ATUO_INCREMENT,rusername varchar(255),sendername varchar(255),amount int,PRIMARY KEY (id));



next Go to your project folder where pom.xml file is present.

Issue command

" mvn clean install "

The above command will clean the previous builds and generate a new build.
The newly generated build(war/jar) is present in

/project_folder/target/


If you want to deploy the war file to a tomcat container, then copy the war to webapps folder in

tomcat(/tomcat/webapps/)
and start the tomcat container.
Start the tomcat container and hit

http://localhost:8080/firstproject
in browser. Browser redirects you to home page of application

Now deploy the war file present in the target folder into tomact:

The home page is "http://localhost:8080/firstproject/"

Register users intially to utilize any other activities.


#----------------------------------------------------------------------

FUNCTIONALITIES OF APPLICATION:

* User will be able to create a account and login accordingly(security part is taken care of utilizing spring security)
* User can be able to view his balance by utilizing the view-balance option that is present once he login
* User can view his previous transactions by utilizing the view-transaction option that is present once he login
* User can transfer his money to another user by giving the details which will be requested upon clicking the new - transaction option.
* User can logout at any time.
* Also the upper limit on what a user can transfer is his balance amount
* Also in case of wrong user name or insufficent funds the transaction will be cancelled 

#----------------------------------------------------------------------
TIPS

(1) use ingonito tab if you face any difficulty
(2) Also incase of encountring an error utilize the back button

#----------------------------------------------------------------------

OTHER USEFUL INTEGRATIONS

* Automation of development process using jenkins -- verified

#----------------------------------------------------------------------