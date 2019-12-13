import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void testBasicRegex() {
        String s = "Hello world!";
        String s1 = "Hello w0rld!";

        Pattern pattern = Pattern.compile("world");

        Matcher correctMatcher = pattern.matcher(s);
        boolean found1 = correctMatcher.find();
        Assert.assertTrue(found1);

        Matcher incorrectMatcher = pattern.matcher(s1);
        boolean found2 = incorrectMatcher.find();
        Assert.assertFalse(found2);
    }

    @Test
    public void testReplacement() {
        String phrase = "Some text here! And more text. And another text here.";
        String replaced = phrase.replaceAll("text", "replacement");
        System.out.println(replaced);
        boolean contains = replaced.contains("text");
        Assert.assertFalse(contains);
    }

    @Test
    public void testReplacement2() {
        String phrase = "Some text here! And more text. And another text here.";
        String replaced = phrase.replaceAll("\\W", "<3");
        System.out.println(replaced);
        Assert.assertFalse(replaced.contains("."));
        Assert.assertFalse(replaced.contains(" "));
        Assert.assertFalse(replaced.contains("!"));
    }

    @Test
    public void testReplacement3() {
        String phrase = "Some text here! And more text. And another text here.";
        String replaced = phrase.replaceAll("[!.]", "<3");
        System.out.println(replaced);
        Assert.assertFalse(replaced.contains("."));
        Assert.assertFalse(replaced.contains("!"));
    }

    @Test
    public void testCountryRegex() {
        String[] belarusNames = {
                "Беларусь",
                "беларусь",
                "Белоруссия",
                "белоруссия",

                "Бeлорусия",
                " Белоруссия",
                "Белоруссия1"
        };
        final Pattern belarusPattern = Pattern.compile("[Бб]ел[ао]рус(ь|сия)");

        Assert.assertEquals(true, belarusPattern.matcher(belarusNames[0]).matches());
        Assert.assertEquals(true, belarusPattern.matcher(belarusNames[1]).matches());
        Assert.assertEquals(true, belarusPattern.matcher(belarusNames[2]).matches());
        Assert.assertEquals(true, belarusPattern.matcher(belarusNames[3]).matches());
        Assert.assertEquals(false, belarusPattern.matcher(belarusNames[4]).matches());
        Assert.assertEquals(false, belarusPattern.matcher(belarusNames[5]).matches());
        Assert.assertEquals(false, belarusPattern.matcher(belarusNames[6]).matches());

    }

    @Test
    public void testEmailRegex() {
        String[] emails = {
                "vitalyatrololo@mail.ru",
                "3vitalyatrololo@mail.ru",
                "vitalyatRololo@mail.ru",
                "v@mail.ru",
                "vitalyatrololo@mail.net",
                "vitalyatrololo@mail.ru2",
                "vitalya_trololo@mail.ru",
                "vitalya-trololo@mail.ru",
        };
        final Pattern emailPattern = Pattern.compile("[A-z_-]{3,20}@[a-z]{4,6}\\.(com|ru|by)");

        Assert.assertEquals(true, emailPattern.matcher(emails[0]).matches());
        Assert.assertEquals(false, emailPattern.matcher(emails[1]).matches());
        Assert.assertEquals(true, emailPattern.matcher(emails[2]).matches());
        Assert.assertEquals(false, emailPattern.matcher(emails[3]).matches());
        Assert.assertEquals(false, emailPattern.matcher(emails[4]).matches());
        Assert.assertEquals(false, emailPattern.matcher(emails[5]).matches());
        Assert.assertEquals(true, emailPattern.matcher(emails[6]).matches());
        Assert.assertEquals(true, emailPattern.matcher(emails[7]).matches());

    }

}
