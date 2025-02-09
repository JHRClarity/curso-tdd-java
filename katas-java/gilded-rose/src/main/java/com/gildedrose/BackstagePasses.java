package com.gildedrose;

public class BackstagePasses extends Item {

  public BackstagePasses(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    sellIn--;
    if (sellIn > 11) {
      quality++;
    } else if (sellIn > 6) {
      quality += 2;
    } else if (sellIn > 0) {
      quality += 3;
    } else {
      quality = 0;
    }
  }
}
