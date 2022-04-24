package com.harsha.cmpe.sjsu.inventory;

import java.util.List;

import com.harsha.cmpe.sjsu.inventory.models.Items;

public interface AbstractOrderHandler {

	public void nextHandler(AbstractOrderHandler next);
	public void handle(List<Items> input);
}
