package com.komoriwu.one.all.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.komoriwu.one.R;
import com.komoriwu.one.model.bean.FindBean;
import com.komoriwu.one.model.bean.ItemListBean;
import com.komoriwu.one.utils.Constants;
import com.komoriwu.one.utils.Utils;
import com.komoriwu.one.widget.DCTextView;
import com.komoriwu.one.widget.FZTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KomoriWu
 * on 2017-12-27.
 */

public class BannerVideoBriefAdapter extends RecyclerView.Adapter<BannerVideoBriefAdapter.
        BannerVideoBriefViewHolder> {

    private Context mContext;
    private List<ItemListBean> mItemListBeans;

    BannerVideoBriefAdapter(Context mContext, List<ItemListBean> itemList) {
        this.mContext = mContext;
        this.mItemListBeans = itemList;
    }

    @Override
    public int getItemViewType(int position) {
        return Constants.ALL_VIEW_TAPE;
    }

    @Override
    public BannerVideoBriefViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_brief_card, parent,
                false);
        return new BannerVideoBriefViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BannerVideoBriefViewHolder holder, int position) {
        ItemListBean itemListBean = mItemListBeans.get(position);
        Utils.displayImage(mContext, itemListBean.getData().getCover().getFeed(), holder.ivCard);
        holder.tvTime.setText(Utils.durationFormat(itemListBean.getData().getDuration()));
        holder.tvTitle.setText(itemListBean.getData().getTitle());
        holder.tvDescription.setText(String.format(mContext.getString(R.string.category1),
                itemListBean.getData().getCategory()));

        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.item_alpha);
        animation.setFillAfter(true);
        holder.ivCard.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return mItemListBeans == null ? 0 : mItemListBeans.size();
    }

    class BannerVideoBriefViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_card)
        ImageView ivCard;
        @BindView(R.id.tv_time)
        DCTextView tvTime;
        @BindView(R.id.tv_title)
        FZTextView tvTitle;
        @BindView(R.id.tv_description)
        FZTextView tvDescription;

        BannerVideoBriefViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}