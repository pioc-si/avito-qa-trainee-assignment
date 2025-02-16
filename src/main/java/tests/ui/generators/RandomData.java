package tests.ui.generators;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomData {

    private static final Integer NAME_LENGTH = 6;
    private static final Integer PRICE_LENGTH = 3;
    private static final Integer DESCRIPTION_LENGTH = 10;

    public static String getName(){
        return "T" + RandomStringUtils.randomAlphabetic(NAME_LENGTH);
    }

    public static int getPrice(){
        return Integer.parseInt(RandomStringUtils.randomNumeric(PRICE_LENGTH));
    }

    public static String getDescription(){
        return "T " + RandomStringUtils.randomAlphabetic(DESCRIPTION_LENGTH) +
                ". " + RandomStringUtils.randomAlphabetic(DESCRIPTION_LENGTH)
                + ".";
    }

}
