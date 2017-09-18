package info.androidhive.firebase.resetpassword.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.androidhive.firebase.R;
import info.androidhive.firebase.base.BaseActivity;
import info.androidhive.firebase.resetpassword.presenter.IeResetPassPresenter;
import info.androidhive.firebase.resetpassword.presenter.ResetPassPresenter;

public class ResetPasswordActivity extends BaseActivity implements IeResetPassView{

    @BindView(R.id.email)
    EditText inputEmail;
    @BindView(R.id.btn_reset_password)
    Button btnReset;
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private IeResetPassPresenter ieResetPassPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewData();
    }

    @OnClick(R.id.btn_back)
    public void onBtnBackClick(View view) {
        finish();
    }
    @OnClick(R.id.btn_reset_password)
    public void onBtnResetPassWordClick(View view) {
        String email = inputEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplication(),
                    "Enter your registered email id", Toast.LENGTH_SHORT).show();
            return;
        }
        // Call reset pass word by presenter.
        ieResetPassPresenter.onReserPassWordListener(email);
    }

    @Override
    public void initViewData() {
        setContentView(R.layout.activity_reset_password);
        ButterKnife.bind(this);
        ieResetPassPresenter = new ResetPassPresenter(this);
    }

    @Override
    public void onResetPassWordSuccess() {
        Toast.makeText(
                ResetPasswordActivity.this,
                "We have sent you instructions to reset your edtPassword!",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onResetPassWordError() {
        Toast.makeText(
                ResetPasswordActivity.this,
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
