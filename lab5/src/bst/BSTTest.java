package bst;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTest {
	private Comparator<String> comparator;
	BinarySearchTree<Integer> myIntBinarySearchTree;
	BinarySearchTree<String> myStringBinarySearchTree;

	@BeforeEach
	void setUp() throws Exception {
		myIntBinarySearchTree = new BinarySearchTree<Integer>();
		comparator = (e1, e2) -> e1.compareTo(e2);
		myStringBinarySearchTree = new BinarySearchTree<String>(comparator);
	}

	@Test
	void testHeightInt() {
		assertTrue(myIntBinarySearchTree.add(5));
		assertTrue(myIntBinarySearchTree.add(22));
		assertTrue(myIntBinarySearchTree.add(33));
		assertTrue(myIntBinarySearchTree.add(11));
		assertTrue(myIntBinarySearchTree.height() == 3);
	}

	@Test
	void testHeightString() {
		assertTrue(myStringBinarySearchTree.add("Klara"));
		assertTrue(myStringBinarySearchTree.add("Nils"));
		assertTrue(myStringBinarySearchTree.add("Bosse"));
		assertTrue(myStringBinarySearchTree.height() == 2);
	}

	@Test
	void testSizeInt() {
		assertTrue(myIntBinarySearchTree.add(5));
		assertTrue(myIntBinarySearchTree.add(22));
		assertTrue(myIntBinarySearchTree.add(33));
		assertTrue(myIntBinarySearchTree.add(11));
		assertTrue(myIntBinarySearchTree.size() == 4);
	}

	@Test
	void testSizeString() {
		assertTrue(myStringBinarySearchTree.add("Klara"));
		assertTrue(myStringBinarySearchTree.add("Nils"));
		assertTrue(myStringBinarySearchTree.add("Bosse"));
		assertTrue(myStringBinarySearchTree.size() == 3);
	}

	@Test
	void testHeightEmptyInt() {
		assertTrue(myIntBinarySearchTree.height() == 0);
	}

	@Test
	void testHeightEmptyString() {
		assertTrue(myStringBinarySearchTree.height() == 0);
	}

	@Test
	void testSizeEmptyInt() {
		assertTrue(myIntBinarySearchTree.size() == 0);
	}

	@Test
	void testSizeEmptyString() {
		assertTrue(myStringBinarySearchTree.size() == 0);
	}

	@Test
	void testAddDuplicatesInt() {
		assertTrue(myIntBinarySearchTree.add(5));
		assertFalse(myIntBinarySearchTree.add(5));
	}

	@Test
	void testAddDuplicatesString() {
		assertTrue(myStringBinarySearchTree.add("Korv"));
		assertFalse(myStringBinarySearchTree.add("Korv"));
	}

	@Test
	void testAddInt() {
		assertTrue(myIntBinarySearchTree.add(3));
		assertTrue(myIntBinarySearchTree.add(22));
		assertTrue(myIntBinarySearchTree.add(44));
		assertTrue(myIntBinarySearchTree.add(10));
		assertTrue(myIntBinarySearchTree.root.element.equals(3));
		assertTrue(myIntBinarySearchTree.root.right.element.equals(22));
		assertTrue(myIntBinarySearchTree.root.right.right.element.equals(44));
		assertTrue(myIntBinarySearchTree.root.right.left.element.equals(10));
		System.out.println("Utskrift av heltal inorder");
		myIntBinarySearchTree.printTree();
		System.out.println();
	}

	@Test
	void testAddString() {
		assertTrue(myStringBinarySearchTree.add("Klara"));
		assertTrue(myStringBinarySearchTree.add("Nils"));
		assertTrue(myStringBinarySearchTree.add("Bosse"));
		assertTrue(myStringBinarySearchTree.root.element.equals("Klara"));
		assertTrue(myStringBinarySearchTree.root.right.element.equals("Nils"));
		assertTrue(myStringBinarySearchTree.root.left.element.equals("Bosse"));
		System.out.println("Utskrift av str??ngar inorder");
		myStringBinarySearchTree.printTree();
		System.out.println();
	}

	@Test
	void testClearString() {
		assertTrue(myStringBinarySearchTree.add("Klara"));
		assertTrue(myStringBinarySearchTree.add("Nils"));
		assertTrue(myStringBinarySearchTree.add("Bosse"));
		myStringBinarySearchTree.clear();
		assertTrue(myStringBinarySearchTree.height() == 0);
		assertTrue(myStringBinarySearchTree.root == null);
	}

	@Test
	void testClearInt() {
		assertTrue(myIntBinarySearchTree.add(3));
		assertTrue(myIntBinarySearchTree.add(22));
		assertTrue(myIntBinarySearchTree.add(44));
		assertTrue(myIntBinarySearchTree.add(10));
		myIntBinarySearchTree.clear();
		assertTrue(myIntBinarySearchTree.root == null);
		assertTrue(myIntBinarySearchTree.size() == 0);
	}

}
