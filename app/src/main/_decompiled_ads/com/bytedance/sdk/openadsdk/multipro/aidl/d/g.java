package com.bytedance.sdk.openadsdk.multipro.aidl.d;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: RewardAdVideoListenerManagerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends a {
    private static Map<String, RemoteCallbackList<IRewardAdInteractionListener>> a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile g f803b;

    public static g a() {
        if (f803b == null) {
            synchronized (g.class) {
                if (f803b == null) {
                    f803b = new g();
                }
            }
        }
        return f803b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.d.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeRewardVideoCallback(String str, String str2, boolean z, int i, String str3, int i2, String str4) throws RemoteException {
        a(str, str2, z, i, str3, i2, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.d.a, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerRewardVideoListener(String str, IRewardAdInteractionListener iRewardAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iRewardAdInteractionListener);
        a.put(str, remoteCallbackList);
    }

    private synchronized void a(String str, String str2, boolean z, int i, String str3, int i2, String str4) {
        RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackListRemove;
        try {
            if (a != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = a.remove(str);
                } else {
                    remoteCallbackListRemove = a.get(str);
                }
                RemoteCallbackList<IRewardAdInteractionListener> remoteCallbackList = remoteCallbackListRemove;
                if (remoteCallbackList != null) {
                    int iBeginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i3 = 0; i3 < iBeginBroadcast; i3++) {
                        try {
                            IRewardAdInteractionListener iRewardAdInteractionListener = (IRewardAdInteractionListener) remoteCallbackList.getBroadcastItem(i3);
                            if (iRewardAdInteractionListener != null) {
                                if ("onAdShow".equals(str2)) {
                                    iRewardAdInteractionListener.onAdShow();
                                } else if ("onAdClose".equals(str2)) {
                                    iRewardAdInteractionListener.onAdClose();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    iRewardAdInteractionListener.onAdVideoBarClick();
                                } else if ("onRewardVerify".equals(str2)) {
                                    iRewardAdInteractionListener.onRewardVerify(z, i, str3, i2, str4);
                                } else if ("recycleRes".equals(str2)) {
                                    iRewardAdInteractionListener.onDestroy();
                                }
                            }
                        } catch (Throwable th) {
                            m.b("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            m.b("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }
}
