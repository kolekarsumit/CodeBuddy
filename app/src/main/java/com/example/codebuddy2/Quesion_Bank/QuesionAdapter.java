package com.example.codebuddy2.Quesion_Bank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codebuddy2.R;

import java.util.ArrayList;

public class QuesionAdapter extends RecyclerView.Adapter<QuesionAdapter.ViewHolder> {

    Context context;
    ArrayList<Quesion_model> arr = new ArrayList<>();
    ItemClickListener itemClickListener;

    QuesionAdapter(Context context, ArrayList<Quesion_model> arr, ItemClickListener itemClickListener) {
        this.context = context;
        this.arr = arr;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.quesion_row, parent, false);
        ViewHolder view = new ViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(arr.get(position).img);
        holder.title.setText(arr.get(position).name);
        holder.itemView.setOnClickListener(view -> {
//            itemClickListener.onItemClick(arr.get(position));
            Intent intent=new Intent(context, View_pdf.class);
            intent.putExtra("name",arr.get(position).name);
            intent.putExtra("position",position);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public interface ItemClickListener {
        void onItemClick(Quesion_model model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.quesion_img);
            title = itemView.findViewById(R.id.quesion_text);
        }
    }
}