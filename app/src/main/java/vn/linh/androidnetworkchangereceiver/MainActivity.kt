package vn.linh.androidnetworkchangereceiver

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ConnectionStateMonitor().enable(this)
    }

    class ConnectionStateMonitor : NetworkCallback() {
        private val networkRequest: NetworkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI).build()

        fun enable(context: Context) {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            connectivityManager.registerNetworkCallback(networkRequest, this)
        }

        override fun onAvailable(network: Network) {
            Log.i(TAG, "onAvailable ")
        }

        override fun onLost(network: Network?) {
            super.onLost(network)
            Log.i(TAG, "onLost ")
        }
    }

    companion object {
        const val TAG = "ConnectionStateMonitor"
    }
}
