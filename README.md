## This project is a phone book backend aplication 
## Programs used
* IntelliJ IDEA 2022.3.3
* Postman 2
## Technologies
Project is created with:
* Java 17
* Spring Boot 3.1.3
* Hinernate
* Maven
## How to run

git clone https://github.com/zotthy/PhoneBookApi.git


cd PhoneBookApi

./mvnw spring-boot:run

## API Request
* register -> localhost:8080/register


<img width="271" alt="Zrzut ekranu 2024-02-12 o 17 37 45" src="https://github.com/zotthy/PhoneBookApi/assets/42466379/f244d32f-c940-4a79-9440-6c474312a8b2">

* login -> localhost:8080/auth <- return a JWT token

<img width="271" alt="Zrzut ekranu 2024-02-12 o 17 40 22" src="https://github.com/zotthy/PhoneBookApi/assets/42466379/adcd6859-28e0-4437-a658-0afc094d6f73">


* localhost:8080/data/add?page=0 GET <- display all aprove data with database
* localhost:8080/data/find?name=John&surname=Doe GET <- search by name and surname
* localhost:8080/data/{id} GET <- display detail
* localhost:8080/data/add POST <- add new phone book record to data (no aprove state)

  
<img width="299" alt="Zrzut ekranu 2024-02-12 o 17 55 30" src="https://github.com/zotthy/PhoneBookApi/assets/42466379/3a6a64cc-da4e-4759-a7ed-322112c50821">

* This is the request you need to have the token
  
* localhost:8080/admin/acceptable <- list to record to aprove
* localhost:8080/admin/acceptable/{id} <- detail record
* localhost:8080/admin/acceptable/update/21 PUT requst to aprove record and modify 

 
<img width="299" alt="Zrzut ekranu 2024-02-12 o 18 10 40" src="https://github.com/zotthy/PhoneBookApi/assets/42466379/4ed85ba3-d38a-45a1-98ef-d7d354042bc4">


* localhost:8080/admin/all-data <- display all data for database
