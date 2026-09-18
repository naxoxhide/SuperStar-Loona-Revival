package com.kbeanie.imagechooser.api.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: loaded from: classes2.dex */
public class VideoChooserBuilder extends AlertDialog.Builder {
    private Context context;
    private DialogInterface.OnClickListener listener;
    private String title;
    private String titleCaptureVideoOption;
    private String titleGalleryOption;

    public VideoChooserBuilder(Context context, int i, DialogInterface.OnClickListener onClickListener) {
        super(context, i);
        this.listener = onClickListener;
        this.context = context;
        setupDefaultData();
    }

    public VideoChooserBuilder(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        this.listener = onClickListener;
        this.context = context;
        setupDefaultData();
    }

    public AlertDialog.Builder setDialogTitle(int i) {
        this.title = this.context.getString(i);
        return this;
    }

    public AlertDialog.Builder setDialogTitle(String str) {
        this.title = str;
        return this;
    }

    public AlertDialog.Builder setTitleGalleryOption(String str) {
        this.titleGalleryOption = str;
        return this;
    }

    public AlertDialog.Builder setTitleGalleryOption(int i) {
        this.titleGalleryOption = this.context.getString(i);
        return this;
    }

    public AlertDialog.Builder setTitleCaptureVideoOption(String str) {
        this.titleCaptureVideoOption = str;
        return this;
    }

    public AlertDialog.Builder setTitleCaptureVideoOption(int i) {
        this.titleCaptureVideoOption = this.context.getString(i);
        return this;
    }

    private void setupDefaultData() {
        this.title = "Choose an option";
        this.titleGalleryOption = "Choose from Gallery";
        this.titleCaptureVideoOption = "Capture Video";
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        setTitle(this.title);
        setItems(new CharSequence[]{this.titleGalleryOption, this.titleCaptureVideoOption}, new DialogInterface.OnClickListener() { // from class: com.kbeanie.imagechooser.api.utils.VideoChooserBuilder.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    VideoChooserBuilder.this.listener.onClick(dialogInterface, ChooserType.REQUEST_PICK_VIDEO);
                } else if (i == 1) {
                    VideoChooserBuilder.this.listener.onClick(dialogInterface, ChooserType.REQUEST_CAPTURE_VIDEO);
                }
            }
        });
        return super.create();
    }
}
