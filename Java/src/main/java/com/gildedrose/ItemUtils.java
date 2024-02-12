package com.gildedrose;

public class ItemUtils {

    public ItemUtils() {
    }

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";

    private static final String BRIE = "Aged Brie";

    private static final String RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public static void itemTimeout(Item item) {
        if (item.name.equals(BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE)) {
            item.quality = 0;
        } else if (!item.name.equals(RAGNAROS)) {
            decreaseQuality(item);
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public static void decreaseSellIn(Item item) {
        if (!item.name.equals(RAGNAROS)) {
            item.sellIn -= 1;
        }
    }

    public static void updateQuality(Item item) {
        if (item.name.equals(BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE)) {
            updateBackstagePass(item);
        } else if (item.quality > 0) {
            if (!item.name.equals(RAGNAROS)) {
                item.quality = item.quality - 1;
            }
        }
    }

    private static void updateBackstagePass(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }

        }
    }
}
