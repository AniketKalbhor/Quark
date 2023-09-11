package com.example.task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//use default function of adapter, view holder holds the view of recycler
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    ArrayList<rowModel> rowModelArrayList;
    RecyclerAdapter(Context context, ArrayList<rowModel> rowModelArrayList){
        this.context = context;
        this.rowModelArrayList = rowModelArrayList;
    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        use layout inflator class to create view from layout
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
//        View v = LayoutInflater.from(context).inflate(R.layout.row, parent, false); //attaching of the scrolled row
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) { //holder- ids of items, pos- which row
        holder.img.setImageResource(rowModelArrayList.get(position).img);
        holder.txtHead.setText(rowModelArrayList.get(position).head);
        holder.txtDetails.setText(rowModelArrayList.get(position).details);
    }

    @Override
    public int getItemCount() {
        return rowModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtHead, txtDetails;
        ImageView img;
        public ViewHolder(View itemView){
            super(itemView);

            txtDetails = itemView.findViewById(R.id.detailRow);
            txtHead = itemView.findViewById(R.id.headRow);
            img = itemView.findViewById(R.id.imgRow);

        }
    }
}
