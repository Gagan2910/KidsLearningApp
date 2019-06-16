package com.example.admin.mobileapplicationassignment1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter2";

    private Context mcontext;
    private ArrayList<String> mFeaturesName = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();

    public RecyclerViewAdapter2(Context context, ArrayList<String> mFeaturesName, ArrayList<String> mImages) {
        this.mcontext = context;
        this.mFeaturesName = mFeaturesName;
        this.mImages = mImages;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_featureslist, parent,false);
        RecyclerViewAdapter2.ViewHolder holder=new RecyclerViewAdapter2.ViewHolder(view);
        return holder;

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter2.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder:called. ");
        Glide.with(mcontext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
        holder.FeatureName.setText(mFeaturesName.get(position));
        holder.parentLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mFeaturesName.get(position));
               if (position == 0) {
                    Intent intent = new Intent(mcontext, StartactivitiesActivity.class);
                  mcontext.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(mcontext, StartactivitiesActivity.class);
                    mcontext.startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(mcontext, StartactivitiesActivity.class);
                    mcontext.startActivity(intent);
                } else if(position==3){
                    Intent intent = new Intent(mcontext, StartactivitiesActivity.class);
                    mcontext.startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(mcontext, GalleryActivity.class);
                    mcontext.startActivity(intent);
                }

              //  Toast.makeText(ncontext,mFeaturesName.get(position2),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFeaturesName.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout parentLinearLayout;
        CircleImageView image;
        TextView FeatureName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.featureimage);
            FeatureName=itemView.findViewById(R.id.feature_name);
            parentLinearLayout=itemView.findViewById(R.id.parentlinearlayout);
        }

    }
}