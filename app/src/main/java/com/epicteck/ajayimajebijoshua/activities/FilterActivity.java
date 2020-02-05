package com.epicteck.ajayimajebijoshua.activities;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.epicteck.ajayimajebijoshua.R;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.InputStream;

import butterknife.ButterKnife;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        setContentView(R.layout.activity_filter);

        ButterKnife.bind(this);

        try{
            InputStream myInput;

            AssetManager assetManager = getAssets();

            myInput = assetManager.open("/venten/car_ownsers_data.csv");

            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            HSSFSheet mySheet = myWorkBook.getSheetAt(0);


        }
        catch(Exception e){
            Toast.makeText(this, R.string.file_not_found_error, Toast.LENGTH_SHORT).show();
        }
    }
}
