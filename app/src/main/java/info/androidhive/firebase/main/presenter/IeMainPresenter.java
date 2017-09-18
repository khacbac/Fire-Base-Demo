package info.androidhive.firebase.main.presenter;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeMainPresenter {
    /**
     *
     * @param email
     */
    void changeEmail(String email);
    void changePassWord(String pass);
    void sendPassWordResetEmail(String email);
}
