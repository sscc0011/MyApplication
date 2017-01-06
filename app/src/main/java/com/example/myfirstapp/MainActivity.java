package com.example.myfirstapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends FragmentActivity  {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

        /** Called when the user clicks the Send button */
        public void sendMessage (View view){
            /**传参intent跳转
             * Intent第一个参数为当前Activity
             * Intent第二个参数为目标类，在目标Activity，在目标Activity中生成视图*/
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            /**获取控件文本字符串*/
            EditText editText = (EditText) findViewById(R.id.edit_message);
            String message = editText.getText().toString();
            /**植入文本，putExtra第一个参数为标识字符串，每个app最好只制定一个
             *                   第二个参数输入传递字符串*/
            intent.putExtra(EXTRA_MESSAGE, message);
            /**执行Intent*/
            startActivity(intent);
        }

    public void sendToFragment(View view) {
        /**不传参直接intent跳转
         * Intent第一个参数为当前Activity
         * Intent第二个参数为目标类，在目标Activity，在目标Activity中生成视图*/
        Intent intent = new Intent(this, FragmentActivity.class);
        /**执行Intent*/
        startActivity(intent);
    }

    public void sendToDynamicFragment(View view) {
        Intent intent = new Intent(this, FragmentDynamicActivity.class);
        startActivity(intent);
    }


    public void welcomeToSmc(View view) {


        System.out.print("----------------------start---------------------------------");
        EditText et1= (EditText) findViewById(R.id.edit_username);
        EditText et2 = (EditText) findViewById(R.id.edit_password);

        String str_et1= et1.getText().toString();
        String str_et2=et2.getText().toString();

        System.out.print("-------------------------------------------------------"+str_et1);
        System.out.print("-------------------------------------------------------"+str_et2);
        if(str_et1.equals("hongkong")||str_et2.equals("123")){
            Intent intent = new Intent(this,SqliteActivity.class);
            startActivity(intent);
        }else {
            Toast toast = Toast.makeText(getApplicationContext(),"請輸入正確的用戶名密碼",Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
