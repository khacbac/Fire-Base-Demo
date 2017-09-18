package info.androidhive.firebase.signup.presenter;

import info.androidhive.firebase.signup.model.IeSignUpModel;
import info.androidhive.firebase.signup.model.SignUpModel;
import info.androidhive.firebase.signup.view.IeSignUpView;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public class SignUpPresenter implements IeSignUpPresenter, IeSignUpModel.IeOnFinishSignUpListener {

    private IeSignUpView ieSignUpView;
    private IeSignUpModel ieSignUpModel;

    public SignUpPresenter(IeSignUpView ieSignUpView) {
        this.ieSignUpView = ieSignUpView;
        ieSignUpModel = new SignUpModel();
    }

    @Override
    public void onSignUp(String email, String pass) {
        ieSignUpView.showProgressbar();
        ieSignUpModel.onSignUp(email,pass,this);
    }

    @Override
    public void onSignUpSuccess(String message) {
        ieSignUpView.onSignUpSuccess(message);
        ieSignUpView.hideProgressbar();
    }

    @Override
    public void onSignUpError(String message) {
        ieSignUpView.onSignUpError(message);
        ieSignUpView.hideProgressbar();
    }
}
