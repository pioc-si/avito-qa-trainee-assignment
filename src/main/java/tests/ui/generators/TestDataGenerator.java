package tests.ui.generators;

import tests.ui.Advertisement;

public class TestDataGenerator {

    public static TestData generate() {
        var advertisement = Advertisement.builder()
                .name(RandomData.getName())
                .price(RandomData.getPrice())
                .description(RandomData.getDescription())
                .url("https://i.pinimg.com/736x/28/f0/e3/28f0e30e9643b90de06eaac32f59491f.jpg")
                .build();

        return TestData.builder()
                .advertisement(advertisement)
                .build();
    }
}
