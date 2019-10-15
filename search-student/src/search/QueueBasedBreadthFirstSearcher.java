package search;

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {
	private final List<T> states;
	private final List<T> predecessors;
	private final Queue<T> queue;
	
	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		
		super(searchProblem);
		states = new ArrayList<T>();
		predecessors = new ArrayList<T>();
		queue = new LinkedList<T>();
		
	}

	@Override
	public List<T> findSolution() {
        	ArrayList<T> path = new ArrayList<T>();
        	T initialState = searchProblem.getInitialState();
        	visited.add(initialState);
        	queue.add(initialState);
        	states.add(initialState);
        	predecessors.add(initialState);
        	boolean pathFound = false;
        	T temp = null;
        	while(!queue.isEmpty()) {
        		temp = queue.remove();
        		for(T neighbor : searchProblem.getSuccessors(temp)){
        			if(!visited.contains(neighbor)) {
        				if(!states.contains(neighbor)) {
        					
        				states.add(neighbor);
        				visited.add(neighbor);
        				queue.add(neighbor);
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
