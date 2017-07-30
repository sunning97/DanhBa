package com.example.giangnguyen.danhba;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Giang Nguyen on 28/07/2017.
 */

public class ContactAdapter extends ArrayAdapter {
    Context context;
    int res;
    List<Contact> arr;
    public ContactAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.arr = objects;
        this.context = context;
        this.res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(context).inflate(R.layout.contact_layout,parent,false);

            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            viewHolder.nName = (TextView) convertView.findViewById(R.id.nName);
            viewHolder.nNumber = (TextView) convertView.findViewById(R.id.nNumber);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Contact contact = arr.get(position);

        viewHolder.nName.setText(contact.getnName());
        viewHolder.nNumber.setText(contact.getnNumber());

        if(contact.isMale()) viewHolder.avatar.setBackgroundResource(R.drawable.male);
        else viewHolder.avatar.setBackgroundResource(R.drawable.female);

        return convertView;
    }

    class ViewHolder
    {
        ImageView avatar;
        TextView nName,nNumber;
    }
}
