package com.example.codebuddy2.Test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codebuddy2.R;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    Context context;
    ArrayList<TestModel> arr;
    ItemClickListener itemClickListener;

    TestAdapter(Context context, ArrayList<TestModel> arr,ItemClickListener itemClickListener) {
        this.context = context;
        this.arr = arr;
        this.itemClickListener=itemClickListener;
    }

    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.test_row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, int position) {

        holder.img.setImageResource(arr.get(position).img);
        holder.text.setText(arr.get(position).name);
        holder.itemView.setOnClickListener( view ->{
//            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//            context.startActivity(intent);
            itemClickListener.OnItemclick(arr.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public interface ItemClickListener {
        void OnItemclick(TestModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.test_img);
            text = itemView.findViewById(R.id.test_text);


        }
    }
}
