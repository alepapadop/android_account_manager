package com.positron.accountmanager.AccountManager;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.positron.accountmanager.Constants;

/**
 * Created by alepapadop on 3/26/16.
 */
public class AccountAuthenticatorImpl extends AbstractAccountAuthenticator {

    private Context _context;

    public AccountAuthenticatorImpl(Context context) {
        super(context);

        _context = context;
    }

    @Override
    public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
        return null;
    }

    @Override
    public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType, String[] requiredFeatures, Bundle options) throws NetworkErrorException {

        Log.d(Constants.ACCOUNT_LOG_TAG, "Adding new account");
        Log.d(Constants.ACCOUNT_LOG_TAG, "The auth token type is " + authTokenType);


        Intent intent = new Intent(_context, AccountAuthenticatorActivity.class);

        intent.putExtra(AccountManager.KEY_ACCOUNT_AUTHENTICATOR_RESPONSE, response);
        intent.putExtra(Constants.ACCOUNT_AUTH_TOKEN_TYPE_KEY, authTokenType);
        intent.putExtra(Constants.ACCOUNT_REQUEST_ORIGIN_KEY, Constants.ACCOUNT_REQUEST_ADD_ACCOUNT);

        Bundle bundle = new Bundle();
        bundle.putParcelable(AccountManager.KEY_INTENT, intent);

        return bundle;
    }

    @Override
    public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        Log.d(Constants.ACCOUNT_LOG_TAG, "getAuthToken");
        return null;
    }

    @Override
    public String getAuthTokenLabel(String authTokenType) {
        return null;
    }

    @Override
    public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account, String authTokenType, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features) throws NetworkErrorException {
        return null;
    }
}
