
![Screenshot 2024-04-28 at 17 43 18](https://github.com/AlkaChaudhary/PetStoreAutomation/assets/87438786/de73ee8f-ae94-4898-933a-95fb719ce85e)


# Petstore API Automation
Petstore has swagger UI link through which user can operated the CURD operations.
RestAssured is an API/Library through which user can automate RestAPI's.
Link is : https://petstore.swagger.io/

## Rest Assured Framework Architechture
---
<img width="678" alt="Screenshot 2024-04-28 at 13 48 06" src="https://github.com/AlkaChaudhary/PetStoreAutomation/assets/87438786/f3285a2a-2b36-47c8-ade6-f587b6d174c1">

### Pre-requisites:
Step 1:  Create Maven Project.

Step 2: Update pom.xml with required dependencies.

Step 3: Create Folder Structure

Step 4: Create Routes.java ---> contains URL's

Step 5: UserEndPoints.java ---> CURD methods implementation

Step 6: Create test cases

Step 7: Create Data driven test
- excel sheet data
- ExcelUtility
- DataProviders

Step 8: Generate extent reports
- Extent reportutility
- testng.xml file
 
Step 9: Add logs
- log4j2 dependency
- log4j2.xml --->src/test/resource 
