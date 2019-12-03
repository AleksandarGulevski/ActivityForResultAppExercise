package com.example.activityforresultappexercise;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.activityforresultappexercise.model.Contact;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> contacts;
    private Context context;
    private ItemClickListener itemClickListener;

    public ContactsAdapter(Context context, ItemClickListener itemClickListener) {
        contacts = new ArrayList<>();
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClickListener(String email);
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(contacts.get(position));
    }

    void addAll(List<Contact> contacts) {
        this.contacts.clear();
        this.contacts.addAll(contacts);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (contacts != null ? contacts.size() : 0);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        Contact contact;
        @BindView(R.id.contactName)
        TextView contactName;
        @BindView(R.id.contactEmail)
        TextView contactEmail;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Contact contact) {
            this.contact = contact;

            if (contact != null) {
                if (!TextUtils.isEmpty(contact.contactName)) {
                    contactName.setText(contact.contactName);
                }
                if (!TextUtils.isEmpty(contact.contactEmail)) {
                    contactEmail.setText(contact.contactEmail);
                }
            }
        }

        @OnClick(R.id.contactContainer)
        public void onItemClick(View view) {
            if (contact != null) {
                if (!TextUtils.isEmpty(contact.contactEmail)) {
                    itemClickListener.onItemClickListener(contact.contactEmail);
                }
            }
        }
    }
}
