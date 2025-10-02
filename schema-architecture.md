This is a Spring Boot built application for a small physician office. It uses Spring MVC and Thymeleaf templates to handle Doctor and Admin controllers, while using other controllers are RESTful APIs.
It uses a MySQL database for appointments, patients, and doctor data, but uses a MongoDB database for prescriptions. All traffic is routed through a common service layer before being routed to the appropriate repository.
The MySQL database uses Spring JPA entities and the MongoDB uses document models.

1. User chooses a role, and either accesses a Thymeleaf webpage, or a REST API.
2. The controller layer responds to the user with either Thymeleaf HTML templates for Doctor/Admin roles, or HTTP request for Patient information formatted in JSON.
3. The service layer handles business logic and validation keeping it separate form data access.
4. The repository layer accesses either a MySQL database for patient and doctor records, or a MongoDB database for prescription records.
5. Models access the necessary database for the role. MySQL data for structered roles like patient info, or MongoDB for unstructured info like prescriptions that may vary
6. When the data is accessed it is bound to the appropriate model as either JPA entities for MySQL data, or JSON for MongoDB data.
7. The data is then returned as an HTML Thymeleaf template or JSON response to an API.
