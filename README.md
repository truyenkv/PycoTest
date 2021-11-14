
### Install on your local
- Install editor - Inteliji (Optional). 
- Install Java - set JAVA_HOME. 
- Install Manve - set MAVEN_HOME. 
- Download chromedriver (chrome driver must Compatible with browser version). 
### How to run  
1. Pull code from GitHub and open by editor or cd to folder where contains the source code.  
2. Start the chromedriver server in your local:  
- cd to folder contain chromedriver (you can user chromedriver in the project)  
- Start chromedriver via command: ```./chromedriver --port=8080```  
3. This project was supported run via maven command line and chrome:  
- Run all Test Case:  ```mvn clean test```  
- Run specific TestCase: ```mvn clean test -Dtest=UserLogin -Dbrowser=chrome```  
