package com.guildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BackstagePassesTest {
    @Test
    void qualityShouldIncreaseOfOneIfSellInIsGreaterThanTen() {
        BackstagePasses backstagePasses = new BackstagePasses(11, 20);

        backstagePasses.updateQuality();
        assertEquals(backstagePasses.quality, 21);
    }

    @Test
    void qualityShouldIncreaseOfTwoIfSellInIsLowerOrEqualsToTen() {
        BackstagePasses backstagePasses = new BackstagePasses(9, 20);

        backstagePasses.updateQuality();
        assertEquals(backstagePasses.quality, 22);
    }
}
