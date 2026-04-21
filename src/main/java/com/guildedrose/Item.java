package com.guildedrose;

public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void increaseQuality() {
        if (this.quality < 50) {
            this.quality++;
        }
    }
    public void decreaseQuality() {
        if (this.quality > 0) {
            this.quality--;
        }
    }

    public void updateQuality() {
        decreaseQuality();
        this.sellIn--;
        if(this.sellIn < 0) {
            decreaseQuality();
        }

    }
}
