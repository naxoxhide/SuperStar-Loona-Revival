package com.kbeanie.imagechooser.api;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.facebook.share.internal.ShareInternalUtility;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.kbeanie.imagechooser.factory.UriFactory;
import com.kbeanie.imagechooser.helpers.StreamHelper;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BChooser {
    static final String TAG = "BChooser";
    protected Activity activity;
    protected Fragment appFragment;
    protected boolean clearOldFiles;
    protected Bundle extras;
    protected String filePathOriginal;
    protected String foldername;
    protected androidx.fragment.app.Fragment fragment;
    protected boolean shouldCreateThumbnails;
    protected int type;

    public abstract String choose() throws ChooserException;

    public abstract void submit(int i, Intent intent);

    @Deprecated
    public BChooser(Activity activity, int i, String str, boolean z) {
        this.activity = activity;
        this.type = i;
        this.foldername = str;
        this.shouldCreateThumbnails = z;
    }

    @Deprecated
    public BChooser(androidx.fragment.app.Fragment fragment, int i, String str, boolean z) {
        this.fragment = fragment;
        this.type = i;
        this.foldername = str;
        this.shouldCreateThumbnails = z;
    }

    @Deprecated
    public BChooser(Fragment fragment, int i, String str, boolean z) {
        this.appFragment = fragment;
        this.type = i;
        this.foldername = str;
        this.shouldCreateThumbnails = z;
    }

    public BChooser(Activity activity, int i, boolean z) {
        this.activity = activity;
        this.type = i;
        this.shouldCreateThumbnails = z;
        initDirectory(activity.getApplicationContext());
    }

    public BChooser(androidx.fragment.app.Fragment fragment, int i, boolean z) {
        this.fragment = fragment;
        this.type = i;
        this.shouldCreateThumbnails = z;
        initDirectory(fragment.getActivity().getApplicationContext());
    }

    public BChooser(Fragment fragment, int i, boolean z) {
        this.appFragment = fragment;
        this.type = i;
        this.shouldCreateThumbnails = z;
        initDirectory(fragment.getActivity().getApplicationContext());
    }

    protected void checkDirectory() throws ChooserException {
        File file = new File(FileUtils.getDirectory(this.foldername));
        if (!file.exists() && !file.mkdirs() && !file.isDirectory()) {
            throw new ChooserException("Error creating directory: " + file);
        }
    }

    protected void startActivity(Intent intent) {
        Activity activity = this.activity;
        if (activity != null) {
            activity.startActivityForResult(intent, this.type);
            return;
        }
        androidx.fragment.app.Fragment fragment = this.fragment;
        if (fragment != null) {
            fragment.startActivityForResult(intent, this.type);
            return;
        }
        Fragment fragment2 = this.appFragment;
        if (fragment2 != null) {
            fragment2.startActivityForResult(intent, this.type);
        }
    }

    public void reinitialize(String str) {
        this.filePathOriginal = str;
    }

    protected void sanitizeURI(String str) {
        this.filePathOriginal = str;
        if (str.matches("https?://\\w+\\.googleusercontent\\.com/.+")) {
            this.filePathOriginal = str;
        }
        if (str.startsWith("file://")) {
            this.filePathOriginal = str.substring(7);
        }
    }

    protected Context getContext() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity.getApplicationContext();
        }
        androidx.fragment.app.Fragment fragment = this.fragment;
        if (fragment != null) {
            return fragment.getActivity().getApplicationContext();
        }
        Fragment fragment2 = this.appFragment;
        if (fragment2 != null) {
            return fragment2.getActivity().getApplicationContext();
        }
        return null;
    }

    protected boolean wasVideoSelected(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent.getType() != null && intent.getType().startsWith("video")) {
            return true;
        }
        String type = getContext().getContentResolver().getType(intent.getData());
        return type != null && type.startsWith("video");
    }

    public void setExtras(Bundle bundle) {
        this.extras = bundle;
    }

    public Bundle getExtras() {
        return this.extras;
    }

    public long queryProbableFileSize(Uri uri, Context context) {
        if (uri.toString().startsWith(ShareInternalUtility.STAGING_PARAM)) {
            return new File(uri.getPath()).length();
        }
        if (uri.toString().startsWith("content")) {
            Cursor cursorQuery = null;
            try {
                cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                StreamHelper.verifyCursor(uri, cursorQuery);
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
                }
                return 0L;
            } catch (ChooserException unused) {
            } finally {
                if (Build.VERSION.SDK_INT >= 16) {
                    StreamHelper.closeSilent(cursorQuery);
                }
            }
        }
        return 0L;
    }

    private void initDirectory(Context context) {
        this.foldername = new BChooserPreferences(context).getFolderName();
    }

    protected String buildFilePathOriginal(String str, String str2) {
        return UriFactory.getInstance().getFilePathOriginal(str, str2);
    }

    protected Uri buildCaptureUri(String str) {
        return Uri.fromFile(new File(str));
    }

    public void clearOldFiles() {
        this.clearOldFiles = true;
    }
}
