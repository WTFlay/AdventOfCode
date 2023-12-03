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
public class Part1Test {

  private TrebuchetAnalyzer trebuchetAnalyzer;

  @BeforeEach
  public void setup() {
    trebuchetAnalyzer = new TrebuchetAnalyzer(new NaturalDigitFinderStrategy());
  }

  @ParameterizedTest
  @CsvSource({
      "12,1abc2",
      "38,pqr3stu8vwx",
      "15,a1b2c3d4e5f",
      "77,treb7uchet",
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

    assertEquals(54597, sum);
  }
}
