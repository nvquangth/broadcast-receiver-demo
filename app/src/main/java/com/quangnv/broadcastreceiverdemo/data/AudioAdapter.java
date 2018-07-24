package com.quangnv.broadcastreceiverdemo.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quangnv.broadcastreceiverdemo.R;

import java.util.ArrayList;
import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.ItemViewHolder> {

    private ItemListener mItemListener;
    private List<Audio> mAudios;
    private LayoutInflater mLayoutInflater;


    public AudioAdapter(Context context, ItemListener itemListener) {
        mItemListener = itemListener;
        mAudios = new ArrayList<>();
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_recycler_view_audio, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, int position) {
        holder.bindView(mAudios.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemListener.onClickListener(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAudios.size();
    }

    public void updateAudios(Audio audio) {
        mAudios.add(audio);
        notifyDataSetChanged();
    }

    public void setAudios(List<Audio> audios) {
        mAudios = audios;
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageViewAudio;
        TextView mTextViewName;

        public ItemViewHolder(View itemView) {
            super(itemView);

            intViews(itemView);

        }

        private void intViews(View itemView) {
            mImageViewAudio = itemView.findViewById(R.id.image_audio);
            mTextViewName = itemView.findViewById(R.id.text_view_name_audio);
        }

        public void bindView(Audio audio) {
            mImageViewAudio.setImageResource(audio.getImage());
            mTextViewName.setText(audio.getName());
        }
    }
}
