package com.harsha.cmpe.sjsu.inventory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import com.harsha.cmpe.sjsu.inventory.files.OutputFile;
import com.harsha.cmpe.sjsu.inventory.files.OutputFileFactory;
import com.harsha.cmpe.sjsu.inventory.models.Items;

public class CheckMaxLimitOrderHandler implements AbstractOrderHandler {

	private AbstractOrderHandler next;
	private final int MAX_LUXURY = 300;
	private final int MAX_ESSENTIAL = 500;
	private final int MAX_MISSC = 600;
	private StringBuilder messageInCorrect = new StringBuilder("Please correct the quantities\n");
	private boolean flag;

	@Override
	public void handle(List<Items> inputs) {
		// process request
		System.out.println("Processign request in Check MaxLimit");
		Map<String, List<Items>> categoryMap = new HashMap<>();
		for (Items input : inputs) {
			if (categoryMap.containsKey(input.getCategory())) {
				categoryMap.get(input.getCategory()).add(input);
			} else {
				List<Items> itemsList = new ArrayList<>();
				itemsList.add(input);
				categoryMap.put(input.getCategory(), itemsList);
			}
		}
		if (Optional.ofNullable(categoryMap.get("LUXURY")).map(List::stream).orElseGet(Stream::empty)
				.mapToInt(i -> i.getQuantity()).sum() > MAX_LUXURY) {
			flag = true;
			for (Items item : categoryMap.get("LUXURY")) {
				messageInCorrect.append(item.getItem() + ":(" + item.getQuantity() + ")\n");
			}

		}
		if (Optional.ofNullable(categoryMap.get("ESSENTIALS")).map(List::stream).orElseGet(Stream::empty)
				.mapToInt(i -> i.getQuantity()).sum() > MAX_ESSENTIAL) {
			flag = true;
			for (Items item : categoryMap.get("ESSENTIALS")) {
				messageInCorrect.append(item.getItem() + ":(" + item.getQuantity() + ")\n");
			}
		}
		if (Optional.ofNullable(categoryMap.get("MISC")).map(List::stream).orElseGet(Stream::empty)
				.mapToInt(i -> i.getQuantity()).sum() > MAX_MISSC) {
			flag = true;
			for (Items item : categoryMap.get("MISC")) {
				messageInCorrect.append(item.getItem() + ":(" + item.getQuantity() + ")\n");
			}
		}
		// If it has no invalid input pass to next handler
		if (!flag) {
			System.out.println("Passing request to next handler");
			next.handle(inputs);
		} else {
			OutputFileFactory fileFactory = new OutputFileFactory();
			OutputFile errFile = fileFactory.getOutputFile("ERROR");
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
		this.next = next;

	}

}
