package dev.schriever.adventofcode.day2;

import dev.schriever.adventofcode.day1.DigitFinder;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class GameParser {

  private final DigitFinder digitFinder;

  public Game parseGame(String input) {
    String[] parts = input.split(":");
    String header = parts[0];
    String gameNumber = digitFinder.findFirstDigit(header);

    List<Round> roundList = new ArrayList<>();
    for (String roundStr : parts[1].split(";")) {
      String[] colors = roundStr.split(",");
      Map<Color, NumberOfBalls> colorMap = parseNumberOfBallsForEachColors(colors);
      roundList.add(new Round(
          colorMap.getOrDefault(Color.RED, NumberOfBalls.ZERO).number(),
          colorMap.getOrDefault(Color.GREEN, NumberOfBalls.ZERO).number(),
          colorMap.getOrDefault(Color.BLUE, NumberOfBalls.ZERO).number()
      ));
    }

    return new Game(Long.valueOf(gameNumber), roundList);
  }

  private Map<Color, NumberOfBalls> parseNumberOfBallsForEachColors(String[] colors) {
    Map<Color, NumberOfBalls> colorMap = new HashMap<>();
    for (String colorStr : colors) {
      Color color = findColor(colorStr);
      String firstDigit = digitFinder.findFirstDigit(colorStr);
      NumberOfBalls numberOfBalls = new NumberOfBalls(Integer.parseInt(firstDigit));
      colorMap.put(color, numberOfBalls);
    }
    return colorMap;
  }

  private Color findColor(String text) {
    return Arrays.stream(Color.values())
        .filter(color -> text.contains(color.name().toLowerCase()))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Unknown color"));
  }

  private enum Color {BLUE, RED, GREEN}

  record NumberOfBalls(int number) {
    static NumberOfBalls ZERO = new NumberOfBalls(0);
  }

}
