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

import java.util.Arrays;

public class Tester extends Activity implements View.OnClickListener {

    private static final String CT3 = "TAB-A03-BR3";
    private static final String CTX = "TAB-A05-BD";
    private static final String CTZ = "TAB-A05-BA1";

    private void makeText(String msg) {
        runOnUiThread(() -> Toast.makeText(this, msg, Toast.LENGTH_SHORT).show());
    }

    private void setOnClickListener(int resId) {
        findViewById(resId).setOnClickListener(this);
    }

    private void changeLayout(int layout, int btnId) {
        setContentView(layout);
        findViewById(btnId).setOnClickListener(this);
        findViewById(R.id.backHome).setOnClickListener(this);
    }

    private String getBoxText(int resId) {
        return ((EditText) findViewById(resId)).getText().toString();
    }

    private String getPullText(int resId) {
        return ((Spinner) findViewById(resId)).getSelectedItem().toString();
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        switch (Build.MODEL) {
            case CT3:
                for (int resId : NOFUNC_CT3) findViewById(resId).setEnabled(false);
                break;
            case CTX:
            case CTZ:
                for (int resId : NOFUNC_CTX) findViewById(resId).setEnabled(false);
                break;
            default:
                makeText("この端末はサポートされていません");
                break;
        }
        for (int resId: FUNC_LIST) setOnClickListener(resId);
    }

    @Override
    public void onClick(final View v) {
        final int resId = v.getId();
        try {
            if (resId == R.id.backHome) {
                //noinspection deprecation
                onBackPressed();
            } else if (resId == R.id.btn_checkPassword) {
                changeLayout(R.layout.layout_checkpassword, R.id.exec_checkPassword);
            } else if (resId == R.id.exec_checkPassword) {
                String passwordText = getBoxText(R.id.passwordText);
                makeText("checkPassword：" + BenesseExtension.checkPassword(passwordText));
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
                String name = getPullText(R.id.name_getInt);
                makeText(name.isEmpty() ? "値を入力してください" : "getInt：" + BenesseExtension.getInt(name));
            } else if (resId == R.id.btn_getLcdSize) {
                makeText("getLcdSize：" + BenesseExtension.getLcdSize());
            } else if (resId == R.id.btn_getString) {
                changeLayout(R.layout.layout_getstring, R.id.exec_getString);
            } else if (resId == R.id.exec_getString) {
                String name = getPullText(R.id.name_getString);
                makeText(name.isEmpty() ? "値を入力してください" : "getString：" + BenesseExtension.getString(name));
            } else if (resId == R.id.btn_putInt) {
                changeLayout(R.layout.layout_putint, R.id.exec_putInt);
            } else if (resId == R.id.exec_putInt) {
                String name = getPullText(R.id.name_putInt);
                String value = getBoxText(R.id.value_putInt);
                makeText(value.isEmpty() ? "値を入力してください" : "putInt：" + BenesseExtension.putInt(name, Integer.parseInt(value)));
            } else if (resId == R.id.btn_putString) {
                changeLayout(R.layout.layout_putstring, R.id.exec_putString);
            } else if (resId == R.id.exec_putString) {
                String name = getPullText(R.id.name_putString);
                String value = getBoxText(R.id.value_putString);
                makeText(value.isEmpty() ? "値を入力してください" : "putString：" + BenesseExtension.putString(name, value));
            } else if (resId == R.id.btn_setDchaState) {
                changeLayout(R.layout.layout_setdchastate, R.id.setDchaState_0);
                Arrays.asList(R.id.setDchaState_1, R.id.setDchaState_2, R.id.setDchaState_3)
                        .forEach(this::setOnClickListener);
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
                String width = getBoxText(R.id.width);
                String height = getBoxText(R.id.height);
                makeText(width.isEmpty() || height.isEmpty() ? "値を入力してください" : "setForcedDisplaySize：" + BenesseExtension.setForcedDisplaySize(Integer.parseInt(width), Integer.parseInt(height)));
            }
        } catch (NoClassDefFoundError ignored) {
            makeText("BenesseExtension が存在しません");
            finish();
        } catch (NoSuchMethodError ignored) {
            makeText("関数が存在しません");
        } catch (SecurityException ignored) {
            makeText("関数の実行に失敗しました");
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

    /** @noinspection NullableProblems*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
