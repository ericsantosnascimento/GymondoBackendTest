## Gymondo Backend Test

You should not take more than 90 minutes to complete all the tasks.

###### Problem Statement
You are asked to extend some of the rest-api functionalities. The application right now is completely functional but we'd like to enrich the user information with:

* The subscriptions that belong to the users;
* The expiration date of each subscription.

We'd also like for you to create the following endpoints:

* Fetch a single user by id;
* Fetch all the subscriptions that belong to a given user;
* Fetch all the subscriptions where the expiration date is after a certain date.

You will find more details once you get your hands in the source code.

###### Objectives
You are being tested for good practices, code cleanliness and performance.

###### Reflections

* What's the problem with the GET /rest-api/api/v1/users endpoint? How can we solve it? Ignore the security topic.
* Imagine that for some reason we decide that we no longer want to deliver the subscriptions with the user (this means removing the "subscriptions" member from the json file). What would you do to accomplish that? Why is this such an important topic?

###### Installing and running

You'll need:
* Java SDK 8
* Git
* Maven
* An IDE of your choice

```
git clone https://github.com/Gymondo-git/GymondoBackendTest.git
git checkout master

mvn clean install

# To run the application:
cd rest-api
mvn tomcat7:run

# Open a web browser and type http://localhost:8080/rest-api/api/v1/users
```
