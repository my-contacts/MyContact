package com.example.lotus.mycontacts.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.lotus.mycontacts.R;
import com.example.lotus.mycontacts.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private int resource;
    private List<Contact> arrayContact;

        public ContactAdapter( Context context, int resource,  List<Contact> objects) {
        super(context, resource, objects);

        this.context=context;
        this.resource=resource;
        this.arrayContact=objects;

    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder= new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_listview,parent,false);
            viewHolder.imgAvatar= (ImageView) convertView.findViewById(R.id.img_avatar);
            viewHolder.tvName= (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvPhone= (TextView) convertView.findViewById(R.id.tv_phone);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
            Contact contact = arrayContact.get(position);

            viewHolder.imgAvatar.setBackgroundResource(R.drawable.ic_user);
            viewHolder.tvName.setText(contact.getName());
            viewHolder.tvPhone.setText(contact.getPhone());
            return  convertView;
    }

//    Lăn lên thấy danh bạ để không bị lag khi lăn lên - xuống
    public class ViewHolder{
            ImageView imgAvatar;
//            cú pháp
            TextView tvName;
            TextView tvPhone;
    }
}
