import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewManAndWomanTests {

    private enum ExpectedStatus {
        EQUALS,
        NOT_EQUALS
    }

    @DataProvider
    public Object[][] dataProviderForMan() {
        return new Object[][]{
                {ExpectedStatus.EQUALS, 65},
                {ExpectedStatus.EQUALS, 70},
                {ExpectedStatus.NOT_EQUALS, 37},
                {ExpectedStatus.NOT_EQUALS, 64},
        };
    }

    @DataProvider
    public Object[][] dataProviderForWoman() {
        return new Object[][]{
                {ExpectedStatus.EQUALS, 60},
                {ExpectedStatus.EQUALS, 65},
                {ExpectedStatus.NOT_EQUALS, 24},
                {ExpectedStatus.NOT_EQUALS, 59},
        };
    }

    //For testing change age for man and woman to check is retired
    Man man = new Man("Ivan", "Smith", 18);
    Woman woman = new Woman("Olya", "Ivanova", 25);


    @Test(testName = "Retired test", dataProvider = "dataProviderForMan", groups = "smoke",
            description = "Testing is retired man")
    public void isManRetiredTest(NewManAndWomanTests.ExpectedStatus status, int age) {
        if (status == NewManAndWomanTests.ExpectedStatus.EQUALS) {
            if (man.getAge() > age) {
                Assert.assertTrue(man.getAge() >= age);
                System.out.println(man.getFirstName() + " is retired because he is " + man.getAge() + " years old!");
            } else if (man.getAge() >= 65) {
                Assert.assertTrue(man.getAge() >= 65);
                System.out.println(man.getFirstName() + " is retired because he is " + man.getAge() + " years old!");
            } else {
                System.out.println(man.getFirstName() + " with this age: " + man.getAge() + " is not retired!");
            }
        } else if (status == ExpectedStatus.NOT_EQUALS) {
            if (man.getAge() <= age) {
                Assert.assertTrue(man.getAge() <= age);
                System.out.println("Man with this age: " + age + " is not retired!");
            } else if (man.getAge() <= 64) {
                Assert.assertTrue(man.getAge() <= 64);
                System.out.println(man.getFirstName() + " is not retired because he is " + man.getAge() + " years old!");
            } else {
                Assert.assertTrue(man.getAge() >= 65);
                System.out.println(man.getFirstName() + " is retired because he is " + man.getAge() + " years old!");
            }
        }
    }

    @Test(testName = "Retired test", dataProvider = "dataProviderForWoman", groups = "smoke",
            description = "Testing is retired woman")
    public void isWomanRetiredTest(NewManAndWomanTests.ExpectedStatus status, int age) {
        if (status == NewManAndWomanTests.ExpectedStatus.EQUALS) {
            if (woman.getAge() > age) {
                Assert.assertTrue(woman.getAge() >= age);
                System.out.println(woman.getFirstName() + " is retired because she is " + woman.getAge() + " years old!");
            } else if (woman.getAge() >= 60) {
                Assert.assertTrue(woman.getAge() >= 60);
                System.out.println(woman.getFirstName() + " is retired because she is " + woman.getAge() + " years old!");
            } else {
                System.out.println(woman.getFirstName() + " with this age: " + woman.getAge() + " is not retired!");
            }
        } else if (status == ExpectedStatus.NOT_EQUALS) {
            if (woman.getAge() <= age) {
                Assert.assertTrue(woman.getAge() <= age);
                System.out.println("Woman with this age: " + age + " is not retired!");
            } else if (woman.getAge() <= 59) {
                Assert.assertTrue(woman.getAge() <= 59);
                System.out.println(woman.getFirstName() + " is not retired because she is " + woman.getAge() + " years old!");
            } else {
                Assert.assertTrue(woman.getAge() >= 60);
                System.out.println(woman.getFirstName() + " is retired because she is " + woman.getAge() + " years old!");
            }
        }
    }
}
