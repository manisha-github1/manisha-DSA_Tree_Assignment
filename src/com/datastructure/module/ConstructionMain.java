package com.datastructure.module;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ConstructionMain {

	static void runtestcase(int buildFloor) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringBuilder sbnw = new StringBuilder();

		Stack<Integer> buildingSize = new Stack();

		Queue<Integer> dayTarget = new LinkedList<Integer>();

		ArrayList<Integer> temp = new ArrayList<Integer>();

		int dayNum, target, srcPeekdata, nwsrcPeekdata, targetPeekdata,  tempdata;
		boolean founddata;

		// Insert Floor data into stack LIFO ==> to get max floor size first
		int size = 0;
		for (int i = 0; i < buildFloor; i++) {
			size = size + 1;
			buildingSize.push(size);
		}

		// For loop for adding user input data on queue for using FIFO
		for (int i = 0; i < buildFloor; i++) {
			dayNum = i + 1;
			System.out.println("Enter the floor size given on day" + ": " + dayNum);
			target = sc.nextInt();
			dayTarget.add(target);
		}

		// Loop for finding Per day Output
		System.out.println("---------------------------------------");
		System.out.println("The order of construction is as follows");
		
		for (int j = 0; j < buildFloor; j++) {
			
			dayNum = j + 1;
			nwsrcPeekdata = 0;
			sb = sb.delete(0, j);
			srcPeekdata = buildingSize.peek();
			targetPeekdata = dayTarget.peek();
			tempdata = srcPeekdata - 1;

			if (srcPeekdata == targetPeekdata || dayTarget.isEmpty() == true) {

				buildingSize.pop();
				dayTarget.remove(srcPeekdata);
				sb = sb.append(srcPeekdata + " ");

				if (!buildingSize.isEmpty()) {
					nwsrcPeekdata = buildingSize.peek();
				}

				// working for test 1
				if (!temp.isEmpty()) {

					for (int i = 0; i < temp.size(); i++) {
						Collections.sort(temp, Collections.reverseOrder());
						founddata = temp.contains(tempdata);

						if (founddata = true && (nwsrcPeekdata < tempdata || temp.get(i) == tempdata)) {

							sb = sb.append(", " + tempdata);
							tempdata = tempdata - 1;
							if (tempdata == 0) {
								break;
							}

							founddata = false;

							if (!buildingSize.isEmpty()) {
								buildingSize.pop();
								if (!buildingSize.isEmpty()) {
									nwsrcPeekdata = buildingSize.peek();
								}
							}
						} 
					}
				}
				// working for test 1
				System.out.println("Day" + ": " + dayNum);
				System.out.println(sb);
				System.out.println(" ");
			}

			if (srcPeekdata != targetPeekdata) {
				temp.add(targetPeekdata);
				dayTarget.remove(targetPeekdata);
				
				System.out.println("Day" + ": " + dayNum);
				System.out.println("  ");
			}

		}

	}

	public static void main(String[] args) {
		int testCase, buildFloor;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Test Case  Number");
		testCase = sc.nextInt();
		System.out.println("Enter the total no of floors in the building for Test Case: " + testCase);

		buildFloor = sc.nextInt();

		// Run the test case

		runtestcase(buildFloor);

	}

}
