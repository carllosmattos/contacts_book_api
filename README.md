# Checking Contacts_book Api

This project is a contact book backend api, a project for technical job testing for SESA. It consists of allowing basic CRUD operations for contacts. This Api was created with Spring boot and has document routes via swagger.

## Getting Started

This project follows the gitflow workflow, with the branches:

main - PRODUCTION


### Installing

Check the spring boot documentation itself

[Spring boot](https://spring.io/projects/spring-boot)

## Running the tests

Use a database of your choice, but make sure you configure it correctly. If using a ConfigDatabase be sure to use an annotation

```
@Profile("test")
```

along with the settings of application.properties

```
spring.profiles.active=test
```

## Running the prod

This application was deployed on [Heroku](https://id.heroku.com/login) and its documentation is accessible on the following link.

[Api Documentation 1.0](https://mycontacts-book-api.herokuapp.com/swagger-ui/index.html)

## Maintainers

Here are some of the maintainers of this project:

* **Carlos Eduardo** - [Git Hub](https://github.com/carllosmattos)

