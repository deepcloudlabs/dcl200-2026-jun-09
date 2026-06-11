package com.example;

import java.lang.ref.WeakReference;
import java.util.Objects;

public class Exercise05 {

	public static void main(String[] args) {
		// object root -> stack
		var strongRef = new Circle(1,2,3);
		WeakReference<Circle> weakRef = new WeakReference<>(strongRef);
		strongRef = null;
		System.gc(); // FullGC -> unless -XX:+DisableExplicitGC
		var circle = weakRef.get();
		if (Objects.nonNull(circle)) {
			System.out.println(circle.area());
		} else {
			System.out.println("Circle object does not exist!");
		}

	}

}

record Circle(int x,int y,int radius) {
	public double area() {return Math.PI * this.radius * this.radius; }

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
}
