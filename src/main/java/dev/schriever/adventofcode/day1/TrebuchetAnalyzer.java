package dev.schriever.adventofcode.day1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrebuchetAnalyzer {

  private final DigitFinder digitFinder;

  public String parseCalibrationValue(String inputLine) {
    return findFirstDigit(inputLine) + findLastDigit(inputLine);
  }

  private String findFirstDigit(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (digitFinder.isDigit(str, i)) {
        return digitFinder.getDigit(str, i);
      }
    }
    return null;
  }

  private String findLastDigit(String str) {
    for (int i = str.length() - 1; i >= 0; i--) {
      if (digitFinder.isDigit(str, i)) {
        return digitFinder.getDigit(str, i);
      }
    }
    return null;
  }

}
