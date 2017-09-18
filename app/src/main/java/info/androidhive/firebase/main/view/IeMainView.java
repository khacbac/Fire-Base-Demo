package info.androidhive.firebase.main.view;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeMainView {
    void onChangeEmailSuccess();
    void onChangeEmailError();
    void onChangePassSuccess();
    void onChangePassError();
    void onSendResetPassWordSuccess();
    void onSendResetPassWordError();
    /**
     * Listener to hide progressbar.
     */
    void hideProgressbar();
    /**
     * Listener to show progressbar.
     */
    void showProgressbar();
}
