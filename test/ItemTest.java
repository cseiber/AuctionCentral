/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Item;

/**
 * @author Carl
 *
 */
public class ItemTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Item#Item(java.lang.String)}.
	 */
	@Test
	public void testItem() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Item#getItemName()}.
	 */
	@Test
	public void testGetItemName() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link model.Item#isValidBid(java.lang.Integer)}.
	 */
	@Test
	public void testIsValidBid() {
		Item theItem = new Item("Banana", 15);
		
		assertTrue(theItem.isValidBid(15));
		assertTrue(theItem.isValidBid(16));
		assertTrue(theItem.isValidBid(30));
		assertFalse(theItem.isValidBid(14));
		assertFalse(theItem.isValidBid(10));
		assertFalse(theItem.isValidBid(-5));
	}
	

}
