package com.positron.accountmanager.Network;

import android.util.Log;

import com.positron.accountmanager.Constants;
import com.positron.accountmanager.Tools.ToolsString;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alepapadop on 4/1/16.
 *
 * Add here functions related to server connection operations
 *
 */
public class NetworkConnectToServer {

    public String download_url(String myurl) throws IOException {
        InputStream is = null;
        HttpURLConnection conn = null;

        try {
            URL url = new URL(myurl);

            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(Constants.NETWORK_READ_TIMEOUT);
            conn.setConnectTimeout(Constants.NETWORK_CONNECT_TIMEOUT);
            conn.setRequestMethod(Constants.NETWORK_REQUEST_METHOD_GET);
            conn.setDoInput(true);
            conn.connect();

            Log.d(Constants.ACCOUNT_LOG_TAG, ((Integer)conn.getResponseCode()).toString());

            is = conn.getInputStream();

            ToolsString string_tool = new ToolsString();
            return string_tool.stream_to_str(is);


        } finally {
            if (is != null) {
                is.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }


}
