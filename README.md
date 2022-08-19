USEFUL THINGS TO RUN/TEST CODE

The project was development with Intelij IDEA, using jdk 17 and using an widfly application server.

- Wildfly application server link: https://www.wildfly.org/downloads/
- Version downloaded 26.1.0.Final (Jakarta EE 8 Full & Web Distribution .zip)
- The zip was extracted in user Documents path
- After that the java project has been open in Intellij you need go to File -> Settings...
- Search (Build, Execution, Deployment) and then click on Application Servers
- Now click in the (+) icon and select Jboss/Wildfly Server
- Select the path where you extracted the wildfly server of the previous steps and click on OK
- Now go to Run menu and click on Edit Configurations...
- Then click in the (+) icon and select Jboss/Wildfly Server (Local)
- After at to down to the right you will see a Warning message that saids "No artifacts marked for deployment"
- Click on Fix button and select the applaudo-test:war exploded option, then at the top select Server tab
- Paste this on URL: http://localhost:8080/applaudo-challenge/app and finally click on OK button
- Now you're ready to run the project with the menu that you will see at up to the right 

Now you can try the postman collection pushed on the repository and you will see 3 endpoints to test.

GET: getItemById
POST: saveItem
GET getByStatusAndName

You don't need to configure a DataSource Connection or JNDI because the project have an H2 embedded database that drop & create when you run or stop the application.


Thank you for your time.



Greethings,


Bryan G.