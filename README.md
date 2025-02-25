Problem Statement:
Implement the service layer of the Spring Boot application MovieMax.
The classes for model, service, and main boot application should be in different packages.
Store the following movie list in a collection.

 | MovieId  | MovieName |
| ------------- | ------------- |
| M1001  | SpiderMan  |
| M1002  | Thor|
| M1003  | Logan  |
| M1004  | Conuring2|
| M1005  | StarWars|
 
 
The application should prompt the user to enter the following details and validate as per the given criteria:
    
|FieldName|Validation|
|---------|------------------|
|name | Only alphabets (a-z and A-Z) and maximum length is 25|
|email |One '@' symbol followed by one '.' followed by 2 or 3 characters|
|phoneNumber |Only numbers and length should be 10|
|city | Only alphabets and maximum length are 15.|
 
 
Display available movie names from the collection and prompt the user to select one. Do a case insensitive comparison to identify the movie Id.
Display a success message if all validations are successful.
 
Verification:
On execution, the application should display the following messages and prompt the user for ticket booking. The appropriate error message should come from invalid data entered by the user.


