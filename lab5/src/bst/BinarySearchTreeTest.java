package bst;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import bst.BinarySearchTree;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Comparator;


public class BinarySearchTreeTest {	
	BinarySearchTree<Integer> intBST;
	BinarySearchTree<String> stringBST;
	private Comparator<String> comparator;
	
	@BeforeEach
	public void setUp() throws Exception {
		intBST = new BinarySearchTree<Integer>();
		comparator = (e1, e2) -> e1.compareTo(e2);
		stringBST = new BinarySearchTree<String>(comparator);
	}

	@Test
	void testHeightInt() {
		assertTrue(intBST.add(3));
		assertTrue(intBST.add(22));
		assertTrue(intBST.add(33));
		assertTrue(intBST.add(11));
		assertTrue(intBST.height() == 3);
	}
	
}
