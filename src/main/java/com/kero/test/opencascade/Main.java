package com.kero.test.opencascade;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	private static Random rand = new Random();
	
	public static void main(String[] args) {
		
		int arraySize = readArraySize();
		
		int[] array = createFilledArray(arraySize);
		System.out.println("Создан массив("+arraySize+"): "+Arrays.toString(array));
		
		array = removeRandomElement(array);
		System.out.println("Удаление случайного элемента, полученный массив: "+Arrays.toString(array));
		
		array = shuffleArray(array, array.length);
		System.out.println("Перемешивание массива, полученный массив: "+Arrays.toString(array));
	
		int removedElement = findRemovedElement(array);
		System.out.println("Удаленный элемент: "+removedElement);
	}
	
	public static int findRemovedElement(int[] array) {
		
		double initialSize = array.length + 1;
		double initialElementsSum = (1 + initialSize) * (initialSize / 2);
		
		double arrayElementsSum = 0;
		
		for(int element : array) {
			
			arrayElementsSum += element;
		}
		
		int missedElement = (int) (initialElementsSum - arrayElementsSum);
		
		return missedElement;
	}
	
	public static int[] createFilledArray(int size) {
		
		int[] array = new int[size];
		
		for(int i = 0; i < array.length; i++) {
			
			array[i] = i + 1;
		}
		
		return array;
	}
	
	public static int[] shuffleArray(int[] arrayArg, int roundsCount) {
		
		int[] array = new int[arrayArg.length];
		System.arraycopy(arrayArg, 0, array, 0, arrayArg.length);
		
		for(int roundIndex = 0; roundIndex < roundsCount; roundIndex++) {
			
			int firstIndex = rand.nextInt(array.length);
			int secondIndex = rand.nextInt(array.length);
			
			int first = array[firstIndex];
			int second = array[secondIndex];
			
			array[firstIndex] = second;
			array[secondIndex] = first;
		}
		
		return array;
	}
	
	public static int[] removeRandomElement(int[] array) {
	
		return removeElement(array, rand.nextInt(array.length));
	}
	
	public static int[] removeElement(int[] arrayArg, int elementIndex) {
		
		int[] array = new int[arrayArg.length - 1];
		System.arraycopy(arrayArg, 0, array, 0, elementIndex);
		System.arraycopy(arrayArg, elementIndex + 1, array, elementIndex, array.length - elementIndex);
		
		return array;
	}
	
	public static int readArraySize() {
		
		Scanner scanner = new Scanner(System.in);
		
		int arraySize = -1;
		
		while(true) {
			
			System.out.println("Введите размер массива");
			
			String line = scanner.nextLine();
		
			try {
				
				arraySize = Integer.valueOf(line);
			}
			catch(NumberFormatException e) {
				
				System.out.println("Размер массива не может быть: "+line+"!");
				continue;
			}
			
			if(arraySize >= 10) {
				
				scanner.close();
				return arraySize;
			}
			else {
				
				System.out.println("Размер массива должен быть >= 10!");	
			}
		}
	}
}
