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

    private static final String CT3 = "TAB-A03-BR3";
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

    private void cannotExec(SecurityException e) {
        e.printStackTrace();
        makeText("関数の実行に失敗しました");
        //backHome();
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

        if (Build.MODEL.equals(CTX) || Build.MODEL.equals(CTZ)) {
            makeText("チャレンジパッドNeo/Nextでは正常に動作しません\nCTZ版を利用してください");
        } else if (!Build.MODEL.equals(CT3)){
            makeText("この端末はサポートされていません");
        }

        findViewById(R.id.btn_enableUnsupportedFunc).setOnClickListener(view -> {
            // 実行できない
            findViewById(R.id.btn_checkPassword).setEnabled(true);
            findViewById(R.id.btn_setDchaState).setEnabled(true);
            findViewById(R.id.btn_enableUnsupportedFunc).setVisibility(View.INVISIBLE);
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
                } catch (SecurityException e) {
                    cannotExec(e);
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
            }
        });

        // getBaseDisplaySize
        findViewById(R.id.btn_getBaseDisplaySize).setOnClickListener(view -> {
            try {
                makeText("getBaseDisplaySize：" + BenesseExtension.getBaseDisplaySize());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
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
            }
        });

        // getLcdSize
        findViewById(R.id.btn_getLcdSize).setOnClickListener(view -> {
            try {
                makeText("getLcdSize：" + BenesseExtension.getLcdSize());
            } catch (NoClassDefFoundError e) {
                noClassFound(e);
            }
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

        // setDchaState
        findViewById(R.id.btn_setDchaState).setOnClickListener(view -> {
            setContentView(R.layout.layout_setdchastate);
            // setDchaState(0)
            findViewById(R.id.setDchaState_0).setOnClickListener(view110 -> {
                try {
                    BenesseExtension.setDchaState(0);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (SecurityException e) {
                    cannotExec(e);
                }
            });
            // setDchaState(1)
            findViewById(R.id.setDchaState_1).setOnClickListener(view111 -> {
                try {
                    BenesseExtension.setDchaState(1);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (SecurityException e) {
                    cannotExec(e);
                }
            });
            // setDchaState(2)
            findViewById(R.id.setDchaState_2).setOnClickListener(view112 -> {
                try {
                    BenesseExtension.setDchaState(2);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (SecurityException e) {
                    cannotExec(e);
                }
            });
            // setDchaState(3)
            findViewById(R.id.setDchaState_3).setOnClickListener(view113 -> {
                try {
                    BenesseExtension.setDchaState(3);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
                } catch (SecurityException e) {
                    cannotExec(e);
                }
            });
            // メニューに戻る
            findViewById(R.id.backHome).setOnClickListener(view114 -> backHome());
        });

        // setForcedDisplaySize
        findViewById(R.id.btn_setForcedDisplaySize).setOnClickListener(view -> {
            setContentView(R.layout.layout_setforceddisplaysize);
            findViewById(R.id.exec).setOnClickListener(view15 -> {
                EditText widthBox = findViewById(R.id.setForcedDisplaySize_width);
                EditText heightBox = findViewById(R.id.setForcedDisplaySize_height);
                String width = widthBox.getText().toString();
                String height = heightBox.getText().toString();
                if (width.isEmpty() || height.isEmpty()) {
                    makeText("値を入力してください");
                }
                try {
                    makeText("実行結果：" + BenesseExtension.setForcedDisplaySize(Integer.parseInt(width), Integer.parseInt(height)));
                } catch (SecurityException e) {
                    cannotExec(e);
                } catch (NoClassDefFoundError e) {
                    noClassFound(e);
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
}
