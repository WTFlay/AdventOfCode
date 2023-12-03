package dev.schriever.adventofcode.day1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrebuchetAnalyzer {

  private final DigitFinderStrategy digitFinderStrategy;

  public String parseCalibrationValue(String inputLine) {
    return findFirstDigit(inputLine) + findLastDigit(inputLine);
  }

  private String findFirstDigit(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (digitFinderStrategy.isDigit(str, i)) {
        return digitFinderStrategy.getDigit(str, i);
      }
    }
    return null;
  }

  private String findLastDigit(String str) {
    for (int i = str.length() - 1; i >= 0; i--) {
      if (digitFinderStrategy.isDigit(str, i)) {
        return digitFinderStrategy.getDigit(str, i);
      }
    }
    return null;
  }

}
