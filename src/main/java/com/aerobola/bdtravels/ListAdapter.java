package com.aerobola.bdtravels;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public abstract class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> mImage_names = new ArrayList<>();
    private ArrayList<String> mImage_detail = new ArrayList<>();
    private ArrayList<Integer> mImage_activity = new ArrayList<>();
    private Context mContext;


    public ListAdapter(Context mContext, ArrayList<Integer> mImages, ArrayList<String> mImage_names, ArrayList<String> mImage_detail, ArrayList<Integer> mImage_activity) {
        this.mImages = mImages;
        this.mImage_names = mImage_names;
        this.mImage_detail = mImage_detail;
        this.mContext = mContext;
        this.mImage_activity = mImage_activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,
                parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.image);
        holder.image_name.setText(mImage_names.get(position));
        holder.image_detail.setText(mImage_detail.get(position));
        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mImage_names.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                if (mImage_activity.get(holder.getAdapterPosition()) == 1) {
                    Intent intent = new Intent(mContext, DetailsActivitySundarban.class);
                    mContext.startActivity(intent);
                }
                if (mImage_activity.get(holder.getAdapterPosition()) == 2) {
                    Intent intent = new Intent(mContext, DetailsActivityKuthibari.class);
                    mContext.startActivity(intent);
                }
                if (mImage_activity.get(holder.getAdapterPosition()) == 3) {
                    Intent intent = new Intent(mContext, DetailsActivityShatGombujMashjid.class);
                    mContext.startActivity(intent);
                }
                if (mImage_activity.get(holder.getAdapterPosition()) == 4) {
                    Intent intent = new Intent(mContext, DetailsActivityMujibNagor.class);
                    mContext.startActivity(intent);
                }
                if (mImage_activity.get(holder.getAdapterPosition()) == 5) {
                    Intent intent = new Intent(mContext, DetailsActivityLalon.class);
                    mContext.startActivity(intent);
                }

                //Dhaka

                if (mImage_activity.get(holder.getAdapterPosition()) == 11) {
                    Intent intent = new Intent(mContext, DetailsActivityAhsanMonjil.class);
                    mContext.startActivity(intent);
                }

                if (mImage_activity.get(holder.getAdapterPosition()) == 12) {
                    Intent intent = new Intent(mContext, DetailsActivityHosniDalan.class);
                    mContext.startActivity(intent);
                }

                if (mImage_activity.get(holder.getAdapterPosition()) == 13) {
                    Intent intent = new Intent(mContext, DetailsActivityLalbagKella.class);
                    mContext.startActivity(intent);
                }

            }

        });
    }

    @Override
    public int getItemCount() {
        return mImage_names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView image_name;
        TextView image_detail;
        LinearLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            image_name = itemView.findViewById(R.id.image_name);
            image_detail = itemView.findViewById(R.id.image_details);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}

