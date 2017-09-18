package info.androidhive.firebase.login.model;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeLoginModel {
    interface IeOnFinishLoginListener {
        /**
         * Listener event login success.
         */
        void onLoginSuccess();
        /**
         * Listener event login error.
         */
        void onLoginError();
    }

    /**
     * Listener event login.
     * @param email String.
     * @param pass String.
     * @param finishLoginListener Interface Finish Callback.
     */
    void onLogin(String email, String pass, IeOnFinishLoginListener finishLoginListener);
}
