package it.ericsson.servlets;

public class Temporizzazione {
	private String start1;
	private String end1;
	private String start2;
	private String end2;
	private String start3;
	private String end3;
	private String start4;
	private String end4;
	
	public Temporizzazione(String s1, String e1, String s2, String e2, String s3, String e3, String s4, String e4) {
		this.start1 = s1;
		this.end1 = e1;
		this.start2 = s2;
		this.end2 = e2;
		this.start3 = s3;
		this.end3 = e3;
		this.start4 = s4;
		this.end4 = e4;
	}
	
	public Temporizzazione (){		
	}
	
	public void SetStart1 (String s){
		this.start1= s; 
	}

	public void SetEnd1 (String s){
		this.end1= s; 
	}

	public void SetStart2 (String s){
		this.start2= s; 
	}

	public void SetEnd2 (String s){
		this.end2= s; 
	}

	public void SetStart3 (String s){
		this.start3= s; 
	}

	public void SetEnd3 (String s){
		this.end3= s; 
	}

	public void SetStart4 (String s){
		this.start4= s; 
	}

	public void SetEnd4 (String s){
		this.end4= s; 
	}

	public String GetStart1(){
		return this.start1;
	}

	public String GetEnd1(){
		return this.end1;
	}
	public String GetStart2(){
		return this.start2;
	}

	public String GetEnd2(){
		return this.end2;
	}
	public String GetStart3(){
		return this.start3;
	}

	public String GetEnd3(){
		return this.end3;
	}
	public String GetStart4(){
		return this.start4;
	}

	public String GetEnd4(){
		return this.end4;
	}
}
