package dev.schriever.adventofcode.day1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrebuchetAnalyzer {

  private final DigitFinder digitFinder;

  public String parseCalibrationValue(String inputLine) {
    return digitFinder.findFirstDigit(inputLine) + digitFinder.findLastDigit(inputLine);
  }

}
