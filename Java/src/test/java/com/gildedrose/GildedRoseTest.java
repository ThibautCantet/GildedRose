package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateQuality_should_not_update_sulfuras_quality_nor_sellin() {
        Item sulfuras = new Item(SULFURAS_HAND_OF_RAGNAROS, 3, 4);
        Item[] items = new Item[] {sulfuras};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, sulfuras.sellIn);
        assertEquals(4, sulfuras.quality);
    }

    @Nested
    class OtherItem {
        @Test
        void updateQuality_should_decrease_by_1_quality_and_decrease_by_1_sellin_when_sellin_is_greater_than_0() {
            Item otherItem = new Item("other item", 3, 4);
            Item[] items = new Item[]{otherItem};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(2, otherItem.sellIn);
            assertEquals(3, otherItem.quality);
        }

        @Test
        void updateQuality_should_decrease_quality_by_2_and_decrease_by_1_sellin_when_sellin_is_less_than_0() {
            Item otherItem = new Item("other item", -1, 4);
            Item[] items = new Item[]{otherItem};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(-2, otherItem.sellIn);
            assertEquals(2, otherItem.quality);
        }

        @Test
        void updateQuality_should_not_update_quality_but_decrease_sellin_when_quality_equal_0() {
            Item otherItem = new Item("other item", -1, 0);
            Item[] items = new Item[]{otherItem};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(-2, otherItem.sellIn);
            assertEquals(0, otherItem.quality);
        }
    }

    @Nested
    class AgedBrie {
        @Test
        void updateQuality_should_increase_quality_and_decrease_sellin_when_quality_is_less_than_50() {
            Item agedBrie = new Item(AGED_BRIE, 3, 4);
            Item[] items = new Item[] {agedBrie};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(2, agedBrie.sellIn);
            assertEquals(5, agedBrie.quality);
        }

        @Test
        void updateQuality_should_increase_quality_by_2_and_decrease_sellin_when_sellin_is_less_than_0() {
            Item agedBrie = new Item(AGED_BRIE, -1, 4);
            Item[] items = new Item[] {agedBrie};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(-2, agedBrie.sellIn);
            assertEquals(6, agedBrie.quality);
        }

        @Test
        void updateQuality_should_not_increase_quality_and_decrease_sellin_when_quality_equal_50() {
            Item agedBrie = new Item(AGED_BRIE, 3, 50);
            Item[] items = new Item[] {agedBrie};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(2, agedBrie.sellIn);
            assertEquals(50, agedBrie.quality);
        }
    }

    @Nested
    class Backstage {
        @Test
        void updateQuality_should_increase_quality_by_2_and_decrement_sellin_when_sellin_between_10_and_5() {
            Item backStage = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 10, 4);
            Item[] items = new Item[]{backStage};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(9, backStage.sellIn);
            assertEquals(6, backStage.quality);
        }

        @Test
        void updateQuality_should_increase_quality_by_3_and_decrement_sellin_when_sellin_less_than_5() {
            Item backStage = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 5, 4);
            Item[] items = new Item[]{backStage};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(4, backStage.sellIn);
            assertEquals(7, backStage.quality);
        }

        @Test
        void updateQuality_should_update_quality_to_zero_when_sellin_is_passed() {
            Item backStage = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 0, 4);
            Item[] items = new Item[]{backStage};
            GildedRose app = new GildedRose(items);

            app.updateQuality();

            assertEquals(-1, backStage.sellIn);
            assertEquals(0, backStage.quality);
        }
    }
}
