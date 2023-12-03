package dev.schriever.adventofcode.day1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleDigitFinder implements DigitFinder {

  private final DigitFinderStrategy digitFinderStrategy;

  @Override
  public String findFirstDigit(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (digitFinderStrategy.isDigit(str, i)) {
        return digitFinderStrategy.getDigit(str, i);
      }
    }
    return null;
  }

  @Override
  public String findLastDigit(String str) {
    for (int i = str.length() - 1; i >= 0; i--) {
      if (digitFinderStrategy.isDigit(str, i)) {
        return digitFinderStrategy.getDigit(str, i);
      }
    }
    return null;
  }

}
