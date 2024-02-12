package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateAll() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        ItemUtils.updateQuality(item);

        ItemUtils.decreaseSellIn(item);

        if (item.sellIn < 0) {
            ItemUtils.itemTimeout(item);
        }
    }

}
