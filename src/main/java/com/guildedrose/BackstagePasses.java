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
         this.sellIn--;
    }
}
