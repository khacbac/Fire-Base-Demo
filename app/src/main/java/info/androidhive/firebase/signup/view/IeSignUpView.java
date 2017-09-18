package info.androidhive.firebase.signup.view;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeSignUpView {
    /**
     * Listener event sign up success.
     * @param message String.
     */
    void onSignUpSuccess(String message);
    /**
     * Listener event sign up error.
     * @param message String.
     */
    void onSignUpError(String message);
    /**
     * Listener to hide progressbar.
     */
    void hideProgressbar();
    /**
     * Listener to show progressbar.
     */
    void showProgressbar();
}
