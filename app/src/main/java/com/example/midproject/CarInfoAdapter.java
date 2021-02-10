package com.example.midproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarInfoAdapter extends RecyclerView.Adapter<CarInfoAdapter.ViewHolder>{
    private ArrayList<CarInfo> items;

    public CarInfoAdapter(ArrayList<CarInfo> _items){
        items = _items;
    }

    public static class CarInfo{
        public int image;
        public String nama, brand, tipe, top_speed;

        public CarInfo(int _image, String _nama, String _brand, String _tipe, String _top_speed){
            image = _image;
            nama = _nama;
            brand = _brand;
            tipe = _tipe;
            top_speed = _top_speed;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgMobil;
        TextView txtName, txtKonten;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMobil = itemView.findViewById(R.id.imgMobil);
            txtName = itemView.findViewById(R.id.txtNama);
            txtKonten = itemView.findViewById(R.id.txtKonten);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frame_car_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CarInfoAdapter.CarInfo item = items.get(position);

        holder.imgMobil.setImageResource(item.image);
        holder.txtName.setText(item.nama);
        holder.txtKonten.setText("Brand: " + item.brand + "\nTipe: " + item.tipe + "\nTop Speed: " + item.top_speed);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
