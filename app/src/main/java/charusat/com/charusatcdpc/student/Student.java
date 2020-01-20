package charusat.com.charusatcdpc.student;

public class Student {

    String name;
    String id;
    String birthdate;
    String phone;
    String address;
    String email;
    String cgpa;
    String skills;
    String projects;
    String branch;
    String sem;

    public Student(String name, String id, String birthdate, String phone, String address, String email, String cgpa, String skills, String projects, String branch, String sem) {
        this.name = name;
        this.id = id;
        this.birthdate = birthdate;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.cgpa = cgpa;
        this.skills = skills;
        this.projects = projects;
        this.branch = branch;
        this.sem = sem;
    }

    public Student() {
        this.name = null;
        this.email = null;
        this.address = null;
        this.birthdate = null;
        this.address = null;
        this.phone = null;
        this.id = null;
        this.cgpa = null;
        this.projects = null;
        this.skills = null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

}
