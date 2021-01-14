package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseTest {

  @Test
  public void checkValuesAreLowered() {
    Item[] items = new Item[]{new Item("foo", 1, 1)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }

  @Test
  public void checkQualityIsNeverNegative() {
    Item[] items = new Item[]{new Item("foo", 0, 0)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(0, app.items[0].quality);
  }

  @Test
  public void checkQualityDegradesTwiceWhenSellDateIsPassed() {
    Item[] items = new Item[]{new Item("foo", -1, 4)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(-2, app.items[0].sellIn);
    assertEquals(2, app.items[0].quality);
  }

  @Test
  public void checkAgedBrieIncreasesQuality() {
    Item[] items = new Item[]{new AgedBrie("Aged Brie", 4, 6), new AgedBrie("Aged Brie", 0, 38)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(3, app.items[0].sellIn);
    assertEquals(7, app.items[0].quality);
    assertEquals(-1, app.items[1].sellIn);
    assertEquals(40, app.items[1].quality);
  }

  @Test
  public void checkQualityIsNeverGreaterThan50() {
    Item[] items = new Item[]{new AgedBrie("Aged Brie", 3, 50), new AgedBrie("Aged Brie", 0, 50)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(2, app.items[0].sellIn);
    assertEquals(50, app.items[0].quality);
    assertEquals(-1, app.items[1].sellIn);
    assertEquals(50, app.items[1].quality);
  }

  @Test
  public void checkSulfurasNeverDecreasesSellInNorQuality() {
    Item[] items = new Item[]{new Sulfuras("Sulfuras, Hand of Ragnaros", 28, 12)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(28, app.items[0].sellIn);
    assertEquals(12, app.items[0].quality);
  }

  @Test
  public void checkBackStageIncreasesQuality() {
    Item[] items = new Item[]{new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 19)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(14, app.items[0].sellIn);
    assertEquals(20, app.items[0].quality);
  }

  @Test
  public void checkBackStageIncreasesQualityTwiceWhenSellInIsLowerThan11() {
    Item[] items = new Item[]{new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 9)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(9, app.items[0].sellIn);
    assertEquals(11, app.items[0].quality);
  }

  @Test
  public void checkBackStageIncreasesQualityThreeTimesWhenSellInIsLowerThan6() {
    Item[] items = new Item[]{new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 12)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, app.items[0].sellIn);
    assertEquals(15, app.items[0].quality);
  }

  @Test
  public void checkBackStageQualityIsZeroWhenSellInIsNegative() {
    Item[] items = new Item[]{new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 0, 4)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(-1, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }
}
