package search;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {
	private final List<T> states;
	private final List<T> predecessors;
	private final Stack<T> stack;
	
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		states = new ArrayList<T>();
		predecessors = new ArrayList<T>();
		stack = new Stack<T>();
		
	}

	@Override
	public List<T> findSolution() {
		ArrayList<T> path = new ArrayList<T>();
		
		
    	T initialState = searchProblem.getInitialState();
    	visited.add(initialState);
    	stack.push(initialState);
    	states.add(initialState);
    	predecessors.add(initialState);
    	boolean pathFound = false;
    	T temp = null;
    	while(!stack.isEmpty()) {
    		temp = stack.pop();
    		for(T neighbor : searchProblem.getSuccessors(temp)){
    			if(!visited.contains(neighbor)) {
    				if(!states.contains(neighbor)) {
    					
    				states.add(neighbor);
    				visited.add(neighbor);
    				stack.push(neighbor);
    				predecessors.add(temp);
    				if(searchProblem.isGoal(neighbor)) {
        				pathFound = true;
        				path.add(neighbor);
        				break;
        				
        			}
    				}
    			}
    			
    			
    			
    			
    			
    		}
    		if(pathFound == true)
    			break;
    		
    	}
    	
    		
    		if(pathFound == true) {
    			temp = path.get(0);
    			while(!temp.equals(searchProblem.getInitialState())) {
    				final T predecessor = predecessors.get(states.indexOf(temp));
    				path.add(predecessor);
    				temp = predecessor;
    			}
    		}
    		Collections.reverse(path);
    		
    		if (path.size() > 0) {
    			if (!isValidSolution(path)) {
    				throw new RuntimeException(
    						"searcher should never find an invalid solution!");
    			}
    		}
    		return path;
    		
        		
	}
}
