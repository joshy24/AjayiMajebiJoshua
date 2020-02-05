package com.epicteck.ajayimajebijoshua.fragments;


import android.app.Dialog;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.epicteck.ajayimajebijoshua.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoadingFragment extends DialogFragment {

    @BindView(R.id.loading_text)
    TextView loading_text;

    public LoadingFragment() {
        // Required empty public constructor
    }

    public static LoadingFragment getInstance(String text){
        LoadingFragment loadingFragment = new LoadingFragment();

        Bundle b = new Bundle();
        b.putString("text", text);

        loadingFragment.setArguments(b);

        return loadingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loading, container, false);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ButterKnife.bind(this,view);

        String text = getArguments().getString("text", "");

        gifView.setImageResource(R.drawable.loader1);

        loading_text.setText(text);

        setCancelable(false);

        return view;
    }*/

    public void setText(String text){
        try{
            loading_text.setText(text);
        }
        catch(Exception e){

        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.fragment_loading, null);

        ButterKnife.bind(this,view);

        String text = getArguments().getString("text", "");

        loading_text.setText(text);

        builder.setCancelable(false);
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view);

        return builder.create();
    }

    @Override
    public void onResume() {
        Window window = getDialog().getWindow();

        window.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.transparent_background));

        Point size = new Point();

        // Store dimensions of the screen in `size`

        Display display = window.getWindowManager().getDefaultDisplay();

        display.getSize(size);

        // Set the width of the dialog proportional to 75% of the screen width

        window.setLayout((int) (size.x * 0.90), WindowManager.LayoutParams.WRAP_CONTENT);

        window.setGravity(Gravity.CENTER);

        super.onResume();
    }

}
