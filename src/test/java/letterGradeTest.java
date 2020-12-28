import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class letterGradeTest
{
    @Test
    public void gradeTest()
    {
        assertEquals('A', letterGrade.letterGrade(100));
        assertEquals('A', letterGrade.letterGrade(90));

        assertEquals('B', letterGrade.letterGrade(89));
        assertEquals('B', letterGrade.letterGrade(80));

        assertEquals('C', letterGrade.letterGrade(79));
        assertEquals('C', letterGrade.letterGrade(70));

        assertEquals('D', letterGrade.letterGrade(69));
        assertEquals('D', letterGrade.letterGrade(60));

        assertEquals('F', letterGrade.letterGrade(59));
        assertEquals('F', letterGrade.letterGrade(0));

        assertEquals('X', letterGrade.letterGrade(101));
        assertEquals('X', letterGrade.letterGrade(-1));
    }

    @Test
    public void testMain() throws IOException {
        String[] args = null;
        final InputStream original = System.in;
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("100".getBytes());
        System.setIn(byteArrayInputStream);
        letterGrade.main(args);

        System.setIn(original);
    }

    @Test
    public void testMainNumberFormatException() throws IOException {
        String[] args = null;
        final InputStream original = System.in;
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("test".getBytes());
        System.setIn(byteArrayInputStream);
        letterGrade.main(args);
        System.setIn(original);
    }

    @Test
    public void testMainIOException() throws IOException {
        String[] args = null;
        final InputStream original = System.in;
        System.setIn(new InputStream() {
            @Override
            public int read() throws IOException {
                throw new IOException();
            }
        });
        letterGrade.main(args);
        System.setIn(original);
    }
}
