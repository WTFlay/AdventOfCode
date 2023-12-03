package dev.schriever.adventofcode.day1;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompositeDigitFinderStrategy implements DigitFinderStrategy {

  private final List<DigitFinderStrategy> digitFinderStrategyList;

  @Override
  public boolean isDigit(String str, int pos) {
    return digitFinderStrategyList.stream().anyMatch(digitFinder -> digitFinder.isDigit(str, pos));
  }

  @Override
  public String getDigit(String str, int pos) {
    return digitFinderStrategyList.stream()
        .filter(digitFinder -> digitFinder.isDigit(str, pos))
        .map(digitFinder -> digitFinder.getDigit(str, pos))
        .findFirst()
        .orElse(null);
  }
}
