package com.datastructure.module;

import com.datastructure.module.ConstructionUtil;
import java.util.Scanner;


public class ConstructionMain {


	public static void main(String[] args) {
		ConstructionUtil ct = new ConstructionUtil();
		int testCase, buildFloor;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Test Case  Number");
		testCase = sc.nextInt();
		System.out.println("Enter the total no of floors in the building for Test Case: " + testCase);

		buildFloor = sc.nextInt();

		// Run the test case

		ct.runtestcase(buildFloor);

	}

}
