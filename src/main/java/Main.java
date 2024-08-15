import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.*;
import java.util.stream.*;
import java.util.*;


public class Main {

    public static String formatting(String foodItem) {
        return " ".repeat(8-foodItem.length()) + foodItem;
    }

    public static List<String> returnList(String foodItem, String compileMatcherMapStream) {
        return Pattern.compile("(?i)(?<=name:"+foodItem.charAt(0)+".{"+(foodItem.length() - 1)+"};price[:])[0-9].[0-9][0-9]+(?=;)").matcher(compileMatcherMapStream).results().map((m) -> m.group()).collect(Collectors.toList());
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