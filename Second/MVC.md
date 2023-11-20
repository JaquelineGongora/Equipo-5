# MVC
MVC (Model-View-Controller) is a design pattern that separates the application into three main components: Model, View and Controller, where each component will be implemented as a class or a set of classes in a way that facilitates modularity, code reuse.

In our project this pattern was used as follows:

[Link](https://github.com/JaquelineGongora/Equipo-5/tree/Second/Code) to access the code.

1. **Model:**
   
   _Student Class:_
   - Represents the main data entity in the application: a student.
   - Contains attributes for student information (id, enrollment, name, diploma, grade).
   - Provides getter and setter methods to access and modify these attributes.
   - Functions as the data and business logic layer.

    _Consultation Class:_
   - Performs operations related to the database for the Student entity
   - Contains methods to load, register, modify, delete and search for students in the database.
   - Acts as the bridge between the data layer and the controller.

2. **View:**

    _NewJFrame class:_
   - Represents the graphical user interface (GUI) of the application.
   - Contains visual components such as buttons, text fields and text areas to interact with the user.
   - Has event methods to handle user actions (button clicks, etc.).

4. **Controller:**

    _StudentController class:_
   - Acts as the main controller that manages the interaction between the model and the view.
   - Implements the ActionListener interface to handle action events generated by the view.
   - Contains methods to add, modify, delete, search for students and clear fields in the interface.
   - Uses Student and Query instances to perform operations and update the view.