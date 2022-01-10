package com.itbulls.learnit.javacore.patterns.structural.flyweight;

public class Tree {
	private int x;
	private int y;
	private TreeType type;

	public Tree(int x, int y, TreeType type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public TreeType getType(){
		return this.type;
	}

	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}

}
