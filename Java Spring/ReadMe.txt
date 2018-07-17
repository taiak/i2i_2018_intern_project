/*Hakan C. Ipek && Ahmet Genç
17.7.2018
Java Web Application for Cell2i Mobile Phone Operator
*/
-This repository contains the Java Files of the project "cell2i Web Application".

-There are two different main files in it.
	-Old Spring Web Project has Spring Framework web application that uses Spring Boot, which we used at the start of the project.
		-Even with advantages of Spring Framework, we had hard times while we were developing our project.
		-Our web service's return values are not we are expecting, so we decided to change our developing method to hard coded Java.
	-New Java Web Application is our final version of the project. 
		-In that project we handle our web service more easily and finished our project more faster.
		-It not caused of disadvantages of Spring framework, Spring has good ways to make things easier but we have limited time and we are not have enough knowledge of Spring.
		(Actually we start the learn Spring at the beginning of our project.)
-Web Application has a login page at the start.
	-With registered phone number and password user can login to index page of application.
	-If user typed wrong number or password he can't login and an error message will be showed in login page.
-Web Application has a change password page for the possibility of forgotten password.
	-User enters his phone number, new password and new password again for confirmation.
	-Security not cared in this page because our Project Manager says its not necessary for now.
	-There are error messages for empty fields, lower than 8 character passwords and passwords that ot contain special character.(different than alphabet characters and numbers)
-After successful login there is index page. 	
	-There are user information at the page. User name, number,tariff and usage of Minutes, SMS, GB are shown in index page.
	-There is a header at top. Only invoice and logout icon are functional, other buttons are redirect user to index page.
	-Invoice icon opens the invoices screen.
	-Logout button makes user logout succesfully.
-Invoices screen shows users last invoices.
	-In this web application, invoices are limited to last 6 invoices.
	-Every invoice has month and year, start and end date, cost and paid information of the invoice.