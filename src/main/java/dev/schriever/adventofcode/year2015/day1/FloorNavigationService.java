package dev.schriever.adventofcode.year2015.day1;

public class FloorNavigationService {
  public long detectFloor(String input) {
    long openingParenthesis = input.chars().filter(ch -> ch == '(').count();
    long closingParenthesis = input.chars().filter(ch -> ch == ')').count();
    return openingParenthesis - closingParenthesis;
  }
}
