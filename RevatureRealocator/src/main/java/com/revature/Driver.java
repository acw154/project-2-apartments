package com.revature;

import com.revature.services.APIParse;
import com.revature.services.DummyData;

public class Driver {

	public static void main(String[] args) {

		DummyData dummy = new DummyData();
		String data = dummy.data;
		APIParse.parse(data);

		}
}
