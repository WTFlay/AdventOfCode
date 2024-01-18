package dev.schriever.adventofcode.year2015.day1;

import dev.schriever.adventofcode.helper.FileHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FloorNavigationServiceTest {

  private FloorNavigationService service;

  @BeforeEach
  void setup() {
    service = new FloorNavigationService();
  }

  @Test
  void should_return_floor_one_when_input_opening_parenthesis() {
    var floor = service.detectFloor("(");

    assertEquals(1, floor);
  }

  @Test
  void should_return_two_when_input_is_two_opening_parenthesis() {
    var floor = service.detectFloor("((");

    assertEquals(2, floor);
  }

  @Test
  void should_return_tree_when_input_is_tree_opening_parenthesis() {
    var floor = service.detectFloor("(((");

    assertEquals(3, floor);
  }

  @Test
  void should_return_minus_two_when_one_closing_parenthesis() {
    var floor = service.detectFloor(")");

    assertEquals(-1, floor);
  }

  @Test
  void should_return_minus_two_when_two_closing_parenthesis() {
    var floor = service.detectFloor("))");

    assertEquals(-2, floor);
  }

  @Test
  void examples() {
    assertEquals(0, service.detectFloor("(())"));
    assertEquals(0, service.detectFloor("()()"));
    assertEquals(3, service.detectFloor("((("));
    assertEquals(3, service.detectFloor("(()(()("));
    assertEquals(3, service.detectFloor("))((((("));
    assertEquals(-1, service.detectFloor("())"));
    assertEquals(-1, service.detectFloor("))("));
    assertEquals(-3, service.detectFloor(")))"));
    assertEquals(-3, service.detectFloor(")())())"));
  }

  @Test
  void result() throws IOException {
    String input = FileHelper.readAllLines("classpath:year2015/day1/input.txt").get(0);

    assertEquals(138, service.detectFloor(input));
  }

  @Test
  void detectBasementEntryPosition_examples() {
    assertEquals(1, service.detectBasementEntryPosition(")"));
    assertEquals(5, service.detectBasementEntryPosition("()())"));
  }

  @Test
  void detectBasementEntryPosition_result() throws IOException {
    String input = FileHelper.readAllLines("classpath:year2015/day1/input.txt").get(0);

    assertEquals(1771, service.detectBasementEntryPosition(input));
  }

}
