package me.s1204.benesse.touch.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.sts.tottori.extension.BenesseExtension;

public class StsTester extends Activity {


    private void makeText(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void noClassFound(@NonNull NoClassDefFoundError ignored) {
        makeText("StsExtensionService が存在しません");
        finishAndRemoveTask();
    }

    private void reflective(@NonNull ReflectiveOperationException ignored) {
        makeText("ReflectiveOperationException");
    }

    private void backHome() {
        finish();
        startActivity(new Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_DEFAULT)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                .setClassName(getPackageName(), getClass().getName()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sts);

        // getLcdSize
        findViewById(R.id.btn_getLcdSize).setOnClickListener(view -> {
            try {
                makeText("getLcdSize：" + BenesseExtension.getLcdSize());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
            } catch (ReflectiveOperationException e) {
                reflective(e);
            }
        });

        // setForcedDisplaySize(int, int)
        findViewById(R.id.btn_setForcedDisplaySize).setOnClickListener(view -> {
            setContentView(R.layout.layout_setforceddisplaysize);
            findViewById(R.id.exec).setOnClickListener(view15 -> {
                EditText widthBox = findViewById(R.id.setForcedDisplaySize_width);
                EditText heightBox = findViewById(R.id.setForcedDisplaySize_height);
                String width = widthBox.getText().toString();
                String height = heightBox.getText().toString();
                if (width.isEmpty() || height.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.setForcedDisplaySize(Integer.parseInt(width), Integer.parseInt(height)));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (ReflectiveOperationException e) {
                    reflective(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view16 -> backHome());
        });
    }

    @Override
    @Deprecated
    public void onBackPressed() {
        super.onBackPressed();
        backHome();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_sts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int itemId = item.getItemId();
        if (itemId == R.id.menu_disable) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(this, getClass().getName()), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
            finishAndRemoveTask();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
