# WebDev Training

Stacks:

- Java + Spring Boot 3 (Maven as Build Tool)

## Java 21 + Spring Boot 3 (java21sb3) - server perspective

Folder: /java21sb3

## Java 21 + Spring Boot 3 (java21sb3) - client perspective

Folder: /java21sb3client

## Topics covered

- Building a RESTful Web Service
  - In: java21sb3.payroll
    - Features: 
      - JPA Overview, 
      - Spring Web, 
      - Spring Basic Class Configuration (with database seeding)
      - Spring HATEOAS, 
      - REST

- Consuming a RESTful Web Service
  - In: java21sb3.consumingrest.server
    - Features:
      - REST Controller
      - Server Port Customizer Component Class
      - Exposing /api (Quote resource)
  - In: java21sb3client.resttemplate
    - Features:
      - RestTemplate Bean declaration in Configuration Class
      - Injecting RestTemplate in Service Class
  - In: java21sb3client.feignclient
    - Features:
      - Declaring a FeignClient called QuoteFeignClient (client which consumes /api)

- Spring Boot Actuator 
  - In: java21sb3.actuatorservice
    - Features:
      - Simple Controller
      - Spring Boot Actuator dependency was added in this project