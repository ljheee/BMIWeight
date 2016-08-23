package com.example.administrator.bmiweight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //声明所需控件
    EditText editTextHeight;
    TextView textViewWeight;

    Button btnMale;
    Button btnFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//加载布局文件

        //XML布局文件中的控件  与 类前的声明---做关联
        editTextHeight = (EditText) findViewById(R.id.editText_height);
        textViewWeight = (TextView) findViewById(R.id.textView_weight);

        btnMale = (Button) findViewById(R.id.button_male);
        btnFemale = (Button) findViewById(R.id.button_female);
        btnMale.setOnClickListener(new MyButtonHandle());//注册监听事件
        btnFemale.setOnClickListener(new MyButtonHandle());
    }

    /**
     * 内部类
     * Button的事件监听
     */
    class MyButtonHandle implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //获取输入框--输入值
            String input = editTextHeight.getText().toString();
            int weight = 0;
            if(input.length()>0){
                weight = Integer.parseInt(input);//数值转化
            }

            int vid =  v.getId();
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
/*

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
*/
}
