package com.example.lz.exercise2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //登录框
        Button button = (Button)findViewById(R.id.button_SignIn);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View login_dialog = inflater.inflate(R.layout.login_dialog,null);
                builder.setView(login_dialog).setTitle("Login")
                        .setPositiveButton(R.string.login,new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText editText = (EditText)login_dialog.findViewById(R.id.editTextUserId);
                                EditText editText1 = (EditText)login_dialog.findViewById(R.id.editTextPwd);

                                if(editText.getText().toString().equals("abc") && editText1.getText().toString().equals("123")) {
                                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                            }
                        });

                builder.show();
            }
        });
//提示框
        Button btn = (Button)this.findViewById(R.id.button_version);
        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("账号：asd  密码：123")
                        .setTitle("提示");

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which)
                    {
                    }
                });
                builder.show();
            }
        });
    }
}