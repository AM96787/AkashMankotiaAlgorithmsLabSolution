package com.greatlearning.dsa;

import java.util.Scanner;

public class CurrencyPayment {
	public static int[] array;
	public static int size, payAmt;
	Scanner sc = new Scanner(System.in);

	// Function to Create the currency denomination array[] of size n based on user
	// inputs
	public void insertDenominations() {
		System.out.print("Enter the Number of Currency Denominations: ");
		size = sc.nextInt();
		array = new int[size];
		System.out.println("\n");
		for (int i = 0; i < size; i++) {
			System.out.print("Enter Denomination " + (i + 1) + ": ");
			array[i] = sc.nextInt();
		}
		System.out.println("\n");
	}

	// Function to display the notes denomination array[] of size n
	public void displayDenominations() {
		System.out.print("Denominations[" + size + "]: ");
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
	}

	// Main Function for checking the minimum number of currency note of any
	// denomination required to make the necessary payment
	public void minNoteCalc(int arr[]) {
		int numnotes[] = new int[size];
		for (int i = 0; i < arr.length; i++) {
			// To find out how many notes of specific currency denomination is required to
			// pay the amount.
			numnotes[i] = (int) (payAmt / arr[i]);
			payAmt = payAmt % arr[i];
		}
		if (payAmt != 0)
			System.out.print("Amount Cannot be Paid in Full");
		else {
			for (int i = 0; i < size; i++)
				System.out.println(arr[i] + ": " + numnotes[i]);
		}
	}

	public static void main(String[] args) {
		CurrencyPayment cp = new CurrencyPayment();
		System.out.println("*****Currency Payment Program*****\n");
		cp.insertDenominations();
		System.out.println("*****Before Sorting*****\n");
		cp.displayDenominations();
		MergeSort ms = new MergeSort();
		System.out.println("*****After Sorting*****\n");
		ms.mergeSort(array, 0, size - 1);
		cp.displayDenominations();
		System.out.print("Enter the Payment amount: ");
		payAmt = cp.sc.nextInt();
		cp.minNoteCalc(array);
	}

}
