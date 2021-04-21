package com.example.Connnect4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class Recyle_adapter extends RecyclerView.Adapter<Recyle_adapter.ViewHolder>{

    private ArrayList<String> mbox = new ArrayList<>();
    private ArrayList<String> mbox_text = new ArrayList<>();
    private Context mContext;

    public Recyle_adapter(ArrayList<String> box, ArrayList<String> box_text, Context mContext) {
        this.mbox = box;
        this.mbox_text = box_text;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //holder.box.text(mbox.get(position));

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView box;
        TextView boxText;
        ConstraintLayout recycleLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            box = itemView.findViewById(R.id.box);
            boxText = itemView.findViewById(R.id.box_text);
            recycleLayout = itemView.findViewById(R.id.recyler_layout);
        }
    }
}
