package dev.schriever.adventofcode.day1;

public class NaturalDigitFinder implements DigitFinder {
  @Override
  public boolean isDigit(String str, int pos) {
    return Character.isDigit(str.charAt(pos));
  }

  @Override
  public String getDigit(String str, int pos) {
    return isDigit(str, pos) ? String.valueOf(str.charAt(pos)) : "";
  }
}
