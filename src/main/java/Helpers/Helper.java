package Helpers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.PolitischeRedenV1.enities.Rede;
public class Helper {
	
	//  This is a function to convert the csv file to an array of Rede
	 
	public static  ArrayList<Rede> convert(String url) throws FileNotFoundException, IOException {
		String delimiter ="," ;
		
		  ArrayList<Rede> records = new ArrayList<Rede>();
		  
		  
		  
		  try (BufferedReader br = new BufferedReader(new FileReader(url))) {
			    String line;
			    while ((line = br.readLine()) != null) {
			    	System.out.println(line);
			        String[] values = line.split(delimiter);
			       
		          records.add(new Rede(values));
			        
			    }
			}
		  return records ;
	}	
	 
	// this a function to find  Politiker , der insgesamt die wenigsten Wörter sprach 
	
	public static  Rede minWords(ArrayList list) {
	    Rede r = new Rede();
		Stream stream = list.stream()
				   .sorted((a,b)-> Integer.compare
				   (Integer.parseInt(((Rede) a).getWorter()), Integer.parseInt(((Rede) b).getWorter())));
		
	  List<Rede> liste = (List<Rede>) stream.collect(Collectors.toList());
	  ArrayList<Rede> array = new ArrayList<Rede>(liste) ;
		return  array.get(0);
	}
	
	// this a function  construct a map from the csv where the key is the name and the value is
	// presents the number of time he spoke  about inner Sicherheit
	public static Map<String,Integer>  mostSpoken (ArrayList<Rede> list,String filter) {
		
		List l = list.stream()
				     .filter(rede -> rede.getThema().contains(filter))
				     .collect(Collectors.toList()) ;
    ArrayList<Rede> array = new ArrayList<Rede>(l) ;
    
    Map<String,Integer> map = new HashMap<String,Integer>();
	
	for(Rede a:array) {
		
		
		if (!map.containsKey(a.getRedner())) {map.put(a.getRedner(),1) ;}
		else map.computeIfPresent(a.getRedner(),(k, v) -> v + 1) ;
		
	}
	
	if (map.size()==0) {map.put("nothing", -1);}

	 return map ;
	 
	}
  
	
public static Map<String,Integer>  mostSpoken2013 (ArrayList<Rede> list,String filter) {
		
		List l = list.stream()
				     .filter(rede -> rede.getDatum().contains(filter))
				     .collect(Collectors.toList()) ;
    ArrayList<Rede> array = new ArrayList<Rede>(l) ;
    
    Map<String,Integer> map = new HashMap<String,Integer>();
	
	for(Rede a:array) {
		
		
		if (!map.containsKey(a.getRedner())) {map.put(a.getRedner(),1) ;}
		else map.computeIfPresent(a.getRedner(),(k, v) -> v + 1) ;
		
	}
	
	if (map.size()==0) {map.put("nothing", -1);}

	 return map ;
	 
	}
  
	
	
	
	   // this a function  to find the maximum of time a person has spoken about Inner Sicherheit
		 
	public static <String, Integer extends Comparable<Integer>> Integer max(Map<String,Integer> map) {
	    Map.Entry<String, Integer> maxEntry = null;
	    for (Map.Entry<String, Integer> entry : map.entrySet()) {
	        if (maxEntry == null || entry.getValue()
	            .compareTo(maxEntry.getValue()) > 0) {
	            maxEntry = entry;
	        }
	    }
	    return maxEntry.getValue();
	}
 
	// this function return an array that contains the persons who spoke the most about inner Sicherheit
	// that means the keys of the map where values is the maximum
	public static ArrayList<String> mostfinal( Map<String,Integer> map , int max ) {
		
	List <String> result = new ArrayList<String>();
	
	for (Map.Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getValue() == max) {result.add(entry.getKey());}
               }
 
 
	
	return (ArrayList) result ;
		
		
		
	}
		
 
	public static String responseSecurity(ArrayList list,String filter) {

		
		Map<String,Integer>  map = mostSpoken(list, filter);
		int maxx = max(map);
		ArrayList array= mostfinal(map, maxx);
		String[] arr = (java.lang.String[]) array.toArray(new String[0]);
		
		return(arr[0]);
	}
	
	
public static String response2013(ArrayList list,String filter) {

		
		Map<String,Integer>  map = mostSpoken2013(list, filter);
		int maxx = max(map);
		ArrayList array= mostfinal(map, maxx);
		String[] arr = (java.lang.String[]) array.toArray(new String[0]);
		
		return(arr[0]);
	}
 }