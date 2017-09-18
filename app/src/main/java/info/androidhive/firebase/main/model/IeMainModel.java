package info.androidhive.firebase.main.model;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeMainModel {
    interface IeOnFinishChangePassListener {
        void changePassSuccess();
        void changePassError();
    }
    interface IeOnFinishChangeEmailListener {
        void changeEmailSuccess();
        void changeEmailError();
    }
    interface IeOnFinishSendResetPassWord {
        void sendResetPassWordSuccess();
        void sendResetPassWordError();
    }
    void changeEmail(String email, IeOnFinishChangeEmailListener finishChangeEmailLis);
    void changePassWord(String pass, IeOnFinishChangePassListener finishChangePassLis);
    void sendPassWordResetEmail(String email,IeOnFinishSendResetPassWord finishSendResetPassWord);
}
