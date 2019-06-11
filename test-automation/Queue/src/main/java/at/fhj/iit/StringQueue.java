package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// there's some Bugs included, try to debug the code and fix the Bugs
// there are different Bugs, wrong implementation, typos, ...
// write Test-Cases (read Queue Interface for understanding methods) and use Debugging possibilies of your IDE

public class StringQueue implements Queue {

	private List<String> elements = new ArrayList<String>();
	private int maxSize;

	public StringQueue(int maxSize){
		this.maxSize = maxSize;
	}

	/**
	 * @param obj Adds the element to the queue.
	 * @return If the addition is successful, the method returns true else false.
	 */
	@Override
	public boolean offer(String obj) {
		if(elements.size() < maxSize)
			elements.add(obj);
		else
			return false;

		return true;
	}

	/**
	 * @return Returns the head (first) element and also deletes it, if the queue is empty it returns null
	 */
	@Override
	public String poll() {
		String element;
		if(elements.size() > 0){
			element = elements.get(0);
			elements.remove(0);
		} else
			element = null;


		return element;
	}

	/**
	 * @return extension to poll(), throws NoSuchElementException if the queue is empty
	 */
	@Override
	public String remove() {
		String element = poll();

		if(element == null)
			throw new NoSuchElementException("there's no element any more");
		return element;
	}

	/**
	 * @return Returns the head element or null if the queue is empty.
	 */
	@Override
	public String peek() {
		String element;
		if(elements.size() > 0)
			element = elements.get(0);
		else
			element = null;

		return element;
	}

	/**
	 * @return extension to peek(), throws NoSuchElementException when the queue is empty.
	 */
	@Override
	public String element() {
		String element = peek();
		if(element == null)
			throw new NoSuchElementException("there's no element any more");

		return element;
	}

}