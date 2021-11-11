public class Person {
    private int id;
    private String name, birthplace, dob;

    public Person() {
    }

    public Person(int id, String name, String birthplace, String dob) {
        this.id = id;
        this.name = name;
        this.birthplace = birthplace;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-20s %-10s", id,name,dob,birthplace);
    }
}
