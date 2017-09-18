package info.androidhive.firebase.resetpassword.model;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public class ResetPasswordModel implements IeResetPasswordModel {
    @Override
    public void onResetPassWord(String email, final IeOnFinishResetPassWord finishListener) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            finishListener.resetSuccess();
                        } else {
                            finishListener.resetError();
                        }
                    }
                });
    }
}
