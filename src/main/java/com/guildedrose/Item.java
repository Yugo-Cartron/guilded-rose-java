package com.guildedrose;

public class Item {
    public String name;
    public int sellIn;
    public Quality quality;

    public Item(String name, int sellIn, Quality quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void applyDailyUpdate() {
        applyDailyQualityUpdate();
        applyDailySellInUpdate();
    }

    private void applyDailySellInUpdate() {
        this.sellIn--;
    }

    private void applyDailyQualityUpdate() {
        if (isPerempted()) {
            this.quality.decreaseFaster();
        } else {
            this.quality.decrease();
        }
    }

    private boolean isPerempted() {
        return this.sellIn < 0;
    }
}
