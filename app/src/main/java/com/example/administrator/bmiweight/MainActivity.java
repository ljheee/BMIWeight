package com.example.administrator.bmiweight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //声明所需控件
    EditText editTextHeight;
    TextView textViewWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//加载布局文件

        //做关联
        editTextHeight = (EditText) findViewById(R.id.editText_height);
        textViewWeight = (TextView) findViewById(R.id.textView_weight);
    }

    public void countWeight(View view) {

        //获取输入框--输入值
        String input = editTextHeight.getText().toString();
        int weight = 0;
        if(input.length()>0){
            weight = Integer.parseInt(input);//数值转化
        }

        int vid =  view.getId();
        switch (vid){
            case R.id.button_male:
                weight = (int)Math.ceil((weight-80)*0.7);
                break;
            case R.id.button_female:
                weight = (int)Math.ceil((weight-70)*0.6);
                break;
            default:
                break;
        }
        textViewWeight.setText(String.valueOf(weight));//设置显示标准体重
    }
}
