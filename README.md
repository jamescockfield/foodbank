# foodbank web app

This project primarily serves as an experiment for me to learn the various functionalities of spring framework, and so it's made primarily using Spring Boot and React.js. I'm also using Blueprint UI library for some frontend components.

The project itself is a web app for the management of the day-to-day functions of a foodbank (Tafel).

It contains a basic customer-facing brochure website with contact form, with a login page leading to the rest of the functionality of the app.

You can view the trello board for this project [here.](https://trello.com/b/A466s4mn)

Installation
------------
The project should run fine using maven. However, the project uses an SQL database so you will need to set a user up who can access this.
```sql
CREATE USER 'foodbank'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON foodbank.* TO 'foodbank'@'localhost';
```
These are the default credentials, but you can customise them in `application.properties` if necessary.

The project will create the foodbank database automatically, but it needs to be run for the first time with the `--seed` command line argument, or whenever you want to seed the database.

From the root directory:
```
mvn spring-boot:run -Dspring-boot.run.arguments=--seed=true
```

When seeding with a preexisting database you will need to manually drop the database before running the above command.

Functionality
-------------

### Volunteers
Volunteers can log in to view a calendar with upcoming events, and see which events they have been assigned to by a manager.

These events are either food collection events or food distribution events.

Collection events require a volunteer to drive between several food donor locations to collect the food and finally return to the foodbank and store it.

The idea is that volunteers assigned to collection events will be able to have a Google Maps route assigned and waiting for them in the app, so they only need to visit the calendar, today's event, and open the route on their phones to be seamlessly led to their various collection points.

Food distribution events are far simpler and only require a mark in the calendar with a time the volunteer should arrive.

### Managers
Managers should be able to visit a manage view from their respective login page, and from here they can:

* managing volunteers (and other managers), deleting, sending platform invites to register
* register new food donors with their respective GPS locations in the database 
* create new events in the calendar
* assign volunteers to those events
* create a list of food donors to be collected from on that day, and the app will automatically design a Google Maps route to be displayed to the volunteer
