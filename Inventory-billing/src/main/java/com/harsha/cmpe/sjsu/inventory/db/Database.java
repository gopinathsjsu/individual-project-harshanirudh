package com.harsha.cmpe.sjsu.inventory.db;
/**
 * Database to simulate an actual in memory database,
 *  which is not persisted on disk using singelton pattern
 * @author harsha
 *
 */
public class Database {

	private static Database singeltonInstance=null;
	private Database() {
		System.out.println("Db Instance Created");
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
   


}
