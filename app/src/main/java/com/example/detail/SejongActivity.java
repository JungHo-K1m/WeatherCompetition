package com.example.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SejongActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.sejong);

        findViewById(R.id.sj_btn01).setOnClickListener(onClickListener);
        findViewById(R.id.sj_btn02).setOnClickListener(onClickListener);
        findViewById(R.id.sj_btn03).setOnClickListener(onClickListener);
        findViewById(R.id.sj_btn04).setOnClickListener(onClickListener);
        findViewById(R.id.sj_btn05).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = v -> {
        switch (v.getId()){
            case R.id.sj_btn01:
                cnstartActivity(DetailActivity.class, "3020054800");
                break;
            case R.id.sj_btn02:
                cnstartActivity(DetailActivity.class, "3017059700");
                break;
            case R.id.sj_btn03:
                cnstartActivity(DetailActivity.class, "3011055200");
                break;
            case R.id.sj_btn04:
                cnstartActivity(DetailActivity.class, "3011072500");
                break;
            case R.id.sj_btn05:
                cnstartActivity(DetailActivity.class, "3020055000");
                break;
        }
    };
    private void cnstartActivity(Class c, String s){
        Intent intent = new Intent(this, c);
        intent.putExtra("code", s);
        startActivity(intent);
    }
}
