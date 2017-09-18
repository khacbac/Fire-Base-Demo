package info.androidhive.firebase.login.presenter;

import info.androidhive.firebase.login.model.IeLoginModel;
import info.androidhive.firebase.login.model.LoginModel;
import info.androidhive.firebase.login.view.IeLoginView;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public class LoginPresenter implements IeLoginPresenter, IeLoginModel.IeOnFinishLoginListener {
    private IeLoginView ieLoginView;
    private IeLoginModel ieLoginModel;

    public LoginPresenter(IeLoginView ieLoginView) {
        this.ieLoginView = ieLoginView;
        ieLoginModel = new LoginModel();
    }

    @Override
    public void onLogin(String email, String pass) {
        ieLoginView.showProgressbar();
        ieLoginModel.onLogin(email,pass,this);
    }

    @Override
    public void onLoginSuccess() {
        ieLoginView.onLoginSuccess();
        ieLoginView.hideProgressbar();
    }

    @Override
    public void onLoginError() {
        ieLoginView.onLoginError();
        ieLoginView.hideProgressbar();
    }
}
