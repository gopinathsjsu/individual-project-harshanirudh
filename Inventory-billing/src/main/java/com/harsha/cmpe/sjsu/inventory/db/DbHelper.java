package com.harsha.cmpe.sjsu.inventory.db;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.harsha.cmpe.sjsu.inventory.files.FileHandler;
import com.harsha.cmpe.sjsu.inventory.models.Items;

/**
 * To load database with intial values
 * @author harsha
 *
 */
public class DbHelper {
	private FileHandler fp=null;
	private Database db=null;
	public DbHelper() {
		fp=new FileHandler();
		db=Database.getInstance();
	}
	public  void intializeDatabase(String location1,String location2) throws IOException {
		List<String> items=fp.readFile(location1);
		List<String> cards=fp.readFile(location2);
		Map<String, Items> itemsMap = db.getItemsTable();
		for(int i=1;i<items.size();i++) {
			String[] data=items.get(i).split(",");
			itemsMap.put(data[0].toUpperCase(), 
					new Items(data[1].toUpperCase(),data[0].toUpperCase(),Integer.parseInt(data[2]),Double.parseDouble(data[3])));
		}
		for(int i=1;i<cards.size();i++) {
			String[] data=cards.get(i).split(",");
			db.getCards().add(data[0]);
		}
		
	}
	
}
