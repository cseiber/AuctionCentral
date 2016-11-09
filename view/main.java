/**
 * 
 */
package view;


import java.util.ArrayList;

import model.Auction;
import model.AuctionDate;
import model.Calendar;
import model.Item;
import model.NPO;

/**
 * @author phuc tran
 *
 */
public class main {
	
	private static Calendar myCalendar;
	
	private static NPO Aaron;
	private static NPO Carl;
	private static NPO Jesse;
	private static NPO Patrick;
	private static NPO Tran;
	
	private static Auction aucAaron;
	private static Auction aucCarl;
	private static Auction aucPatrick;
	private static Auction aucJesse;
	private static Auction aucTran;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		viewCalendar();
		//printDate();

	}
	
	public static void setup(){
		myCalendar = new Calendar();
		
		Aaron = new NPO("AaronG", "Aaron");
		Carl = new NPO("CarlS", "Carl");
		Patrick = new NPO("Patrick_2016", "Patrick");
		Jesse = new NPO("Jesse_TCSS360", "Jesse");
		Tran = new NPO("PhucT", "PhucTran");
		
		aucAaron = new Auction(Aaron, 2016, 11, 8, 15, 30);
		aucCarl = new Auction(Carl, 2016, 11, 3, 10, 30);
		aucPatrick = new Auction(Patrick, 2016, 11, 12, 17, 00);
		aucJesse = new Auction(Jesse, 2016, 11, 2, 11, 30);
		aucTran = new Auction(Tran, 2016, 11, 1, 9, 45);

		aucAaron.addItem(new Item("chocolate"));
		aucAaron.addItem(new Item("candy"));
		aucAaron.addItem(new Item("donut"));
		
		aucCarl.addItem(new Item("car"));
		aucCarl.addItem(new Item("truck"));
		
		aucPatrick.addItem(new Item("iphone7"));
		aucPatrick.addItem(new Item("SS s7 edge"));
		aucPatrick.addItem(new Item("HTC One 10"));
		
		aucJesse.addItem(new Item( "banana") );
		aucJesse.addItem(new Item( "apple") );
		aucJesse.addItem(new Item( "orange") );
		
		aucTran.addItem(new Item("I-MAC pro"));
		
		
		myCalendar.addAuction(aucAaron);
		myCalendar.addAuction(aucCarl);
		myCalendar.addAuction(aucPatrick);
		myCalendar.addAuction(aucJesse);
		myCalendar.addAuction(aucTran);
		
	}
	
	public static void printDate(){
		Item myItem1 = new Item("Banana", "Good", "Small", 15);
		Item myItem2 = new Item("Banana", "Good", "Small", 15);
		Item myItem3 = new Item("Bandadsadas", "Good", "Small", 15);
		System.out.println(myItem1.isEqual(myItem2));
		System.out.println(myItem1.isEqual(myItem3));
	}
	
	
	public static void viewCalendar(){
		setup();
		AuctionDate date = new AuctionDate(2016,11,3);
		ArrayList<Auction> printList = (ArrayList<Auction>) myCalendar.getAuctionsAfterThisDate(date);
		for(Auction a : printList){
			System.out.println("--------------------");
			System.out.println(a.toString());
		}
	}

}
