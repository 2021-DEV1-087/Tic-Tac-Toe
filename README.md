**Tic Tac Toe Kata**

A sample Tic-Tac-Toe application developed using Test Driven Development approach.

As one of the requirement was to use Java/Spring, this application is developed as a Spring Boot REST API.

**Necessary prerequisites are:**
Java8 (JDK1.8)
Maven 3.8.1
Git 2.30.0

**Download from Git**
To download the project, simply open a terminal window and execute the following command :
https://github.com/2021-DEV1-087/Tic-Tac-Toe.git

**Test**
All tests are in "com.game.tictoctoe.TictoctoeApplicationTests.java"
cd to the project directory and execute : mvn test

**Running the project**
In a terminal window, cd to the project directory and execute : mvn spring-boot:run

**Interacting with the game API**
Once started, the API is available at the http://localhost:8080/tic-tac-toe/api

**How to play the game?**
To place a move, POST to the http://localhost:8080/tic-tac-toe/api/playTheGame url with the RequestGamingDto information in the body :
RequestGamingDto { "playerSymbol": "X", "positionX": 2, "positionY": 2}

**Documentation and test  with openApi and swagger**
There is no client has been developed, but it's possible to interact and test the API through swagger openApi url:
http://localhost:8080/swagger-ui-custom.html
http://localhost:8080/api-docs


