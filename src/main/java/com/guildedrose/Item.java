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
        this.quality++;
    }
    public void decreaseQuality() {
        this.quality--;
    }
    public void increaseSellIn() {
        this.sellIn++;
    }
    public void decreaseSellIn() {
        this.sellIn--;
    }
}
