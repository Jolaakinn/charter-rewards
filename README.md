# charter-rewards
A system for Calculating Customers Rewards
#THE REST API TO GET CUSTOMER REWARDS BASED ON CUSTOMER ID

A retailer offers a rewards program to its customers, awarding points based on each A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
 
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
 
Given a record of every transaction during a three-month period, calculate the reward points earned for
each customer per month and total.
•	The package name is structured as com.charter.rewards

•	Exception is thrown if customer does not exists.

•	MySQL database was used

•	Install MySQL db locally and run it . change the database settings in application.properties file. It is currently configured 
to run on localhost

•	Do run the script.sql after setting up mySQL or you can decide to create a mysql database of your choice, and 
then makes changes on the application.properties database configuration

•	Once DB setup is complete, import as maven project and then run in any IDE of your choice. I used STS

•	Open up your browser to access Swagger API Documentation on localhost//:8080
•	i have exposed three endpoint to add customer, get transactions by customer Id, and also perform transactioons
