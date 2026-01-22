Nebarex – QA Automation Framework

Project Overview
Nebarex is a robust QA Automation Framework built to validate the functional, integration, and regression aspects of the Nebarex application. 
This project demonstrates end-to-end automation covering UI testing, API validation, data verification, and reporting.



Goals & Purpose

•	Validate UI, API, and backend data consistency

•	Enable fast regression and sanity test execution

•	Provide clear and actionable test reports

•	Reduce manual testing effort through automation



Logic that used for Validation:

<img width="530" height="389" alt="image" src="https://github.com/user-attachments/assets/eca6fd4b-c475-459d-af08-ddac33879fc8" />


 
 Test Coverage
 
•	API Contract & Response Validation

•	Positive & Negative Scenarios




Technology Stack


Layer	                                                                                  Technology

Programming Language	   ------------------->                                            Java

UI Automation            ------------------->             	                             Selenium WebDriver

API Testing	             ------------------->                                            Rest Assured

Test Framework	         ------------------->                                            TestNG

Build Tool	             ------------------->                                             Maven

Reporting	Extent         ------------------->                                             Reports / Allure

Design Pattern	         ------------------->                                             Page Object Model (POM)

Version Control	         ------------------->                                             Git & GitHub

IDE	                     ------------------->                                             IntelliJ IDEA




Framework Architecture



•	Page Object Model (POM) for UI maintainability

•	Reusable utilities 

•	Centralized test data management

•	Modular API test structure




Project Structure


Nebarex/


│── src/main/java

            │   ├── base     - Base Class   

            │   ├── pages    - Pages Classes 

            │   ├── api      - Api Class    

            │   ├── utils    - Utility Class      
         



│── src/test/java

          │   ├── automation.tests - All the testNg Tests      


              │── pom.xml

              │── testng.xml



Prerequisites

•	Java 17 

•	Maven

•	IntelliJ IDEA

•	Git

•	Chrome



 

 
 How to Execute Tests

 
 
Clone Repository

git clone <repository-url>

cd Nebarex

Run All Tests

mvn clean test

Run Specific TestNG Suite

mvn test -DsuiteXmlFile=testng.xml


 
 

 
 Reporting & Logs
 
•	Detailed execution reports generated after each run

•	Screenshots captured automatically on failures

Reports:


An Allure report has been generated to provide a detailed overview of the test execution.

Total Test Cases: 9

Passed: 6

Failed: 3


<img width="925" height="533" alt="image" src="https://github.com/user-attachments/assets/bf1f1914-1832-4160-a330-ca5b10089066" />


Fail Tests:

Given
The application displays data on the Web UI and the corresponding data is available through the API response.

When
The automated test compares the API response data with the data displayed on the Web UI.

Then
If any mismatch is detected between the API data and the Web UI data, the test case fails and the missing or non-matching elements are logged in the test report for analysis.

Details are available in the screenshot :
<img width="952" height="528" alt="image" src="https://github.com/user-attachments/assets/aa9bc4a1-4bef-4bd4-837f-d4daa4b4fd23" />
<img width="944" height="530" alt="image" src="https://github.com/user-attachments/assets/05d13ff4-3b46-4f6b-883a-6a03e5904bc3" />
<img width="953" height="511" alt="image" src="https://github.com/user-attachments/assets/380ef154-90f4-419b-80b5-5316ace72144" />


Pass Tests:


Given:
The application displays data on the Web UI and the corresponding data is available through the API response.

When:
The automated test compares the API response data with the data displayed on the Web UI.

Then:
When the API response data exactly matches the data displayed on the Web UI, the test case passes and the successful validation is recorded in the test report.

For Ex-

<img width="950" height="506" alt="image" src="https://github.com/user-attachments/assets/7493044a-807d-4c21-98a0-cf863b0c5ec8" />






Submit Form Validation:



Given:

The customer information submission form is available and accessible to the user.

When:

The user enters valid and complete customer details in all mandatory fields and submits the form.

Then:

The system successfully saves the customer information, displays a confirmation message, and the submitted data is persisted correctly in the system.

<img width="946" height="496" alt="image" src="https://github.com/user-attachments/assets/d5be27f8-2017-4df5-b078-35254ae0dbba" />




Given:

The customer information submission form is available and accessible to the user.

When:

The user fills in all mandatory customer details correctly but does not accept the Terms and Conditions and attempts to submit the form.

Then:

The system prevents submission, displays an appropriate error or warning message, and does not save the customer information until the Terms and Conditions are accepted.

<img width="949" height="520" alt="image" src="https://github.com/user-attachments/assets/40232815-e5b1-4256-b662-42ba6f47038a" />








