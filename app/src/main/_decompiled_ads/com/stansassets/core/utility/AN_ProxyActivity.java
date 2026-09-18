package com.stansassets.core.utility;

import android.app.Activity;
import android.content.Intent;
import com.stansassets.core.interfaces.AN_ActivityCreateCallback;
import com.stansassets.core.interfaces.AN_ActivityResultCallback;
import com.stansassets.core.interfaces.AN_iProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class AN_ProxyActivity extends Activity implements AN_iProxyActivity {
    private static final String CALLBACK_ID = "CALLBACK_ID";
    private static HashMap<String, AN_ActivityCreateCallback> m_callbacks = new HashMap<>();
    private ArrayList<AN_ActivityResultCallback> m_activityResultCallbacks = new ArrayList<>();
    private boolean m_onActivityResultReceived = false;
    private boolean m_isRestarting = false;

    public static void Create(AN_ActivityCreateCallback<AN_ProxyActivity> aN_ActivityCreateCallback) {
        Intent intent = new Intent(AN_UnityBridge.currentActivity, (Class<?>) AN_ProxyActivity.class);
        String strRandomString = SA_IdFactory.RandomString();
        intent.putExtra(CALLBACK_ID, strRandomString);
        m_callbacks.put(strRandomString, aN_ActivityCreateCallback);
        AN_UnityBridge.currentActivity.startActivity(intent);
    }

    public static void startForResult(final Intent intent, final AN_ActivityResultCallback aN_ActivityResultCallback) {
        Create(new AN_ActivityCreateCallback<AN_ProxyActivity>() { // from class: com.stansassets.core.utility.AN_ProxyActivity.1
            @Override // com.stansassets.core.interfaces.AN_ActivityCreateCallback
            public void OnCreate(final AN_ProxyActivity aN_ProxyActivity) {
                aN_ProxyActivity.AddActivityResultListener(new AN_ActivityResultCallback() { // from class: com.stansassets.core.utility.AN_ProxyActivity.1.1
                    @Override // com.stansassets.core.interfaces.AN_ActivityResultCallback
                    public void onActivityResult(int i, int i2, Intent intent2) {
                        aN_ActivityResultCallback.onActivityResult(i, i2, intent2);
                        aN_ProxyActivity.finish();
                    }
                });
                aN_ProxyActivity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.m_isRestarting = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        AN_Logger.Log("AN_ProxyActivity onStart");
        String stringExtra = getIntent().getStringExtra(CALLBACK_ID);
        if (m_callbacks.containsKey(stringExtra)) {
            m_callbacks.get(stringExtra).OnCreate(this);
            m_callbacks.remove(stringExtra);
        } else {
            if (this.m_isRestarting) {
                return;
            }
            AN_Logger.Log("AN_ProxyActivity onStart callback was already fired, activity will be finished");
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        AN_Logger.Log("AN_ProxyActivity::onActivityResult");
        this.m_onActivityResultReceived = true;
        Iterator<AN_ActivityResultCallback> it = this.m_activityResultCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
        AN_Logger.Log("AN_ProxyActivity::finish");
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AN_Logger.Log("AN_ProxyActivity::onDestroy");
        if (this.m_onActivityResultReceived) {
            return;
        }
        AN_Logger.Log("We have onDestroy before we got a chance to send something. Force send empty results ");
        Iterator<AN_ActivityResultCallback> it = this.m_activityResultCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(-1, -1, null);
        }
    }

    @Override // com.stansassets.core.interfaces.AN_iProxyActivity
    public void AddActivityResultListener(AN_ActivityResultCallback aN_ActivityResultCallback) {
        this.m_activityResultCallbacks.add(aN_ActivityResultCallback);
    }
}
