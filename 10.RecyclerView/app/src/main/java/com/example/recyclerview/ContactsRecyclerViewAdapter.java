package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {


    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactsRecyclerViewAdapter(TextView txtName) {

    }

    //Generates viewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate a layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(contacts.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContact(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }



    //Holding the view Items from contacts
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
