package me.mortuza.edetailingclone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import me.mortuza.edetailingclone.ModelStatus;
import me.mortuza.edetailingclone.R;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.Views> {
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
    public Views onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Views(LayoutInflater.from(mContext).inflate(R.layout.ramp_page_adapter_view_holder, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Views views, int i) {
        ModelStatus modelStatus = modelStatuses.get(i);
        views.mPAgo.setText(modelStatus.getAgo());
        views.mPName.setText(modelStatus.getpName());
        views.pDec.setText(modelStatus.getStatus());
        Glide.with(mContext).load(modelStatus.getpImageURL()).apply(new RequestOptions().circleCrop()).into(views.mPImage);
        Linkify.addLinks(views.pDec, Linkify.WEB_URLS);
    }

    @Override
    public int getItemCount() {
        return modelStatuses.size();
    }

    class Views extends RecyclerView.ViewHolder {

        private ImageView mPMenu;
        private TextView mPName;
        private TextView mPAgo;
        private TextView pDec;
        private ImageView mPImage;

        Views(@NonNull View itemView) {
            super(itemView);
            mPMenu = itemView.findViewById(R.id.pMenu);
            mPName = itemView.findViewById(R.id.pName);
            mPAgo = itemView.findViewById(R.id.pAgo);
            mPImage = itemView.findViewById(R.id.pImage);
            pDec = itemView.findViewById(R.id.pDec);
        }
    }
}
