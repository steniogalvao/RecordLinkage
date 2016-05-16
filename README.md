# RecordLinkage
Repositório referente ao desafio de ambientação da empresa infoway


INSTRUCTIONS AFTER CLONE

1- Install mysql if you don't have
2- Log in as root and create a new user with this command: CREATE USER 'infoway'@'localhost' IDENTIFIED BY 'infoway' ;
3- Create a new database called infoway with commando: CREATE DATABASE infoway;
4- Give permissions for the new user created with this command: GRANT ALL PRIVILEGES ON infoway.* TO 'infoway'@'%';
5- Refresh permission with the commando: FLUSH PRIVILEGES;
7- Open the folder and copy 'listings.txt' and 'products.txt' to /home directory 
6- Now you can deploy the aplication in your ID

HOW TO RUN WITHOU IDE

1- Download the file in https://drive.google.com/file/d/0B32Lc_93wNdoUE9qZGRuQ21Od2c/view?usp=sharing 
2- Extract the files
3- Open the folder and copy 'listings.txt' and 'products.txt' to /home directory
4- Install mysql if you don't have
5- Log in as root and create a new user with this command: CREATE USER 'infoway'@'localhost' IDENTIFIED BY 'infoway' ;
6- Create a new database called infoway with commando: CREATE DATABASE infoway;
7- Give permissions for the new user created with this command: GRANT ALL PRIVILEGES ON infoway.* TO 'infoway'@'%';
8- Refresh permission with the commando: FLUSH PRIVILEGES;
9- Open the folder of the RecordLinkage and run the app.sh
10- Wait a while and you can acess the aplication in localhost:8080/RecordLinkage
11- to finish the aplication you need to run the shutdown.sh
