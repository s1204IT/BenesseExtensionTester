package me.s1204.benesse.touch.test;

import android.app.Activity;
import android.content.Intent;
import android.os.BenesseExtension;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Arrays;

public class Tester extends Activity implements View.OnClickListener {

    private static final String CT3 = "TAB-A03-BR3";
    private static final String CTX = "TAB-A05-BD";
    private static final String CTZ = "TAB-A05-BA1";

    private void makeText(String msg) {
        runOnUiThread(() -> Toast.makeText(this, msg, Toast.LENGTH_SHORT).show());
    }

    private void changeLayout(int layout, int btnId) {
        setContentView(layout);
        findViewById(btnId).setOnClickListener(this);
        findViewById(R.id.backHome).setOnClickListener(this);
    }

    private static final int[] FUNC_LIST = {
            R.id.btn_checkPassword,
            R.id.btn_checkUsbCam,
            R.id.btn_getBaseDisplaySize,
            R.id.btn_getDchaState,
            R.id.btn_getInitialDisplaySize,
            R.id.btn_getInt,
            R.id.btn_getLcdSize,
            R.id.btn_getString,
            R.id.btn_putInt,
            R.id.btn_putString,
            R.id.btn_setDchaState,
            R.id.btn_setForcedDisplaySize
    };

    private static final int[] NOFUNC_CT3 = {
            R.id.btn_getInt,
            R.id.btn_putInt,
            R.id.btn_putString
    };

    private static final int[] NOFUNC_CTX = {
            R.id.btn_checkUsbCam,
            R.id.btn_getBaseDisplaySize,
            R.id.btn_getInitialDisplaySize,
            R.id.btn_getLcdSize,
            R.id.btn_setForcedDisplaySize
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        switch (Build.MODEL) {
            case CT3:
                for (int resId : NOFUNC_CT3) findViewById(resId).setEnabled(false);
                break;
            case CTX:
            case CTZ:
                for (int resId : NOFUNC_CTX) findViewById(resId).setEnabled(false);
                if (Build.MODEL.equals(CTX)) findViewById(R.id.btn_putString).setEnabled(false);
                break;
            default:
                makeText("この端末はサポートされていません");
                break;
        }
        for (int resId: FUNC_LIST) findViewById(resId).setOnClickListener(this);
    }

