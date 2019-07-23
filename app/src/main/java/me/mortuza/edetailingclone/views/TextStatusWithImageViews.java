package me.mortuza.edetailingclone.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.mortuza.edetailingclone.R;

public class TextStatusWithImageViews extends RecyclerView.ViewHolder {

    public ImageView mPMenu;
    public TextView mPName;
    public TextView mPAgo;
    public ImageView userSharedImage;
    public ImageView mPImage;

    public TextStatusWithImageViews(@NonNull View itemView) {
        super(itemView);
        mPMenu = itemView.findViewById(R.id.pMenu);
        mPName = itemView.findViewById(R.id.pName);
        mPAgo = itemView.findViewById(R.id.pAgo);
        mPImage = itemView.findViewById(R.id.pImage);
        userSharedImage = itemView.findViewById(R.id.userSharedImage);
    }
}

