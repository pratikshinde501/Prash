import java.time.Year;

public class Student {
    static Student[] studentRecords = new Student[20];
    static int itCounter = 0;
    static int cseCounter = 0;
    static int eceCounter = 0;
    static int mechCounter = 0;
    static int chemCounter = 0;
    static int textileCounter = 0;

    String studentEmail;
    String studentName;
    String registrationNumber;
    String bloodType;
    int currentAcademicYear;
    String department;
    int enrollmentYear;
    String enrollmentMode;

    void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    void generateRegistrationNumber() {
        String deptCode = this.department.substring(0, 2).toUpperCase();
        int sequenceNum = 0;

        if (deptCode.equals("C")) {
            sequenceNum = ++cseCounter;
        } else if (deptCode.equals("E")) {
            sequenceNum = ++eceCounter;
        } else if (deptCode.equals("I")) {
            sequenceNum = ++itCounter;
        } else if (deptCode.equals("M")) {
            sequenceNum = ++mechCounter;
        } else if (deptCode.equals("T")) {
            sequenceNum = ++textileCounter;
        } else {
            sequenceNum = ++chemCounter;
        }

        if (enrollmentMode.equals("DSY")) {
            sequenceNum = 500 + sequenceNum;
            this.registrationNumber = this.enrollmentYear + "B" + deptCode + sequenceNum;
        } else {
            this.registrationNumber = this.enrollmentYear + "B" + deptCode + "0" + sequenceNum;
        }
        assignEmail(registrationNumber);
    }

    void assignBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    void assignEmail(String registrationNumber) {
        this.studentEmail = registrationNumber + "@sggs.ac.in";
    }

    void calculateCurrentAcademicYear(int enrollmentYear) {
        this.currentAcademicYear = (Year.now().getValue() - enrollmentYear) + 1;
    }

    void assignEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    void assignDepartment(String department) {
        this.department = department;
    }

    void assignEnrollmentMode(String enrollmentMode) {
        this.enrollmentMode = enrollmentMode;
    }

    void populateStudentInfo(String details) {
        String[] studentEntries = details.split("#");
        int totalEntries = studentEntries.length;

        for (int index = 0; index < totalEntries; index++) {
            String[] individualDetails = studentEntries[index].split(",");
            Student newStudent = new Student();

            for (String data : individualDetails) {
                data = data.trim();
                if (data.startsWith("Name=")) {
                    newStudent.setStudentName(data.substring(5));
                } else if (data.startsWith("Branch=")) {
                    newStudent.assignDepartment(data.substring(7));
                } else if (data.startsWith("BloodGroup=")) {
                    newStudent.assignBloodType(data.substring(11));
                } else if (data.startsWith("AdmissionYear=")) {
                    newStudent.assignEnrollmentYear(Integer.parseInt(data.substring(14)));
                } else if (data.startsWith("Mode=")) {
                    newStudent.assignEnrollmentMode(data.substring(5));
                }
            }

            newStudent.generateRegistrationNumber();
            newStudent.calculateCurrentAcademicYear(newStudent.enrollmentYear);
            studentRecords[index] = newStudent;
        }
    }

    void displayStudentDetails() {
        System.out.println("Name: " + studentName);
        System.out.println("Email: " + studentEmail);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Blood Group: " + bloodType);
        System.out.println("Current Year: " + currentAcademicYear);
        System.out.println("Department: " + department);
        System.out.println("Enrollment Year: " + enrollmentYear);
        System.out.println("Mode: " + enrollmentMode);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.populateStudentInfo(
            "Name=Pratik Shinde,Branch=IT,BloodGroup=O+,AdmissionYear=2024,Mode=DSY #Name=Vishal Barde,Branch=CSE,BloodGroup=O+,AdmissionYear=2023,Mode=Regular #Name=Om Bhosale,Branch=Mech,BloodGroup=A+,AdmissionYear=2023,Mode=Regular"
        );

        for (Student record : studentRecords) {
            if (record != null) {
                record.displayStudentDetails();
                System.out.println();
            }
        }
    }
}
