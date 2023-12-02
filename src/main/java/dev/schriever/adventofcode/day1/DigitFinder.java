package dev.schriever.adventofcode.day1;

public interface DigitFinder {
  boolean isDigit(String str, int pos);

  String getDigit(String str, int pos);
}
