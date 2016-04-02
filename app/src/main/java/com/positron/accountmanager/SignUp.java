package com.positron.accountmanager;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.positron.accountmanager.AccountManager.AccountAuthenticatorAsyncTaskData;

public class SignUp extends AppCompatActivity implements LoaderManager.LoaderCallbacks<AccountAuthenticatorAsyncTaskData> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }


    }

    public void sign_up_commit(View view) {
        String username = null;
        String password = null;

        EditText username_te = (EditText)findViewById(R.id.sign_up_username);
        if (username_te != null) {
            username = username_te.getText().toString();
        }

        EditText password_te = (EditText)findViewById(R.id.sign_up_password);
        if (password_te != null) {
            password = password_te.getText().toString();
        }

        Intent intent = new Intent();
        intent.putExtra(Constants.ACCOUNT_USERNAME_KEY, username);
        intent.putExtra(Constants.ACCOUNT_PASSWORD_KEY, password);
        intent.putExtra(Constants.ACCOUNT_AUTH_TOKEN_KEY, Constants.TMP_AUTH_TOKEN);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public Loader<AccountAuthenticatorAsyncTaskData> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<AccountAuthenticatorAsyncTaskData> loader, AccountAuthenticatorAsyncTaskData data) {

    }

    @Override
    public void onLoaderReset(Loader<AccountAuthenticatorAsyncTaskData> loader) {

    }
}
