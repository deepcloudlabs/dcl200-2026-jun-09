package com.example;
public class Exercise01 {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2_000; i++) {
			Thread.sleep(2);
		} // 2000 x 2ms = 4000 ms
		long end = System.currentTimeMillis();
		// Windows   11: Cost (%): 36, Millis elapsed: 5509
		// Ubuntu 22.04: Cost (%):  6, Millis elapsed: 4219
		System.out.println("Cost (%): " + (end - start - 4000) / 40.0);
		System.out.println("Millis elapsed: " + (end - start));
	}
}