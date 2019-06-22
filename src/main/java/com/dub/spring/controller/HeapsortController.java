package com.dub.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dub.spring.heapsort.Heap;
import com.dub.spring.heapsort.HeapSortResult;


@Controller
public class HeapsortController {
	
	@RequestMapping(value="heapsort")
	public String heapsort() {
		return "heapsort/heapSort";
	}
	
	@RequestMapping(value="sort", method=RequestMethod.POST)
	@ResponseBody
	public  HeapSortResult sort(@RequestBody List<Integer> values) {
			
		HeapSortResult results = new HeapSortResult();
		
		Heap heap = new Heap(values, results);
		
		heap.build();
			
		heap.heapSort();
		
		return results;
	}
	
}
