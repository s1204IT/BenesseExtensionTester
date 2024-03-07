package me.s1204.benesse.touch.test;

import android.app.Activity;
import android.content.Intent;
import android.os.BenesseExtension;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Tester extends Activity {

    private static final String CTX = "TAB-A05-BD";
    private static final String CTZ = "TAB-A05-BA1";


    private void backHome() {
        finish();
        startActivity(new Intent(Intent.ACTION_MAIN).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }
    private void makeText(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void noClassFound(NoClassDefFoundError e) {
        e.printStackTrace();
        makeText("BenesseExtension が存在しません");
        finishAndRemoveTask();
    }

    private void noSuchFunc(NoSuchMethodError e) {
        e.printStackTrace();
        makeText("関数が存在しません");
        //backHome();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        if (Build.MODEL.equals(CTX)) {
            findViewById(R.id.btn_putString).setEnabled(false);
            findViewById(R.id.btn_enableNoSuchFunc).setVisibility(View.VISIBLE);
        } else if (!Build.MODEL.equals(CTZ)){
            makeText("この端末はサポートされていません");
        }

        findViewById(R.id.btn_enableNoSuchFunc).setOnClickListener(view -> {
            // 存在しない
            findViewById(R.id.btn_putString).setEnabled(true);
            findViewById(R.id.btn_enableNoSuchFunc).setVisibility(View.INVISIBLE);
        });

        // checkPassword
        findViewById(R.id.btn_checkPassword).setOnClickListener(view -> {
            setContentView(R.layout.layout_checkpassword);
            findViewById(R.id.exec).setOnClickListener(view1 -> {
                EditText passwordBox = findViewById(R.id.checkPassword_value);
                String password = passwordBox.getText().toString();
                try {
                    makeText("実行結果：" + BenesseExtension.checkPassword(password));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view12 -> backHome());
        });

        // getDchaState
        findViewById(R.id.btn_getDchaState).setOnClickListener(view -> {
            try {
                makeText("getDchaState：" + BenesseExtension.getDchaState());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
            }
        });

        // getInt
        findViewById(R.id.btn_getInt).setOnClickListener(view -> {
            setContentView(R.layout.layout_getint);
            findViewById(R.id.exec).setOnClickListener(view13 -> {
                EditText variableBox = findViewById(R.id.getInt_variable);
                String variable = variableBox.getText().toString();
                if (variable.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.getInt(variable));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (NoSuchMethodError e) {
                    noSuchFunc(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view14 -> backHome());
        });

        // getString
        findViewById(R.id.btn_getString).setOnClickListener(view -> {
            setContentView(R.layout.layout_getstring);
            findViewById(R.id.exec).setOnClickListener(view15 -> {
                EditText variableBox = findViewById(R.id.getString_variable);
                String variable = variableBox.getText().toString();
                if (variable.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.getString(variable));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view16 -> backHome());
        });

        // putInt
        findViewById(R.id.btn_putInt).setOnClickListener(view -> {
            setContentView(R.layout.layout_putint);
            findViewById(R.id.exec).setOnClickListener(view17 -> {
                EditText putIntBox = findViewById(R.id.putInt_variable);
                EditText putIntValueBox = findViewById(R.id.putInt_value);
                String variable = putIntBox.getText().toString();
                String value = putIntValueBox.getText().toString();
                if (variable.isEmpty() || value.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.putInt(variable, Integer.parseInt(value)));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (NoSuchMethodError e) {
                    noSuchFunc(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view18 -> backHome());
        });

        // putString
        findViewById(R.id.btn_putString).setOnClickListener(view -> {
            setContentView(R.layout.layout_putstring);
            findViewById(R.id.exec).setOnClickListener(view115 -> {
                EditText putStringBox = findViewById(R.id.putString_variable);
                EditText putStringValueBox = findViewById(R.id.putString_value);
                String variable = putStringBox.getText().toString();
                String value = putStringValueBox.getText().toString();
                if (variable.isEmpty() || value.isEmpty()) {
                    makeText("値を入力してください");
                    return;
                }
                try {
                    makeText("実行結果：" + BenesseExtension.putString(variable, value));
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (NoSuchMethodError e) {
                    noSuchFunc(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view19 -> backHome());
        });

        // setDchaState
        findViewById(R.id.btn_setDchaState).setOnClickListener(view -> {
            setContentView(R.layout.layout_setdchastate);
            // setDchaState(0)
            findViewById(R.id.setDchaState_0).setOnClickListener(view110 -> {
                try {
                    BenesseExtension.setDchaState(0);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // setDchaState(1)
            findViewById(R.id.setDchaState_1).setOnClickListener(view111 -> {
                try {
                    BenesseExtension.setDchaState(1);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // setDchaState(2)
            findViewById(R.id.setDchaState_2).setOnClickListener(view112 -> {
                try {
                    BenesseExtension.setDchaState(2);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // setDchaState(3)
            findViewById(R.id.setDchaState_3).setOnClickListener(view113 -> {
                try {
                    BenesseExtension.setDchaState(3);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view114 -> backHome());
        });

    }

    @Override
    @Deprecated
    public void onBackPressed() {
        backHome();
    }
}
