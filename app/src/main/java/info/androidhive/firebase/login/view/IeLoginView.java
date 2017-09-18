package info.androidhive.firebase.login.view;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeLoginView {
    /**
     * Listener login success.
     */
    void onLoginSuccess();
    /**
     * Listener login error.
     */
    void onLoginError();
    /**
     * Listener to hide progressbar.
     */
    void hideProgressbar();
    /**
     * Listener to show progressbar.
     */
    void showProgressbar();
}
