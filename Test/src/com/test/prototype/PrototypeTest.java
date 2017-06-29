package com.test.prototype;

public class PrototypeTest {
    public static void main(String args[]){
        PrototypeImpl prototype = new PrototypeImpl(1000);
 
        for (int y = 1; y < 10; y++) {
            // Create a defensive copy of the object to allow safe mutation
			try {
				Prototype tempotype = prototype.clone();
				
				// Derive a new value from the prototype's "x" value
//	            tempotype.setX(tempotype.getX() * y);
//	            tempotype.printX();
	            System.out.println(tempotype + "X is " + tempotype.getX());
	            
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
        }
    }
}
