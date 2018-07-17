# Banking Application >
#--------------------------------------------------------------------

PREREQUISITES:<br>
Java JRE,Maven,Tomcat, MySQL database.<br>

#--------------------------------------------------------------------

INSTALLING :<br>

create a new database in mysql using below command:<br>

CREATE DATABASE assignment1;<br>


now we have to Create a new user in mysql: <br>

CREATE USER 'balaji'@'localhost' IDENTIFIED BY 'balaji';<br>
GRANT ALL PRIVILEGES ON assignment1.* TO 'balaji'@'localhost';<br>


start the mysql service by using the below command and enter the password 'balaji':<br>

mysql -u balaji -p;<br>
//In case of password prompt type the password 'balaji'<br>

Now create two tables in the assignment1 database using below commands:<br>

use assignment1;<br>
CREATE TABLE finalusers(username varchar(255),password varchar(255),balance int,PRIMARY KEY (username));<br>
CREATE TABLE finaltransaction(id int ATUO_INCREMENT,rusername varchar(255),sendername varchar(255),amount int,PRIMARY KEY (id));<br>



next Go to your project folder where pom.xml file is present.<br>

Issue command<br>

" mvn clean install "<br>

The above command will clean the previous builds and generate a new build.<br>
The newly generated build(war/jar) is present in<br>

/project_folder/target/<br>


If you want to deploy the war file to a tomcat container, then copy the war to webapps folder in<br>

tomcat(/tomcat/webapps/)<br>
and start the tomcat container.<br>
Start the tomcat container and hit.<br>

http://localhost:8080/firstproject<br>
in browser. Browser redirects you to home page of application<br>

Now deploy the war file present in the target folder into tomact:<br>

The home page is "http://localhost:8080/firstproject/"<br>

Register users intially to utilize any other activities.<br>


#---------------------------------------------------------------------

FUNCTIONALITIES OF APPLICATION:<br>

* User will be able to create a account and login accordingly(security part is taken care of utilizing spring security)<br>
* User can be able to view his balance by utilizing the view-balance option that is present once he login<br>
* User can view his previous transactions by utilizing the view-transaction option that is present once he login<br>
* User can transfer his money to another user by giving the details which will be requested upon clicking the new - transaction option.<br>
* User can logout at any time.<br>
* Also the upper limit on what a user can transfer is his balance amount<br>
* Also in case of wrong user name or insufficent funds the transaction will be cancelled <br>

#----------------------------------------------------------------------

TIPS<br>

(1) use ingonito tab if you face any difficulty<br>
(2) Also incase of encountring an error utilize the back button<br>

#----------------------------------------------------------------------

OTHER USEFUL INTEGRATIONS<br>

* Automation of development process using jenkins -- verified<br>

#----------------------------------------------------------------------