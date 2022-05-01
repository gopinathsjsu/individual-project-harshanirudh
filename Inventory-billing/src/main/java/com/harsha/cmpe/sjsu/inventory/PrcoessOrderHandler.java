package com.harsha.cmpe.sjsu.inventory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.harsha.cmpe.sjsu.inventory.db.Database;
import com.harsha.cmpe.sjsu.inventory.files.OutputFileFactory;
import com.harsha.cmpe.sjsu.inventory.models.InputItems;
import com.harsha.cmpe.sjsu.inventory.models.Items;

public class PrcoessOrderHandler implements AbstractOrderHandler{
	private AbstractOrderHandler next;
	@Override
	public void nextHandler(AbstractOrderHandler next) {
		// TODO Auto-generated method stub
		this.next=next;
	}

	@Override
	public void handle(List<Items> input) {
		// TODO Auto-generated method stub
		System.out.println("Processign request in Proceess order ");
		Database db=Database.getInstance();
		List<String> content=new ArrayList<>();
		double total = 0;
		content.add("Item,Quantity,Price\n");
		System.out.println("Before adding cards to DB\n"+db.getCards());
		for(Items item:input) {
			total+=db.getItemsTable().get(item.getItem()).getPrice()*item.getQuantity();
			int intialInventory=db.getItemsTable().get(item.getItem()).getQuantity();
			db.getItemsTable().get(item.getItem()).setQuantity(intialInventory-item.getQuantity());;
			//Add cards to cardset
			
			String cardValue=((InputItems)item).getCardNumber();
			if(cardValue!=null)
				db.getCards().add(cardValue);
			StringBuilder line=new StringBuilder();
			line.append(item.getItem()).append(",")
			.append(item.getQuantity()).append(",").append(item.getPrice())
			.append("\n");
			content.add(line.toString());
		}
		System.out.println("After adding cards to db\n"+db.getCards());
		content.add("Totoal Amount \n");
		content.add(String.valueOf(total));
		OutputFileFactory fileFactory=new OutputFileFactory();
		try {
			fileFactory.getOutputFile("OUTPUT").writeToFile(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
