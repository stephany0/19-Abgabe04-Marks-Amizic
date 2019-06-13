package at.fhj.iit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class StringQueueTest {
    public StringQueue q;

    @Before
    public void setUp() throws Exception {
        q = new StringQueue(5);
    }

    /**
     * check if objects are added to the list
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception{
        boolean var = q.offer("hallo");
        assertTrue(var);
    }

    /**
     * When the maxSize is reached this test will return false.
     * In this case if maxSize is 5 any number above it will return false.
     * @throws Exception
     */
    @Test
    public void testOffer() throws Exception{
        boolean var = true;
        for(int i=0; i<=4; i++) {
            var = q.offer("hallo");

        }
        assertTrue(var);
    }
    /**
     * test returns true if element is null
     *
     * @throws Exception
     */
    @Test
    public void testPollIfEmpty() throws Exception{
       String element = q.poll();
       assertNull(element);
    }

    /**
     * test if the head element is returned
     * @throws Exception
     */
    @Test
    public void testPollIfDeleted() throws Exception{
        q.offer("hallo");
        String element = q.poll();
        assertTrue(element.contentEquals("hallo"));
    }
    /**
     *  test if remove method will throw NoSuchElementException
     * @throws Exception
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveIfEmpty() throws Exception{
        q.remove();
    }

    /**
     * test if Remove method is retuning the right element if not empty
     * @throws Exception
     */
    @Test
    public void testRemoveIfNotEmpty() throws Exception{
        q.offer("hallo");
        String element = q.remove();
        assertTrue(element.contentEquals("hallo"));
    }

    /**
     * test if Peek method is empty and returns null
     * @throws Exception
     */
    @Test
    public void testPeekIfEmpty() throws Exception{
        String element = q.peek();
        assertNull(element);
    }

    /**
     * test if peek returns the right value if it is not empty
     * @throws Exception
     */
    @Test
    public void testPeekIfNotEmpty() throws Exception{
        q.offer("hallo");
        String element = q.peek();
        assertTrue(element.contentEquals("hallo"));
    }

    /**
     * test if element method throws exception
     * @throws Exception
     */
    @Test(expected = NoSuchElementException.class)
    public void testElementIfEmpty() throws Exception{
        q.element();
    }
    @After
    public void tearDown() throws Exception {

    }
}