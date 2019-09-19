package a2btree;

import java.io.Serializable;

/*
 * This class is used for creating object of each data record.
 * */

public class DataRecordObject implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rid;
	private String id;
	private String date;
	private String day;
	private String time;
	private String sensorID;
	private String sensorName;
	private String hourlyCounts;
	
	/*public DataRecordObject(){
		
	}
	
	public DataRecordObject(String rid, String id, String date, String day, String time, String sensorID, String sensorName, String hourlyCounts){
		this.rid = id;
		this.id = id;
		this.date = date;
		this.day = day;
		this.time = time;
		this.sensorID = sensorID;
		this.sensorName = sensorName;
		this.hourlyCounts = hourlyCounts;
		
	}*/
	
	public void setrid(String rid){
		this.rid = rid;
	}

	public void setid(String id){
		this.rid = id;
	}
	
	public void setdate(String date){
		this.date = date;
	}
	
	public void setday(String day){
		this.day = day;
	}
	
	public void settime(String time){
		this.time = time;
	}
	
	public void setsensorID(String setsensorID){
		this.sensorID = setsensorID;
	}
	
	public void setsensorName(String sensorName){
		this.sensorName = sensorName;
	}
	public void sethourlyCounts(String hourlyCounts){
		this.hourlyCounts = hourlyCounts;
	}
	public String getrid(){
		return rid;
	}
	
	public String getid(){
		return id;
	}
	
	public String getdate(){
		return date;
	}
	
	public String getday(){
		return day;
	}
	
	public String gettime(){
		return time;
	}
	
	public String getsensorID(){
		return sensorID;
	}
	
	public String getsensorName(){
		return sensorName;
	}
	
	public String gethourlyCounts(){
		return hourlyCounts;
	}
	
	
	public String toString(){
		return this.rid+this.id + this.date +this.day +this.time +this.sensorID + this.sensorName + this.hourlyCounts;
	}
	
	
}
