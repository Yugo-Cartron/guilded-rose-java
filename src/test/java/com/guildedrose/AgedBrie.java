package com.guildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AgedBrie {
    @Test
    void qualityShouldIncreaseOfOneIfSellInIsGreaterThan0() {
    AgedBrie agedBrie = new AgedBrie();
    
    }

    @Test
    void qualityShouldIncreaseOfTwoIfSellInIsLowerThan0() {
        Sulfura sulfuraItem = new Sulfura();

        assertEquals(sulfuraItem.sellIn, -1);
        sulfuraItem.updateSellIn();
        assertEquals(sulfuraItem.sellIn, -1);
    }
}
