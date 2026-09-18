package com.bytedance.sdk.openadsdk.multipro.aidl.d;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import java.util.HashMap;

/* JADX INFO: compiled from: CommonPermissionListenerManagerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends a {
    private static HashMap<String, RemoteCallbackList<ICommonPermissionListener>> a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile c f800b;

    public static c a() {
        if (f800b == null) {
            synchronized (c.class) {
                if (f800b == null) {
                    f800b = new c();
                }
            }
        }
        return f800b;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.d.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void broadcastPermissionListener(String str, String str2) throws RemoteException {
        m.a("MultiProcess", "00000 CommonPermissionListenerManagerImpl broadcastDialogListener: 00000" + String.valueOf(str) + ", " + str2);
        RemoteCallbackList<ICommonPermissionListener> remoteCallbackListRemove = a.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            ICommonPermissionListener iCommonPermissionListener = (ICommonPermissionListener) remoteCallbackListRemove.getBroadcastItem(i);
            if (iCommonPermissionListener != null) {
                m.a("MultiProcess", "CommonPermissionListenerManagerImpl broadcastDialogListener: " + String.valueOf(str) + ", " + str2);
                if (str2 == null) {
                    iCommonPermissionListener.onGranted();
                } else {
                    iCommonPermissionListener.onDenied(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.d.a, com.bytedance.sdk.openadsdk.IListenerManager
    public void registerPermissionListener(String str, ICommonPermissionListener iCommonPermissionListener) throws RemoteException {
        if (iCommonPermissionListener == null) {
            return;
        }
        m.a("MultiProcess", "CommonPermissionListenerManagerImpl registerPermissionListener");
        RemoteCallbackList<ICommonPermissionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iCommonPermissionListener);
        a.put(str, remoteCallbackList);
    }
}
