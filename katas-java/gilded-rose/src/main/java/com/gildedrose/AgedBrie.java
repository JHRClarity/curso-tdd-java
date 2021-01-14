package com.gildedrose;

public class AgedBrie extends Item {

  public AgedBrie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    sellIn--;
    if (sellIn < 0) {
      quality += 2;
    } else {
      quality++;
    }
    quality = validateQuality(quality);
  }
}
