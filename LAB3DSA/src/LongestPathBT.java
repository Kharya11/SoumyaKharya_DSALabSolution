import java.io.*;
import java.util.ArrayList;

class LongestPathBT {

//Binary tree node
	static class Node {
		Node left;
		Node right;
		int data;
	};

//Function to create a new Binary node
	static Node newNode(int data) {
		Node temp = new Node();

		temp.data = data;
		temp.left = null;
		temp.right = null;

		return temp;
	}

//Function to find and return the longest path
	public static ArrayList<Integer> longestPath(Node root) {

		// If root is null means there is no binary tree so
		// return a empty 
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

     	ArrayList<Integer> right = longestPath(root.right);
		ArrayList<Integer> left = longestPath(root.left);

		// Compare the size of the two ArrayList
		// and insert current node accordingly
		if (right.size() < left.size()) {
			left.add(root.data);
		} else {
			right.add(root.data);
		}
		return (left.size() > right.size() ? left : right);
	}

//Main Class
	public static void main(String[] args) {
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(103);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.left = newNode(140);
		root.left.left.left = newNode(5);

		ArrayList<Integer> output = longestPath(root);
		int count = output.size();

		System.out.print(output.get(count - 1));
		for (int i = count - 2; i >= 0; i--) {
			System.out.print(" -> " + output.get(i));
		}
	}
}
