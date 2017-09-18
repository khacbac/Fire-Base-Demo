package info.androidhive.firebase.signup.model;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public class SignUpModel implements IeSignUpModel {

    @Override
    public void onSignUp(String email, String pass, final IeOnFinishSignUpListener finishListener) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finishListener.onSignUpSuccess(
                                    String.format("%s", task.getException()));
                        } else {
                            finishListener.onSignUpError(String.format("%s", task.getException()));
                        }
                    }
                });
    }
}
