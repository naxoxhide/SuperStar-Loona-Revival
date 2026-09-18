package com.stansassets.android.app.permissions;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.stansassets.core.interfaces.AN_ActivityCreateCallback;
import com.stansassets.core.interfaces.AN_RequestPermissionsResult;
import com.stansassets.core.utility.AN_UnityBridge;
import com.stansassets.core.utility.SA_IdFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class AN_PermissionsProxyActivity extends Activity {
    private static final String CALLBACK_ID = "CALLBACK_ID";
    private static HashMap<String, AN_ActivityCreateCallback> m_callbacks = new HashMap<>();
    private ArrayList<AN_RequestPermissionsResult> m_requestPermissionsResultCallbacks = new ArrayList<>();

    public static void Create(AN_ActivityCreateCallback<AN_PermissionsProxyActivity> aN_ActivityCreateCallback) {
        Intent intent = new Intent(AN_UnityBridge.currentActivity, (Class<?>) AN_PermissionsProxyActivity.class);
        String strRandomString = SA_IdFactory.RandomString();
        intent.putExtra(CALLBACK_ID, strRandomString);
        m_callbacks.put(strRandomString, aN_ActivityCreateCallback);
        AN_UnityBridge.currentActivity.startActivity(intent);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        String stringExtra = getIntent().getStringExtra(CALLBACK_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        AN_ActivityCreateCallback aN_ActivityCreateCallback = m_callbacks.get(stringExtra);
        if (aN_ActivityCreateCallback == null) {
            finish();
        } else {
            aN_ActivityCreateCallback.OnCreate(this);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Iterator<AN_RequestPermissionsResult> it = this.m_requestPermissionsResultCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void AddRequestPermissionsResultListner(AN_RequestPermissionsResult aN_RequestPermissionsResult) {
        this.m_requestPermissionsResultCallbacks.add(aN_RequestPermissionsResult);
    }
}
