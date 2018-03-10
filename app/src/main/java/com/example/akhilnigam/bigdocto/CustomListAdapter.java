package com.example.akhilnigam.bigdocto;

/**
 * Created by Akhil_xonym on 13-01-2018.
 */


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by quocnguyen on 03/08/2016.
 */
public class CustomListAdapter extends ArrayAdapter<Product> {

    ArrayList<Product> products;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null, true);

        }
        Product product = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewProduct);
        Glide.with(context).load(product.getImage()).into(imageView);

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        txtName.setText(product.getName());

        TextView txtPrice = (TextView) convertView.findViewById(R.id.txtPrice);
        txtPrice.setText(product.getPrice());

        TextView txtAddress = (TextView) convertView.findViewById(R.id.txtAddress);
        txtAddress.setText(product.getAddress());

        TextView txtTime = (TextView) convertView.findViewById(R.id.txtTime);
        txtTime.setText(product.getTime());



        return convertView;
    }
}