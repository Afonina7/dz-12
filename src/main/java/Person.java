public class Person {

    private final String firstName;
    private String lastName;
    private int age;
    private Person partner;
    private final String originalLastName;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.originalLastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public boolean isRetired() {
        if (this instanceof Woman) {
            return age >= 60;
        } else if (this instanceof Man) {
            return age >=65;
        }
        return false;
    }

    public void deregisterPartnership(boolean revertLastName) {
        if (revertLastName) {
            this.partner = null;
            this.lastName = this.originalLastName;
        }
    }
}
