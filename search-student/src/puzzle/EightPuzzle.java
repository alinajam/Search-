package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import search.SearchProblem;
import search.Solver;

/**
 * A class to represent an instance of the eight-puzzle.
 * 
 * The spaces in an 8-puzzle are indexed as follows:
 * 
 * 0 | 1 | 2
 * --+---+---
 * 3 | 4 | 5
 * --+---+---
 * 6 | 7 | 8
 * 
 * The puzzle contains the eight numbers 1-8, and an empty space.
 * If we represent the empty space as 0, then the puzzle is solved
 * when the values in the puzzle are as follows:
 * 
 * 1 | 2 | 3
 * --+---+---
 * 4 | 5 | 6
 * --+---+---
 * 7 | 8 | 0
 * 
 * That is, when the space at index 0 contains value 1, the space 
 * at index 1 contains value 2, and so on.
 * 
 * From any given state, you can swap the empty space with a space 
 * adjacent to it (that is, above, below, left, or right of it,
 * without wrapping around).
 * 
 * For example, if the empty space is at index 2, you may swap
 * it with the value at index 1 or 5, but not any other index.
 * 
 * Only half of all possible puzzle states are solvable! See:
 * https://en.wikipedia.org/wiki/15_puzzle
 * for details.
 * 

 * @author liberato
 *
 */
public class EightPuzzle implements SearchProblem<List<Integer>> {
	
	List<Integer> startingValues;

	/**
	 * Creates a new instance of the 8 puzzle with the given starting values.
	 * 
	 * The values are indexed as described above, and should contain exactly the
	 * nine integers from 0 to 8.
	 * 
	 * @param startingValues
	 *            the starting values, 0 -- 8
	 * @throws IllegalArgumentException
	 *             if startingValues is invalid
	 */
	public EightPuzzle(List<Integer> startingValues) {
		if(startingValues.size() != 9)
			throw new IllegalArgumentException();
		for(int i = 0; i < 9; i++) {
			if(!startingValues.contains(i))
				throw new IllegalArgumentException();
		}
		this.startingValues = startingValues;
	}

	@Override
	public List<Integer> getInitialState() {
		// TODO
		return startingValues;
		
	}

	

	@Override
	public List<List<Integer>> getSuccessors(List<Integer> currentState) {
		List<List<Integer>> newList = new ArrayList<List<Integer>>();
		int index = currentState.indexOf(0);
		
		if(index == 0) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			
			int temp = currentState.get(index+3);
			list1.set(index + 3, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index+1);
			list2.set(index + 1, currentState.get(index));
			list2.set(index, temp2);
			
			newList.add(list1);
			newList.add(list2);
			
		}
		if(index == 1) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			List<Integer> list3 = new ArrayList<Integer>(currentState);
			

			int temp = currentState.get(index+3);
			list1.set(index + 3, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index+1);
			list2.set(index + 1, currentState.get(index));
			list2.set(index, temp2);
			
			int temp3 = currentState.get(index-1);
			list3.set(index - 1, currentState.get(index));
			list3.set(index, temp3);
			

			newList.add(list1);
			newList.add(list2);
			newList.add(list3);
			
		}
		if(index == 2) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			
			int temp = currentState.get(index+3);
			list1.set(index + 3, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index-1);
			list2.set(index - 1, currentState.get(index));
			list2.set(index, temp2);
			
			newList.add(list1);
			newList.add(list2);
		}
		if(index == 3) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			List<Integer> list3 = new ArrayList<Integer>(currentState);
			

			int temp = currentState.get(index+3);
			list1.set(index + 3, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index-3);
			list2.set(index - 3, currentState.get(index));
			list2.set(index, temp2);
			
			int temp3 = currentState.get(index+1);
			list3.set(index + 1, currentState.get(index));
			list3.set(index, temp3);
			

			newList.add(list1);
			newList.add(list2);
			newList.add(list3);
			
		}
		if(index == 4) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			List<Integer> list3 = new ArrayList<Integer>(currentState);
			List<Integer> list4 = new ArrayList<Integer>(currentState);
			

			int temp = currentState.get(index+3);
			list1.set(index + 3, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index-1);
			list2.set(index - 1, currentState.get(index));
			list2.set(index, temp2);
			
			int temp3 = currentState.get(index+1);
			list3.set(index + 1, currentState.get(index));
			list3.set(index, temp3);
			
			int temp4 = currentState.get(index-3);
			list4.set(index-3, currentState.get(index));
			list4.set(index, temp4);
			
			newList.add(list1);
			newList.add(list2);
			newList.add(list3);
			newList.add(list4);
			
			
			
		}
		if(index == 5) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			List<Integer> list3 = new ArrayList<Integer>(currentState);
			

			int temp = currentState.get(index+3);
			list1.set(index + 3, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index-3);
			list2.set(index - 3, currentState.get(index));
			list2.set(index, temp2);
			
			int temp3 = currentState.get(index-1);
			list3.set(index - 1, currentState.get(index));
			list3.set(index, temp3);
			

			newList.add(list1);
			newList.add(list2);
			newList.add(list3);
			
		}
		if(index == 6) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			
			int temp = currentState.get(index-3);
			list1.set(index - 3, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index+1);
			list2.set(index + 1, currentState.get(index));
			list2.set(index, temp2);
			
			newList.add(list1);
			newList.add(list2);
		}
		if(index == 7) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			List<Integer> list3 = new ArrayList<Integer>(currentState);
			

			int temp = currentState.get(index+1);
			list1.set(index + 1, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index-3);
			list2.set(index - 3, currentState.get(index));
			list2.set(index, temp2);
			
			int temp3 = currentState.get(index-1);
			list3.set(index - 1, currentState.get(index));
			list3.set(index, temp3);
			

			newList.add(list1);
			newList.add(list2);
			newList.add(list3);
			
		}
		if(index == 8) {
			List<Integer> list1 = new ArrayList<Integer>(currentState);
			List<Integer> list2 = new ArrayList<Integer>(currentState);
			
			int temp = currentState.get(index-3);
			list1.set(index - 3, currentState.get(index));
			list1.set(index, temp);
			
			int temp2 = currentState.get(index-1);
			list2.set(index - 1, currentState.get(index));
			list2.set(index, temp2);
			
			newList.add(list1);
			newList.add(list2);
		}
		// TODO
		return newList;
	}


	@Override
	public boolean isGoal(List<Integer> state) {
		int index = 0;
		while(index < 8) {
			if(state.get(index) == index+1)
				index++;
			else return false;
		}
			// TODO
		return true;
	}

	public static void main(String[] args) {
		EightPuzzle e = new EightPuzzle(Arrays.asList(new Integer[] { 1, 2, 3,
				4, 0, 6, 7, 5, 8 }));

		List<List<Integer>> r = new Solver<List<Integer>>(e).solveWithBFS();
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}
}
