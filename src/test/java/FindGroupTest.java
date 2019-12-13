import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroupTest {

    @Test
    public void testGroupsGreedy() {
        String magicString =
                "Some text here, then object: {number:8}, " +
                        "then another object: {number: 32}," +
                        "and one more object: {number: 17}" +
                        "the end";


        Pattern pattern = Pattern.compile("\\{.+}");
        Matcher matcher = pattern.matcher(magicString);

        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

    @Test
    public void testGroupsSuperGreedy() {
        String magicString =
                "Some text here, then object: {number:8}, " +
                        "then another object: {number: 32}," +
                        "and one more object: {number: 17}" +
                        "the end";


        Pattern pattern = Pattern.compile("\\{.++}");
        Matcher matcher = pattern.matcher(magicString);

        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

    @Test
    public void testGroupsLazy() {
        String magicString =
                "Some text here, then object: {number:8}, " +
                        "then another object: {number: 32}," +
                        "and one more object: {number: 17}" +
                        "the end";


        Pattern pattern = Pattern.compile("\\{.+?}");
        Matcher matcher = pattern.matcher(magicString);

        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
