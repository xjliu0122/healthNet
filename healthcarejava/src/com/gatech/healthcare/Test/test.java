package com.gatech.healthcare.Test;

import com.gatech.healthcare.Service.GetOccurance;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetOccurance occ = new GetOccurance();
		String test  = occ.getData();
		System.out.println(test);
	}

}
