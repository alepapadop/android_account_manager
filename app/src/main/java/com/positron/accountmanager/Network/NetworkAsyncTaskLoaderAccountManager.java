package com.positron.accountmanager.Network;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.positron.accountmanager.AccountManager.AccountAuthenticatorAsyncTaskData;
import com.positron.accountmanager.Constants;

/**
 * Created by alepapadop on 4/1/16.
 *
 * Use this in order to make async tasks related to the acccount manager...
 * sign in, sign up, test auth token etc
 *
 */
public class NetworkAsyncTaskLoaderAccountManager extends AsyncTaskLoader<AccountAuthenticatorAsyncTaskData> {

    private String _username = null;
    private String _password = null;
    //private String _auth_token = null;
    private String _url = null;

    public NetworkAsyncTaskLoaderAccountManager(Context context, AccountAuthenticatorAsyncTaskData data) {
        super(context);

        _username = data.get_username();
        _password = data.get_password();
        //_auth_token = data.get_auth_token();
        _url = data.get_url();

    }

    @Override
    public void deliverResult(AccountAuthenticatorAsyncTaskData data) {
        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        // check the internet connection here
    }

    @Override
    public AccountAuthenticatorAsyncTaskData loadInBackground() {

        AccountAuthenticatorAsyncTaskData data = new AccountAuthenticatorAsyncTaskData();
        Log.d(Constants.ACCOUNT_LOG_TAG, "background");
        NetworkConnectToServer server_connect = new NetworkConnectToServer();
        try {
            if (getId() == Constants.ACCOUNT_ASYNC_LOADER_SIGN_IN.intValue()) {
                String server_response_str = server_connect.download_url(_url);
                Log.d(Constants.ACCOUNT_LOG_TAG, server_response_str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        data.set_password(_password);
        data.set_username(_username);
        data.set_auth_token("login token");

        return data;
    }
}
