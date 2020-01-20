package charusat.com.charusatcdpc.admin;

public class Company {

    String company_name;
    String company_location;
    String company_type;
    String required_skills;
    String required_students;
    String website;
    String company_email;

    public Company()
    {
        this.company_name = null;
        this.company_location = null;
        this.company_type = null;
        this.required_skills = null;
        this.required_students = null;
        this.website = null;
        this.company_email = null;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_location() {
        return company_location;
    }

    public void setCompany_location(String company_location) {
        this.company_location = company_location;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getRequired_skills() {
        return required_skills;
    }

    public void setRequired_skills(String required_skills) {
        this.required_skills = required_skills;
    }

    public String getRequired_students() {
        return required_students;
    }

    public void setRequired_students(String required_students) {
        this.required_students = required_students;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }



    public Company(String company_name, String company_location, String company_type, String required_skills, String required_students, String website, String company_email) {
        this.company_name = company_name;
        this.company_location = company_location;
        this.company_type = company_type;
        this.required_skills = required_skills;
        this.required_students = required_students;
        this.website = website;
        this.company_email = company_email;
    }
}
