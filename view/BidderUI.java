package view;

import java.util.Collection;

import model.Bid;
import model.Bidder;

public class BidderUI {
	
	BidderUI()
	{
		
	}

	
	public void viewallBids(Bidder theBidder)
	{
		Collection<Bid> bids = theBidder.getMyBids();
		System.out.println("--------------------------------------------------");
		System.out.println("Bidder: " + theBidder.getMyName());
		System.out.println("Current Bids");
		System.out.println("");
		System.out.println("");
		for (Bid b : bids)
		{
			String auction = 
			System.out.println();
		}
		System.out.println("--------------------------------------------------");
	}
}
