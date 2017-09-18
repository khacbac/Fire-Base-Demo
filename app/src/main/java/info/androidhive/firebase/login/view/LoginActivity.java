package info.androidhive.firebase.login.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.androidhive.firebase.main.view.MainActivity;
import info.androidhive.firebase.R;
import info.androidhive.firebase.base.BaseActivity;
import info.androidhive.firebase.resetpassword.view.ResetPasswordActivity;
import info.androidhive.firebase.signup.view.SignupActivity;
import info.androidhive.firebase.login.presenter.IeLoginPresenter;
import info.androidhive.firebase.login.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements IeLoginView {

    @BindView(R.id.email)
    EditText inputEmail;
    @BindView(R.id.password)
    EditText inputPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_reset_password)
    Button btnReset;

    private IeLoginPresenter ieLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewData();
    }

    @OnClick(R.id.btn_signup)
    public void onBtnSignUpClick(View view) {
        switchToScreen(SignupActivity.class);
    }
    @OnClick(R.id.btn_reset_password)
    public void onBtnResetPassWordClick(View view) {
        switchToScreen(ResetPasswordActivity.class);
    }
    @OnClick(R.id.btn_login)
    public void onBtnLoginClick(View view) {
        String email = inputEmail.getText().toString();
        final String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Enter edtPassword!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 6) {
            inputPassword.setError(getString(R.string.minimum_password));
            return;
        }

        // Call login by Presenter.
        ieLoginPresenter.onLogin(email,password);

    }

    @Override
    public void onLoginSuccess() {
        switchToScreen(MainActivity.class);
        finish();
    }

    @Override
    public void onLoginError() {
        Toast.makeText(LoginActivity.this,
                getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void initViewData() {
        //Get Firebase auth instance
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            switchToScreen(MainActivity.class);
            finish();
        }
        // set the view now
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ieLoginPresenter = new LoginPresenter(this);
    }
}

