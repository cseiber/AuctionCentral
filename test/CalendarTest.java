/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Auction;
import model.Calendar;
import model.NPO;

/**
 * @author Carl
 *
 */
public class CalendarTest {

	Calendar myCalendar;
	NPO a;
	NPO b;
	NPO c;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myCalendar = new Calendar();
		a = new NPO("NPOa", "a");
		b = new NPO("NPOb", "b");
		c = new NPO("NPOc", "c");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Calendar#Calendar()}.
	 */
	@Test
	public void testCalendar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Calendar#addAuction(model.Auction)}.
	 */
	@Test
	public void testAddAuction() {
		Auction theAuction = new Auction(a, 3);
		
		//expected the size of auction list = 0
		// and the NPO hasAuction() = FALSE
		assertEquals(0, myCalendar.getAuctions().size(), 0.0);
		assertFalse(theAuction.getNPO().hasAuction());
		
		myCalendar.addAuction(theAuction);
		// expected the size of auction list = 1 (after add)
		// NPO hasAuction() = TRUE
		// Note*: change the expected value in assertEquals method to experience the Unit test
		assertEquals(1, myCalendar.getAuctions().size(), 0.0);	
		assertTrue(theAuction.getNPO().hasAuction());
	}

	/**
	 * Test method for {@link model.Calendar#getAuctions(java.util.Date)}.
	 */
	@Test
	public void testGetAuctions() {
		
		ArrayList<Auction> ary = new ArrayList<Auction>();
		Auction theAuction = new Auction(a, 3);
		ary.add(theAuction);
		Auction theNextAuction = new Auction(b, 3);
		ary.add(theNextAuction);
		Auction theLastAuction = new Auction(c, 3);
		ary.add(theLastAuction);
		
		Collection<Auction> control = ary;
		
		myCalendar.addAuction(theAuction);
		myCalendar.addAuction(theNextAuction);
		myCalendar.addAuction(theLastAuction);
		
		Collection<Auction> auctions = myCalendar.getAuctions();
		
		assertNotNull(auctions);
		assertEquals(auctions.size(), control.size());
		assertTrue(auctions.containsAll(control));
		assertTrue(control.containsAll(auctions));
		
	}

	/**
	 * Test method for {@link model.Calendar#deleteAuction(java.lang.String)}.
	 */
	@Test
	public void testDeleteAuction() {
		Auction theAuction = new Auction(a, 3);
		Auction theNextAuction = new Auction(b, 3);
		myCalendar.addAuction(theAuction);
		myCalendar.addAuction(theNextAuction);
		
		assertNotNull(myCalendar.getAuctions());
		assertEquals(2, myCalendar.getAuctions().size());
		
		assertTrue(myCalendar.deleteAuction("a"));
		assertFalse(myCalendar.deleteAuction("a"));
		
		assertEquals(1, myCalendar.getAuctions().size());
		
		assertTrue(myCalendar.deleteAuction("b"));
		assertFalse(myCalendar.deleteAuction("b"));
		
		assertEquals(0, myCalendar.getAuctions().size());
		
	}

/*	*//**
	 * Test method for {@link model.Calendar#hasAuction(java.lang.String)}.
	 *//*
	@Test
	public void testHasAuction() {
		
		fail("Not yet implemented");
	}*/

/*	*//**
	 * Test method for {@link model.Calendar#main(java.lang.String[])}.
	 *//*
	@Test
	public void testMain() {
		fail("Not yet implemented");
	}*/

}
