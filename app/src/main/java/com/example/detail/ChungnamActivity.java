package com.example.detail;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChungnamActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.chungnam);

        findViewById(R.id.cn_btn01).setOnClickListener(onClickListener);
        findViewById(R.id.cn_btn02).setOnClickListener(onClickListener);
        findViewById(R.id.cn_btn03).setOnClickListener(onClickListener);
        findViewById(R.id.cn_btn04).setOnClickListener(onClickListener);
        findViewById(R.id.cn_btn05).setOnClickListener(onClickListener);
        findViewById(R.id.cn_btn06).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = v -> {
        switch (v.getId()){
            case R.id.cn_btn01:
                cnstartActivity(DetailActivity.class, "4415056000");
                break;
            case R.id.cn_btn02:
                cnstartActivity(DetailActivity.class, "4415025000");
                break;
            case R.id.cn_btn03:
                cnstartActivity(DetailActivity.class, "4481038000");
                break;
            case R.id.cn_btn04:
                cnstartActivity(DetailActivity.class, "4415031000");
                break;
            case R.id.cn_btn05:
                cnstartActivity(DetailActivity.class, "4415033000");
                break;
            case R.id.cn_btn06:
                cnstartActivity(DetailActivity.class, "4476036000");
                break;

        }
    };
    private void cnstartActivity(Class c, String s){
        Intent intent = new Intent(this, c);
        intent.putExtra("code", s);
        startActivity(intent);
    }
}
