package com.harsha.cmpe.sjsu.inventory.db;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Database to simulate an actual in memory database,
 *  which is not persisted on disk using singelton pattern
 * @author harsha
 *
 */
import com.harsha.cmpe.sjsu.inventory.models.Items;
public class Database {

	private static Database singeltonInstance=null;
	private  Map<String,Items> itemsTable=null;
	private  Set<String> cards= null;
	private Database() {
		System.out.println("Db Instance Created");
		itemsTable=new HashMap<>();
		cards= new HashSet<>();
	}
	/**
	 * Static function to get the database instance
	 * @return
	 */
	
	public static Database getInstance() {
		if(singeltonInstance==null)
			singeltonInstance=new Database();
		return singeltonInstance;
	}
	public Map<String, Items> getItemsTable() {
		return itemsTable;
	}
	public void setItemsTable(Map<String, Items> itemsTable) {
		this.itemsTable = itemsTable;
	}
	public Set<String> getCards() {
		return cards;
	}
	public void setCards(Set<String> cards) {
		this.cards = cards;
	}
	
   


}
