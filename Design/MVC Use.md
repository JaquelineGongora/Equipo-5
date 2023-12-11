# Project Overview

## Introduction
Our project involves the development of a CRUD (Create, Read, Update, Delete) system for a continuous education platform. We have implemented the MVC (Model-View-Controller) paradigm, with connections to a database and the use of several packages.

## Model
In the Model component, we handle data manipulation for the application. It includes the following classes:

### "Estudiante" Class:
Represents a model to store information related to a student. Fields include identification ("id"), registration number ("matricula"), name ("nombre"), diploma ("diplomado"), and grades for each module ("calif1", "calif2", "calif3", "calif4"). Additionally, there is a field called "calif" for storing the final diploma grade. The class has getter and setter methods to access and modify these fields.

### "Usuario" Class:
Represents a model to store information related to a user. Information includes the user's name ("nombre"), password ("contrasenia"), and user type ("tipo"). User type is represented by an integer. The class includes getter and setter methods for accessing and modifying the fields.

## Controller
### "ControladorEstudiante" Class:
Handles logic related to searching for students after logging in.

#### Constructor ("ControladorEstudiante"):
Associates instances of "Estudiante", "InicioEstudiante", and "Consultador", and adds an ActionListener to the search button ("botonBuscar") in the interface.

#### Method "buscar()":
Called when the search button is clicked. Uses the "buscar" method of a "Consultador" object to execute queries and obtain information about students. Results are displayed in the table of the "InicioEstudiante" interface.

#### Method "llenarDesdeVista()":
Fills the "Estudiante" object with the provided registration number in the interface.

#### Method "actionPerformed(ActionEvent e)":
Part of the ActionListener interface, called when an event occurs. Checks if the event comes from the search button ("botonBuscar") and calls the "buscar()" method in response.

#### Generate Certificate:
Uses the "llenarDesdeVista" method to obtain data. Then, validates if modules or diplomas were approved and generates a certificate accordingly.

### "ControladorInstructor" Class:
Controller associated with the instructor's user interface ("InstructoresUI").

#### Attributes:
- "estudiante": Object of the "Estudiante" class used to store and manipulate information about students.
- "vista": Object of the "InstructoresUI" class, representing the user interface.
- "consultador": Object of the "Consultador" class used for queries and operations on the database or another data source.

#### Constructor ("ControladorInstructor"):
Associates instances of "InstructoresUI", "Consultador", and "Estudiante". Adds ActionListeners to the interface buttons ("btn_modificar", "btn_mostrar", "buscar_btn").

#### Method "actionPerformed(ActionEvent e)":
Handles button events in the interface ("btn_modificar", "btn_mostrar", "buscar_btn").

Actions:
- Calls the "ModificarEstudiante()" method and then "Mostrar()" if the modify button is clicked.
- Calls "Mostrar()" if the show button is clicked.
- Calls "buscar()" if the search button is clicked.

#### Method "Mostrar()":
Uses the "MostrarAlumnos" method of the "consultador" object to display information about students in a table in the "InstructoresUI" interface.

#### Method "Seleccionar()":
Fills text fields in the interface with selected information from the student table. Parameters include a "JTable" and several "JTextField" from the "vista" object to display and manipulate information.

#### Method "ModificarEstudiante()":
Modifies student information in the database based on the selection in the student table.

#### Method "llenarVistaDesdeEstudiante()":
Fills text fields in the interface with information from the "Estudiante" object.

#### Method "limpiarCampos()":
Clears text fields in the interface.

#### Method "buscar()":
Searches and displays information about a student in the interface table based on the provided registration number.

### "ControladorLogin" Class:
Handles events of the login interface and authenticates the user using a "Consultador" object. Redirects to the appropriate interface (AccionesUI or InicioEstudiante) depending on the user type.

#### Attributes:
- "usuario": Object of the "Usuario" class used to store and manipulate information about users.
- "vista": Object of the "Login" class, representing the login interface.
- "inicio": Object of the "AccionesUI" class, representing the interface for user type 1.
- "inEst": Object of the "InicioEstudiante" class, representing the interface for user type 2.
- "consultas": Object of the "Consultador" class used for queries and operations related to the database or another data source.

#### Constructor ("ControladorLogin"):
Associates instances of "Usuario", "Login", "Consultador", "AccionesUI", and "InicioEstudiante". Adds an ActionListener to the login button ("usuarioBoton") in the interface.

