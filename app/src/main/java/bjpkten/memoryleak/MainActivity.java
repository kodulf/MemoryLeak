package bjpkten.memoryleak;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Trace;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements SingleInstanceLeakDemo.OnDataArrivedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ContentResolver contentResolver = getContentResolver();
//        Cursor query = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null, null);

//        query.close();

        File file = new File("");
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory("");

        try {
            FileReader fileReader = new FileReader(file);


            while (fileReader.read()!=0){

            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Log.d("kodulf","onCreate");
        Trace.beginSection("kodulf");
        setContentView(R.layout.activity_main);
        Trace.endSection();

        SingleInstanceLeakDemo.getmSingleInstanceLeakDemo().registerListerner(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("kodulf","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("kodulf","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("kodulf","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("kodulf","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("kodulf","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("kodulf","onDestroy");
    }

    public void jump(View view) {
        Trace.beginSection("kodulf");
        startActivityForResult(new Intent(this,SecondActivity.class),100);
        Trace.endSection();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("kodulf","onActivityResult");

        finish();

    }

    @Override
    public void onDataArrived(Object data) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
