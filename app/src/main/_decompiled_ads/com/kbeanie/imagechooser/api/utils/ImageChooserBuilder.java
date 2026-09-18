package com.kbeanie.imagechooser.api.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: loaded from: classes2.dex */
public class ImageChooserBuilder extends AlertDialog.Builder {
    private Context context;
    private DialogInterface.OnClickListener listener;
    private String title;
    private String titleGalleryOption;
    private String titleTakePictureOption;

    public ImageChooserBuilder(Context context, int i, DialogInterface.OnClickListener onClickListener) {
        super(context, i);
        this.listener = onClickListener;
        this.context = context;
        setupDefaultData();
    }

    public ImageChooserBuilder(Context context, DialogInterface.OnClickListener onClickListener) {
        super(context);
        this.listener = onClickListener;
        this.context = context;
        setupDefaultData();
    }

    public AlertDialog.Builder setDialogTitle(String str) {
        this.title = str;
        return this;
    }

    public AlertDialog.Builder setDialogTitle(int i) {
        this.title = this.context.getString(i);
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

    public AlertDialog.Builder setTitleTakePictureOption(String str) {
        this.titleTakePictureOption = str;
        return this;
    }

    public AlertDialog.Builder setTitleTakePictureOption(int i) {
        this.titleTakePictureOption = this.context.getString(i);
        return this;
    }

    private void setupDefaultData() {
        this.title = "Choose an option";
        this.titleGalleryOption = "Choose from Gallery";
        this.titleTakePictureOption = "Take a picture";
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        setTitle(this.title);
        setItems(new CharSequence[]{this.titleGalleryOption, this.titleTakePictureOption}, new DialogInterface.OnClickListener() { // from class: com.kbeanie.imagechooser.api.utils.ImageChooserBuilder.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ImageChooserBuilder.this.listener.onClick(dialogInterface, ChooserType.REQUEST_PICK_PICTURE);
                } else if (i == 1) {
                    ImageChooserBuilder.this.listener.onClick(dialogInterface, ChooserType.REQUEST_CAPTURE_PICTURE);
                }
            }
        });
        return super.create();
    }
}
