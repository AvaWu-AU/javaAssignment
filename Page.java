package a2btree;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Page<T> implements Serializable{

	private static final long serialVersionUID = 1L;

		/**
	     * Define number of records in each page.
	     */
	    private int pageSize;
	     
	    /**
	     * Total number of pages
	     */
	    private int totalPageNum;
	     
	    /**
	     * Database
	     */
	    private List<T> data;
	 
	    public Page(List<T> data, int pageSize) {
	        if (data == null || data.isEmpty()) {
	            throw new IllegalArgumentException("Data is not exit!");
	        }
	 
	        this.data = data;
	        this.pageSize = pageSize;
	        this.totalPageNum = data.size()/pageSize;
	        if(data.size()%pageSize!=0){
	            this.totalPageNum++;
	        }
	    }
	 
	    public List<T> getPagedList(int pageNum) {
	        int fromIndex = (pageNum - 1) * pageSize;
	        if (fromIndex >= data.size()) {
	            return Collections.emptyList();
	        }
	 
	        int toIndex = pageNum * pageSize;
	        if (toIndex >= data.size()) {
	            toIndex = data.size();
	        }
	        return data.subList(fromIndex, toIndex);
	    }
	 
	    public int getPageSize() {
	        return pageSize;
	    }
	 
	    public List<T> getData() {
	        return data;
	    }
	 
	    public int getPageCount() {
	        return totalPageNum;
	    }
	
}
