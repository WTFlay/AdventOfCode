package dev.schriever.adventofcode.day2;

public record Round(int red, int green, int blue) {

  public boolean hasOneColorGreater(Round other) {
    return red > other.red || green > other.green || blue > other.blue;
  }

}
