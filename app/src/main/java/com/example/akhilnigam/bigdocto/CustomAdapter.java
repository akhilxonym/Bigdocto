package com.example.akhilnigam.bigdocto;

/**
 * Created by Akhil_xonym on 10-01-2018.
 */


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Akhil_xonym on 04-07-2017.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;

    private List<MyData> my_data;
    public CustomAdapter(Context context, List<MyData> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(my_data.get(position).getName());
        holder.typ.setText(my_data.get(position).getTyp());
        Glide.with(context).load(my_data.get(position).getImage_link()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, my_data.get(position).getName() ,Toast.LENGTH_SHORT ).show();
                Intent intent=new Intent(context, Showdoctor.class);
                intent.putExtra("name",my_data.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView name;
        public TextView typ;
        public ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            typ = (TextView) itemView.findViewById(R.id.typ);
            imageView = (ImageView) itemView.findViewById(R.id.image);



        }
    }
}