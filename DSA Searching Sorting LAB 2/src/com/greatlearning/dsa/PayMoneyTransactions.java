package com.greatlearning.dsa;

import java.util.Scanner;

public class PayMoneyTransactions {
	public int[] array;
	public int size, target, sum, vcount, i = 0, tvalue;
	Scanner sc = new Scanner(System.in);

	// Main function for taking the Target Value from user
	// and calling the function to check the target status
	public void EnterTargetValue() {
		for (int j = 0; j < target; j++) {
			vcount = sum = i = 0;
			System.out.print("Enter the value of Target " + (j + 1) + ": ");
			tvalue = sc.nextInt();
			System.out.print("\n");
			int c = CheckTargetStatus(tvalue);
			if (c > 0)
				System.out.println("Target achieved after " + c + " transactions.\n");
			else
				System.out.println("Given target is not achieved.\n");
		}
	}

	// Function to compare the target value with the array elements and return the
	// count of transactions required to achieve the target
	public int CheckTargetStatus(int tv) {
		while (sum < tv && i < size) {
			vcount = vcount + 1;
			sum = array[i] + sum;
			i = i + 1;
			CheckTargetStatus(tv);
		}
		if (sum >= tv)
			return vcount;
		else
			return -1;
	}

	// Function to Create the array[] of size n based on user inputs
	public void insertTransactions() {
		System.out.print("Enter the Number of Transactions: ");
		size = sc.nextInt();
		array = new int[size];
		System.out.println("\n");
		for (int i = 0; i < size; i++) {
			System.out.print("Enter the transaction at position " + i + ": ");
			array[i] = sc.nextInt();
			System.out.println("\n");
		}
	}

	// Function to display the array[] of size n
	public void displayArray() {
		System.out.print("PayMoney[" + size + "]: ");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		PayMoneyTransactions trx = new PayMoneyTransactions();
		System.out.println("*****PayMoney Transactions*****\n");
		trx.insertTransactions();
		trx.displayArray();
		System.out.print("Enter the total no of targets that needs to be achieved: ");
		trx.target = trx.sc.nextInt();
		System.out.print("\n");
		trx.EnterTargetValue();
	}
}