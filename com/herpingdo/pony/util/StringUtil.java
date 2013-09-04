package com.herpingdo.pony.util;

public class StringUtil {
    
	private static StringUtil instance = new StringUtil();
    
	public static StringUtil getInstance() {
		return instance;
	}
    public String[] popStringArr(String[] array, int str) {
        String[] tmp = new String[array.length - str];
        int count = 0;
        for (int i = str; i < array.length; i++) {
            tmp[count] = array[i];
            count++;
        }
        return tmp;
    }
	
    public String popString(String[] array, int sta) {
    	return combine(popStringArr(array, sta), " ");
    }
    
    public String combine(String[] stuff, String glue) {
    	String returnable = "";
    	for (String s : stuff) {
    		returnable += glue + s;
    	}
    	return returnable.substring(1);
    }
    
    public boolean matchAny(String in, String...strings) {
    	for (String s : strings) {
    		if (!s.equalsIgnoreCase(in)) return false;
    	}
    	return true;
    }
    
    public String commafy(Object...objects) {
    	String ret = "";
    	for (Object o : objects) {
    		String s = o.toString();
    		if (s.equalsIgnoreCase(objects[objects.length - 1].toString())) {
    			ret += s + ".";
    			break;
    		}
    		ret += s + ", ";
    	}
    	return ret;
    }
    
    public String[] toStringArr(Object[] objects) {
	    String[] ret = new String[objects.length];
  		for (int i = 0; i < objects.length; i++) {
  			ret[i] = objects[i].toString();
  		}
  		return ret;
  	}
}
