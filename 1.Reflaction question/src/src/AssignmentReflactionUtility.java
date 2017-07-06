package src;
import java.lang.reflect.*;
import java.util.Collection;
import java.util.Iterator;

public class AssignmentReflactionUtility {

 
	private static boolean isPropertyIsPrimitive(Class<?> obj)
	{
		if(obj == boolean.class || obj == String.class || obj == int.class || obj == Integer.class || obj == double.class || obj == float.class)
			return true;
		return false;	
	}
	
	
	
	private static StringBuilder returnPrimitveSB(Field f,Object className,String prefix) throws ReflectiveOperationException{
		
		StringBuilder sb = new StringBuilder();
		
	    try {
	    	Object value =  f.get(className );
			sb.append(prefix+value.toString());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	    sb.append(prefix+"\n"); //append new line 
	    
		return sb;
	}
	
	public static StringBuilder ReturnStructObj(Object className,String prefix) throws ReflectiveOperationException{

		StringBuilder sb = new StringBuilder();
		sb.append(prefix+"Object of Class \""+className.getClass().getSimpleName()+"\"")
		.append(prefix+"\n----------------------------------------\n");
		
		 for (Field f : className.getClass().getFields()) { 
		   
			 sb.append(prefix+f.getName());
		     sb.append(prefix+" = ");
			    
		    //check if property primitive
		    if(isPropertyIsPrimitive(f.getType())){
		    	sb.append(returnPrimitveSB(f,className,prefix));
		    }
		    else{
//		    	if field is collection type 
		    	if (Collection.class.isAssignableFrom(f.getType())) {
		    		sb.append(ReturnStructObjCollection(f));
		    	}
//		    	if field is an array
		    	else if(f.getType().isArray()){
		    		sb.append(ReturnStructObjArray(f));
		    	}
		    	else{
			    	//recursion method:
		    		prefix+="\t";
		    		sb.append(prefix).append(ReturnStructObj(f.get(className),prefix)); 
		    	}
		    		
		    }

		  }
		
		return sb;

	}
	

	public static StringBuilder ReturnStructObjCollection(Object collectionField) throws ReflectiveOperationException{
		StringBuilder sb = new StringBuilder();
		
		Iterator<?> iterator = ((Collection<?>) collectionField).iterator();
		while(iterator.hasNext()){
		  Object item = iterator.next();
		  sb.append(ReturnStructObj(item,""));
		}
	 
		sb.append("\n");//new line
		return sb;
	}
	
	public static StringBuilder	ReturnStructObjArray(Object arrayField) throws ReflectiveOperationException{
		
		StringBuilder sb = new StringBuilder();
 
		//convert to array
		for(Object item : (Object[])arrayField){
			sb.append(ReturnStructObj(item,""));
		}
		
		sb.append("\n");//add new line
		return sb;
	}
	

}
