package me.s1204.benesse.touch.test;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
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

/** @noinspection CallToPrintStackTrace*/
public class Tester extends Activity {

    private static final String CT3 = "TAB-A03-BR3";
    private static final String CTX = "TAB-A05-BD";
    private static final String CTZ = "TAB-A05-BA1";

    private void backHome() {
        finish();
        startActivity(new Intent(Intent.ACTION_MAIN)
                .addCategory(Intent.CATEGORY_DEFAULT)
                .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                .setPackage(getPackageName()));
    }

    private void makeText(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void noClassFound(@NonNull NoClassDefFoundError e) {
        e.printStackTrace();
        makeText("BenesseExtension が存在しません");
        finishAndRemoveTask();
    }

    private void cannotExec(@NonNull SecurityException e) {
        e.printStackTrace();
        makeText("関数の実行に失敗しました");
        //backHome();
    }

    private void noSuchFunc(@NonNull NoSuchMethodError e) {
        e.printStackTrace();
        makeText("関数が存在しません");
        //backHome();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        switch (Build.MODEL) {
            case CT3:
                findViewById(R.id.btn_getInt).setEnabled(false);
                findViewById(R.id.btn_putInt).setEnabled(false);
                findViewById(R.id.btn_putString).setEnabled(false);
                break;
            case CTX:
            case CTZ:
                findViewById(R.id.btn_checkUsbCam).setEnabled(false);
                findViewById(R.id.btn_getBaseDisplaySize).setEnabled(false);
                findViewById(R.id.btn_getInitialDisplaySize).setEnabled(false);
                findViewById(R.id.btn_getLcdSize).setEnabled(false);
                findViewById(R.id.btn_setForcedDisplaySize).setEnabled(false);
                if (Build.MODEL.equals(CTX)) findViewById(R.id.btn_putString).setEnabled(false);
                break;
            default:
                makeText("この端末はサポートされていません");
                findViewById(R.id.btn_enableNoSuchFunc).setVisibility(View.INVISIBLE);
                break;
        }

        findViewById(R.id.btn_enableNoSuchFunc).setOnClickListener(view -> {
            // 存在しない
            findViewById(R.id.btn_checkUsbCam).setEnabled(true);
            findViewById(R.id.btn_getBaseDisplaySize).setEnabled(true);
            findViewById(R.id.btn_getInitialDisplaySize).setEnabled(true);
            findViewById(R.id.btn_getInt).setEnabled(true);
            findViewById(R.id.btn_getLcdSize).setEnabled(true);
            findViewById(R.id.btn_putInt).setEnabled(true);
            findViewById(R.id.btn_putString).setEnabled(true);
            findViewById(R.id.btn_setForcedDisplaySize).setEnabled(true);
            findViewById(R.id.btn_enableNoSuchFunc).setVisibility(View.INVISIBLE);
        });

        // checkPassword(String)
        findViewById(R.id.btn_checkPassword).setOnClickListener(view -> {
            setContentView(R.layout.layout_checkpassword);
            findViewById(R.id.exec).setOnClickListener(view1 -> {
                EditText passwordBox = findViewById(R.id.checkPassword_value);
                String password = passwordBox.getText().toString();
                try {
                    makeText("実行結果：" + BenesseExtension.checkPassword(password));
                } catch (SecurityException e) {
                    cannotExec(e);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view12 -> backHome());
        });

        // checkUsbCam
        findViewById(R.id.btn_checkUsbCam).setOnClickListener(view -> {
            try {
                makeText("checkUsbCam：" + BenesseExtension.checkUsbCam());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
            } catch (NoSuchMethodError e) {
                noSuchFunc(e);
            }
        });

        // getBaseDisplaySize
        findViewById(R.id.btn_getBaseDisplaySize).setOnClickListener(view -> {
            try {
                makeText("getBaseDisplaySize：" + BenesseExtension.getBaseDisplaySize());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
            } catch (NoSuchMethodError e) {
                noSuchFunc(e);
            }
        });

        // getDchaState
        findViewById(R.id.btn_getDchaState).setOnClickListener(view -> {
            try {
                makeText("getDchaState：" + BenesseExtension.getDchaState());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
            }
        });

        // getInitialDisplaySize
        findViewById(R.id.btn_getInitialDisplaySize).setOnClickListener(view -> {
            try {
                makeText("getInitialDisplaySize：" + BenesseExtension.getInitialDisplaySize());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
            } catch (NoSuchMethodError e) {
                noSuchFunc(e);
            }
        });

        // getInt(String)
        findViewById(R.id.btn_getInt).setOnClickListener(view -> {
            setContentView(R.layout.layout_getint);
            findViewById(R.id.exec).setOnClickListener(view13 -> {
                Spinner varBox = findViewById(R.id.getInt_var);
                String var = varBox.getSelectedItem().toString();
                if (var.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.getInt(var));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (NoSuchMethodError e) {
                    noSuchFunc(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view14 -> backHome());
        });

        // getLcdSize
        findViewById(R.id.btn_getLcdSize).setOnClickListener(view -> {
            try {
                makeText("getLcdSize：" + BenesseExtension.getLcdSize());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
            } catch (NoSuchMethodError e) {
                noSuchFunc(e);
            }
        });

        // getString(String)
        findViewById(R.id.btn_getString).setOnClickListener(view -> {
            setContentView(R.layout.layout_getstring);
            findViewById(R.id.exec).setOnClickListener(view15 -> {
                Spinner varBox = findViewById(R.id.getString_var);
                String var = varBox.getSelectedItem().toString();
                if (var.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.getString(var));
                } catch (SecurityException e) {
                    cannotExec(e);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view16 -> backHome());
        });

        // putInt(String, int)
        findViewById(R.id.btn_putInt).setOnClickListener(view -> {
            setContentView(R.layout.layout_putint);
            findViewById(R.id.exec).setOnClickListener(view17 -> {
                Spinner varBox = findViewById(R.id.putInt_var);
                EditText valBox = findViewById(R.id.putInt_val);
                String var = varBox.getSelectedItem().toString();
                String val = valBox.getText().toString();
                if (var.isEmpty() || val.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.putInt(var, Integer.parseInt(val)));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (NoSuchMethodError e) {
                    noSuchFunc(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view18 -> backHome());
        });

        // putString(String, String)
        findViewById(R.id.btn_putString).setOnClickListener(view -> {
            setContentView(R.layout.layout_putstring);
            findViewById(R.id.exec).setOnClickListener(view115 -> {
                Spinner varBox = findViewById(R.id.putString_var);
                EditText valBox = findViewById(R.id.putString_val);
                String var = varBox.getSelectedItem().toString();
                String val = valBox.getText().toString();
                if (var.isEmpty() || val.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.putString(var, val));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (NoSuchMethodError e) {
                    noSuchFunc(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view19 -> backHome());
        });

        // setDchaState(int)
        findViewById(R.id.btn_setDchaState).setOnClickListener(view -> {
            setContentView(R.layout.layout_setdchastate);
            // setDchaState(0)
            findViewById(R.id.setDchaState_0).setOnClickListener(view110 -> {
                try {
                    BenesseExtension.setDchaState(0);
                } catch (SecurityException e) {
                    cannotExec(e);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // setDchaState(1)
            findViewById(R.id.setDchaState_1).setOnClickListener(view111 -> {
                try {
                    BenesseExtension.setDchaState(1);
                } catch (SecurityException e) {
                    cannotExec(e);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // setDchaState(2)
            findViewById(R.id.setDchaState_2).setOnClickListener(view112 -> {
                try {
                    BenesseExtension.setDchaState(2);
                } catch (SecurityException e) {
                    cannotExec(e);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // setDchaState(3)
            findViewById(R.id.setDchaState_3).setOnClickListener(view113 -> {
                try {
                    BenesseExtension.setDchaState(3);
                } catch (SecurityException e) {
                    cannotExec(e);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view114 -> backHome());
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
                if (checkSelfPermission(Manifest.permission.WRITE_SECURE_SETTINGS) != PackageManager.PERMISSION_GRANTED) {
                    makeText("このアプリに WRITE_SECURE_SETTINGS の権限を付与してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.setForcedDisplaySize(Integer.parseInt(width), Integer.parseInt(height)));
                } catch (SecurityException e) {
                    cannotExec(e);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (NoSuchMethodError e) {
                    noSuchFunc(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view16 -> backHome());
        });

    }

    @Override
    @Deprecated
    public void onBackPressed() {
        backHome();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_about) {
            setContentView(R.layout.about);
            return true;
        } else if (itemId == R.id.menu_settings) {
            startActivity(new Intent(Intent.ACTION_MAIN).setClassName("com.android.settings", "com.android.settings.Settings"));
            return true;
        } else if (itemId == R.id.menu_devopts) {
            startActivity(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
