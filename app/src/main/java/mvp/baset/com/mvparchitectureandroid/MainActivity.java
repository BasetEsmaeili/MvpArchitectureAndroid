package mvp.baset.com.mvparchitectureandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView ,View.OnClickListener{
private MainPresenter presenter;
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button=findViewById(R.id.button);
        presenter=new MainPresenter(this,new MainInteractor());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        Toast.makeText(this, "Error: UserName is Empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this, "Error: Password is Empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.button:
                validateCredentials();
                break;
        }
    }

    private void validateCredentials() {
        presenter.validateCredentials(username.getText().toString(),password.getText().toString());
    }
}
