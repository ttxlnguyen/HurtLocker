import org.junit.*;
import java.util.*;

public class HurtLockerTest {

    @Test
    public void testGetList() {
        int expected = 5;
        String s = "xxxxx";
        List<String> list = Main.returnList("x", s);
        int actual = list.size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void formatting() {
        String expected = "    Milk";
        String actual = Main.formatting("Milk");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void formatting2() {
        String expected = "22222222";
        String actual = Main.formatting("22222222");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testProcess() {
        String expected = ""+
                "name:    Milk       seen: 3 times\n" +
                "=============       =============\n" +
                "Price:   4.99       seen: 3 times\n" +
                "-------------       -------------\n\n";
        ArrayList<String> arr = new ArrayList<>();
        arr.add("4.99");
        arr.add("4.99");
        arr.add("4.99");
        String actual = Main.logic(arr, "Milk");
        Assert.assertEquals(expected, actual);
    }
}
