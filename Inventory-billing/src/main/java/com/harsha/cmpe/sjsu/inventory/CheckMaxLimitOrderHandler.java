package com.harsha.cmpe.sjsu.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.harsha.cmpe.sjsu.inventory.models.Items;

public class CheckMaxLimitOrderHandler implements AbstractOrderHandler {

	private AbstractOrderHandler next;
	private final int MAX_LUXURY = 3;
    private final int MAX_ESSENTIAL = 5;
    private final int MAX_MISSC = 6;
    private StringBuilder messageInCorrect=new StringBuilder();
    private boolean flag;
	@Override
	public void handle(List<Items> inputs) {
		// process request
		System.out.println("Processign request in Check MaxLimit");
		Map<String,List<Items>>categoryMap=new HashMap<>();
		for(Items input :inputs) {
			if(categoryMap.containsKey(input.getCategory())) {
				categoryMap.get(input.getCategory()).add(input);
			}else {
				List<Items> itemsList=new ArrayList<>();
				itemsList.add(input);
				categoryMap.put(input.getCategory(), itemsList);
			}
		}
		if(categoryMap.get("LUXURY").stream().mapToInt(i->i.getQuantity()).sum()>MAX_LUXURY){
           flag=true;
           for(Items item: categoryMap.get("LUXURY")) {
        	   messageInCorrect.append(item.getItem()+":("+item.getQuantity()+")\n");
           }
           
        }if(categoryMap.get("ESSENTIALS").stream().mapToInt(i->i.getQuantity()).sum()>MAX_ESSENTIAL){
        	flag=true;
            for(Items item: categoryMap.get("ESSENTIALS")) {
         	   messageInCorrect.append(item.getItem()+":("+item.getQuantity()+")\n");
            }
        } if(categoryMap.get("MISC").stream().mapToInt(i->i.getQuantity()).sum()>MAX_MISSC){
        	flag=true;
            for(Items item: categoryMap.get("MISC")) {
         	   messageInCorrect.append(item.getItem()+":("+item.getQuantity()+")\n");
            }
        }
		// If it has no invalid input pass to next handler
		if(!flag) {
			System.out.println("Passing request to next handler");
			next.handle(inputs);
		}
		System.out.println(messageInCorrect.toString());
		
	}
	@Override
	public void nextHandler(AbstractOrderHandler next) {
		// TODO Auto-generated method stub
		this.next=next;
		
	}

}
