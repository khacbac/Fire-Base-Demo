package info.androidhive.firebase.signup.model;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeSignUpModel {
    interface IeOnFinishSignUpListener {
        /**
         * Listener on sign up success.
         * @param message String.
         */
        void onSignUpSuccess(String message);
        /**
         * Listener on sign up error.
         * @param message String.
         */
        void onSignUpError(String message);
    }

    /**
     * Listener event sign up called.
     * @param email String.
     * @param pass String.
     * @param finishListener interface listen on sign up finish.
     */
    void onSignUp(String email, String pass, IeOnFinishSignUpListener finishListener);

}
