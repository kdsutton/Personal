

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PalindromeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PalindromeTest
{
    /**
     * Default constructor for test class PalindromeTest
     */
    public PalindromeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void palindromeTest() {
        Palindrome palindrome = new Palindrome("racecar");
        assertTrue(palindrome.isPalindrome());
        palindrome.setPalindrome("race car");
        assertTrue(palindrome.isPalindrome());
        palindrome.setPalindrome("race, car!");
        assertTrue(palindrome.isPalindrome());
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
