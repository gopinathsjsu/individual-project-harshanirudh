# individual-project-harshanirudh
# Problem Statement
Requirements:

The application should maintain an internal, static database (inventory of stock)  (this may be developed using HashMaps and/or other  built-in Java Data structures). This means once we re-run the program, the changes to the data would not persist. We will provide the data that has to be maintained. The data will contain the following tables and fields:
(Sample input file and sample data set for the inventory would be provided separately)
Table 1: Items
Category (Essentials, Luxury, Miscellaneous)
Item for each category (Essentials - Clothes, soap, milk; Luxury - perfume, chocolates; Misc - Bedsheets, footwear)
The available Quantity of each item
Price of each item
Table 2: Cards
Card Numbers
2. Input CSV file will contain an order including Items, Quantity needed, and the payment card number.
3. Input file should be processed as follows:
Validate if the requested quantity for each item is permissible. For example, if the request is to order 3 soaps, check the database if we have at least 3 soaps in our inventory.
There will be a cap on the quantity of each category that can be ordered in one single order. For example, restrict Essentials to a maximum of 3, Luxury to 4, and Misc to 6. (This will be configured beforehand)
In case it is an incorrect request, generate and output TXT file with message "Please correct quantities." and include the items with incorrect quantities
After this validation, if the cart is valid, calculate prices for the cart.
Take the card number of the user and if it is not present in DB add it.
Output the CSV list with the total amount paid.
Please refer to the attached file for Inventory, Sample Input and output files. If you cannot proceed with an input transaction for any reasons mentioned above, generate an output TXT with a reason for the same.
