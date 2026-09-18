package com.kbeanie.imagechooser.api;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.kbeanie.imagechooser.exceptions.ChooserException;
import com.kbeanie.imagechooser.threads.FileProcessorListener;
import com.kbeanie.imagechooser.threads.FileProcessorThread;

/* JADX INFO: loaded from: classes2.dex */
public class FileChooserManager extends MediaChooserManager implements FileProcessorListener {
    private static final String TAG = "FileChooserManager";
    private FileChooserListener listener;
    private String mimeType;

    public FileChooserManager(Activity activity) {
        super(activity, 500);
    }

    public FileChooserManager(Fragment fragment) {
        super(fragment, 500);
    }

    public FileChooserManager(android.app.Fragment fragment) {
        super(fragment, 500);
    }

    public FileChooserManager(Activity activity, String str) {
        super(activity, 500, str);
    }

    public FileChooserManager(Fragment fragment, String str) {
        super(fragment, 500, str);
    }

    public FileChooserManager(android.app.Fragment fragment, String str) {
        super(fragment, 500, str);
    }

    public FileChooserManager(Activity activity, boolean z) {
        super(activity, 500, z);
    }

    public FileChooserManager(Fragment fragment, boolean z) {
        super(fragment, 500, z);
    }

    public FileChooserManager(android.app.Fragment fragment, boolean z) {
        super(fragment, 500, z);
    }

    public FileChooserManager(Activity activity, String str, boolean z) {
        super(activity, 500, str, z);
    }

    public FileChooserManager(Fragment fragment, String str, boolean z) {
        super(fragment, 500, str, z);
    }

    public FileChooserManager(android.app.Fragment fragment, String str, boolean z) {
        super(fragment, 500, str, z);
    }

    public void setFileChooserListener(FileChooserListener fileChooserListener) {
        this.listener = fileChooserListener;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    @Override // com.kbeanie.imagechooser.api.MediaChooserManager, com.kbeanie.imagechooser.api.BChooser
    public String choose() throws ChooserException {
        if (this.listener == null) {
            throw new IllegalArgumentException("FileChooserListener cannot be null. Forgot to set FileChooserListener???");
        }
        if (this.mimeType == null) {
            this.mimeType = "*/*";
        }
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType(this.mimeType);
            intent.addFlags(1);
            intent.addCategory("android.intent.category.OPENABLE");
            startActivity(intent);
            return null;
        } catch (ActivityNotFoundException e) {
            throw new ChooserException(e);
        }
    }

    @Override // com.kbeanie.imagechooser.api.MediaChooserManager, com.kbeanie.imagechooser.api.BChooser
    public void submit(int i, Intent intent) throws Throwable {
        try {
            if (i != this.type) {
                onError("onActivityResult requestCode is different from the type the chooser was initialized with.");
            } else {
                processFile(intent);
            }
        } catch (Exception e) {
            onError(e.getMessage());
        }
    }

    private void processFile(Intent intent) throws Throwable {
        FileProcessorThread fileProcessorThread = new FileProcessorThread(intent.getDataString(), this.foldername, this.shouldCreateThumbnails);
        fileProcessorThread.clearOldFiles(this.clearOldFiles);
        fileProcessorThread.setListener(this);
        if (this.activity != null) {
            fileProcessorThread.setContext(this.activity.getApplicationContext());
        } else if (this.fragment != null) {
            fileProcessorThread.setContext(this.fragment.getActivity().getApplicationContext());
        } else if (this.appFragment != null) {
            fileProcessorThread.setContext(this.appFragment.getActivity().getApplicationContext());
        }
        fileProcessorThread.start();
    }

    @Override // com.kbeanie.imagechooser.threads.FileProcessorListener
    public void onProcessedFile(ChosenFile chosenFile) {
        FileChooserListener fileChooserListener = this.listener;
        if (fileChooserListener != null) {
            fileChooserListener.onFileChosen(chosenFile);
        }
    }

    @Override // com.kbeanie.imagechooser.api.MediaChooserManager, com.kbeanie.imagechooser.threads.ImageProcessorListener, com.kbeanie.imagechooser.threads.VideoProcessorListener, com.kbeanie.imagechooser.threads.FileProcessorListener
    public void onError(String str) {
        super.onError(str);
        FileChooserListener fileChooserListener = this.listener;
        if (fileChooserListener != null) {
            fileChooserListener.onError(str);
        }
    }
}
