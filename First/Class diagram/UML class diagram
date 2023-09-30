```mermaid
classDiagram
    class Student {
        - Name: String
        - Last Name: String
        - Student Number: String
        - Email: String
        + Register()
        + Modify()
        + ReviewGrades()
    }

    class Diploma {
        - Name: String
        - Description: String
        - Duration: String
        + GetInformation()
    }

    class Course {
        - Name: String
        - Description: String
        - Duration: String
        + GetInformation()
    }

    class Grade {
        - Student: Student
        - Course/Diploma: Course or Diploma
        - Grade: Double
    }

    class FacultyOfMathematics {
        - Name: String
        + OfferCourse()
        + OfferDiploma()
    }

    class DepartmentOfEngagement {
        - Name: String
        + PromoteServices()
    }

    class Service {
        - Name: String
        - Description: String
    }

    class ProfessionalProduct {
        - Name: String
        - Description: String
        - Rating: Double
    }

    class Sector {
        - Name: String
    }

    Student -- Grade: "ReviewGrades"
    FacultyOfMathematics -- Course: "OfferCourse"
    FacultyOfMathematics -- Diploma: "OfferDiploma"
    DepartmentOfEngagement -- Service: "PromoteServices"
    Course -- ProfessionalProduct: "Offer"
    Diploma -- ProfessionalProduct: "Offer"
    ProfessionalProduct -- Sector: "BelongTo"
