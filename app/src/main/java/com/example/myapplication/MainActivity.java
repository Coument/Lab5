package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("請選擇功能");
                alert.setMessage("請根據下方按鈕選擇要顯示的物件");

                alert.setNeutralButton("取消",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "dialog關閉",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast();
                    }
                });
                alert.setPositiveButton("List", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showList_dialog();
                    }
                });
                alert.show();
            }
        });
    }
    private void showToast() {
        Toast toast=new Toast(MainActivity.this);
        toast.setGravity(Gravity.TOP,0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.toast_));
        toast.setView(layout);
        toast.show();
    }
    private void showList_dialog(){
        final  String[] list={"message1","message2","message3","message4","message5"};
        AlertDialog.Builder dialog_list= new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("使用LIST呈現");
        dialog_list.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"你選的是"+list[i],Toast.LENGTH_SHORT).show();
            }
        });
        dialog_list.show();
    }
}