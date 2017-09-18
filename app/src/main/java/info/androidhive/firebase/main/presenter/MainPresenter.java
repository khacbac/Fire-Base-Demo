package info.androidhive.firebase.main.presenter;

import info.androidhive.firebase.main.model.IeMainModel;
import info.androidhive.firebase.main.model.MainModel;
import info.androidhive.firebase.main.view.IeMainView;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public class MainPresenter implements IeMainPresenter,
        IeMainModel.IeOnFinishChangeEmailListener,IeMainModel.IeOnFinishChangePassListener,
        IeMainModel.IeOnFinishSendResetPassWord {

    private IeMainView ieMainView;
    private IeMainModel ieMainModel;

    public MainPresenter(IeMainView ieMainView) {
        this.ieMainView = ieMainView;
        ieMainModel = new MainModel();
    }

    @Override
    public void changeEmail(String email) {
        ieMainView.showProgressbar();
        ieMainModel.changeEmail(email,this);
    }

    @Override
    public void changePassWord(String pass) {
        ieMainView.showProgressbar();
        ieMainModel.changePassWord(pass,this);

    }

    @Override
    public void sendPassWordResetEmail(String email) {
        ieMainView.showProgressbar();
        ieMainModel.sendPassWordResetEmail(email,this);
    }

    @Override
    public void changePassSuccess() {
        ieMainView.onChangePassSuccess();
        ieMainView.hideProgressbar();
    }

    @Override
    public void changePassError() {
        ieMainView.onChangePassError();
        ieMainView.hideProgressbar();
    }

    @Override
    public void changeEmailSuccess() {
        ieMainView.onChangeEmailSuccess();
        ieMainView.hideProgressbar();
    }

    @Override
    public void changeEmailError() {
        ieMainView.onChangeEmailError();
        ieMainView.hideProgressbar();
    }

    @Override
    public void sendResetPassWordSuccess() {
        ieMainView.onSendResetPassWordSuccess();
        ieMainView.hideProgressbar();
    }

    @Override
    public void sendResetPassWordError() {
        ieMainView.onSendResetPassWordError();
        ieMainView.hideProgressbar();
    }
}
