package info.androidhive.firebase.resetpassword.presenter;

import info.androidhive.firebase.resetpassword.model.IeResetPasswordModel;
import info.androidhive.firebase.resetpassword.model.ResetPasswordModel;
import info.androidhive.firebase.resetpassword.view.IeResetPassView;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public class ResetPassPresenter implements IeResetPassPresenter,
        IeResetPasswordModel.IeOnFinishResetPassWord {
    private IeResetPassView ieResetPassView;
    private IeResetPasswordModel ieResetPasswordModel;

    public ResetPassPresenter(IeResetPassView ieResetPassView) {
        this.ieResetPassView = ieResetPassView;
        ieResetPasswordModel = new ResetPasswordModel();
    }

    @Override
    public void onReserPassWordListener(String email) {
        ieResetPasswordModel.onResetPassWord(email,this);
        ieResetPassView.showProgressbar();
    }

    @Override
    public void resetSuccess() {
        ieResetPassView.onResetPassWordSuccess();
        ieResetPassView.hideProgressbar();
    }

    @Override
    public void resetError() {
        ieResetPassView.onResetPassWordError();
        ieResetPassView.hideProgressbar();
    }
}
