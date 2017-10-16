import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SorterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SorterTest {
    /**
     * Default constructor for test class SorterTest
     */
    public SorterTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }
    
    @Test
    public void test() {
        System.out.println();
        Sorter sorter = new Sorter();
        List<String> inputArray = new ArrayList<String>();
        Random gen = new Random();
        for(int i = 0; i < 10; i++) {
            inputArray.add(Integer.toString(gen.nextInt(10)));
        }
        System.out.println("inputArray: " + inputArray);
        List<String> outputArray = sorter.quicksort(inputArray);
        System.out.println("outputArray: " + outputArray);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
}
