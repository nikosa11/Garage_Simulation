package com.example.Garage.Service;

public class ValidationService {
	
	public static boolean isStringOnlyAlphabet(String name)
	{
	    return ((!name.equals(""))
	            && (name != null)
	            && (name.matches("^[a-zA-Z]*$")));
	}
	
	
	public static boolean isValid(String name)
	{
	    return isStringOnlyAlphabet(name);
	}
	

}
