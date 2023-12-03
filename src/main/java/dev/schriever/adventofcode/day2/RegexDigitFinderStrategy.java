package dev.schriever.adventofcode.day2;

import dev.schriever.adventofcode.day1.DigitFinderStrategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDigitFinderStrategy implements DigitFinderStrategy {
  @Override
  public boolean isDigit(String str, int pos) {
    return matchDigit(str.substring(pos)).find();
  }

  @Override
  public String getDigit(String str, int pos) {
    var matcher = matchDigit(str.substring(pos));
    if (matcher.find()) {
      return matcher.group();
    }
    return null;
  }

  private Matcher matchDigit(String str) {
    Pattern integerPattern = Pattern.compile("-?\\d+");
    return integerPattern.matcher(str);
  }
}
