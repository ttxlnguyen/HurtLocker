import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.*;
import java.util.stream.*;
import java.util.*;


public class Main {
    static String[] foodItem = {"Milk", "Apples", "Bread", "Cookie"};

    public static String formatting(String foodItem) {
        return " ".repeat(8-foodItem.length()) + foodItem;
    }

    public static List<String> returnList(String foodItem, String compileMatcherMapStream) {
        return Pattern.compile("(?i)(?<=name:"+foodItem.charAt(0)+".{"+(foodItem.length() - 1)+"};price[:])[0-9].[0-9][0-9]+(?=;)").matcher(compileMatcherMapStream).results().map((m) -> m.group()).collect(Collectors.toList());
    }

    public static String logic(List<String> list, String foodItem) {
        StringBuilder sb = new StringBuilder("name:"+ formatting(foodItem)+"       seen: " +list.size()+ " times\n=============       =============\n");
        (new HashSet<>(list)).stream().forEach((m)->{sb.append(String.format("Price:   %s       seen: %d times\n-------------       -------------\n",m, Collections.frequency(list, m)));});
        return sb.append("\n").toString();
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