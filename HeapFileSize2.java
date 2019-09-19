package a2btree;
import java.util.*;
import java.io.*;
import java.util.ArrayList; 
import java.util.List;


/*
 * *This class is created to load the data in to the DataBase object and insert into pages. The Size of each page is 8192 bytes
 */

public class HeapFileSize2{
	Scanner scan = new Scanner(System.in);
	private long startTime;
	private long endTime;
	private int numOfRecords2;
private int totalPage;
	

	public void loadData() throws Exception{
		System.out.println("Please enter the path of the data file for inserting into page size of 8192 bytes: \n(assign2.csv file is submitted in the same folder with this project)");
		String fileName =scan.nextLine(); 
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		List<DataRecordObject> database = new ArrayList<DataRecordObject>();
		
		
		
		try{
			br = new BufferedReader(new FileReader(fileName));  /* data file in any computer can be used for test. test data file:assign2.csv */
			while((line= br.readLine())!=null){
				
				String[] data = line.split(csvSplitBy);
				
				DataRecordObject dataObject = new DataRecordObject();
				
				//add values from data file to data object
				
				dataObject.setrid(data[0]);
				dataObject.setid(data[1]);
				dataObject.setdate(data[2]);
				dataObject.setday(data[3]);
				dataObject.settime(data[4]);
				dataObject.setsensorID(data[5]);
				dataObject.setsensorName(data[6]);
				dataObject.sethourlyCounts(data[7]);
				
				//add data record to a list
				database.add(dataObject);
				numOfRecords2++;
				//pages.getDataList().add(dataObject);
		
				//pagesList.add(pages);

				//System.out.println(pages.getDataList());
			}
		}
			
			//print all the values stored in the list of data
			//printDataList(database);
			
		
		catch (FileNotFoundException e){
			e.printStackTrace();
			
		}
		catch (IOException e){
			e.printStackTrace();
			
		}
		finally {
			if(br !=null){
				try{
					br.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
			}
			
		}

		
		/*
		 * In the page size of 8192 bytes, each record is insert into each row of the page, and the fixed length for each 
		 * record is approximately 120 bytes. Therefore, each page can store 55 records and 32617 pages are needed for total 
		 * number of 1793913 records
		 * 
		 * */
		startTime=System.currentTimeMillis(); //record the start time of loading data time.
		
		Page<DataRecordObject> paper = new Page<DataRecordObject>(database,55);
		totalPage = paper.getPageCount();
		/*for(int i=1; i<=totalPage; i++){
			List<DataRecordObject> page = paper.getPagedList(i);
			//System.out.println(page);
		}*/
		
		File writeName = new File("8192.txt");
		writeName.createNewFile();
		FileOutputStream fos = new FileOutputStream(writeName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(paper);
		oos.flush();
		oos.close();
		
		endTime = System.currentTimeMillis(); //record the end time of loading data time
		
		//System.out.println(pagesList);
	}
	
	public void printDataList(List<DataRecordObject> dataListToPrint){
		
		for(int i=0; i< dataListToPrint.size(); i++){
			System.out.println(((DataRecordObject) dataListToPrint.get(i)).getrid()  + ((DataRecordObject) dataListToPrint.get(i)).getid() + ((DataRecordObject) dataListToPrint.get(i)).getdate()  + ((DataRecordObject) dataListToPrint.get(i)).getday()
					 + ((DataRecordObject) dataListToPrint.get(i)).gettime() + ((DataRecordObject) dataListToPrint.get(i)).getsensorID() + ((DataRecordObject) dataListToPrint.get(i)).getsensorName()
					 + ((DataRecordObject) dataListToPrint.get(i)).gethourlyCounts());
			
		}
		
	}

	//Print out execution details.
	 public void printLog2(){
		 	System.out.println("Total inserted "+ numOfRecords2 +" records into the pages which page size is 8192 bytes");
		 	System.out.println("Total page number in this file with page size of 8192 bytes is "+totalPage);
			System.out.println("Total time for building heap file with page size 8192 bytes is： "+(endTime-startTime)+" milliseconds"); 
			
	 }


}
