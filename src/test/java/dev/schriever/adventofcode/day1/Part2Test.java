package dev.schriever.adventofcode.day1;

import dev.schriever.adventofcode.helper.FileHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Day1")
public class Part2Test {
  private TrebuchetAnalyzer trebuchetAnalyzer;

  @BeforeEach
  public void setup() {
    DigitFinderStrategy compositeDigitFinderStrategy = new CompositeDigitFinderStrategy(
        List.of(new NaturalDigitFinderStrategy(), new LetterDigitFinderStrategy())
    );
    trebuchetAnalyzer = new TrebuchetAnalyzer(compositeDigitFinderStrategy);
  }

  @ParameterizedTest
  @CsvSource({
      "29,two1nine",
      "83,eightwothree",
      "13,abcone2threexyz",
      "24,xtwone3four",
      "42,4nineeightseven2",
      "14,zoneight234",
      "76,7pqrstsixteen"
  })
  public void examples(String expected, String inputLine) {
    assertEquals(expected, trebuchetAnalyzer.parseCalibrationValue(inputLine));
  }

  @Test
  public void result() throws IOException {
    List<String> inputLines = FileHelper.readAllLines("classpath:day1/input");
    List<String> calibrationValues = new ArrayList<>();

    for (String inputLine : inputLines) {
      String calibrationValue = trebuchetAnalyzer.parseCalibrationValue(inputLine);
      calibrationValues.add(calibrationValue);
    }
    Long sum = calibrationValues.stream().map(Long::valueOf).reduce(0L, Long::sum);

    assertEquals(54504, sum);
  }

}
