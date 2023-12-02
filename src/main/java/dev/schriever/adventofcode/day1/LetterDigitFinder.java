package dev.schriever.adventofcode.day1;

import java.util.HashMap;
import java.util.Map;

public class LetterDigitFinder implements DigitFinder {

  private final Map<String, String> digitLettersMap;

  public LetterDigitFinder() {
    digitLettersMap = new HashMap<>();
    digitLettersMap.put("one", "1");
    digitLettersMap.put("two", "2");
    digitLettersMap.put("three", "3");
    digitLettersMap.put("four", "4");
    digitLettersMap.put("five", "5");
    digitLettersMap.put("six", "6");
    digitLettersMap.put("seven", "7");
    digitLettersMap.put("eight", "8");
    digitLettersMap.put("nine", "9");
  }

  @Override
  public boolean isDigit(String str, int pos) {
    return digitLettersMap.keySet().stream().anyMatch(str.substring(pos)::startsWith);
  }

  @Override
  public String getDigit(String str, int pos) {
    return digitLettersMap.keySet()
        .stream()
        .filter(str.substring(pos)::startsWith)
        .map(digitLettersMap::get)
        .findFirst()
        .orElse(null);
  }
}
