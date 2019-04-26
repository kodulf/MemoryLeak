package bjpkten.memoryleak;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    public static View mView;
    public static View mView2;

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Trace.beginSection("kodulf");
        setContentView(R.layout.activity_second);
        mView  = findViewById(R.id.view);
        mView2 = new View(this);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                testANR();
//            }
//        }).start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        doNothing();
        Trace.endSection();

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
        });
    }

    public static synchronized void testANR(){
        Trace.beginSection("kodulf testANR");
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Trace.endSection();
    }

    public static synchronized void doNothing(){

    }
}
