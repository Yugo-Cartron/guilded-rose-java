package com.guildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AgedBrieTest {
    @Test
    void qualityShouldIncreaseOfOneIfSellInIsGreaterThan0() {
    AgedBrie agedBrie = new AgedBrie(1, 40);
    
    agedBrie.updateQuality();
    assertEquals(agedBrie.quality, 41);
    }

    @Test
    void qualityShouldIncreaseOfTwoIfSellInIsLowerThan0() {
    AgedBrie agedBrie = new AgedBrie(-1, 40);
    
    agedBrie.updateQuality();
    assertEquals(agedBrie.quality, 42);
    }
}
