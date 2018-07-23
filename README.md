# Banking Application 
#--------------------------------------------------------------------

PREREQUISITES:<br>
Java,Maven,Tomcat,MySQL database.<br>

#--------------------------------------------------------------------

INSTALLING :<br>
#DATABASE CONFIGURATIONS Compulsory 


(.)create a new database in mysql using below command:<br>

CREATE DATABASE assignment1;<br>


(.)now we have to Create a new user in mysql: <br>

CREATE USER 'balaji'@'localhost' IDENTIFIED BY 'balaji';<br>
GRANT ALL PRIVILEGES ON assignment1.* TO 'balaji'@'localhost';<br>


(.)start the mysql service by using the below command and enter the password 'balaji':<br>

mysql -u balaji -p;<br>

(.)In case of password prompt type the password 'balaji'<br>

(.)Now create two tables in the assignment1 database using below commands:<br>

USE assignment1;<br>
CREATE TABLE finalusers(username varchar(255),password varchar(255),balance int,PRIMARY KEY (username));<br>
CREATE TABLE finaltransaction(id int AUTO_INCREMENT,rusername varchar(255),sendername varchar(255),amount int,PRIMARY KEY (id));<br>

#-----------------------------------------------------------------------------

#In Above configurations the new created user is only given permission on newly created database so that he can only change that database ensuring saftey for other exsisting databases.

#-----------------------------------------------------------------------------

#Below will be four possible methods for deploying the Application choose any one

#------------------------------------------------------------------------------  

#Method 1 "Deploying in tomcat by directly downloading the war file present in github" 


(1) Download the war file named "firstproject.war" present in "first->Myapplication->target"<br>

(2) Copy the downloaded war file to the webapps folder of tomcat.Generally this folder is located at "/var/lib/tomcat8/webapps" but this is not a compulsion so check your tomcat location and copy the "firstproject.war" to webapps folder of tomcat<br>

(3) Now restart the tomcat if already running if not just start it<br>

(4) Also wait for the system to load it in the tomcat container

(5) Now go to the "http://localhost:8080/firstproject/"

#----------------------------------------------------------------------------------

#Method 2 "Generating the war file and deploying it in tomcat"

(1) Download the entire project and extract it into a folder<br>

(2) Go to the folder where the pom.xml is present<br>

(3) Issue the below command <br>

mvn clean install<br>

(4) Now this will generate the new build <br>

(5) Now copy this generated war file to the webapps folder of tomcat,which is generally present in "/var/lib/tomcat/webapps" but this is not a compulsion so check your tomcat location and copy the "firstproject.war" to webapps folder of tomcat<br>

(6) Now restart the tomcat if already running if not just start it<br>

(7) Also wait for the system to load it in the tomcat container<br>

(8) Now go to the "http://localhost:8080/firstproject/"<br>

#--------------------------------------------------------------------------------------

#Method 3 "Directly running without usage of tomcat container"

(1) Utilize any of above methods to get the war file.<br>

(2) Now instead of copying it to webapps folder run the below command<br>

java -jar firstproject.war<br>

(3) Above the firstproject represnt the generated war file.<br>

(4) Now go to the "http://localhost:8080/firstproject/"<br>

#--------------------------------------------------------------------------------------

#Method 4 "Directly importing into STS"

(1) Download the entire folder <br>

(2) Impot it into STS and run the Myapplication by selecting "run as spring boot app"<br>

(3) Now go to the "http://localhost:8080/firstproject/"<br>

#--------------------------------------------------------------------------------------

Register users intially to utilize any other activities.<br>

Also register atleast two users to get a perfect transaction or incase of wrong user it will redirect to error page<br>

#---------------------------------------------------------------------

FUNCTIONALITIES OF APPLICATION:<br>

* User will be able to create a account and login accordingly(security part is taken care of utilizing spring security)<br>
* User can be able to view his balance by utilizing the view-balance option that is present once he login<br>
* User can view his previous transactions by utilizing the view-transaction option that is present once he login<br>
* User can transfer his money to another user by giving the details which will be requested upon clicking the new - transaction option.<br>
* User can logout at any time.<br>
* Also the upper limit on what a user can transfer is his balance amount<br>
* Also in case of wrong user name or insufficent funds the transaction will be cancelled <br>

#----------------------------------------------------------------------------

TIPS<br>

(1) use ingonito tab if you face any difficulty<br>
(2) Also incase of encountring an error utilize the back button<br>

#----------------------------------------------------------------------------

OTHER USEFUL INTEGRATIONS<br>

* Automation of development process using jenkins -- verified<br>

#-----------------------------------------------------------------------------