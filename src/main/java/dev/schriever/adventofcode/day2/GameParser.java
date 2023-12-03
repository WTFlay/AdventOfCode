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
      Map<Color, Integer> colorMap = new HashMap<>();
      for (String colorStr : colors) {
        String total = digitFinder.findFirstDigit(colorStr);
        Color color = findColor(colorStr);
        colorMap.put(color, Integer.valueOf(total));
      }
      roundList.add(new Round(
          colorMap.getOrDefault(Color.RED, 0),
          colorMap.getOrDefault(Color.GREEN, 0),
          colorMap.getOrDefault(Color.BLUE, 0)
      ));
    }

    return new Game(Long.valueOf(gameNumber), roundList);
  }

  private Color findColor(String text) {
    return Arrays.stream(Color.values())
        .filter(color -> text.contains(color.name().toLowerCase()))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Unknown color"));
  }

  private enum Color {BLUE, RED, GREEN}

}
