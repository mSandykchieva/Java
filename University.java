import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }
    //Implement the following features:
    //•	getCapacity()
    //•	getStudents()
    //•	getStudentCount() method– returns the number of students in the university
    //•	registerStudent(Student student) method – adds an entity to the students if there is room for it
    //o	Returns "Added student {firstName} {lastName}" if the student is successfully added
    //o	Returns "Student is already in the university" if the student is already in the university
    //o	Returns "No seats in the university" if the university is full

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < capacity && !this.students.contains(student)) {
            this.students.add(student);
            return "Added student student.getFirstName() student.getLastName()";
        } else if (this.students.size() < capacity && this.students.contains(student)) {
            return "Student is already in the university";
        } else if (this.students.size()>=capacity){
            return "No seats in the university";
        }
        return null;
    }

    //•	dismissStudent(Student student) method – removes the student
    //o	Returns "Student not found" if the student is not in the university
    //
    //•	getStudent(String firstName, String lastName) method - returns the student with the given names.
    //•	getStatistics() – returns a String in the following format:
    //o	"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}

    public String dismissStudent(Student student) {

        if (this.students.contains(student)) {
            this.students.remove(student);
            return null;
        }
        return "Student not found";
    }

    public Student getStudent (String firstName, String lastName){
        for (Student student:this.students) {
            if(student.getFirstName().equals(firstName)&& student.getLastName().equals(lastName)){
                return student;
            }

        }
        return null;
    }

    public String getStatistics (){
        StringBuilder builder = new StringBuilder();
        String result = "";
        for (Student student:this.students) {
            builder.append("==Student: First Name = ").append(student.getFirstName()).append(", Last Name = ").append(student.getLastName()).append(", Best Subject = ").append(student.getBestSubject()).append(System.lineSeparator());

        }
        result+=builder;
        return result;
    }


}
