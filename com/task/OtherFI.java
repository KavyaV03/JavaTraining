package com.task;

import java.util.function.BiPredicate;

public class OtherFI {
	public void biPredict(){
		BiPredicate<Long,Long> loi = (x,y)-> x>y;
		BiPredicate<Long,Long> lo = (x,y)-> x==y;
	System.out.println(loi.or(lo).test(123L,123L));
	}
}

