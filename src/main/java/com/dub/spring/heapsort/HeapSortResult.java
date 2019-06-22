package com.dub.spring.heapsort;


import java.util.ArrayList;
import java.util.List;

/**
 * This helper class is used for display only 
 */

public class HeapSortResult {

    private List<List<Integer>> results;
    private List<List<Integer>> swaps;
    private List<List<Integer>> outnodes;
    
    public HeapSortResult() {
    	 results = new ArrayList<>();
    	 swaps = new ArrayList<>();
    	 outnodes = new ArrayList<>();
    }
    
    
	public List<List<Integer>> getResults() {
		return results;
	}
	public void setResults(List<List<Integer>> results) {
		this.results = results;
	}
	public List<List<Integer>> getSwaps() {
		return swaps;
	}
	public void setSwaps(List<List<Integer>> swaps) {
		this.swaps = swaps;
	}
	public List<List<Integer>> getOutnodes() {
		return outnodes;
	}
	public void setOutnodes(List<List<Integer>> outnodes) {
		this.outnodes = outnodes;
	}
	
	// convenience methods
	
	void addResult(List<Integer> newResult) {
		results.add(newResult);
	}
	
	void addSwap(List<Integer> newSwap) {
		swaps.add(newSwap);
	}
	
	void addOutnode(List<Integer> newOutnode) {
		outnodes.add(newOutnode);
	}
}
