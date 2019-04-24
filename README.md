### Note
- If app target android 24, don't register CONNECTIVITY_ACTION broadcast in manifest.
However, we can register broadcast by `Context.registerReceiver()`. However CONNECTIVITY_ACTION
constant was deprecated in API level 28 => use another way for listen connection change
https://developer.android.com/reference/android/net/ConnectivityManager.html#CONNECTIVITY_ACTION