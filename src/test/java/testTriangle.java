import it.unimi.di.vec.ass1.TriangleImpl;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class testTriangle{
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    int lato1 = 10;
    int lato2 = 9;
    int lato3 = 8;

    @Before
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void createObject(){
        TriangleImpl tri = new TriangleImpl(lato1, lato2, lato3);
        assertNotNull(tri);
    }

    @Test
    public void isScaleno(){
        TriangleImpl tri = new TriangleImpl(lato1, lato2, lato3);
        tri.describe();
        assertEquals("scaleno", outputStream.toString());
    }

    @Test
    public void isIsoscele(){
        TriangleImpl tri = new TriangleImpl(lato1, lato1, lato3);
        tri.describe();
        assertEquals("isoscele", outputStream.toString());
    }

    @Test
    public void isEquilatero(){
        TriangleImpl tri = new TriangleImpl(lato1, lato1, lato1);
        tri.describe();
        assertEquals("equilatero", outputStream.toString());
    }

}
