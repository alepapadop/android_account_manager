package com.positron.accountmanager;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.positron.accountmanager.AccountManager.AccountAuthenticatorAsyncTaskData;
import com.positron.accountmanager.Network.NetworkAsyncTaskLoaderAccountManager;

public class SignIn extends AppCompatActivity implements LoaderManager.LoaderCallbacks<AccountAuthenticatorAsyncTaskData> {

    LoaderManager _loader_manager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
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

        _loader_manager = getLoaderManager();
    }


    public void sign_in_commit(View view) {

        String username = null;
        String password = null;

        EditText username_te = (EditText)findViewById(R.id.sign_in_username);
        if (username_te != null) {
            username = username_te.getText().toString();
        }

        EditText password_te = (EditText)findViewById(R.id.sign_in_password);
        if (password_te != null) {
            password = password_te.getText().toString();
        }

        Bundle bundle = new Bundle();
        AccountAuthenticatorAsyncTaskData data = new AccountAuthenticatorAsyncTaskData();
        data.set_username(username);
        data.set_password(password);
        data.set_url(Constants.SERVER_LOGIN_URL);
        bundle.putSerializable(Constants.ACCOUNT_ASYNC_BUNDLE_KEY, data);

        _loader_manager.restartLoader(Constants.ACCOUNT_ASYNC_LOADER_SIGN_IN, bundle, this).forceLoad();

    }

    @Override
    public Loader<AccountAuthenticatorAsyncTaskData> onCreateLoader(int id, Bundle args) {

        AccountAuthenticatorAsyncTaskData data = (AccountAuthenticatorAsyncTaskData)args.getSerializable(Constants.ACCOUNT_ASYNC_BUNDLE_KEY);
        Log.d(Constants.ACCOUNT_LOG_TAG, "loader");
        return new NetworkAsyncTaskLoaderAccountManager(this, data);

    }

    @Override
    public void onLoadFinished(Loader<AccountAuthenticatorAsyncTaskData> loader, AccountAuthenticatorAsyncTaskData data) {
        finish();
    }

    @Override
    public void onLoaderReset(Loader<AccountAuthenticatorAsyncTaskData> loader) {

    }
}
