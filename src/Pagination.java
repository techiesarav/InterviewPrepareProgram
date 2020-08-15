import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class nameComp implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}
	
	
}

class relavanceComp implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		// TODO Auto-generated method stub
		return o1.relavance -o2.relavance;
	}
	
}


class priceComp implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		// TODO Auto-generated method stub
		return o1.price - o2.price;
	}
	
}


   

class Item{
	String name;
	int relavance;
	int price;
	
	Item(String name,int relevance,int price){
		this.name = name;
		this.relavance = relevance;
		this.price = price;
	}
}
public class Pagination {
	
	 public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
		 int n = items.size();
		 List<Item> itemList = new ArrayList<>();
		 List<String> result = new ArrayList<>();
		 nameComp nmCom = new nameComp();
		 relavanceComp relCom = new relavanceComp();
		 priceComp priCom = new priceComp();
		 for(int i=0;i<n;i++) {
			 List<String> item = items.get(i);
			 Item it = new Item(item.get(0),Integer.parseInt(item.get(1)),Integer.parseInt(item.get(2)));
			 itemList.add(it);
		 }
		 if(sortParameter ==0) {
			itemList = itemList.stream().sorted(nmCom).collect(Collectors.toList());
		 }else if(sortParameter ==1) {
			 itemList = itemList.stream().sorted(relCom).collect(Collectors.toList());
		 }else if(sortParameter ==2) {
			 itemList = itemList.stream().sorted(priCom).collect(Collectors.toList());
		 }
		 if(sortOrder !=0) {
			 Collections.reverse(itemList);
		 }
		 int noOfPages = n/itemsPerPage;
		 for(int i=0;i<noOfPages;i++) {
			 if(i == pageNumber) {
				 int o = itemsPerPage;
				 int j=i+o-1;
				 while(o>0) {
					 result.add(itemList.get(j).name);
					 j++;
					 o--;
				 }
			 }
		 }
		 return result;
     }
	 
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\rr.txt"));

        int arraySize = Integer.parseInt(bufferedReader.readLine().trim());
        int itemVal = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<String>> items = new ArrayList<>();
        for(int i=0;i<arraySize;i++) {
        	List<String> item = new ArrayList<>();
        	String str[] = null;
        	try {
        		 str =bufferedReader.readLine().split(" ");                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        	for(int j=0;j<itemVal;j++) {
        		item.add(str[j]);
             }
        	items.add(item);
        }

        int sortParameter = Integer.parseInt(bufferedReader.readLine().trim());
        int sortOrder = Integer.parseInt(bufferedReader.readLine().trim());
        int noOfItemsPerPage = Integer.parseInt(bufferedReader.readLine().trim());
        int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());
       List<String> result= fetchItemsToDisplay(items,sortParameter,sortOrder,noOfItemsPerPage,pageNumber);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
