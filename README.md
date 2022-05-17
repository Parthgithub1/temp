# QAAutomation
CONTENTS OF THIS FILE 
--------------------- 

- Introduction of Project 

- Tools & Technology & Configuration 

- Pre-Requirements and Installation 

- Steps for How to Run Project  

 

INTRODUCTION  
------------ 

 
**Project: Hopscotch**

Hopscotch is a new bill pay and invoicing platform that enables small businesses to pay and get paid in real-time without any fees. 

This repository contains the automation code of the hopscotch 

Visit the project page: 
   1. Dev : https://dev.zurohq.com/login 

   2. QAT : https://qat.zurohq.com/login 

  3.  UAT : https://uat.zurohq.com/login 

 

Tools & Technology  
------------ 

We have used Selenium Web-Driver with JAVA  

Versions Used for this Project are: 

[Java - JDK] [1.8] 

[Selenium Web-Driver] [3.14]

[BDD Framework(Cucumber)] [7.2.3]

[J-Unit] [4.13.2] 

[Maven-sure-fire] [2.22.2] 

[Maven-compiler] [3.10.1] 

 
 
Pre-Requirements  
------------ 

Install Eclipse IDE - https://www.eclipse.org/downloads/  

Install JDK - https://www.oracle.com/java/technologies/downloads/  

Install Maven - https://maven.apache.org/install.html 

Import the project in Eclipse 

Update the project in eclipse 

 

How to Run Project 
------------ 

Make Sure all the Pre-Requirements are fulfilled  

Below are the Ways that we can run the Project : -

1. 
Open the Runner Class of the Project (Example: Hopscotchtestrunner.java) - We can find this class inside src/test/java/runner 

Right click from Runner class as mentioned above and Select “Run-As” Option  

Select “JUnit Test” and Script will Run  

2. 

We Can also Run Project using command line by following below steps “ 

Pre-Condition : Set the Path Variables for JAVA & Maven 

Open Terminal  

Reach till the location where the Project is > Project directory  

Then fire Command: 

 mvn clean > This will clean the Project before execution  

mvn test > This will run the Project and will test the scripts  


3. 
We Can also run the Project using specific tags. This can be used when we want to run any Particular Cases/Scenarios from Project 

Example : 
1. To Run using specific Enviornment we can use command : mvn test -Denvironment="uat"
2. To Run the Project using HeadLess the command is : mvn test -Dheadless= “true”
3. Other commands are : mvn test -Denvironment="uat" -Dcucumber.filter.tags="@Smoke and not @uat"

This way we can use the different Variables to run Run Projects with different combinations !


4. 
We can also Run the Project from gitHub > Actions Tab 
- Users can Login in the gitHub with correct Credentails 
- Make Sure builds are ready in gitHub for Run 
- Navigate to Actions tab 
- Select the Environment from the List present 
- Select the Run workflow option
- Click on "Run workflow" button 
- The Build will starting executing 

