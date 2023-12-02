package dev.schriever.adventofcode.day1;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DigitFinderFactory implements DigitFinder {

  private final List<DigitFinder> digitFinderList;

  @Override
  public boolean isDigit(String str, int pos) {
    return digitFinderList.stream().anyMatch(digitFinder -> digitFinder.isDigit(str, pos));
  }

  @Override
  public String getDigit(String str, int pos) {
    return digitFinderList.stream()
        .filter(digitFinder -> digitFinder.isDigit(str, pos))
        .map(digitFinder -> digitFinder.getDigit(str, pos))
        .findFirst()
        .orElse(null);
  }
}
