package view;

import java.util.Collection;

import model.Bid;
import model.Bidder;

public class BidderUI {
	
	static Bidder currentBidder;
	
	BidderUI()
	{
		
		
	}
	
	public static void welcomeScreen(Bidder bidder){
		
		currentBidder = bidder;
		System.out.println("Welcome "+ currentBidder.getMyName());
		System.out.println("in bidder ui");
	}

}
