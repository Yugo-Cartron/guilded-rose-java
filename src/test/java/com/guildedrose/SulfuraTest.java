package com.guildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SulfuraTest {
    @Test
    void sulfuraShouldAlwaysHave80Quality() {
    Sulfura sulfuraItem = new Sulfura();
    
    assertEquals(sulfuraItem.quality, 80);
    sulfuraItem.updateQuality();
    assertEquals(sulfuraItem.quality, 80);
    }

    @Test
    void sellInShouldAlwaysEqualMinusOne() {
        Sulfura sulfuraItem = new Sulfura();

        assertEquals(sulfuraItem.sellIn, -1);
        sulfuraItem.updateSellIn();
        assertEquals(sulfuraItem.sellIn, -1);
    }
}
