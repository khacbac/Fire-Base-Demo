package info.androidhive.firebase.resetpassword.view;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeResetPassView {
    /**
     * Listener event reset pass word success.
     */
    void onResetPassWordSuccess();
    /**
     * Listener event reset pass word error.
     */
    void onResetPassWordError();
    /**
     * Listener to hide progressbar.
     */
    void hideProgressbar();
    /**
     * Listener to show progressbar.
     */
    void showProgressbar();
}
