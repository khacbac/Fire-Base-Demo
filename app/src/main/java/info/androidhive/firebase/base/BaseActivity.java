package info.androidhive.firebase.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by doanLV4 on 9/18/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public abstract void initViewData();

    public void switchToScreen(Class context) {
        Intent intent = new Intent(this,context);
        startActivity(intent);
    }
}
