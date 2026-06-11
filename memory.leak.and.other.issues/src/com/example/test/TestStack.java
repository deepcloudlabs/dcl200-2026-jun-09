package com.example.test;

import java.util.concurrent.TimeUnit;

import com.example.util.Stack;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 * 
 */
public class TestStack {
	private static final int SIZE = 512;

	public static void main(String[] args) throws InterruptedException {
		Stack<LargeObject> s = new Stack<>(SIZE);
		System.out.println("Pushing %d objects into the stack".formatted(SIZE));
		for (int i = 0; i < SIZE; i++) { // 4MB * 512 = 2GB
			s.push(new LargeObject());
		}
		System.out.println("Stack size is %d".formatted(s.size()));
		System.out.println("Popping objects from the stack until it is empty.");
		while (!s.isEmpty()) {
			s.pop();
		}
		System.out.println("Stack is now empty: %d".formatted(s.size()));
		while (true) {
			TimeUnit.MILLISECONDS.sleep(100);
		}
	}

}

// G1GC: Regional GC -> RegionSize: 2MB
// Object Size > 1MB -> Humonguous Object
class LargeObject {
	@SuppressWarnings("unused")
	private int[] array = new int[1024 * 1024]; // 12B + 4B + 4 * 1MB = 4MB + 16B
}
