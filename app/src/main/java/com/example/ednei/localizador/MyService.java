package com.example.ednei.localizador;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        MyNotification.pushNotification(getApplicationContext(), "App", "App rodando.");
        new MyLocation(getApplicationContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}

