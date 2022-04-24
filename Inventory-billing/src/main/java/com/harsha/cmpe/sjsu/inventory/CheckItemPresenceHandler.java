package com.harsha.cmpe.sjsu.inventory;

import java.util.List;

import com.harsha.cmpe.sjsu.inventory.db.Database;
import com.harsha.cmpe.sjsu.inventory.models.Items;

public class CheckItemPresenceHandler implements AbstractOrderHandler {
	private AbstractOrderHandler next;
	private StringBuilder messageInCorrect=new StringBuilder();
	private boolean flag;
	@Override
	public void nextHandler(AbstractOrderHandler next) {
		// TODO Auto-generated method stub
		this.next=next;
	}

	@Override
	public void handle(List<Items> input) {
		System.out.println("Processing request in Item presence handler");
		Database db=Database.getInstance();
		for(Items item:input) {
			if(!db.getItemsTable().containsKey(item.getItem())) {
				messageInCorrect.append("Item not available in inventory\n");
				messageInCorrect.append(item.getItem());
				flag=true;
			}
				
		}
		if(!flag) {
			System.out.println("Passing request to next handler");
			next.handle(input);
		}
	}

}
