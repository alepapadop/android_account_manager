package com.positron.accountmanager;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void sign_up_commit(View view) {

        EditText username_te = (EditText)findViewById(R.id.sign_up_username);
        String username = username_te.getText().toString();

        EditText password_te = (EditText)findViewById(R.id.sign_up_password);
        String password = password_te.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(Constants.ACCOUNT_USERNAME, username);
        intent.putExtra(Constants.ACCOUNT_PASSWORD, password);
        intent.putExtra(Constants.ACCOUNT_AUTH_TOKEN_KEY, Constants.TMP_AUTH_TOKEN);
        setResult(RESULT_OK, intent);
        finish();
    }

}
