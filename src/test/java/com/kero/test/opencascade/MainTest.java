package com.kero.test.opencascade;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class MainTest {

	@Test
	public void createTest() {
		
		int[] array = Main.createFilledArray(6);
	
		assertArrayEquals(array, new int[] {1, 2, 3, 4, 5, 6});
	}
	
	@Test
	public void findTest() {
		
		int[] array = new int[] {1, 2, 3, 4, 5, 7, 8, 9, 10};
		int removedElement = Main.findRemovedElement(array);
		assertEquals(removedElement, 6);
	
		array = new int[] {3, 2, 1, 4, 8, 7, 5, 10, 9};
		removedElement = Main.findRemovedElement(array);
		assertEquals(removedElement, 6);
		
		array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		removedElement = Main.findRemovedElement(array);
		assertEquals(removedElement, 11);
		
		array = new int[] {1, 2};
		removedElement = Main.findRemovedElement(array);
		assertEquals(removedElement, 3);
		
		array = new int[] {2, 3};
		removedElement = Main.findRemovedElement(array);
		assertEquals(removedElement, 1);
		
		array = new int[] {1};
		removedElement = Main.findRemovedElement(array);
		assertEquals(removedElement, 2);
	}
	
	@Test
	public void removeTest() {
		
		int[] array = new int[] {5, 10, 15, 20};
		
		int[] result = Main.removeElement(array, 0);
		assertArrayEquals(result, new int[] {10, 15, 20});

		result = Main.removeElement(array, 2);
		assertArrayEquals(result, new int[] {5, 10, 20});
		
		result = Main.removeElement(array, 1);
		assertArrayEquals(result, new int[] {5, 15, 20});
		
		result = Main.removeElement(array, 3);
		assertArrayEquals(result, new int[] {5, 10, 15});
	}
	
	@RepeatedTest(10)
	public void shuffleTest() {
		
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int maxVariations = 3628800; // 10!
		int collisions = 0;
		
		for(int i = 0; i < maxVariations / 10; i++) {
			
			int[] result = Main.shuffleArray(array, array.length);
		
			collisions += Arrays.equals(array, result) ? 1 : 0;
		}
		
		if(collisions >= maxVariations / 100) {
			
			throw new RuntimeException("Shuffle has many collisions: "+collisions+"!");
		}
	}
}
