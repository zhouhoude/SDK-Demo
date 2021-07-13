package com.sx.app;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sxsdk.collection.CollectionManager;
import com.sxsdk.collection.callback.InfoCallBack;

public class MainActivity extends AppCompatActivity {

    private String[] permissions = {Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS, Manifest.permission.READ_CALENDAR, Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, 1001);
        }
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CollectionManager.getAppInfoList(MainActivity.this, new InfoCallBack() {
                    @Override
                    public void result(String info) {
                        Log.e("CollectionManager", "AppInfo:"+info);
                    }
                });
                CollectionManager.getSmsInfoList(MainActivity.this, new InfoCallBack() {
                    @Override
                    public void result(String info) {
                        Log.e("CollectionManager", "SmsInfo:"+info);
                    }
                });
                CollectionManager.getLocationInfo(MainActivity.this, new InfoCallBack() {
                    @Override
                    public void result(String info) {
                        Log.e("CollectionManager", "Location:"+info);
                    }
                });
                CollectionManager.getAllContacts(MainActivity.this, new InfoCallBack() {
                    @Override
                    public void result(String info) {
                        Log.e("CollectionManager", "Contacts:"+info);
                    }
                });
                CollectionManager.getCalendarInfo(MainActivity.this, new InfoCallBack() {
                    @Override
                    public void result(String info) {
                        Log.e("CollectionManager", "Calendar:"+info);
                    }
                });
                CollectionManager.getDeviceInfo(MainActivity.this, new InfoCallBack() {
                    @Override
                    public void result(String info) {
                        Log.e("CollectionManager", "DeviceInfo:"+info);
                    }
                });
            }
        });
    }
}
