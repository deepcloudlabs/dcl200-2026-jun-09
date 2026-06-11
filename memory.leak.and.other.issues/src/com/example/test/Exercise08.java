package com.example.test;

import java.util.HashSet;
import java.util.Objects;

public class Exercise08 {

	public static void main(String[] args) {
		var set = new HashSet<>(20,0.5f);
		var start = System.currentTimeMillis();
		for (var i = 0; i < 20; ++i) {
			set.add(new ABC(42));
		}
		System.out.println(set.size());
		while (!set.isEmpty()) {
			set.remove(new ABC(42));
			System.out.println(set.size());
		}
		System.out.println(set.size());
		var stop = System.currentTimeMillis();
		System.out.println("Duration: %d ms. length: %d".formatted(stop - start,set.size()));
		
	}

}

record R1(int x) {
	
}

class ABC {
	int x;

	public ABC(int x) {
		this.x = x;
	}

	@Override
	public int hashCode() {	
		System.err.println("ABC::hashCode");
		return Objects.hashCode(x);
	}

	@Override
	public boolean equals(Object obj) {
		System.err.println("ABC::equals");
		if (Objects.isNull(obj)) return false;
		if (!obj.getClass().equals(ABC.class)) return false;
		var other = (ABC) obj;
		return other.x == this.x;
	}
	
	
}
