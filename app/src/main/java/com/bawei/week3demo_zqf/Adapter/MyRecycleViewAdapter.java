package com.bawei.week3demo_zqf.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.week3demo_zqf.JavaBeans.Bean;
import com.bawei.week3demo_zqf.R;
import com.bawei.week3demo_zqf.Utils.ImageLoaderUtils;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder> implements View.OnClickListener {
    private Context context;
    private Bean bean;

    public MyRecycleViewAdapter(Bean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        if (mMyItemclickListener != null) {
            mMyItemclickListener.itemclick(view, (Integer) view.getTag());
        }
    }

    public final int Type = 555;
    public final int Type2 = 666;

    @Override
    public int getItemViewType(int position) {

        if (position % 2 == 0) {
            return Type;
        } else {
            return Type2;
        }
    }

    public interface MyItemclickListener {
        void itemclick(View view, int position);
    }

    public MyItemclickListener mMyItemclickListener;

    public void setmMyItemclickListener(MyItemclickListener mMyItemclickListener) {
        this.mMyItemclickListener = mMyItemclickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case Type:
                View inflate = View.inflate(context, R.layout.item0, null);
                inflate.setOnClickListener(this);
                return new MyViewHolder(inflate);
            case Type2:
                View inflate2 = View.inflate(context, R.layout.item, null);
                inflate2.setOnClickListener(this);
                return new MyViewHolder(inflate2);
            default:
                break;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.itemView.setTag(position);
        int type = getItemViewType(position);
        switch (type) {
            case Type:
                String images = bean.data.get(position).images;
                String[] split = images.split("\\|");
                ImageLoaderUtils.setImageView(split[0],context,holder.image1);
                ImageLoaderUtils.setImageView(split[1],context,holder.image2);
                ImageLoaderUtils.setImageView(split[2],context,holder.image3);
                break;
            case Type2:
                holder.tv_title.setText(bean.data.get(position).title);
                holder.tv_title2.setText(bean.data.get(position).subhead);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return bean.data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image1;
        private final ImageView image2;
        private final ImageView image3;
        private final TextView tv_title;
        private final TextView tv_title2;

        public MyViewHolder(View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            image3 = itemView.findViewById(R.id.image3);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_title2 = itemView.findViewById(R.id.tv_title2);
        }
    }
}