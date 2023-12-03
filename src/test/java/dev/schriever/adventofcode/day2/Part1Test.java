package dev.schriever.adventofcode.day2;

import dev.schriever.adventofcode.day1.DigitFinder;
import dev.schriever.adventofcode.day1.SimpleDigitFinder;
import dev.schriever.adventofcode.helper.FileHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Day2")
public class Part1Test {

  private GameParser gameParser;

  @BeforeEach
  public void setup() {
    DigitFinder digitFinder = new SimpleDigitFinder(new RegexDigitFinderStrategy());
    gameParser = new GameParser(digitFinder);
  }

  @Test
  public void example_1() {
    var input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

    var game = gameParser.parseGame(input);

    assertEquals(1L, game.number());
    assertEquals(3, game.rounds().size());
    assertEquals(new Round(4, 0, 3), game.rounds().get(0));
    assertEquals(new Round(1, 2, 6), game.rounds().get(1));
    assertEquals(new Round(0, 2, 0), game.rounds().get(2));
  }

  @Test
  public void example_3() {
    var input = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";

    var game = gameParser.parseGame(input);

    assertEquals(3L, game.number());
    assertEquals(3, game.rounds().size());
    assertEquals(new Round(20, 8, 6), game.rounds().get(0));
    assertEquals(new Round(4, 13, 5), game.rounds().get(1));
    assertEquals(new Round(1, 5, 0), game.rounds().get(2));
  }

  @Test
  public void totalExamples() {
    var inputLines = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";

    var possibleRound = new Round(12, 13, 14);

    var result = inputLines.lines()
        .map(gameParser::parseGame)
        .filter(game -> game.rounds().stream().noneMatch(round -> round.hasOneColorGreater(possibleRound)))
        .map(Game::number)
        .reduce(0L, Long::sum);

    assertEquals(8L, result);
  }

  @Test
  public void result() throws IOException {
    List<String> inputLines = FileHelper.readAllLines("classpath:day2/input");

    var possibleRound = new Round(12, 13, 14);

    var result = inputLines.stream()
        .map(gameParser::parseGame)
        .filter(game -> game.rounds().stream().noneMatch(round -> round.hasOneColorGreater(possibleRound)))
        .map(Game::number)
        .reduce(0L, Long::sum);

    assertEquals(2317, result);
  }

}
