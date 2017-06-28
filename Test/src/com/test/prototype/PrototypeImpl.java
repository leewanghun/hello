package com.test.prototype;

class PrototypeImpl implements Prototype, Cloneable {
	private int x;

	/**
	 * Constructor
	 */
	public PrototypeImpl(int x) {
		setX(x);
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void printX() {
		System.out.println("Value: " + x);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public PrototypeImpl clone() throws CloneNotSupportedException {
		return (PrototypeImpl) super.clone();
	}
}