package it.unimi.di.vec.extensions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(OddExecExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestOddExecExtension {
  private static final boolean[] executed = new boolean[8];

  @BeforeEach
  void setUp(TestInfo info) {
    int i = Integer.parseInt(info.getDisplayName());
    executed[i] = true;
  }

  @Test
  @DisplayName("4")
  @Order(2)
  void test4() {
    fail("test4 not skipped");
  }

  @Test
  @DisplayName("5")
  @Order(3)
  void test5() {}

  @Test
  @DisplayName("6")
  @Order(4)
  void test6() {
    fail("test6 not skipped");
  }

  @Test
  @DisplayName("7")
  @Order(5)
  void test7() {}

  @ParameterizedTest(name = "{arguments}")
  @DisplayName("Parametric")
  @Order(1)
  @ValueSource(strings = {"1", "2", "3"})
  void testParam(String num) {
    if (Integer.parseInt(num) % 2 == 0) fail("test" + num + " not skipped");
  }

  @AfterAll
  static void finalAssertion() {
    assertThat(executed).containsSequence(false, true, false, true, false, true, false, true);
  }
}
