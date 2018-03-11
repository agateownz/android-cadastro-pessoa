package com.agateownz.testapplication.utility;

import android.database.sqlite.SQLiteOpenHelper;

import com.agateownz.testapplication.data.SQLiteDatabaseHelper;
import com.clough.android.androiddbviewer.ADBVApplication;

/**
 * Created by luisg on 04/03/2018.
 */

public class CustomApplication extends ADBVApplication {

    @Override
    public SQLiteOpenHelper getDataBase() {
        return new SQLiteDatabaseHelper(getApplicationContext());
    }
}
