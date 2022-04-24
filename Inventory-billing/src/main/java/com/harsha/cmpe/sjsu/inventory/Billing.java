package com.harsha.cmpe.sjsu.inventory;

import java.io.IOException;
import java.util.List;

import com.harsha.cmpe.sjsu.inventory.db.Database;
import com.harsha.cmpe.sjsu.inventory.db.DbHelper;
import com.harsha.cmpe.sjsu.inventory.files.InputReader;
import com.harsha.cmpe.sjsu.inventory.models.Items;

public class Billing {

	public static void main(String[] args) {
		if(args.length<3) {
			System.out.println("Provide input file location");
			System.exit(-1);
		}
		triggeBilling(args);
	}

	private static void triggeBilling(String[] args) {
		DbHelper dbhelper=new DbHelper();
		try {
			//Intialize the db
			dbhelper.intializeDatabase(args[0],args[1]);
//			System.out.println(Database.getInstance().getItemsTable());
			//Read input file
			InputReader reader=new InputReader(args[2]);
			List<Items>input=reader.getItems();
			
			//Intialize the handler chain
			AbstractOrderHandler itemPresence=new CheckItemPresenceHandler();
			AbstractOrderHandler checkMaxLimit=new CheckMaxLimitOrderHandler();
			AbstractOrderHandler validateOrder=new ValidateOrderHandler();
			AbstractOrderHandler processOrder=new PrcoessOrderHandler();
			itemPresence.nextHandler(checkMaxLimit);
			checkMaxLimit.nextHandler(validateOrder);
			validateOrder.nextHandler(processOrder);
			
			itemPresence.handle(input);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
