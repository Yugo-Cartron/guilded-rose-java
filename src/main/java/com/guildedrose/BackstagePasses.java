package com.guildedrose;

public class BackstagePasses extends Item {

    public BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    } 

    public void updateQuality() {
        this.quality++;

        if(this.sellIn <= 10) {
            this.quality++;
        }
        if(this.sellIn <= 5) {
            this.quality++;
        }
        if(this.sellIn < 0) {
            this.quality = 0;
        }
         this.sellIn--;
    }
}
