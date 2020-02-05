package com.epicteck.ajayimajebijoshua.utils;

/**
 * Created by Josh on 11/18/2016.
 */

public class StringUtil {

    public static String toAllLowerCase(String input){
        if(input.length()<=0){
            return "";
        }

        String new_input = input.replace(" ", "");

        return new_input.toLowerCase();
    }

    public static String toFirstUpper(String input){
        StringBuilder new_string = new StringBuilder();

        if(input.length()<=0){
            return "";
        }
        else{
            for(int i=0;i<input.length();i++){
                if(i==0){
                    new_string.append(Character.toUpperCase(input.charAt(0)));
                }
                else{
                    new_string.append(input.charAt(i));
                }
            }
            return new_string.toString();
        }
    }

    public static String getFormattedAmount(int amount){
        String string = Integer.toString(amount);

        switch(string.length()){
            case 3:
                return "₦"+string;
            case 4:
                return "₦"+string.charAt(0)+","+string.substring(1);
            case 5:
                return "₦"+string.substring(0,2)+","+string.substring(2);
            case 6:
                return "₦"+string.substring(0,3)+","+string.substring(3);
            case 7:
                return "₦"+string.charAt(0)+","+string.substring(1,4)+","+string.substring(4);
            case 8:
                return "₦"+string.substring(0,2)+","+string.substring(2,5)+","+string.substring(5);
            case 9:
                return "₦"+string.substring(0,3)+","+string.substring(3,6)+","+string.substring(6);
        }

        return "";
    }
}
