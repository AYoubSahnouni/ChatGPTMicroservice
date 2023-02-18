
# ChatGPT Microservice

This microservice is designed to consume the ChatGPT API using SpringBoot. It allows users to interact with the ChatGPT API through a simple RESTful API.

## Requirements

Before running the microservice, you will need the following:

* Java 17
* Maven
* ChatGPT API key

## Getting Started
To run the ChatGPT microservice, follow these steps:

* Clone the repository to your local machine.
* Open a terminal and navigate to the root directory of the project.
* Run mvn clean install to build the project and install dependencies.
* Once the build is successful, run mvn spring-boot:run to start the microservice.
* The microservice will start up and listen on port 8080 by default.

## API Documentation

The ChatGPT microservice provides the following endpoints:

* GET / - returns the page index.html that provide an input.
* POST / - returns a JSON response containing the generated response from ChatGPT.

## Project Structure
The project is structured as follows:

* src/main/java/de/bsi/openai/chatgpt/ChatGptController - contains the Controller .
* src/main/resources - contains configuration files and resources used by the microservice.
* src/test/java/com/example/chatgpt - contains test code.
