# jchess
Demonstrate containerized backend web-service with chess game.

Goal:  I want to create a multi-player chess game.  Because I want a better understanding of how to set up a containerized micro-service API with a database, this will be the focus of my efforts.  The front end will either be a java-based UI or javascript UI.  But the UI is only for demonstration and testing purposes.  I will use a javascript front-end unless I find an easy library in Java for sending REST requests, in which case I will create a java front-end.  At worst, I can just make calls to the backend using the Postman app.  

Requirements:
User:  As a user, I should be able to select and move a pawn into legal squares.
As a user, I should not be able to select an opponent’s pawn.
As a user, I should not be able to move a pawn into illegal squares.
As a user, I should be able to join a game.
As a user, I should be able to leave a game.
As a user, I should be able to re-enter a game.
As a user, I should be able to see other players who have accounts.
As a user, I should be able to challenge another player to a game.
As a user, I should be able to respond to a challenge.
As a UI, I should be able to make requests to an API to find legal moves for a piece.
As a UI, I should be able to call the API with updates on piece positions.
As a UI, I should be able to call the API to get all pieces on the board and their board locations.
As a UI, I should be able to call the API and get all the games I have been a part of.
As a UI, I should be able to create a new game.
As the application, I should be able to store and retrieve the state of a game.
BR:  Pawns should be able to move two squares towards the other side of the board on their first move, one square on all subsequent moves, and move diagonally, if they are taking other pieces.
BR:  There are two players per game.
BR:  Once players have entered a game, they should be able to leave and return to that game.
BR:  Turns alternate from one player to the other.
BR:  There are two teams: White and Black.  The White team goes first.
BR:  Lacking any other heuristic, the players will be assigned randomly.

Architecture:
I will use Docker Containers to contain the parts of my application, and Docker-Compose to orchestrate them.  I will also use Spring-boot and Maven as necessary to help with the build management.  I will use a Mongo Database.  There will be three layers to the back-end: the request layer, that handles the requests, the business logic layer that processes requests, and the data access layer that interfaces with the database.

Roadmap:
Nov 24:  Create the foundation architecture:  Have the Containers spin up instances of the Web Server, the Back End Java application, and the Mongo database.  Verify communication between these the Web Service and the Back-end, and the back end and MongoDB.
Nov 31:  Create the game logic: pieces, the board, how to manage movement, how to store board state, how to shift from one player’s turn to the other.
Dec 8:  Create the connection logic.  How to store player accounts, how challenge players, and how to start and retrieve a game.
Dec 15:  Project finished by Dec 14.  Troubleshooting, testing, and presentation preparation.

Responsibilities:  
As an isolated team member, I will shoulder all the responsibilities.

