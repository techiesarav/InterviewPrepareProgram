import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class TracXnInterview {

   private static String addResult(String cFatAndFiber,
    String cFatAndCarb,
    String cFiberAndCarb){
        if(cFatAndCarb.equals("1") ||
            cFatAndFiber.equals("1") ||
            cFiberAndCarb.equals("1")){
                return "1";
            }else{
                return "0";
            }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<String> fiberClist = new ArrayList<>();
        List<String> fatClist = new ArrayList<>();
        List<String> carbClist = new ArrayList<>();
        StringBuilder s = new StringBuilder("");
        int numberOfDays = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] ingredients = new String[numberOfDays];
        ingredients = in.nextLine().split(" ");
        for(String ingredient : ingredients){
            if(ingredient.contains("FAT")){
                fatClist.add(ingredient);
            }else if(ingredient.contains("FIBER")){
                fiberClist.add(ingredient);
            }else if(ingredient.contains("CARB")){
                carbClist.add(ingredient);
            }
    
        String cFatAndFiber = checkFatAndFiber(fatClist,
         fiberClist);
        String cFatAndCarb =  checkFatAndCarb(fatClist,
        carbClist);
        String cFiberAndCarb = checkFiberAndCarb(fiberClist,
        carbClist);
        s.append(addResult(cFatAndFiber,cFatAndCarb,cFiberAndCarb)); 
        }
        System.out.println(s);
    }

    private static String checkFatAndFiber(List<String> fatList,List<String> fiberList){
        if(fatList.size() >=2 && fiberList.size() >=1){
        	if(fatList.size() >2) {
        		 fatList.remove(0);
                 fatList.remove(0);
                 fatList.remove(0);
        	}else {
        		 fatList.remove(0);
                 fatList.remove(0);
                 fiberList.remove(0);
        	}
            return "1";
         }else if(fatList.size() >=1 && fiberList.size() >=2){
        	if(fiberList.size() >2) {
        		fiberList.remove(0);
                fiberList.remove(0);
                fiberList.remove(0);
        	}else {
        		fatList.remove(0);
                fiberList.remove(0);
                fiberList.remove(0);        		
        	} 
            return "1";
         }else{
             return "";
         }
    }

    private static String checkFatAndCarb(List<String> fatList,List<String> carbList){
         if(fatList.size() >=2 && carbList.size() >=1){
        	if(fatList.size() >2) {
        		fatList.remove(0);
                fatList.remove(0);
                fatList.remove(0);	
        	}else {
        		fatList.remove(0);
                fatList.remove(0);
                carbList.remove(0);	
        	}
            return "1";
         }else if(fatList.size() >=1 && carbList.size() >=2){
        	if(carbList.size() >2) {
        		carbList.remove(0);
                carbList.remove(0);
                carbList.remove(0);
        	}else {
        		fatList.remove(0);
                carbList.remove(0);
                carbList.remove(0);	
        	}
            return "1";
         }else{
             return "";
         }
    }

    private static String  checkFiberAndCarb(List<String> fiberList,List<String> carbList){
         if(fiberList.size() >=2 && carbList.size() >=1){
            fiberList.remove(0);
            carbList.remove(0);
            fiberList.remove(0);
            return "1";
         }else if(fiberList.size() >=1 && carbList.size() >=2){
            fiberList.remove(0);
            carbList.remove(0);
            carbList.remove(0);
            return "1";
         }else{
             return "";
         }
    }
}