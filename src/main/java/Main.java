public class Main {

    public static void printPersonDetails(Person person) {
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Is Retired: " + person.isRetired());
        if (person.getPartner() != null) {
            System.out.println("Partner: " + person.getPartner().getFirstName() + " " + person.getPartner().getLastName());
        } else {
            System.out.println("Partner: None");
        }
        System.out.println("--------------------");
    }
}
