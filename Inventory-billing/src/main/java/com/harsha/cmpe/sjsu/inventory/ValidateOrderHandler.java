package com.harsha.cmpe.sjsu.inventory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.harsha.cmpe.sjsu.inventory.db.Database;
import com.harsha.cmpe.sjsu.inventory.files.OutputFile;
import com.harsha.cmpe.sjsu.inventory.files.OutputFileFactory;
import com.harsha.cmpe.sjsu.inventory.models.Items;

public class ValidateOrderHandler implements AbstractOrderHandler {
	private AbstractOrderHandler next;
	private StringBuilder messageInCorrect=new StringBuilder();
	private boolean flag;
	@Override
	public void handle(List<Items> input) {
		System.out.println("Processign request in Validate Order ");
		Database db=Database.getInstance();
		for(Items item:input) {
			//when inventory quantity is less
			messageInCorrect.append("Please Check the Quantities of the following\n");
			if(db.getItemsTable().get(item.getItem()).getQuantity()<item.getQuantity()) {
				flag=true;
				messageInCorrect.append(item.getItem()+":("+item.getQuantity()+")\n");
			}
		}
		if(!flag) {
			System.out.println("Passing request to next handler");
			next.handle(input);
		}else {
			OutputFileFactory fileFactory=new OutputFileFactory();
			OutputFile errFile = fileFactory.getOutputFile("EROOR");
			try {
				errFile.writeToFile(Arrays.asList(messageInCorrect.toString()));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void nextHandler(AbstractOrderHandler next) {
		// TODO Auto-generated method stub
		this.next=next;
	}

}
