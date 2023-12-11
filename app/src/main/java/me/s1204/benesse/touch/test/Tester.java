package me.s1204.benesse.touch.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.BenesseExtension;

public class Tester extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        // checkPassword
        findViewById(R.id.btn_checkPassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_checkpassword);
                findViewById(R.id.exec).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText passwordBox = findViewById(R.id.checkPassword_value);
                        String password = passwordBox.getText().toString();
                        Toast.makeText(getApplicationContext(), "実行結果：" + BenesseExtension.checkPassword(password), Toast.LENGTH_LONG).show();
                    }
                });
                // メニューに戻る
                findViewById(R.id.backHome).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent().setClassName(getPackageName(), getComponentName().getClassName()).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                    }
                });
            }
        });

        // getDchaState
        findViewById(R.id.btn_getDchaState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "getDchaState：" + BenesseExtension.getDchaState(), Toast.LENGTH_LONG).show();
            }
        });


        // getInt
        findViewById(R.id.btn_getInt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_getint);
                findViewById(R.id.exec).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText variableBox = findViewById(R.id.getInt_variable);
                        String variable = variableBox.getText().toString();
                        Toast.makeText(getApplicationContext(), "実行結果：" + BenesseExtension.getInt(variable), Toast.LENGTH_LONG).show();
                    }
                });
                // メニューに戻る
                findViewById(R.id.backHome).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent().setClassName(getPackageName(), getComponentName().getClassName()).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                    }
                });
            }
        });

        // getString
        findViewById(R.id.btn_getString).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_getstring);
                findViewById(R.id.exec).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText variableBox = findViewById(R.id.getString_variable);
                        String variable = variableBox.getText().toString();
                        Toast.makeText(getApplicationContext(), "実行結果：" + BenesseExtension.getString(variable), Toast.LENGTH_LONG).show();
                    }
                });
                // メニューに戻る
                findViewById(R.id.backHome).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent().setClassName(getPackageName(), getComponentName().getClassName()).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                    }
                });
            }
        });

        // putInt
        findViewById(R.id.btn_putInt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_putint);
                findViewById(R.id.exec).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText putIntBox = findViewById(R.id.putInt_variable);
                        EditText putIntValueBox = findViewById(R.id.putInt_value);
                        String variable = putIntBox.getText().toString();
                        String value = putIntValueBox.getText().toString();
                        if (variable.equals("")) {
                            Toast.makeText(getApplicationContext(), "変数を入力してください", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (value.equals("")) {
                            value = null;
                        }
                        assert value != null;
                        Toast.makeText(getApplicationContext(), "実行結果：" + BenesseExtension.putInt(variable, Integer.parseInt(value)), Toast.LENGTH_LONG).show();
                    }
                });
                // メニューに戻る
                findViewById(R.id.backHome).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent().setClassName(getPackageName(), getComponentName().getClassName()).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                    }
                });
            }
        });

        // putString
        findViewById(R.id.btn_putString).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_putstring);
                findViewById(R.id.exec).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText putStringBox = findViewById(R.id.putString_variable);
                        EditText putStringValueBox = findViewById(R.id.putString_value);
                        String variable = putStringBox.getText().toString();
                        String value = putStringValueBox.getText().toString();
                        if (variable.equals("")) {
                            Toast.makeText(getApplicationContext(), "変数を入力してください", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (value.equals("")) {
                            value = null;
                        }
                        Toast.makeText(getApplicationContext(), "実行結果：" + BenesseExtension.putString(variable, value), Toast.LENGTH_LONG).show();
                    }
                });
                // メニューに戻る
                findViewById(R.id.backHome).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent().setClassName(getPackageName(), getComponentName().getClassName()).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                    }
                });
            }
        });

        // setDchaState
        findViewById(R.id.btn_setDchaState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_setdchastate);
                // setDchaState(0)
                findViewById(R.id.setDchaState_0).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BenesseExtension.setDchaState(0);
                    }
                });
                // setDchaState(1)
                findViewById(R.id.setDchaState_1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BenesseExtension.setDchaState(1);
                    }
                });
                // setDchaState(2)
                findViewById(R.id.setDchaState_2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BenesseExtension.setDchaState(2);
                    }
                });
                // setDchaState(3)
                findViewById(R.id.setDchaState_3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BenesseExtension.setDchaState(3);
                    }
                });
                // メニューに戻る
                findViewById(R.id.backHome).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent().setClassName(getPackageName(), getComponentName().getClassName()).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent().setClassName(getPackageName(), getComponentName().getClassName()).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }
}