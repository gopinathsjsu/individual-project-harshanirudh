# Problem Statement
Requirements:
***
The application should maintain an internal, static database (inventory of stock)  (this may be developed using HashMaps and/or other  built-in Java Data structures). This means once we re-run the program, the changes to the data would not persist. We will provide the data that has to be maintained. The data will contain the following tables and fields:<br /> 
(Sample input file and sample data set for the inventory would be provided separately)<br /> 
Table 1: Items<br /> 
Category (Essentials, Luxury, Miscellaneous)<br /> 
Item for each category (Essentials - Clothes, soap, milk; Luxury - perfume, chocolates; Misc - Bedsheets, footwear)<br /> 
The available Quantity of each item<br /> 
Price of each item<br /> 
Table 2: Cards<br /> 
Card Numbers<br /> 
2. Input CSV file will contain an order including Items, Quantity needed, and the payment card number.<br /> 
3. Input file should be processed as follows:<br /> 
- Validate if the requested quantity for each item is permissible. For example, if the request is to order 3 soaps, check the database if we have at least 3 soaps in our inventory.<br /> 
- There will be a cap on the quantity of each category that can be ordered in one single order. For example, restrict Essentials to a maximum of 3, Luxury to 4, and Misc to 6. (This will be configured beforehand)<br /> 
- In case it is an incorrect request, generate and output TXT file with message "Please correct quantities." and include the items with incorrect quantities
- After this validation, if the cart is valid, calculate prices for the cart.<br /> 
- Take the card number of the user and if it is not present in DB add it.<br /> 
Output the CSV list with the total amount paid.<br /> 

Please refer to the attached file for Inventory, Sample Input and output files. If you cannot proceed with an input transaction for any reasons mentioned above, generate an output TXT with a reason for the same.<br /> 
<br /> 
## Steps to run the program
***
**Java 8 needs to be installed**

- Open CMD or Terminal   
- Download the JAR file from the repository present in artifacts folder.  
- Run the following command in terminal  
`java -jar <jar_name> <input_file_location>`  
- For example: `java -jar Inventory-billing-0.0.1-SNAPSHOT.jar input.csv`  
- Output files shall be created in **OUT** directory at the root of the folder  
- It contains both the error and output files  


## Design Patterns Used:  
***
1. Singleton pattern  
    - Singleton pattern is one of the simplest design patterns and it comes under creational design pattern
    - This pattern lets the client use the class only with one object.
    - Whenever an object is needed the same object is given.
    - Here, the inventory database has been implemented with singleton pattern, so that we can mimic a real database where it has single source of truth.
    - Whenever the database is required , a static call to `getInstance()` method gives the object.  

    ![Singelton Class Diagram](/Inventory-billing/Artifacts/Singelton.drawio%20(1).png "Singelton Class Diagram")  

2. Chain of Responsibility pattern  
    - This is behavioural pattern.
    - It is very useful pattern when the request has to be handled and prcoessed by multiple classes/objects. 
    - Base class defines the methods signatures and the concerate classes override the behaviors and a chain is created .
    - In the chain the request is passed along till the appropriate class processes it and gives the result.  
    - Here the base class is AbstractOrderHandler and we have 4 concerete handlers
        - **CheckItemPresenceHandler**: Check if items are present in inventory or not. If present passes to next handler in the chain.
        - **CheckMaxLimitOrderHandler**: Checks if the items in the order obey the maximum category as defined in the problem statement.If yes, passes down the chain
        - **ValidateOrderHandler**: Checks if the items quantity in the order is availabile in the inventory. If yes, passes the request down the chain.
        - **ProcessOrderHandler** : Finally this class processes the order and the request is fulfilled.

     ![Chain Of Responsibility Pattern Class Diagram](/Inventory-billing/Artifacts/ChainOfResponsibil.drawio.png "Chain Of Responsibility Pattern Class Diagram")  

3. Factory Pattern
    - This is also a creational design pattern.
    - I have used this pattern to create output file and error file as required.
        - Base Class: OutputFile
        - Concrete Class 1: CSVOutput
        - Concrete Class 2: ErrorFile
    - Factory pattern allows sub classes to choose the type of objects to create.
    - it also promotes loose coupling  
     ![Factory Pattern class diagram](/Inventory-billing/Artifacts/factory.drawio.png "Factory Pattern Class Diagram")  

# Screenshots

## Test Case 1

### Input
![TC1](/Inventory-billing//Artifacts/TC-1-Input.png)
### Output
![TC1](/Inventory-billing//Artifacts/TC-1-console.png)
![TC1](/Inventory-billing//Artifacts/TC-1-Output.png)
## Test Case 2

### Input
### Output

    