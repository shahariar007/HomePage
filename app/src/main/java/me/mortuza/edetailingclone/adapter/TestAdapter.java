package me.mortuza.edetailingclone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import me.mortuza.edetailingclone.ModelStatus;
import me.mortuza.edetailingclone.R;
import me.mortuza.edetailingclone.views.TextStatusViews;
import me.mortuza.edetailingclone.views.TextStatusWithImageViews;

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<ModelStatus> modelStatuses = new ArrayList<>();

    public TestAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setModelStatuses(List<ModelStatus> modelStatuses) {
        this.modelStatuses = modelStatuses;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0)
            return new TextStatusViews((LayoutInflater.from(mContext).inflate(R.layout.ramp_page_adapter_view_holder, viewGroup, false)));

        return new TextStatusWithImageViews((LayoutInflater.from(mContext).inflate(R.layout.ramp_page_adapter_image_with_text, viewGroup, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == 0) {
            TextStatusViews textStatusViews = (TextStatusViews) viewHolder;
            ModelStatus modelStatus = modelStatuses.get(i);
            textStatusViews.mPAgo.setText(modelStatus.getAgo());
            textStatusViews.mPName.setText(modelStatus.getpName());
            textStatusViews.pDec.setText(modelStatus.getStatus());
            Glide.with(mContext).load(modelStatus.getpImageURL()).apply(new RequestOptions().circleCrop()).into(textStatusViews.mPImage);
            Linkify.addLinks(textStatusViews.pDec, Linkify.WEB_URLS);
        } else {
            TextStatusWithImageViews textStatusViews = (TextStatusWithImageViews) viewHolder;
            ModelStatus modelStatus = modelStatuses.get(i);
            textStatusViews.mPAgo.setText(modelStatus.getAgo());
            textStatusViews.mPName.setText(modelStatus.getpName());

            Glide.with(mContext).load(modelStatus.getpImageURL()).apply(new RequestOptions().circleCrop()).into(textStatusViews.mPImage);
            Glide.with(mContext).load(modelStatus.getpImageURL()).into(textStatusViews.userSharedImage);
            //Linkify.addLinks(textStatusViews.pDec, Linkify.WEB_URLS);
        }
    }


    @Override
    public int getItemCount() {
        return modelStatuses.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }
}
