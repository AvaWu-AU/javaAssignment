package a2btree;

import java.io.*;

//Please run this class to Demo project.
public class AppDemo {

	public static void main(String[] args) throws Exception{
		
		HeapFileSize1 loadDataBaseSize1 = new HeapFileSize1();
		HeapFileSize2 loadDataBaseSize2 = new HeapFileSize2();
		loadDataBaseSize1.loadData();
		loadDataBaseSize2.loadData();
		loadDataBaseSize1.printLog();
		loadDataBaseSize2.printLog2();
	}

}
