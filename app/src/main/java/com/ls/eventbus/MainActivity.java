package com.ls.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/*
    eventBus的简单用法
    比otto少写一个注册与取消注册
 */
public class MainActivity extends AppCompatActivity {

    private EditText str;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        str = (EditText) findViewById(R.id.str);
        button = (Button) findViewById(R.id.set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(onMessageEventPostThread());
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public MessageEvent onMessageEventPostThread() {
        return new MessageEvent(str.getText().toString());
    }

}
