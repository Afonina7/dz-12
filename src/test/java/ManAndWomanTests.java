import org.testng.annotations.*;
import org.testng.Assert;


public class ManAndWomanTests {

    Woman woman = new Woman("Olya", "Ivanova", 34);
    Man man = new Man("Ivan", "Smith", 37);

    @Test(testName = "Person test", groups = "smoke", description = "Testing woman and man data")
    public void ManAndWomanTests() {
        //////// Woman assertions ////////
        System.out.println("//////// Woman assertions ////////");
        Main.printPersonDetails(woman);
        Assert.assertEquals(woman.getFirstName(), "Olya", "First name is incorrect!");
        Assert.assertEquals(woman.getLastName(), "Ivanova", "Last name is incorrect!");
        Assert.assertEquals(woman.getAge(), 34, "Age is incorrect");

        woman.setAge(45);
        Assert.assertEquals(woman.getAge(), 45);
        System.out.println(woman.getFirstName() + " Is Retired: " + woman.isRetired());

        woman.setAge(60);
        Assert.assertEquals(woman.getAge(), 60);
        System.out.println(woman.getFirstName() + " Is Retired: " + woman.isRetired());

        woman.registerPartnership(man);
        Assert.assertEquals(woman.getLastName(), "Smith", "Last name is incorrect");
        Assert.assertNotEquals(woman.getLastName(), "Ivanova", "Last name is incorrect!");

        System.out.println("Information for Woman after true deregister partnership: ");
        woman.deregisterPartnership(true);
        Assert.assertEquals(woman.getLastName(), "Ivanova", "Last name is incorrect!");
        Main.printPersonDetails(woman);

        System.out.println("--------------------");

        //////// Man assertions ////////
        System.out.println("//////// Man assertions ////////");
        Assert.assertEquals(man.getFirstName(), "Ivan", "First name is incorrect");
        Assert.assertEquals(man.getLastName(), "Smith", "Last name is incorrect!");
        Assert.assertEquals(man.getAge(), 37, "Age is incorrect!");

        man.setAge(65);
        Assert.assertEquals(man.getAge(), 65);
        System.out.println("Is Retired: " + man.isRetired());
        Assert.assertTrue(man.isRetired(), "Is not retired");

        System.out.println("Information for Man after true de register partnership: ");
        man.deregisterPartnership(true);
        Assert.assertEquals(man.getLastName(), "Smith", "Last name is incorrect!");
        Main.printPersonDetails(man);
    }
}

