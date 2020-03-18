import it.unimi.di.vec.ass1.TriangleImpl;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

public class testTriangle{
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    InputStream backupInputStream = System.in;

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void createObject(){
        setInputNumber("8 5 5");
        TriangleImpl tri = new TriangleImpl();
        assertNotNull(tri);
    }


    @Test
    public void inputNotNumber() {
        setInputNumber("5 5 R");
        try {
            new TriangleImpl();
            fail("Test must be fail with error " + InputMismatchException.class);
        } catch (InputMismatchException ime) {
            ime.getMessage();
        }
    }

    @Test
    public void inputNotInteger() {
        setInputNumber("5 6,3 4");
        try {
            new TriangleImpl();
            fail("Test must be fail with error " + InputMismatchException.class);
        } catch (InputMismatchException ime) {
            ime.getMessage();
        }
    }

    @Test
    public void inputNotNegative() {
        setInputNumber("-9 7 10");
        try {
            new TriangleImpl();
            fail("Test must fail with exception " + IllegalArgumentException.class);
        } catch (IllegalArgumentException ime) {
            assertEquals(ime.getMessage(), "Number must be positive");
        }
    }

    @Test
    public void invalidInputNumber() {
        setInputNumber("1 1 6");
        try {
            new TriangleImpl();
            fail("Test must be fail with exception " + IllegalArgumentException.class);
        } catch (IllegalArgumentException ime) {
            assertEquals(ime.getMessage(), "Number of sides cannot create triangle");
        }
    }


    @Test
    public void isScalene(){
        setInputNumber("3 5 4");
        TriangleImpl tri = new TriangleImpl();
        tri.describe();
        assertEquals("scalene", outputStream.toString());
    }

    @Test
    public void isIsosceles(){
        setInputNumber("3 5 5");
        TriangleImpl tri = new TriangleImpl();
        tri.describe();
        assertEquals("isosceles", outputStream.toString());
    }

    @Test
    public void isEquilateral(){
        setInputNumber("5 5 5");
        TriangleImpl tri = new TriangleImpl();
        tri.describe();
        assertEquals("equilateral", outputStream.toString());
    }

    @AfterEach
    public void resetSystemIn(){
        System.setIn(backupInputStream);
    }

    private void setInputNumber(String number) {
        InputStream is = new ByteArrayInputStream(number.getBytes());
        System.setIn(is);
    }

}
