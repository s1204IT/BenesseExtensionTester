package me.s1204.benesse.touch.test;

import android.app.Activity;
import android.os.Bundle;

public class About extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }
    @Override
    @Deprecated
    public void onBackPressed() {
        finish();
    }
}
