package com.guildedrose;

public class AgedBrie extends Item {
    
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    public void updateQuality() {
        this.quality++;
        this.sellIn--;
        if(this.sellIn < 0) {
            this.quality++;
        }
    }
}
