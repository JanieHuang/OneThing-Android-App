package com.gkmicro.onething;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText textview;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (EditText) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        final SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String oldItem = sharedPref.getString("oldItem", "Nothing Created Yet...");
        textview.setText(oldItem);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("oldItem", textview.getText().toString());
                editor.commit();

                Animation animation = new AlphaAnimation(1.0f, 0.0f);
                animation.setDuration(1000);
                button.startAnimation(animation);


            }
        });
    }
}
