/*
 * #341. Flatten Nested List Iterator
 * 
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
             
Example 2:

Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
             
 */



/*
* Time Complexity: O (N) -> 'N' is the number of elements in input list
*
* Space Complexity: O (N) -> 'N' is the number of elements(integers) stored in a queue
* 
* Did this code successfully run on leetcode: Yes
* 
* Any problem you faced while coding this: No
* 
*/

package com.s30.edu.design3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
 interface NestedInteger {
 
	 // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 public boolean isInteger();
 
	 // @return the single integer that this NestedInteger holds, if it holds a single integer
	 // Return null if this NestedInteger holds a nested list
	 public Integer getInteger();
 
	 // @return the nested list that this NestedInteger holds, if it holds a nested list
	 // Return null if this NestedInteger holds a single integer
	 public List<NestedInteger> getList();
 }
 

public class NestedListIterator implements Iterator<Integer> {
	
	// #1. Initialize a queue
    Queue<Integer> queue;
    public NestedListIterator(List<NestedInteger> nestedList) {
        // #2. Create a queue using LinkedList
        queue = new LinkedList<>();
        
        // #3. Initiate recursive call on whole input list
        recurr(nestedList);
        
    }

	@Override
	public boolean hasNext() {
		// #7. Check if queue has more elements
        return !queue.isEmpty();
	}

	@Override
	public Integer next() {
		// #8. remove the elements from queue on calling next repeatedly until hasNext returns false
        // Means, no more elements in a queue
        return queue.poll();
	}
	
	public void recurr(List<NestedInteger> nestedList){
        // #4. Traverse through the whole input list and also through the nested lists inside it
        for(NestedInteger element : nestedList){
            // #5. Check if the element is integer, if yes
            // Add it to the queue
            if(element.isInteger()){
                queue.add(element.getInteger());
            }
            else{
                // #6. If element is a list, call recursion on that list
                recurr(element.getList());
            }
        }
        
        
    }

}
