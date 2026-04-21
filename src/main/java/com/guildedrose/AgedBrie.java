package com.guildedrose;

public class AgedBrie extends Item {
    
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        this.sellIn--;
        if(this.sellIn < 0) {
            increaseQuality();
        }
    }
}
