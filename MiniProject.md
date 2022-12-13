# Week 8 Mini Project

## Prompt:

Your client Ethan has a hard time keeping track of his weekly grocery list and has contracted you to create him a grocery list application which includes a frontend and backend.

Ethan requests that you use his favorite programming language Java 11, Spring Boot, Spring Data, Postgresql and React for a user interface.

Attempt to complete as many phases as you can during the interview prep period, be prepared for possible questions about this mini project

## Phase One User Stories:

As a user, Ethan would like to
- 1. Be able to add grocery items to his list with the following properites
    - Name, Description, Price
- 2. Be able to remove grocery itesm from his list when purchased
- 3. Be able to access the backend of his project from anywhere in the world
    - (Use a jenkins pipeline to push and build the Spring Boot app to an EC2)
    - (Use a AWS RDS instance with Postgres to seamlessly use a DB with the EC2)
- 4. Be able to access the user interface of his grocery list application from anywhere in the world
    - (Build and deploy the React application on an AWS S3)

## Phase Two User Stories:

As a user, Ethan would like to:
- 1. Be able to allow other people signup for the grocery list service
- 2. Be able to allow other people to log into their own grocery list dashboard
- 3. Be able to give other users access to grocery list that he owns
- 4. Be able to store and access multiple lists at a time on the dash board
- 5. Be able to see when you make changes to the frontend
    - (Look into how to automatically build and deploy the React application to an AWS S3 on a git push)

## Phase Three User Stories:

As a user, Ethan would like to:
- Congratulate you on finishing both phases in three days, you really put your training to work!
- As one final test, attempt to setup Jenkins to complete a full CI/CD pipeline, use Docker to containerize the spring boot application as well.