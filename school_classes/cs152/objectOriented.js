function Student(firstName, lastName, studentID){
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentID = studentID;
    this.display = function() {
        console.log("First Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nStudent ID: " + this.studentID);
    };
}

var students = [
    new Student("John", "Doe", "1234567890"),
    new Student("Your", "Name", "Student ID"),
]

var newStudents = [
    new Student("Froilan", "Zarate", "016475732", (this.graduated = false)),
    new Student("Sam", "Smith", "3373737373737")
]

var student = {
    firstName: "Hello",
    lastName: "World",
    studentID: "14572395"
}

for (var i = 0; i < students.length; i++) {
    students[i].display();
    console.log("graduated: " + students[i].graduated + "\n")
}
