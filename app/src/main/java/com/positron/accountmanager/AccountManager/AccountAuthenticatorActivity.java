package com.positron.accountmanager.AccountManager;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;

import com.positron.accountmanager.Constants;
import com.positron.accountmanager.SignIn;
import com.positron.accountmanager.SignUp;


public class AccountAuthenticatorActivity extends android.accounts.AccountAuthenticatorActivity {

    private String          _auth_token_type = null;
    private Integer         _account_request = null;
    private AccountManager  _account_manager = null;
    private Integer         _request = null;
    private String          _username = null;
    private String          _password = null;
    private String          _auth_token = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            _request = bundle.getInt(Constants.ACCOUNT_REQUEST_ORIGIN_KEY);

            _auth_token_type = bundle.getString(Constants.ACCOUNT_AUTH_TOKEN_TYPE_KEY);
            _account_request = bundle.getInt(Constants.ACCOUNT_REQUEST_ORIGIN_KEY);

        }

        if (_auth_token_type == null) {
            _auth_token_type = Constants.ACCOUNT_AUTH_TOKEN_TYPE;
        }

        if (_account_request == null) {
            _account_request = Constants.ACCOUNT_REQUEST_SIGN_UP;
        }

        _account_manager = AccountManager.get(getBaseContext());

        Intent intent = null;

        if (_request.equals(Constants.ACCOUNT_REQUEST_ADD_ACCOUNT)) {
            intent = new Intent(this, SignUp.class);
        } else if (_request.equals(Constants.ACCOUNT_REQUEST_SIGN_UP)) {
            intent = new Intent(this, SignUp.class);
        } else if (_request.equals(Constants.ACCOUNT_REQUEST_SIGN_IN)) {
            intent = new Intent(this, SignIn.class);
        } else {
            assert true;
        }

        startActivityForResult(intent, _request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Check which request we're responding to
        if (requestCode == Constants.ACCOUNT_REQUEST_ADD_ACCOUNT) {
            if (resultCode == RESULT_OK) {
                _username = data.getStringExtra(Constants.ACCOUNT_USERNAME_KEY);
                _password = data.getStringExtra(Constants.ACCOUNT_PASSWORD_KEY);
                _auth_token = data.getStringExtra(Constants.ACCOUNT_AUTH_TOKEN_TYPE_KEY);

                create_account();
            }
        } else if (requestCode == Constants.ACCOUNT_REQUEST_SIGN_UP) {
            if (resultCode == RESULT_OK) {
                assert true;
            }
        } else if (requestCode == Constants.ACCOUNT_REQUEST_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                assert true;
            }
        } else {
            assert true;
        }

        finish();
    }

    private void create_account() {

        final Account account = new Account(_username, _auth_token_type);

        _account_manager.addAccountExplicitly(account, _password, null);
        _account_manager.setAuthToken(account, _auth_token_type, _auth_token);
    }

}
