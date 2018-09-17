package com.example.a32174224.multi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public native void save(String str);
    public int count(int num1,int num2){
        int num3;
        num3= num1*num2;
        return num3;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText num1 =(EditText)findViewById(R.id.editText);
                final EditText num2 =(EditText)findViewById(R.id.editText2);

                final TextView tt =(TextView)findViewById(R.id.textView2);

                int NUM1 =Integer.parseInt(num1.getText().toString());
                int NUM2 =Integer.parseInt(num2.getText().toString());

                int re =count(NUM1,NUM2);

                String temp =String.valueOf(re);

                save(temp);
                tt.setText(temp);
            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

}
// Example of a call to a native method
//TextView tv = (TextView) findViewById(R.id.sample_text);
//tv.setText(stringFromJNI());
//public native String stringFromJNI();