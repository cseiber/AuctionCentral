/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.NPO;

/**
 * @author Carl
 *
 */
public class NPOTest {

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
	 * Test method for {@link model.NPO#isValidAuctionDate(java.time.LocalDateTime)}.
	 */
	@Test
	public void testisValidAuctionDateOnDateGreaterThanOneYear() {
		NPO theNPO = new NPO("theNPO", "NPO");
		theNPO.setLastAuctionDate(LocalDateTime.of(2015, 7, 30, 18, 0));
		assertTrue(theNPO.isValidAuctionDate(LocalDateTime.now().plusMonths(1)));
	}
	
	/**
	 * Test method for {@link model.NPO#isValidAuctionDate(java.time.LocalDateTime)}.
	 */
	@Test
	public void testisValidAuctionDateOnDateLessThanOneYear() {
		NPO theNPO = new NPO("theNPO", "NPO");
		theNPO.setLastAuctionDate(LocalDateTime.of(2015, 12, 30, 18, 0));
		assertFalse(theNPO.isValidAuctionDate(LocalDateTime.now()));
	}
	
	/**
	 * Test method for {@link model.NPO#isValidAuctionDate(java.time.LocalDateTime)}.
	 */
	@Test
	public void testisValidAuctionDateOnDateLessThanOneMonthInFuture() {
		NPO theNPO = new NPO("theNPO", "NPO");
		theNPO.setLastAuctionDate(LocalDateTime.of(2010, 12, 30, 18, 0));
		assertTrue(theNPO.isValidAuctionDate(LocalDateTime.now().plusDays(15)));
	}
	
	/**
	 * Test method for {@link model.NPO#isValidAuctionDate(java.time.LocalDateTime)}.
	 */
	@Test
	public void testisValidAuctionDateOnDateExactlyOneMonthInFuture() {
		NPO theNPO = new NPO("theNPO", "NPO");
		theNPO.setLastAuctionDate(LocalDateTime.of(2010, 12, 30, 18, 0));
		assertTrue(theNPO.isValidAuctionDate(LocalDateTime.now().plusMonths(1)));
	}
	
	/**
	 * Test method for {@link model.NPO#isValidAuctionDate(java.time.LocalDateTime)}.
	 */
	@Test
	public void testisValidAuctionDateOnDateMoreThanOneMonthInFuture() {
		NPO theNPO = new NPO("theNPO", "NPO");
		theNPO.setLastAuctionDate(LocalDateTime.of(2010, 12, 30, 18, 0));
		assertFalse(theNPO.isValidAuctionDate(LocalDateTime.now().plusMonths(1).plusDays(1)));
	}
	
	/**
	 * Test method for {@link model.NPO#isValidAuctionDate(java.time.LocalDateTime)}.
	 */
	@Test
	public void testisValidAuctionDateOnDateLessThantOneWeekInFuture() {
		NPO theNPO = new NPO("theNPO", "NPO");
		theNPO.setLastAuctionDate(LocalDateTime.of(2010, 12, 30, 18, 0));
		assertFalse(theNPO.isValidAuctionDate(LocalDateTime.now().plusDays(3)));
	}
	
	/**
	 * Test method for {@link model.NPO#isValidAuctionDate(java.time.LocalDateTime)}.
	 */
	@Test
	public void testisValidAuctionDateOnDateInThePast() {
		NPO theNPO = new NPO("theNPO", "NPO");
		theNPO.setLastAuctionDate(LocalDateTime.of(2010, 12, 30, 18, 0));
		assertFalse(theNPO.isValidAuctionDate(LocalDateTime.now().minusDays(15)));
	}

}
