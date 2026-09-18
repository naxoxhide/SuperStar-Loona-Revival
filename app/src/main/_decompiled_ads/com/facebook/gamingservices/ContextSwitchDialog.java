package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.webkit.internal.AssetHelper;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.gamingservices.model.ContextSwitchContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ContextSwitchDialog extends FacebookDialogBase<ContextSwitchContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingContextSwitch.toRequestCode();
    private FacebookCallback mCallback;

    public ContextSwitchDialog(final Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public ContextSwitchDialog(final Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public ContextSwitchDialog(final android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private ContextSwitchDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    public boolean canShow(ContextSwitchContent content) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            return true;
        }
        return new FacebookAppHandler().canShow(content, true) || new WebHandler().canShow(content, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(final ContextSwitchContent content, final Object mode) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(content, mode);
        } else {
            super.showImpl(content, mode);
        }
    }

    private void showForCloud(final ContextSwitchContent content, final Object mode) {
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open ContextSwitchContent with an invalid access token");
        }
        DaemonRequest.Callback callback = new DaemonRequest.Callback() { // from class: com.facebook.gamingservices.ContextSwitchDialog.1
            @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
            public void onCompleted(GraphResponse response) {
                if (ContextSwitchDialog.this.mCallback != null) {
                    if (response.getError() != null) {
                        ContextSwitchDialog.this.mCallback.onError(new FacebookException(response.getError().getErrorMessage()));
                    } else {
                        ContextSwitchDialog.this.mCallback.onSuccess(new Result(response));
                    }
                }
            }
        };
        String contextID = content.getContextID();
        if (contextID == null) {
            FacebookCallback facebookCallback = this.mCallback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Required string contextID not provided."));
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", contextID);
            DaemonRequest.executeAsync(activityContext, jSONObject, callback, SDKMessageEnum.CONTEXT_SWITCH);
        } catch (JSONException unused) {
            FacebookCallback facebookCallback2 = this.mCallback;
            if (facebookCallback2 != null) {
                facebookCallback2.onError(new FacebookException("Couldn't prepare Context Switch Dialog"));
            }
        }
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(final CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback) {
        this.mCallback = callback;
        final ResultProcessor resultProcessor = callback == null ? null : new ResultProcessor(callback) { // from class: com.facebook.gamingservices.ContextSwitchDialog.2
            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle results) {
                if (results != null) {
                    if (results.getString("error_message") != null) {
                        callback.onError(new FacebookException(results.getString("error_message")));
                        return;
                    }
                    if (results.getString("id") != null) {
                        GamingContext.setCurrentGamingContext(new GamingContext(results.getString("id")));
                        callback.onSuccess(new Result(results.getString("id")));
                    } else if (results.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID) != null) {
                        GamingContext.setCurrentGamingContext(new GamingContext(results.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID)));
                        callback.onSuccess(new Result(results.getString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID)));
                    }
                    callback.onError(new FacebookException(results.getString("Invalid response received from server.")));
                    return;
                }
                onCancel(appCall);
            }
        };
        callbackManager.registerCallback(getRequestCodeField(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.ContextSwitchDialog.3
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int resultCode, Intent data) {
                return ShareInternalUtility.handleActivityResult(ContextSwitchDialog.this.getRequestCodeField(), resultCode, data, resultProcessor);
            }
        });
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<ContextSwitchContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler());
        arrayList.add(new WebHandler());
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCodeField());
    }

    public static final class Result {
        String contextID;

        private Result(String contextID) {
            this.contextID = contextID;
        }

        private Result(GraphResponse response) {
            try {
                JSONObject graphObject = response.getGraphObject();
                if (graphObject == null) {
                    this.contextID = null;
                } else {
                    JSONObject jSONObjectOptJSONObject = graphObject.optJSONObject("data");
                    this.contextID = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.getString("id") : null;
                }
            } catch (JSONException unused) {
                this.contextID = null;
            }
        }

        public String getContextID() {
            return this.contextID;
        }
    }

    private class WebHandler extends FacebookDialogBase<ContextSwitchContent, Result>.ModeHandler {
        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(final ContextSwitchContent content, boolean isBestEffort) {
            return true;
        }

        private WebHandler() {
            super(ContextSwitchDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final ContextSwitchContent content) {
            AppCall appCallCreateBaseAppCall = ContextSwitchDialog.this.createBaseAppCall();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_CONTEXT_CONTEXT_ID, content.getContextID());
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                bundle.putString("dialog_access_token", currentAccessToken.getToken());
            }
            DialogPresenter.setupAppCallForWebDialog(appCallCreateBaseAppCall, "context", bundle);
            return appCallCreateBaseAppCall;
        }
    }

    private class FacebookAppHandler extends FacebookDialogBase<ContextSwitchContent, Result>.ModeHandler {
        private FacebookAppHandler() {
            super(ContextSwitchDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(final ContextSwitchContent content, boolean isBestEffort) {
            PackageManager packageManager = ContextSwitchDialog.this.getActivityContext().getPackageManager();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            boolean z = intent.resolveActivity(packageManager) != null;
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            return z && (currentAccessToken != null && currentAccessToken.getGraphDomain() != null && FacebookSdk.GAMING.equals(currentAccessToken.getGraphDomain()));
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final ContextSwitchContent content) {
            AppCall appCallCreateBaseAppCall = ContextSwitchDialog.this.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "CONTEXT_SWITCH");
            if (currentAccessToken != null) {
                bundle.putString("game_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("game_id", FacebookSdk.getApplicationId());
            }
            if (content.getContextID() != null) {
                bundle.putString("context_token_id", content.getContextID());
            }
            NativeProtocol.setupProtocolRequestIntent(intent, appCallCreateBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            appCallCreateBaseAppCall.setRequestIntent(intent);
            return appCallCreateBaseAppCall;
        }
    }
}
