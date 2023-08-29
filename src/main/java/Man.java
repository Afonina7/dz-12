public class Man extends Person {

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    public void registerPartnership(Woman wife) {
        setLastName(wife.getLastName());
        setPartner(wife);
    }
}
