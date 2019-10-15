package search;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstraction over the idea of a search.
 *
 * @author liberato
 *
 * @param <T>
 */
public abstract class Searcher<T> {
	protected final SearchProblem<T> searchProblem;
	protected final List<T> visited;
	protected List<T> solution;

	/**
	 * Instantiates a searcher.
	 * 
	 * @param searchProblem
	 *            the search problem for which this searcher will find and
	 *            validate solutions
	 */
	public Searcher(SearchProblem<T> searchProblem) {
		this.searchProblem = searchProblem;
		this.visited = new ArrayList<T>();
	}

	/**
	 * Finds and return a solution to the problem, consisting of a list of
	 * states.
	 * 
	 * The list should start with the initial state of the underlying problem.
	 * Then, it should have one or more additional states. Each state should be
	 * a successor of its predecessor. The last state should be a goal state of
	 * the underlying problem.
	 * 
	 * If there is no solution, then this method should return an empty list.
	 * 
	 * @return a solution to the problem (or an empty list)
	 */
	public abstract List<T> findSolution();

	/**
	 * Checks that a solution is valid.
	 * 
	 * A valid solution consists of a list of states. The list should start with
	 * the initial state of the underlying problem. Then, it should have one or
	 * more additional states. Each state should be a successor of its
	 * predecessor. The last state should be a goal state of the underlying
	 * problem.
	 * 
	 * @param solution
	 * @return true iff this solution is a valid solution
	 * @throws NullPointerException
	 *             if solution is null
	 */
	private boolean checkSuccessors(T pre, T suc)
	{
		List<T> succs = searchProblem.getSuccessors(pre);
		for(T s : succs)
		{
			if(suc.equals(s))
			{
				return true;
			}
		}
		return false;
		
	}
	public final boolean isValidSolution(List<T> solution) {
		if(solution == null)
        	throw new NullPointerException();
        if(solution.size() == 0)
        	return false;
        if(!solution.get(0).equals(searchProblem.getInitialState()))
        	return false;
        if(!searchProblem.isGoal(solution.get(solution.size() - 1)))
        	return false;
        else{ 
        	int index = 1;
        	while(index < solution.size()) {
        		
        		if(!checkSuccessors(solution.get(index - 1),solution.get(index)))
        		{
        			return false;
        		}   		
        		++index;
        	}	
      	
        	return true;
        }     
        	
        	// TODO
        
	}
}
