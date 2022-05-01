package com.harsha.cmpe.sjsu.inventory.files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.harsha.cmpe.sjsu.inventory.db.Database;
import com.harsha.cmpe.sjsu.inventory.models.InputItems;
import com.harsha.cmpe.sjsu.inventory.models.Items;

public class InputReader {
	private String path;
	private FileHandler filehelper;
	private Database db;
	public InputReader(String path) {
		this.path=path;
		this.filehelper=new FileHandler();
		this.db=Database.getInstance();
	}
	public List<Items> getItems() throws IOException{
		List<Items> result=new ArrayList<>();
		List<String>content=filehelper.readFile(path);
		
		for(int i=1;i<content.size();i++) {
			String[] items=content.get(i).split(",");
			if(db.getItemsTable().containsKey(items[0].toUpperCase()) ) {
				Items matchedItem=db.getItemsTable().get(items[0].toUpperCase());
				String category=matchedItem.getCategory();
				String itemName=matchedItem.getItem();
				Double price=matchedItem.getPrice();
				Items Item=new InputItems(category, itemName, Integer.parseInt(items[1]), price,items.length<3?null:items[2].trim());
				result.add(Item);
			}else {
				Items item=new InputItems(null, items[0].toUpperCase(), Integer.parseInt(items[1]), 0, null);
				result.add(item);
			}
			
		}
		System.out.println(result);
		return result;
	}
}
