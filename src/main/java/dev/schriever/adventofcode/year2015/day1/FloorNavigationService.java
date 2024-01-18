package dev.schriever.adventofcode.year2015.day1;

public class FloorNavigationService {
  private static final char UP_CHAR = '(';
  private static final char DOWN_CHAR = ')';

  public long detectFloor(String input) {
    long upFloors = input.chars().filter(this::isUpFloorChar).count();
    long downFloors = input.chars().filter(this::isDownFloorChar).count();
    return upFloors - downFloors;
  }

  public long detectBasementEntryPosition(String input) {
    long actualFloor = 0;
    for (int i = 0; i < input.length(); i++) {
      if (isUpFloorChar(input.charAt(i))) {
        actualFloor += 1;
      } else if (isDownFloorChar(input.charAt(i))) {
        actualFloor -= 1;
      }
      if (actualFloor == -1) {
        return i + 1;
      }
    }
    return 0;
  }

  private boolean isUpFloorChar(int ch) {
    return ch == UP_CHAR;
  }

  private boolean isDownFloorChar(int ch) {
    return ch == DOWN_CHAR;
  }
}
