package com.gildedrose;

public class Item {

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = validateQuality(quality);
  }

  public void update() {
    sellIn--;
    if (sellIn < 0) {
      quality -= 2;
    } else {
      quality--;
    }
    quality = validateQuality(quality);
  }

  protected int validateQuality(int quality) {

    if (quality > 50) {
      return 50;
    } else if (quality < 0) {
      return 0;
    }

    return quality;
  }

  public String toString() {
    return name + ", " + sellIn + ", " + quality;
  }
}
