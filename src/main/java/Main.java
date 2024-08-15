import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {

    public static String formatting(String food) {
        return " ".repeat(8-food.length()) + food;
    }

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
}
