package com.epam.example.notsolid.impl;

public class Rhombus extends Parallelogramm {

	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		super.setHeight(width);
	}

	@Override
	public void setHeight(double height) {
		super.setWidth(height);
		super.setHeight(height);
	}
}
