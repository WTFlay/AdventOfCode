package dev.schriever.adventofcode.day1;

public class NaturalDigitFinderStrategy implements DigitFinderStrategy {
  @Override
  public boolean isDigit(String str, int pos) {
    return Character.isDigit(str.charAt(pos));
  }

  @Override
  public String getDigit(String str, int pos) {
    return isDigit(str, pos) ? String.valueOf(str.charAt(pos)) : "";
  }
}
