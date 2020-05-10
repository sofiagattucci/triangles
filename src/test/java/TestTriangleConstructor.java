import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import it.unimi.di.vec.ass1.TriangleImpl;
import it.unimi.di.vec.extensions.OddExecExtension;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(OddExecExtension.class)
public class TestTriangleConstructor {

  @Tag("TestTagged")
  @ParameterizedTest
  @ValueSource(strings = {"5 3 5", "7 8 2", "3 3 3"})
  public void createObject(String value) {
    setInputNumber(value);
    TriangleImpl tri = new TriangleImpl();
    assertNotNull(tri);
  }

  @ParameterizedTest
  @ValueSource(strings = {"3 9 A", "B 9 2", "3 C 2"})
  public void inputNotNumber(String value) {
    setInputNumber(value);
    assertThatThrownBy(TriangleImpl::new).isInstanceOf(InputMismatchException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"2 5 4.3", "1.1 5 2", "3 7.9 5"})
  public void inputNotInteger(String value) {
    setInputNumber(value);
    assertThatThrownBy(TriangleImpl::new).isInstanceOf(InputMismatchException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"2 5 -5", "-3 5 2", "3 -2 5"})
  public void inputNotNegative(String value) {
    setInputNumber(value);
    assertThatThrownBy(TriangleImpl::new)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Number must be positive");
  }

  @ParameterizedTest
  @ValueSource(strings = {"1 1 6", "5 2 1", "5 8 2"})
  public void invalidInputNumber(String value) {
    setInputNumber(value);
    assertThatThrownBy(TriangleImpl::new)
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Number of sides cannot create triangle");
  }

  private void setInputNumber(String number) {
    InputStream is = new ByteArrayInputStream(number.getBytes());
    System.setIn(is);
  }
}
