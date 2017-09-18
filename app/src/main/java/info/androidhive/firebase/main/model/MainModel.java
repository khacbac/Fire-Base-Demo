package info.androidhive.firebase.main.model;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public class MainModel implements IeMainModel {
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public MainModel() {
    }

    @Override
    public void changeEmail(String email, final IeOnFinishChangeEmailListener finishChangeEmailLis) {
        if (user != null) {
            user.updateEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                finishChangeEmailLis.changeEmailSuccess();
                            } else {
                                finishChangeEmailLis.changeEmailError();
                            }
                        }
                    });
        }
    }

    @Override
    public void changePassWord(String pass, final IeOnFinishChangePassListener finishChangePassLis) {
        if (user != null) {
            user.updatePassword(pass)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                finishChangePassLis.changePassSuccess();
                            } else {
                                finishChangePassLis.changePassError();
                            }
                        }
                    });
        }
    }

    @Override
    public void sendPassWordResetEmail(String email, final IeOnFinishSendResetPassWord finishSendResetPassWord) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth != null) {
            auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                finishSendResetPassWord.sendResetPassWordSuccess();
                            } else {
                                finishSendResetPassWord.sendResetPassWordError();
                            }
                        }
                    });
        }
    }
}
