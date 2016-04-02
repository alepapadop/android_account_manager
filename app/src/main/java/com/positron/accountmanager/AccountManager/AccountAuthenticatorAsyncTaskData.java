package com.positron.accountmanager.AccountManager;

import java.io.Serializable;

/**
 * Created by alepapadop on 3/31/16.
 *
 * Use this class in order to pass and get data from the AsyncTaskLoaderCalls during
 * Account Manager Operations
 *
 */
public class AccountAuthenticatorAsyncTaskData implements Serializable{

    private String _username;
    private String _password;
    private String _auth_token;
    private String _url;

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_auth_token() {
        return _auth_token;
    }

    public void set_auth_token(String _auth_token) {
        this._auth_token = _auth_token;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}
