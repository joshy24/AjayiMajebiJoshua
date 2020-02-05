package com.epicteck.ajayimajebijoshua.utils;

import androidx.fragment.app.FragmentManager;

import com.epicteck.ajayimajebijoshua.fragments.LoadingFragment;

public class HandleLoading {
    public static LoadingFragment loadingFragment = LoadingFragment.getInstance("Please Wait...");

    public static void showLoading(FragmentManager fragmentManager){
        try{
            loadingFragment.showNow(fragmentManager, "loading_fragment");
        }
        catch(Exception e){

        }
    }

    public static void showLoading(FragmentManager fragmentManager, String text){
        try{
            loadingFragment.setText(text);
            loadingFragment.showNow(fragmentManager, "loading_fragment");
        }
        catch(Exception e){

        }
    }

    public static void hideLoading(){
        try{
            loadingFragment.dismiss();
        }
        catch (Exception e){

        }
    }

}
