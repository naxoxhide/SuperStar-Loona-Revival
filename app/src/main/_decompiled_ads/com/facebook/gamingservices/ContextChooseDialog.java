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
import com.facebook.gamingservices.model.ContextChooseContent;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ContextChooseDialog extends FacebookDialogBase<ContextChooseContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingContextChoose.toRequestCode();
    private FacebookCallback mCallback;

    public ContextChooseDialog(final Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public ContextChooseDialog(final Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public ContextChooseDialog(final android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private ContextChooseDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    @Override // com.facebook.internal.FacebookDialogBase, com.facebook.FacebookDialog
    public boolean canShow(ContextChooseContent content) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            return true;
        }
        return new FacebookAppHandler().canShow(content, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.internal.FacebookDialogBase
    public void showImpl(final ContextChooseContent content, final Object mode) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(content, mode);
        } else {
            super.showImpl(content, mode);
        }
    }

    private void showForCloud(final ContextChooseContent content, final Object mode) {
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open ContextChooseContent with an invalid access token");
        }
        DaemonRequest.Callback callback = new DaemonRequest.Callback() { // from class: com.facebook.gamingservices.ContextChooseDialog.1
            @Override // com.facebook.gamingservices.cloudgaming.DaemonRequest.Callback
            public void onCompleted(GraphResponse response) {
                if (ContextChooseDialog.this.mCallback != null) {
                    if (response.getError() != null) {
                        ContextChooseDialog.this.mCallback.onError(new FacebookException(response.getError().getErrorMessage()));
                    } else {
                        ContextChooseDialog.this.mCallback.onSuccess(new Result(response));
                    }
                }
            }
        };
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filters", content.getFilters());
            jSONObject.put(SDKConstants.PARAM_CONTEXT_MIN_SIZE, content.getMinSize());
            List<String> filters = content.getFilters();
            if (filters != null && !filters.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < filters.size(); i++) {
                    jSONArray.put(filters.get(i));
                }
                jSONObject.put("filters", jSONArray);
            }
            DaemonRequest.executeAsync(activityContext, jSONObject, callback, SDKMessageEnum.CONTEXT_CHOOSE);
        } catch (JSONException unused) {
            FacebookCallback facebookCallback = this.mCallback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Couldn't prepare Context Choose Dialog"));
            }
        }
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected void registerCallbackImpl(final CallbackManagerImpl callbackManager, final FacebookCallback<Result> callback) {
        this.mCallback = callback;
        final ResultProcessor resultProcessor = callback == null ? null : new ResultProcessor(callback) { // from class: com.facebook.gamingservices.ContextChooseDialog.2
            @Override // com.facebook.share.internal.ResultProcessor
            public void onSuccess(AppCall appCall, Bundle results) {
                if (results != null) {
                    if (results.getString("error_message") != null) {
                        callback.onError(new FacebookException(results.getString("error_message")));
                        return;
                    }
                    if (results.getString("id") != null) {
                        GamingContext.setCurrentGamingContext(new GamingContext(results.getString("id")));
                        callback.onSuccess(new Result(results));
                    }
                    callback.onError(new FacebookException(results.getString("Invalid response received from server.")));
                    return;
                }
                onCancel(appCall);
            }
        };
        callbackManager.registerCallback(getRequestCodeField(), new CallbackManagerImpl.Callback() { // from class: com.facebook.gamingservices.ContextChooseDialog.3
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int resultCode, Intent data) {
                return ShareInternalUtility.handleActivityResult(ContextChooseDialog.this.getRequestCodeField(), resultCode, data, resultProcessor);
            }
        });
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected List<FacebookDialogBase<ContextChooseContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler());
        return arrayList;
    }

    @Override // com.facebook.internal.FacebookDialogBase
    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCodeField());
    }

    public static final class Result {
        String contextID;

        private Result(Bundle results) {
            this.contextID = results.getString("id");
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

    private class FacebookAppHandler extends FacebookDialogBase<ContextChooseContent, Result>.ModeHandler {
        private FacebookAppHandler() {
            super(ContextChooseDialog.this);
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public boolean canShow(final ContextChooseContent content, boolean isBestEffort) {
            PackageManager packageManager = ContextChooseDialog.this.getActivityContext().getPackageManager();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            boolean z = intent.resolveActivity(packageManager) != null;
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            return z && (currentAccessToken != null && currentAccessToken.getGraphDomain() != null && FacebookSdk.GAMING.equals(currentAccessToken.getGraphDomain()));
        }

        @Override // com.facebook.internal.FacebookDialogBase.ModeHandler
        public AppCall createAppCall(final ContextChooseContent content) {
            AppCall appCallCreateBaseAppCall = ContextChooseDialog.this.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "CONTEXT_CHOOSE");
            if (currentAccessToken != null) {
                bundle.putString("game_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("game_id", FacebookSdk.getApplicationId());
            }
            if (content.getMinSize() != null) {
                bundle.putString("min_thread_size", String.valueOf(content.getMinSize()));
            }
            if (content.getMaxSize() != null) {
                bundle.putString("max_thread_size", String.valueOf(content.getMaxSize()));
            }
            if (content.getFilters() != null) {
                bundle.putString("filters", new JSONArray((Collection) content.getFilters()).toString());
            }
            NativeProtocol.setupProtocolRequestIntent(intent, appCallCreateBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            appCallCreateBaseAppCall.setRequestIntent(intent);
            return appCallCreateBaseAppCall;
        }
    }
}
