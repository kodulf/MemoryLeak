package bjpkten.memoryleak;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Kodulf on 2019/4/15.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
    }
}
