package com.positron.accountmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AccountAuthenticatorService extends Service {
    public AccountAuthenticatorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        AccountAuthenticatorImpl impl = new AccountAuthenticatorImpl(this);
        return impl.getIBinder();
    }
}
