# Medici Group - Technical Challenge

## Introduction

The goal of this excercise is to give the candidates a preview of what they will be working on and at the same time, give them the opportunity to code and show us how they work in a real environment.

The test requires an implementation of a very simple REST microservice that can answer to three different endpoints.

## Description

The task at hand is to create a small microservice for a room booking service. The service will allow users to list the available rooms. Make a booking and cancel a booking.

The service will talk to a PostgreSQL database, and has to be written in Java (using any framework or library, although Spring Boot is recommended).

The task has to be delivered in a single git repository. The service has to contain a Dockerfile to run inside Docker and also docker-compose file to launch the service and the database.

The code has to be as _production grade_ as possible. Optionally, tests can be included, although this is not a requirement.

There is a two weeks time limit for the task.

## Specification 

The task must implement the following REST API. Some endpoints are required, and others are optional, to be implemented if the candidate so decides.

### Required endpoints


#### GET /rooms
This will return the available rooms. Rooms must contain a room ID, a type field (single, double, suite) and a booking calendar.
The booking calendar is simply a list showing which days it is booked.

#### POST /booking
This will create a booking, it should contain the room ID and the period for which we're booking the room.

### Optional endpoints

#### GET /bookings
Get a list of the bookings for all rooms.

#### DELETE /bookings/id
Delete / cancel a booking.

## General requirements

To summarize and for clarity, these are the requirements that have to be met:

* The task has to be written in Java
* The task has to include a Dockerfile and a docker-compose file
* The required endpoints have to be implemented.
* The task has to be completed within two weeks.

## Optional features 

If the candidate so decides, the following extra features can be added:
* Optional endpoints
* Unit tests
* End-to-end tests
* Other endpoints / other features
