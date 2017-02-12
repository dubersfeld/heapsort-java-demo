package com.dub.site.heapsort;


import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a Heap Sort
 * the public methods should be called in this order:
 * heap = new Heap(values);
 * heap.build();
 * heap.heapSort();
 * then the list values should be sorted 
 */

public class Heap {
	
	private List<Integer> values = new ArrayList<>();
	
	private ArrayList<Integer> aux = new ArrayList<>();
	private ArrayList<Integer> auxSwap = new ArrayList<>();
	private ArrayList<Integer> auxOut = new ArrayList<>();
	
	private HeapSortResult results;
		
	private int mLength;
	private int mHeapSize;
	
	public Heap(List<Integer> values, HeapSortResult results) {
		this.values= values;
		this.mLength = values.size();// length
		this.mHeapSize = values.size();// initial heap size
		this.results = results;
		
		// initialize 
		for (int i = 0; i < mLength; i++) {
	        aux.add(i);
	        auxSwap.add(0);
	        auxOut.add(0);        
		}// for 
		System.out.println("Heap constructed");
	}// Heap
	

	/** helper methods */
	
	private int left(int i) { 
		return 2 * i + 1; 
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private void swap(int i, int j) {// swap aux[i] and aux[j], not i an j
		int temp = aux.get(i);
		aux.set(i, aux.get(j));
		aux.set(j, temp);

		System.out.println("swap " + i + ", " + j);
		 
		for (int k = 0; k < this.mLength; k++ ) {
			auxSwap.set(k, (k == i || k == j) ? 1 : 0);
		}	
	}
  
	private void maxHeapify(int i) {// non recursive implementation
		int j = i;
		int largest = i;

		System.out.println("maxHeapify begin");
		 
		while (true) {
			int l = this.left(j);
			int r = this.right(j);

			if ( (l < mHeapSize) && ( values.get(aux.get(l)) > values.get(aux.get(j))) ) {
				largest = l;
			} else {
				largest = j;
			}
			 
			if ( (r < mHeapSize) && ( values.get(aux.get(r)) > values.get(aux.get(largest))) ) {
				largest = r;
			}

			if (largest == j) {
				break; 
			} else {
				// one more iteration
	        	swap(j, largest);
	        	j = largest;
	        }

			// update all display lists
	        results.addResult(new ArrayList<Integer>(aux));
	        results.addSwap(new ArrayList<Integer>(auxSwap));
	        results.addOutnode(new ArrayList<Integer>(auxOut)); 	        
		}    
	}// maxHeapify
	    
	public void build() {
		for (int i = (int)Math.floor(this.mLength / 2) - 1; i >= 0; i--) {
			System.out.println("build for: " + i);
			maxHeapify(i);
		} 	
	}// build
	    
	public void heapSort() {   
		for (int i = mLength - 1; i >= 0; i--) {
			swap(0, i);
    
			// main function
			mHeapSize--;
			maxHeapify(0);

			for (int j = 0; j < mLength; j++) {
				auxOut.set(j, (j >= mHeapSize) ? 1 : 0);// mark nodes outside of the actual heap
			}     
	          
	        // used for animation only  
	        results.addResult(new ArrayList<Integer>(aux));
	        results.addSwap(new ArrayList<Integer>(auxSwap));
	        results.addOutnode(new ArrayList<Integer>(auxOut));    
		}          
	}// heapSort
	   
}
