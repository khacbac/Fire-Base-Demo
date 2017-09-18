package info.androidhive.firebase.resetpassword.model;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public interface IeResetPasswordModel {
    interface IeOnFinishResetPassWord {
        /**
         * Listener event reset password success.
         */
        void resetSuccess();
        /**
         * Listener event reset password error.
         */
        void resetError();
    }

    /**
     * Listener event reset password called.
     * @param email String.
     * @param finishListener Interface listener event reset finish.
     */
    void onResetPassWord(String email, IeOnFinishResetPassWord finishListener);
}
