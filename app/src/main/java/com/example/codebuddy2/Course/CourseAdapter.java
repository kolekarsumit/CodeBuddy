package com.example.codebuddy2.Course;

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
import java.util.HashMap;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    Context context;
    ArrayList<CourseModel> arrcontacts;
    private ItemClickListener mItemListner;

    HashMap<String, String> data = new HashMap<>();

    CourseAdapter(Context context, ArrayList<CourseModel> arrcontacts, HashMap<String, String> data, ItemClickListener itemClickListener) {
        this.context = context;
        this.arrcontacts = arrcontacts;
        this.mItemListner = itemClickListener;
        this.data = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.course_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.img.setImageResource(arrcontacts.get(position).img);
        holder.textsmt.setText(arrcontacts.get(position).smt);
        holder.textname.setText(arrcontacts.get(position).name);

        holder.itemView.setOnClickListener(view -> {

            Intent intent = new Intent(context, CardDetails.class);

//
            intent.putExtra("heading", arrcontacts.get(position).name);
            intent.putExtra("img", arrcontacts.get(position).img);
            intent.putExtra("desc", data.get(arrcontacts.get(position).name));
            intent.putExtra("position", position);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return arrcontacts.size();
    }

    public interface ItemClickListener {
        void onItemClick(CourseModel details);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textname, textsmt;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textname = itemView.findViewById(R.id.textoncard);
            textsmt = itemView.findViewById(R.id.statmentoncard);
            img = itemView.findViewById(R.id.cardimg);
        }
    }


}
