package mvp.baset.com.mvparchitectureandroid;

/**
 * Created by windows 8.1 on 2018/07/30.
 */

public class MainPresenter implements InterfaceOnLoginFinished {
    private MainInteractor mainInteractor;
    private MainView mainView;
    public MainPresenter(MainView mainView,MainInteractor mainInteractor){
        this.mainInteractor=mainInteractor;
        this.mainView=mainView;
    }
    public void validateCredentials(String userName,String password){
        if (mainView!=null){
            mainView.showProgress();
        }
        mainInteractor.login(userName,password,this);
    }

    @Override
    public void onUserNameError() {
if (mainView!=null){
    mainView.setUsernameError();
    mainView.hideProgress();
}
    }

    @Override
    public void onPasswordError() {
if (mainView!=null){
    mainView.setPasswordError();
    mainView.hideProgress();
}
    }

    @Override
    public void onSuccess() {
        if (mainView
                != null){
            mainView.navigateToHome();
            mainView.hideProgress();
        }

    }
    public void onDestroy() {
        mainView = null;
    }
}
