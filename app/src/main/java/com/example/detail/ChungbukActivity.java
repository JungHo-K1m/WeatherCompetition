package com.example.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChungbukActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.chungbuk);

        findViewById(R.id.cb_btn01).setOnClickListener(onClickListener);
        findViewById(R.id.cb_btn02).setOnClickListener(onClickListener);
        findViewById(R.id.cb_btn03).setOnClickListener(onClickListener);
        findViewById(R.id.cb_btn04).setOnClickListener(onClickListener);
        findViewById(R.id.cb_btn05).setOnClickListener(onClickListener);
        findViewById(R.id.cb_btn06).setOnClickListener(onClickListener);
        findViewById(R.id.cb_btn07).setOnClickListener(onClickListener);

    }
    View.OnClickListener onClickListener = v -> {
        switch (v.getId()){
            case R.id.cb_btn01:
                cnstartActivity(DetailActivity.class, "4311135000");
                break;
            case R.id.cb_btn02:
                cnstartActivity(DetailActivity.class, "4311425300");
                break;
            case R.id.cb_btn03:
                cnstartActivity(DetailActivity.class, "4311134000");
                break;
            case R.id.cb_btn04:
                cnstartActivity(DetailActivity.class, "4311425300/");
                break;
            case R.id.cb_btn05:
                cnstartActivity(DetailActivity.class, "4311169000");
                break;
            case R.id.cb_btn06:
                cnstartActivity(DetailActivity.class, "4311133000");
                break;
            case R.id.cb_btn07:
                cnstartActivity(DetailActivity.class, "4375025300");
                break;

        }
    };
    private void cnstartActivity(Class c, String s){
        Intent intent = new Intent(this, c);
        intent.putExtra("code", s);
        startActivity(intent);
    }
}