#### Method "actionPerformed(ActionEvent e)":
Handles button events in the interface ("usuarioBoton").

Actions:
- Calls the "Verificar()" method if the login button is clicked.

#### Method "Verificar()":
Verifies user authentication and redirects to the corresponding interface based on the user type.

Actions:
- Calls the "llenarUsuario()" method to get user information from the interface.
- Uses the "consultas" object to search for the user in the database.
- If the user exists, redirects to the corresponding interface based on the user type (1 or 2).
- Shows an error message if the user data is incorrect or does not exist.

#### Method "llenarUsuario()":
Fills the "usuario" object with the information entered by the user in the interface.

### "ControlPdf" Class:
This controller demonstrates functionality to generate grade reports in PDF format and has the ability to generate certificates.

#### Attributes:
- "estudiante": Object of the "Estudiante" class used to store and manipulate information about students.
- "vista": Object of the "ReportesUI" class, representing the interface for report generation.
- "consultador": Object of the "Consultador" class used for queries and operations related to the database or another data source.
- "textArea": A "JTextArea" object that seems not to be used in this code snippet.

#### Constructor ("ControladorPdf"):
Associates instances of "ReportesUI", "Consultador", and "Estudiante". Adds ActionListeners to the interface buttons for PDF generation ("pdf_button") and certificates ("contancia_btn").

#### Method "actionPerformed(ActionEvent e)":
Handles button events in the interface ("pdf_button", "contancia_btn").

Actions:
- Calls the "Hacerpdf(List<Estudiante> estudiantes)" method if the PDF generation button is clicked.
- Calls the "HacerConstancia()" method if the certificate generation button is clicked.

#### Method "HacerConstancia()":

#### Method "Hacerpdf(List<Estudiante> estudiantes)":
Generates a PDF file with information about students' grades.

Parameters:
- List of "Estudiante" objects used to fill the PDF content.

Actions:
- Opens a "JFileChooser" for

 the user to select the location and name of the resulting PDF file.
- Uses the iText library to create a PDF document.
- Adds a header with the logo, title, and faculty.
- Creates a table to display information about students (registration number, name, diploma, grades, etc.).
- Changes the background color of the final cells according to the obtained grades.
- Adds a final paragraph with additional information.
- Closes the document.

## View
The "View" package encompasses the graphical interfaces fundamental for the interaction and functionality of the program. Each interface serves a specific purpose and contributes to the overall flow of the application.

### "Login" Interface:
Designed for users to log in.

#### Functionality:
- Allows user authentication.
- Redirects to the "InicioEstudiante" interface if the user is a student or to "InicioInstructores" if it is an instructor.

### "InicioInstructor" Interface:
Main view for instructors or teachers after logging in.

#### Functionality:
- Provides access to the "ReportesUI" and "DiplomadosUI" views.

### "DiplomadosUI" Interface:
Facilitates the selection of the course for data modification.

#### Functionality:
- Allows access to the "AccionesUI" view after choosing a course.

### "AccionesUI" Interface:
Enables the user to display a table with information about their students.

#### Functionality:
- Modification of student grades.
- Visualization of the status for each module.
- Filtering of students by their registration number.

### "ReportesUI" Interface:
Designed for the generation of a PDF with the list of students and their grades.

#### Functionality:
- Creation of PDF reports.
- Generation of certificates validating the approval of modules, courses, or diplomas.

### "InicioEstudiante" Interface:
View for students to search for their grades using their registration number and selecting the diploma.

#### Functionality:
- Search for grades by registration number and diploma.
- Generation of certificates validating the approval of courses.

## Argumentation:
The design of the interfaces reflects a clear division of responsibilities, providing each type of user (instructors and students) access to specific functions they need. The "Login" interface plays the crucial role of authenticating users and directing them to the appropriate interface based on their role.

Views related to instructors, such as "InicioInstructor", "DiplomadosUI", and "AccionesUI", provide tools to manage and assess the performance of students. "ReportesUI" facilitates the generation of detailed reports in PDF format, while "InicioEstudiante" focuses on the specific needs of students, allowing them to check and validate their grades through searches and certificate generation.

The structure of the interfaces demonstrates a well-planned and user-oriented architecture, addressing the needs of both instructors and students clearly and efficiently.
