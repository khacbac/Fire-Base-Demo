package info.androidhive.firebase.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.androidhive.firebase.R;
import info.androidhive.firebase.base.BaseActivity;
import info.androidhive.firebase.login.view.LoginActivity;
import info.androidhive.firebase.main.presenter.IeMainPresenter;
import info.androidhive.firebase.main.presenter.MainPresenter;
import info.androidhive.firebase.signup.view.SignupActivity;

public class MainActivity extends BaseActivity implements IeMainView{

    @BindView(R.id.change_email_button)
    Button btnChangeEmail;
    @BindView(R.id.change_password_button)
    Button btnChangePassword;
    @BindView(R.id.sending_pass_reset_button)
    Button btnSendResetEmail;
    @BindView(R.id.remove_user_button)
    Button btnRemoveUser;
    @BindView(R.id.changeEmail)
    Button changeEmail;
    @BindView(R.id.changePass)
    Button changePassword;
    @BindView(R.id.send)
    Button sendEmail;
    @BindView(R.id.remove)
    Button remove;
    @BindView(R.id.sign_out)
    Button signOut;
    @BindView(R.id.old_email)
    EditText edtOldEmail;
    @BindView(R.id.new_email)
    EditText edtNewEmail;
    @BindView(R.id.password)
    EditText edtPassword;
    @BindView(R.id.newPassword)
    EditText edtNewPassword;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private IeMainPresenter ieMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Init data for all view.
        initViewData();
    }

    @Override
    public void initViewData() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        // Not Visibility View.
        chooseVisibilityViews();
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }
        ieMainPresenter = new MainPresenter(this);
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        //get current user
        user = FirebaseAuth.getInstance().getCurrentUser();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    switchToScreen(LoginActivity.class);
                    finish();
                }
            }
        };
    }


    @OnClick(R.id.change_email_button)
    public void onBtnChangeEmailClick(View view) {
        // Visibility edittext new Email, button change Email.
        chooseVisibilityViews(edtNewEmail, changeEmail);
    }

    @OnClick(R.id.change_password_button)
    public void onBtnChangePasswordClick(View view) {
        // Visibility edittext new password, button change password.
        chooseVisibilityViews(edtNewPassword, changePassword);
    }

    @OnClick(R.id.sending_pass_reset_button)
    public void onBtnSendPassResetClick(View view) {
        // Visibility edittext old Email, button send Email.
        chooseVisibilityViews(edtOldEmail, sendEmail);
    }

    @OnClick(R.id.changeEmail)
    public void onChangeEmailClick(View view) {
        String email = edtNewEmail.getText().toString().trim();
        if (email.equals("")) {
            edtNewEmail.setError("Enter email");
            return;
        }
        if (user != null && !email.equals("")) {
            // Call change email by presenter.
            ieMainPresenter.changeEmail(email);
        }
    }

    @OnClick(R.id.changePass)
    public void onChangePassClick(View view) {
        String pass = edtNewPassword.getText().toString().trim();
        if (pass.equals("")) {
            edtNewPassword.setError("Enter edtPassword");
            return;
        }
        if (pass.length() < 6) {
            edtNewPassword.setError("Password too short, enter minimum 6 characters");
            return;
        }
        // Call change pass word by presenter.
        ieMainPresenter.changePassWord(pass);
    }

    @OnClick(R.id.send)
    public void onSendBtnClick() {
        String email = edtOldEmail.getText().toString().trim();
        if (email.equals("")) {
            edtOldEmail.setError("Enter email");
            return;
        }
        // Call send pass word reset by presenter.
        ieMainPresenter.sendPassWordResetEmail(email);
    }

    @OnClick(R.id.remove_user_button)
    public void onBtnRemoveUserClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        if (user != null) {
            user.delete()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this,
                                        "Your profile is deleted:( Create a account now!",
                                        Toast.LENGTH_SHORT
                                ).show();
                                startActivity(new Intent(MainActivity.this,
                                        SignupActivity.class));
                                finish();
                                progressBar.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(
                                        MainActivity.this,
                                        "Failed to delete your account!",
                                        Toast.LENGTH_SHORT
                                ).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
        }
    }

    @OnClick(R.id.sign_out)
    public void onBtnSignOutClick(View view) {
        signOut();
    }

    /**
     * Chon view se hien thi tuy theo truong hop cu the.
     * @param views View Visibility.
     */
    private void chooseVisibilityViews(View... views) {
        edtOldEmail.setVisibility(View.GONE);
        edtNewEmail.setVisibility(View.GONE);
        edtPassword.setVisibility(View.GONE);
        edtNewPassword.setVisibility(View.GONE);
        changeEmail.setVisibility(View.GONE);
        changePassword.setVisibility(View.GONE);
        sendEmail.setVisibility(View.GONE);
        remove.setVisibility(View.GONE);
        if (views != null) {
            for (View view : views)
            view.setVisibility(View.VISIBLE);
        }
    }

    //sign out method
    public void signOut() {
        auth.signOut();
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    @Override
    public void onChangeEmailSuccess() {
        Toast.makeText(MainActivity.this,
                "Change email success!",
                Toast.LENGTH_SHORT
        ).show();
        switchToScreen(SignupActivity.class);
        finish();
    }

    @Override
    public void onChangeEmailError() {
        Toast.makeText(
                MainActivity.this,
                "Failed to update email!",
                Toast.LENGTH_LONG
        ).show();
    }

    @Override
    public void onChangePassSuccess() {
        Toast.makeText(MainActivity.this,
                "Password is updated," +
                        "sign in with new edtPassword!",
                Toast.LENGTH_SHORT
        ).show();
        signOut();
    }

    @Override
    public void onChangePassError() {
        Toast.makeText(MainActivity.this,
                "Failed to update edtPassword!",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onSendResetPassWordSuccess() {
        Toast.makeText(MainActivity.this,
                "Reset edtPassword email is sent!",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onSendResetPassWordError() {
        Toast.makeText(MainActivity.this,
                "Failed to send reset email!",
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