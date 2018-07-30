package mvp.baset.com.mvparchitectureandroid;

import android.os.Handler;
import android.text.TextUtils;



/**
 * Created by windows 8.1 on 2018/07/30.
 */

public class MainInteractor {
    private Handler handler;
    public void login(final  String userName, final String password, final InterfaceOnLoginFinished listener){
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(userName)){
                    listener.onUserNameError();
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                }
                listener.onSuccess();

            }
        },100);}
}
