package bjpkten.memoryleak;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kodulf on 2019/4/17.
 */
public class SingleInstanceLeakDemo {


    private List<OnDataArrivedListener> mListeners = new ArrayList<>();

//    private static SingleInstanceLeakDemo mSingleInstanceLeakDemo = new SingleInstanceLeakDemo();

    private SingleInstanceLeakDemo(){

    }

    public static SingleInstanceLeakDemo getmSingleInstanceLeakDemo(){
        return SingLetHolder.INSTANCE;
    }

    private  static class SingLetHolder{
        public static final SingleInstanceLeakDemo INSTANCE = new SingleInstanceLeakDemo();
    }

    public synchronized void registerListerner (OnDataArrivedListener listener){
        if(!mListeners.contains(listener)){
            mListeners.add(listener);
        }
    }

    public synchronized void unregisterListner(OnDataArrivedListener listener){
        mListeners.remove(listener);
    }

    public  interface OnDataArrivedListener{
        public void onDataArrived(Object data);
    }

}
