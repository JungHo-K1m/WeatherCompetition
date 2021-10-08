package com.example.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.cb).setOnClickListener(onClickListener);
        findViewById(R.id.cn).setOnClickListener(onClickListener);
        findViewById(R.id.dj).setOnClickListener(onClickListener);
        findViewById(R.id.sj).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = v -> {
        switch (v.getId()){
            case R.id.cb:
                mystartActivity(ChungbukActivity.class);
                break;
            case R.id.cn:
                mystartActivity(ChungnamActivity.class);
                break;
            case R.id.dj:
                mystartActivity(DaejeonActivity.class);
                break;
            case R.id.sj:
                mystartActivity(SejongActivity.class);
                break;
        }
    };
    private void mystartActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}