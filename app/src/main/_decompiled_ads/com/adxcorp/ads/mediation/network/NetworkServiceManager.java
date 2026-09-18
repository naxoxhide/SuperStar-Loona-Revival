package com.adxcorp.ads.mediation.network;

import android.os.Handler;
import android.os.Message;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NetworkServiceManager {
    public static final int MAX_CONNECTIONS = 5;
    public static final String TAG = "NetworkServiceManager";
    private static NetworkServiceManager ourInstance = new NetworkServiceManager();
    private ArrayList<NetworkService> active = new ArrayList<>();
    private ArrayList<NetworkService> queue = new ArrayList<>();

    private NetworkServiceManager() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "NetworkServiceManager instance is created.");
        }
    }

    public static NetworkServiceManager getInstance() {
        return ourInstance;
    }

    public void get(String str, Handler handler) {
        try {
            push(new NetworkService(str, null, handler, "GET"));
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            if (handler != null) {
                handler.sendMessage(Message.obtain(handler, -1));
            }
        }
    }

    public void post(String str, String str2, Handler handler) {
        try {
            push(new NetworkService(str, str2, handler, "POST"));
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            if (handler != null) {
                handler.sendMessage(Message.obtain(handler, -1));
            }
        }
    }

    private void push(NetworkService networkService) {
        this.queue.add(networkService);
        if (this.active.size() < 5) {
            startNext();
        }
    }

    private void startNext() {
        try {
            synchronized (this.queue) {
                try {
                    if (!this.queue.isEmpty()) {
                        NetworkService networkService = this.queue.get(0);
                        this.queue.remove(0);
                        this.active.add(networkService);
                        networkService.process();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    public void didComplete(NetworkService networkService) {
        this.active.remove(networkService);
        startNext();
    }
}