    @Override
    public void onClick(@NonNull final View v) {
        final int resId = v.getId();
        try {
            if (resId == R.id.backHome) {
                //noinspection deprecation
                onBackPressed();
            } else if (resId == R.id.btn_checkPassword) {
                changeLayout(R.layout.layout_checkpassword, R.id.exec_checkPassword);
            } else if (resId == R.id.exec_checkPassword) {
                EditText passwordBox = findViewById(R.id.passwordText);
                String password = passwordBox.getText().toString();
                makeText("checkPassword：" + BenesseExtension.checkPassword(password));
            } else if (resId == R.id.btn_checkUsbCam) {
                makeText("checkUsbCam：" + BenesseExtension.checkUsbCam());
            } else if (resId == R.id.btn_getBaseDisplaySize) {
                makeText("getBaseDisplaySize：" + BenesseExtension.getBaseDisplaySize());
            } else if (resId == R.id.btn_getDchaState) {
                makeText("getDchaState：" + BenesseExtension.getDchaState());
            } else if (resId == R.id.btn_getInitialDisplaySize) {
                makeText("getInitialDisplaySize：" + BenesseExtension.getInitialDisplaySize());
            } else if (resId == R.id.btn_getInt) {
                changeLayout(R.layout.layout_getint, R.id.exec_getInt);
            } else if (resId == R.id.exec_getInt) {
                String name = ((Spinner) findViewById(R.id.name_getInt)).getSelectedItem().toString();
                makeText(((Spinner) findViewById(R.id.name_getInt)).getSelectedItem().toString().isEmpty() ? "値を入力してください" : "getInt：" + BenesseExtension.getInt(name));
            } else if (resId == R.id.btn_getLcdSize) {
                makeText("getLcdSize：" + BenesseExtension.getLcdSize());
            } else if (resId == R.id.btn_getString) {
                changeLayout(R.layout.layout_getstring, R.id.exec_getString);
            } else if (resId == R.id.exec_getString) {
                String name = ((Spinner) findViewById(R.id.name_getString)).getSelectedItem().toString();
                makeText(name.isEmpty() ? "値を入力してください" : "getString：" + BenesseExtension.getString(name));
            } else if (resId == R.id.btn_putInt) {
                changeLayout(R.layout.layout_putint, R.id.exec_putInt);
            } else if (resId == R.id.exec_putInt) {
                String name = ((Spinner) findViewById(R.id.name_putInt)).getSelectedItem().toString();
                // TODO: NumberFormatException のバグ修正
                String value = findViewById(R.id.value_putInt).toString().trim();
                makeText(value);
                //makeText(value.isEmpty() ? "値を入力してください" : "putInt：" + BenesseExtension.putInt(name, Integer.parseInt(value)));
            } else if (resId == R.id.btn_putString) {
                changeLayout(R.layout.layout_putstring, R.id.exec_putString);
            } else if (resId == R.id.exec_putString) {
                String name = ((Spinner) findViewById(R.id.name_putString)).getSelectedItem().toString();
                String value = (findViewById(R.id.value_putString)).toString();
                makeText(value.isEmpty() ? "値を入力してください" : "putString：" + BenesseExtension.putString(name, value));
            } else if (resId == R.id.btn_setDchaState) {
                changeLayout(R.layout.layout_setdchastate, R.id.setDchaState_0);
                Arrays.asList(R.id.setDchaState_1, R.id.setDchaState_2, R.id.setDchaState_3)
                        .forEach(btnId -> findViewById(btnId).setOnClickListener(this));
            } else if (resId == R.id.setDchaState_0) {
                BenesseExtension.setDchaState(0);
            } else if (resId == R.id.setDchaState_1) {
                BenesseExtension.setDchaState(1);
            } else if (resId == R.id.setDchaState_2) {
                BenesseExtension.setDchaState(2);
            } else if (resId == R.id.setDchaState_3) {
                BenesseExtension.setDchaState(3);
            } else if (resId == R.id.btn_setForcedDisplaySize) {
                changeLayout(R.layout.layout_setforceddisplaysize, R.id.exec_setForcedDisplaySize);
            } else if (resId ==R.id.exec_setForcedDisplaySize) {
                String width = ((EditText) findViewById(R.id.width)).getText().toString();
                String height = ((EditText) findViewById(R.id.height)).getText().toString();
                makeText(width.isEmpty() || height.isEmpty() ? "値を入力してください" : "setForcedDisplaySize：" + BenesseExtension.setForcedDisplaySize(Integer.parseInt(width), Integer.parseInt(height)));
            }
        } catch (NoClassDefFoundError ignored) {
            makeText("BenesseExtension が存在しません");
            finish();
        } catch (NoSuchMethodError ignored) {
            makeText("関数が存在しません");
        } catch (SecurityException ignored) {
            makeText("関数の実行に失敗しました");
        } catch (NumberFormatException ignored) {
            makeText("数値のフォーマットが一致しません");
        }
    }

    /** @noinspection DeprecatedIsStillUsed*/
    @Override
    @Deprecated
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_DEFAULT)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                .setPackage(getPackageName()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int itemId = item.getItemId();
        if (itemId == R.id.menu_about) {
            setContentView(R.layout.about);
            return true;
        } else if (itemId == R.id.menu_settings) {
            startActivity(new Intent(Settings.ACTION_SETTINGS));
            return true;
        } else if (itemId == R.id.menu_devopts) {
            startActivity(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
