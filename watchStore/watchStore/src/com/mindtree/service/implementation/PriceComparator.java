package com.mindtree.service.implementation;

import java.util.Comparator;

import com.mindtree.entity.Watch;

public class PriceComparator implements Comparator<Watch>{


	public int compare(Watch e1, Watch e2) {
		if(e1.getwPrice()<e2.getwPrice()) {
			return 1;
		}
		return -1;
	}

}
