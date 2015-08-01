package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args){
		Random rand = new Random();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<Integer> l4 = new ArrayList<Integer>();
		for(int i = 0;i < 100; i++){
			int value = rand.nextInt(100);
			boolean k = value<50? l1.add(value) : value < 75 ? l2.add(value) : value < 90 ? l3.add(value) : value < 100 ? l4.add(value) : false;
		}
		System.out.println(l1.size());
		System.out.println(l2.size());
		System.out.println(l3.size());
		System.out.println(l4.size());
	}
}
