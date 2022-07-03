package com.udinus.uas_13037_13038_13048_13065;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.ListViewHolder> {
    private ArrayList<ListBook> listBooks;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListBookAdapter(ArrayList<ListBook> list) {
        this.listBooks = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_listbook, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ListBook listBook = listBooks.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listBook.getPhoto())
                .apply(new RequestOptions().override(76,106))
                .into(holder.imgPhoto);
        holder.tvName.setText(listBook.getJudul());
        holder.tvDetail.setText(listBook.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listBooks.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listBooks.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        ListViewHolder(View itemview) {
            super(itemview);
            imgPhoto = itemview.findViewById(R.id.img_item_book);
            tvName = itemview.findViewById(R.id.tv_item_judul);
            tvDetail = itemview.findViewById(R.id.tv_detail);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(ListBook data);
    }

}
