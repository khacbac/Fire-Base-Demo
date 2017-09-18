package info.androidhive.firebase.signup.presenter;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeSignUpPresenter {
    /**
     * Listener event sign up called.
     * @param email String.
     * @param pass String.
     */
    void onSignUp(String email, String pass);

}
