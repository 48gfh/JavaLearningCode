public class Student {
    private int sutdentId;
    private String studentName;
    private int studentAge;
    private String studentSex;

    public int getSutdentId() {
        return sutdentId;
    }

    public void setSutdentId(int sutdentId) {
        this.sutdentId = sutdentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Student() {
    }

    public Student(int sutdentId, String studentSex, int studentAge, String studentName) {
        this.sutdentId = sutdentId;
        this.studentSex = studentSex;
        this.studentAge = studentAge;
        this.studentName = studentName;
    }
}
