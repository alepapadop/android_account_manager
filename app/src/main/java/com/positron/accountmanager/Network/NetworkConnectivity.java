package com.positron.accountmanager.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by alepapadop on 4/1/16.
 */
public class NetworkConnectivity {

    private static NetworkConnectivity _network_conn = null;
    private ConnectivityManager _conn_manager = null;
    private Context _context;

    NetworkConnectivity() {

    }

    public static synchronized NetworkConnectivity get_network_connectivity() {
        if (_network_conn == null) {
            _network_conn = new NetworkConnectivity();
        }

        return _network_conn;
    }

    private NetworkInfo get_active_network(Context context) {

        ConnectivityManager conn_manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo active_network = conn_manager.getActiveNetworkInfo();

        return active_network;
    }

    public boolean is_network_up(Context context) {
        NetworkInfo active_network = get_active_network(context);

        return active_network != null && active_network.isConnectedOrConnecting();
    }

    public boolean is_network_wifi(Context context) {
        NetworkInfo active_network = get_active_network(context);

        return active_network != null && active_network.getType() == ConnectivityManager.TYPE_WIFI;
    }

    public boolean is_network_mobile(Context context) {
        NetworkInfo active_network = get_active_network(context);

        return active_network != null && active_network.getType() == ConnectivityManager.TYPE_MOBILE;
    }


}
