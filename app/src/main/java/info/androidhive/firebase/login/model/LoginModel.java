package info.androidhive.firebase.login.model;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public class LoginModel implements IeLoginModel {
    @Override
    public void onLogin(String email, String pass, final IeOnFinishLoginListener finishLoginListener) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finishLoginListener.onLoginSuccess();
                        } else {
                            finishLoginListener.onLoginError();
                        }
                    }
                });
    }
}
