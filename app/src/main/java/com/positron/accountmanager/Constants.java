package com.positron.accountmanager;

/**
 * Created by alepapadop on 3/26/16.
 *
 * Use this class in order to store Application Wide Constants
 *
 * Variables with ****_KEY are used in Bundles and Intents in order to pass
 * the data
 *
 */
public class Constants {


    public static final String ACCOUNT_LOG_TAG = "account_log";

    public static final String ACCOUNT_REQUEST_ORIGIN_KEY = "account_request_origin";
    public static final String ACCOUNT_AUTH_TOKEN_TYPE_KEY = "auth_token";
    public static final String ACCOUNT_AUTH_TOKEN_TYPE = "com.positron.account_manager"; // this must be the same as the accountType in authenticator.xml

    public static final Integer  ACCOUNT_REQUEST_SIGN_IN = 0;
    public static final Integer  ACCOUNT_REQUEST_ADD_ACCOUNT = 1;
    public static final Integer  ACCOUNT_REQUEST_SIGN_UP = 2;

    public static final String  ACCOUNT_AUTH_TOKEN_KEY = "this_is_a_tmp_key";
    public static final String  TMP_AUTH_TOKEN = "test_token";

    public static final String  ACCOUNT_USERNAME_KEY = "username";
    public static final String  ACCOUNT_PASSWORD_KEY = "password";

    public static final Integer ACCOUNT_ASYNC_LOADER_SIGN_IN = 0;


    public static final String ACCOUNT_ASYNC_BUNDLE_KEY = "account_async_bundle";

    public static final int NETWORK_READ_TIMEOUT = 10000;
    public static final int NETWORK_CONNECT_TIMEOUT = 15000;

    public static final String NETWORK_REQUEST_METHOD_GET = "GET";

    public static final String SERVER_LOGIN_URL = "https://httpbin.org/get";
}
