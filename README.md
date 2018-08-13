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

<b>Answer:</b><i> there's no pagination on this endpoint which means we would fetch the whole database basically so causing huge load and slow response time,
to fix it i would simply implement a pagination mechanism where the user could send offset and size. </i>


* Imagine that for some reason we decide that we no longer want to deliver the subscriptions with the user (this means removing the "subscriptions" member from the json file). What would you do to accomplish that? Why is this such an important topic?


<b>Answer:</b> <i>When clients rely on your payload we cant simply remove fields like that, I would create a /api/v2/users and provide the new users payload
without subscriptions and give this to the clients so they could implement, the topic is important because when you create contracts between clients and api
you need to stick with it somehow and api version is one of the ways to keep things working.</i>

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
