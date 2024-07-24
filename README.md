# RTO-Simulation
The RTO (Regional Transport Office) Management System is a Java-based application developed to efficiently manage various operations of an RTO using JDBC for database connectivity. The system interacts with SQL tables to handle and store data related to vehicle registration, driver licenses, vehicle inspections, and penalties.

## Technical Details:
- Database: The system uses a relational database MySQL to store all data related to RTO operations.
- JDBC: Java Database Connectivity (JDBC) is used to connect the Java application to the SQL database, enabling CRUD operations (Create, Read, Update, Delete) on the data.
- User Interface: A simple user interface allows RTO staff to interact with the system, performing tasks like registration, license issuance, and penalty management.
- Security: Implements user authentication and authorization to ensure only authorized personnel can access and modify sensitive data.

Key Features:
- User Authentication: The system prompts for a password at the beginning to ensure secure access to the database functionalities.
- Database Connectivity: The application uses JDBC to connect to a MySQL database named rto, with credentials for the database specified in the code.
- Menu-Driven Interface: The system offers a menu-driven interface with various options for the user to perform different operations related to vehicle and owner management, traffic fines, and insurance policies.

Functionalities:
- Insert an Owner-Vehicle Pair: Allows the user to input and insert details of a new vehicle owner and their vehicle into the database.
- Remove an Owner-Vehicle Pair: Enables the removal of an owner and their associated vehicle from the database.
- Raise a New Ticket (Traffic Fine): Facilitates the issuance of a new traffic fine, associating it with a specific vehicle.
- Get 'PENDING' or 'CLEARED' Fines for a Certain Vehicle ID: Retrieves fines based on their status (pending or cleared) for a given vehicle ID.
- List All Vehicles with Insurance Premium Greater Than a Certain Value: Lists vehicles whose insurance premium exceeds a specified amount.
- Number of Traffic Fines Issued for Each Violation Type: Provides a count of traffic fines issued, grouped by the type of violation.
- Vehicle ID with Maximum Fine Amount (Due or Paid): Identifies the vehicle with the highest fine amount, either due or paid.
- List of All Insurance Companies: Displays a list of all distinct insurance companies present in the database.
- List of Vehicles Registered in a Particular Year: Lists vehicles that were registered in a specified year.
- Number of Fines of Vehicles of All Brands: Shows the count of fines for vehicles, grouped by their brand.
- List of Owners Who Are Born After a Certain Year: Lists vehicle owners who were born after a specified year.
- Average Premium Amount: Calculates and displays the average insurance premium amount.
- Maximum and Minimum Insurance Premium for Each Company: Displays the maximum and minimum insurance premiums for each insurance company.
- Transaction Management: The system manages transactions by setting auto-commit to false and manually committing changes to ensure data integrity. In case of errors, it performs a rollback to revert changes.
