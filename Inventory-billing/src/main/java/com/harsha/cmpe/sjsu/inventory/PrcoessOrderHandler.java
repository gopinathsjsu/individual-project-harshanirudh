package com.harsha.cmpe.sjsu.inventory;

import java.util.List;

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
	}

}
