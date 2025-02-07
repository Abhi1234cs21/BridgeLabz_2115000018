class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getPersonDetails() {
        return "Name: " + name + ", Age: " + age;
    }

    public void displayRole() {
        System.out.println("Role: Person");
    }
}

class Teacher {
    Person person;
    String subject;

    Teacher(Person person, String subject) {
        this.person = person;
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role: Teacher, Subject: " + subject);
    }

    public String getDetails() {
        return person.getPersonDetails() + ", Subject: " + subject;
    }
}

class Student {
    Person person;
    String grade;

    Student(Person person, String grade) {
        this.person = person;
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role: Student, Grade: " + grade);
    }

    public String getDetails() {
        return person.getPersonDetails() + ", Grade: " + grade;
    }
}

class Staff {
    Person person;
    String department;

    Staff(Person person, String department) {
        this.person = person;
        this.department = department;
    }

    public void displayRole() {
        System.out.println("Role: Staff, Department: " + department);
    }

    public String getDetails() {
        return person.getPersonDetails() + ", Department: " + department;
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Person teacherPerson = new Person("Mr. Smith", 35);
        Teacher teacher = new Teacher(teacherPerson, "Mathematics");
        
        Person studentPerson = new Person("Alice Johnson", 16);
        Student student = new Student(studentPerson, "10th Grade");
        
        Person staffPerson = new Person("Mrs. Green", 50);
        Staff staff = new Staff(staffPerson, "Administration");

        teacher.displayRole();
        System.out.println(teacher.getDetails());

        student.displayRole();
        System.out.println(student.getDetails());

        staff.displayRole();
        System.out.println(staff.getDetails());
    }
}
