package dev.schriever.adventofcode.year2015.day1;

public class FloorNavigationService {
  private static final long INITIAL_FLOOR = 0;
  private static final long BASEMENT_FLOOR = -1;
  private static final char UP_CHAR = '(';
  private static final char DOWN_CHAR = ')';

  public long detectFloor(String input) {
    return input.chars().mapToLong(this::toFloorDirection).reduce(INITIAL_FLOOR, Long::sum);
  }

  public long detectBasementEntryPosition(String input) {
    long actualFloor = INITIAL_FLOOR;
    for (int pos = 0; pos < input.length(); pos++) {
      char currentChar = input.charAt(pos);
      actualFloor += toFloorDirection(currentChar);
      if (actualFloor == BASEMENT_FLOOR) {
        return pos + 1;
      }
    }
    throw new RuntimeException("We never reach the basement");
  }

  private long toFloorDirection(int ch) {
    if (isUpFloorChar(ch)) {
      return 1;
    } else if (isDownFloorChar(ch)) {
      return -1;
    } else {
      return 0;
    }
  }

  private boolean isUpFloorChar(int ch) {
    return ch == UP_CHAR;
  }

  private boolean isDownFloorChar(int ch) {
    return ch == DOWN_CHAR;
  }
}
