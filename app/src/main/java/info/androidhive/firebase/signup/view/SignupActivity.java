package info.androidhive.firebase.signup.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.androidhive.firebase.main.view.MainActivity;
import info.androidhive.firebase.R;
import info.androidhive.firebase.base.BaseActivity;
import info.androidhive.firebase.resetpassword.view.ResetPasswordActivity;
import info.androidhive.firebase.signup.presenter.IeSignUpPresenter;
import info.androidhive.firebase.signup.presenter.SignUpPresenter;

public class SignupActivity extends BaseActivity implements IeSignUpView{

    @BindView(R.id.email)
    EditText inputEmail;
    @BindView(R.id.password)
    EditText inputPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.sign_in_button)
    Button btnSignIn;
    @BindView(R.id.sign_up_button)
    Button btnSignUp;
    @BindView(R.id.btn_reset_password)
    Button btnResetPassword;

    private IeSignUpPresenter ieSignUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_reset_password)
    public void onBtnResetPassWordClick(View view) {
        startActivity(new Intent(SignupActivity.this, ResetPasswordActivity.class));
    }
    @OnClick(R.id.sign_in_button)
    public void onBtnSignInClick(View view) {
        finish();
    }
    @OnClick(R.id.sign_up_button)
    public void onBtnSignUpClick(View view) {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
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
            Toast.makeText(
                    getApplicationContext(),
                    "Password too short, enter minimum 6 characters!",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }
        // Call sign up user by presenter.
        ieSignUpPresenter.onSignUp(email,password);
    }

    @Override
    public void initViewData() {
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        ieSignUpPresenter = new SignUpPresenter(this);
    }

    @Override
    public void onSignUpSuccess(String message) {
        Toast.makeText(
                SignupActivity.this,
                "createUserWithEmail:onComplete:" + message,
                Toast.LENGTH_SHORT
        ).show();
        switchToScreen(MainActivity.class);
        finish();
    }

    @Override
    public void onSignUpError(String message) {
        Toast.makeText(
                SignupActivity.this,
                "Authentication failed." + message,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }
}