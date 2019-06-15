package at.fhj.iit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Test class of the StringQueue class
 * tests all methods
 */
public class StringQueueTest {
    private StringQueue q;

    @Before
    public void setUp(){
        q = new StringQueue(5);
    }

    /**
     * check if objects are added to the list
     */
    @Test
    public void testOffer(){
        boolean var = q.offer("hallo");
        assertTrue(var);
    }

    /**
     * this test tries to add 6 elements although the maxsize
     * of the queue is 5. The last addition should fail and
     * after the loop the test checks if var is false
     */
    @Test
    public void testMaxSize(){
        boolean var = true;
        for(int i=0; i<=5; i++) {
            var = q.offer("hallo");

        }
        assertFalse(var);
    }
    /**
     * tries to remove head (first) element of an empty queue
     * and checks if null gets returned
     */
    @Test
    public void testPollIfEmpty(){
       String element = q.poll();
       assertNull(element);
    }

    /**
     * adds an element to the queue, removes it and checks if it
     * is the same element
     */
    @Test
    public void testOfferPoll(){
        q.offer("hallo");
        String element = q.poll();
        assertTrue(element.contentEquals("hallo"));
    }
    /**
     *  test if remove method will throw NoSuchElementException if
     *  queue is empty
     */
    @Test(expected = NoSuchElementException.class)
    public void testRemoveIfEmpty(){
        q.remove();
    }

    /**
     * test if Remove method is returning the right element if not empty
     */
    @Test
    public void testOfferRemove(){
        q.offer("1");
        String element = q.remove();
        assertTrue(element.contentEquals("1"));
    }

    /**
     * use peek method on an empty queue and check if null
     * gets returned
     */
    @Test
    public void testPeekIfEmpty(){
        String element = q.peek();
        assertNull(element);
    }

    /**
     * test if peek returns the right value if it is not empty
     */
    @Test
    public void testOfferPeek(){
        q.offer("hallo");
        q.offer("2");
        String element = q.peek();
        assertTrue(element.contentEquals("hallo"));
    }

    /**
     * tests if the method element returns the right value
     */
    @Test
    public void testOfferElement(){
        q.offer("element");
        q.offer("2");
        String element = q.element();
        assertTrue(element.contentEquals("element"));
    }

    /**
     * test if exception gets thrown if you use the
     * method element on an empty queue
     */
    @Test(expected = NoSuchElementException.class)
    public void testElementIfEmpty(){
        q.element();
    }

    @After
    public void tearDown() {
        q = null;
    }
}