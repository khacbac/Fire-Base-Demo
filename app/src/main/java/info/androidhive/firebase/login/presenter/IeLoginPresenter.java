package info.androidhive.firebase.login.presenter;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeLoginPresenter {
    /**
     * Listener event login.
     * @param email String.
     * @param pass String.
     */
    void onLogin(String email, String pass);
}
