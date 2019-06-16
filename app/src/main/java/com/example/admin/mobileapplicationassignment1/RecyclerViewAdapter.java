package com.example.admin.mobileapplicationassignment1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private Context mcontext;
    private ArrayList<String> mImagesName=new ArrayList<>();
    private ArrayList<String> mImages=new ArrayList<>();

    public RecyclerViewAdapter(Context context, ArrayList<String> mImagesName, ArrayList<String> mImages) {
        this.mcontext = context;
        this.mImagesName = mImagesName;
        this.mImages = mImages;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent,false);
     ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder:called. ");
        Glide.with(mcontext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
        holder.imageName.setText(mImagesName.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: clicked on: " + mImagesName.get(position));
                if(position==0) {
                    Intent intent = new Intent(mcontext, AboutapplicationActivity.class);
                    mcontext.startActivity(intent);
                }
                else  if(position==1)
                {Intent intent = new Intent(mcontext, FeaturesActivity.class);
                    mcontext.startActivity(intent);
                }
                else  if(position==2)
                {Intent intent = new Intent(mcontext, ContactusActivity.class);
                    mcontext.startActivity(intent);
                }
                else  if(position==3)
                {Intent intent = new Intent(mcontext, AboutdeveloperActivity.class);
                    mcontext.startActivity(intent);
                }
                else
                {
                Intent intent = new Intent(mcontext, GoogleMapsActivity.class);
                    mcontext.startActivity(intent);

                }
               // Toast.makeText(mcontext,mImagesName.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return mImagesName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout parentLayout;
        CircleImageView image;
        TextView imageName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.featureimage);
            imageName=itemView.findViewById(R.id.image_name);
            parentLayout=itemView.findViewById(R.id.parent_layout);


        }

    }
}
