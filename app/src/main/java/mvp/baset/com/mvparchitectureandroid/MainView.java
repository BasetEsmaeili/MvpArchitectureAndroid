package mvp.baset.com.mvparchitectureandroid;

/**
 * Created by windows 8.1 on 2018/07/30.
 */

public interface MainView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
