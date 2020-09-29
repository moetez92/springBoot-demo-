package com.example.PolitischeRedenV1.enities;

public class Rede {
	
	
   Long id ;
   String redner,thema,datum,worter ;
   
   public Rede() {
	 
}
  
   public Rede(String redner , String thema , String datum, String worter) {
	   
	   this.redner=redner;
	   this.thema=thema ; 
	   this.datum=datum ;
	   this.worter=worter ;
		 
}
   public Rede(String [] line) {
	   
	   this.redner=line[0];
	   this.thema=line[1];
	   this.datum=line[2];
	   this.worter=line[3];
		 
}

public String getRedner() {
	return redner;
}

public void setRedner(String redner) {
	this.redner = redner;
}

public String getThema() {
	return thema;
}

public void setThema(String thema) {
	this.thema = thema;
}

public String getDatum() {
	return datum;
}

public void setDatum(String datum) {
	this.datum = datum;
}

public String getWorter() {
	return worter;
}

public void setWorter(String worter) {
	this.worter = worter;
}
    
   
 @Override
	public String toString() {
		 
	 return "xxx  "+this.redner;
	}
   
   
   
}
