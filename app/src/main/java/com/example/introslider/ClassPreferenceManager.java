package com.example.introslider;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

public class ClassPreferenceManager
{
    private Context context;
    private SharedPreferences preferences;

    public ClassPreferenceManager(Context context) {
        this.context = context;
        getSharedPreference();
    }

    private void getSharedPreference()
    {
        preferences = context.getSharedPreferences(context.getString(R.string.my_preference), Context.MODE_PRIVATE);
    }

    public void writePreference()
    {
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(context.getString(R.string.my_preference_key), "INIT_OK");

        editor.commit();
    }

    public boolean checkPreference()
    {
        boolean status = false;

        if( preferences.getString( context.getString(R.string.my_preference_key), "INIT_OK" ).equals("null") )
        {
            status = false;
        }
        else
        {
            status = true;
        }

        return status;
    }

    public void clearPreference()
    {
        preferences.edit( ).clear().commit();
    }
}
