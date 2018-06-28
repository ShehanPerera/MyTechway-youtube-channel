package com.github.dataStructures;
import java.util.*;
public class Stack {
	private int stackArray[];
	private int arraySize, top;

	/**
	 * Constructor to declare stackArray and other necessory variables
	 * @param n Size of the stackArray
	 */
	public Stack(int n) {
		arraySize = n;
		stackArray = new int[n];
		top = -1;
	}

	/**
	 * Function to check whether stackArray is empty or not.
	 * @return true if stackArray is empty, else false.
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 *Function to check weather stackArray is full or not.
	 * @return true if stackArray is full, else false.
	 */
	public boolean isFull() {
		return top == arraySize-1;
	}

	/**
	 * Function to check the length of the array (Count of filled element).
	 * @return length of the array
	 */
	public int len() {
		return top+1;
	}

	/**
	 * Function to check the size of the stackArray.
	 * @return size of the stackArray
	 */
	public int size() {
		return arraySize;
	}

	/**
	 * Function to check the top element (Not to pull, just check)
	 * @return value of the top element
	 */
	public int peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("Underflow Exception: No element in top to display.");
		}
		return stackArray[top];
	}

	/**
	 * Function to push element to stack
	 * @param val value to push
	 */
	public void push(int val) {
		if(isFull()) {
			throw new IndexOutOfBoundsException("Overflow Exception: Your stack is full");
		} else {
			stackArray[++top] = val;
		}
	}

	/**
	 * Function to pull the top element from the stack
	 * @return top element
	 */
	public int pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("Underflow Exception: No element in top to display.");
		}
		return stackArray[top--];
	}

}
