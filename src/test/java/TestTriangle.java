import it.unimi.di.vec.ass1.TriangleImpl;
import static org.assertj.core.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

//@ExtendWith(OddTest.class)
public class TestTriangle {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    InputStream backupInputStream = System.in;

    @BeforeEach
    public void initialConfiguration() {
        System.setOut(new PrintStream(outputStream));
    }


    @ExtendWith(MethodDescriptionExt.class)
    @ParameterizedTest
    @ValueSource(strings = {"3 5 5",
            "3 5 3",
            "3 3 5"
    })
    public void isIsosceles(String value){
        TriangleImpl tri = createTriangle(value);
        tri.describe();
        assertThat(outputStream.toString()).as(value).isEqualTo("isosceles");
    }

    @Rule public InfoAboutTest iat = new InfoAboutTest();
    @Tag("TestTagged")
    @Test
    public void isScalene(){
        TriangleImpl tri = createTriangle("3 5 4");
        tri.describe();
        assertThat(outputStream.toString()).isEqualTo("scalene");
    }

    @Tag("TestTagged")
    @Test
    public void isEquilateral(){
        TriangleImpl tri = createTriangle("5 5 5");
        tri.describe();
        assertThat(outputStream.toString()).isEqualTo("equilateral");
    }

    @AfterEach
    public void resetSystemIn(){
        System.setIn(backupInputStream);
    }

    private void setInputNumber(String number) {
        InputStream is = new ByteArrayInputStream(number.getBytes());
        System.setIn(is);
    }


    private TriangleImpl createTriangle(String s) {
        setInputNumber(s);
        return new TriangleImpl();
    }

}
