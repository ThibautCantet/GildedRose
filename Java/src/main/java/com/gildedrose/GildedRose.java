package com.gildedrose;

class GildedRose {
    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;
    private static final int MAXIMUM_INCREASE_DAY_2 = 11;
    private static final int MAXIMUM_INCREASE_DAY_1 = 6;
    private static final int MINIMUM_SELLIN = 0;

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (items[i].quality > MINIMUM_QUALITY) {
                    if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < MAXIMUM_QUALITY) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].sellIn < MAXIMUM_INCREASE_DAY_2) {
                            if (items[i].quality < MAXIMUM_QUALITY) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < MAXIMUM_INCREASE_DAY_1) {
                            if (items[i].quality < MAXIMUM_QUALITY) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < MINIMUM_SELLIN) {
                if (!items[i].name.equals(AGED_BRIE)) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].quality > MINIMUM_QUALITY) {
                            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < MAXIMUM_QUALITY) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}