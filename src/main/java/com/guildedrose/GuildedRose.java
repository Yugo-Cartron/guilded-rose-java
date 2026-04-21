package com.guildedrose;

class GuildedRose {
    Item[] items;

    public GuildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                decreaseQualityForNormalItemsOrSulfuras(item);
            } else {
                if (item.quality < 50) {
                    item.increaseQuality();

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.increaseQuality();
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.increaseQuality();
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.decreaseSellIn();
            }

            if (item.sellIn < 0) {
                updateWhenSellInIsPassed(item);
            }
        }
    }
    private void decreaseQualityForNormalItemsOrSulfuras(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.decreaseQuality();
            }
        }
    }

    private void updateWhenSellInIsPassed(Item item) {
        switch (item.name) {
            case "Backstage passes to a TAFKAL80ETC concert": {
                item.quality = 0;
                break;
            }
            case "Aged Brie": {
                if (item.quality < 50) {
                    item.increaseQuality();
                }
                break;
            }
            default: {
                decreaseQualityForNormalItemsOrSulfuras(item);
                break;
            }
        }
    }
}
