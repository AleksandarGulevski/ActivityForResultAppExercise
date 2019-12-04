package com.example.activityforresultappexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.activityforresultappexercise.model.Contact;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class ContactsActivity
        extends AppCompatActivity
        implements ContactsAdapter.ItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ButterKnife.bind(this);
        setupUi();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, ContactsActivity.class));
    }

    private void setupUi() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ContactsAdapter adapter = new ContactsAdapter(this);
        adapter.addAll(getContacts());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        DividerItemDecoration itemDivider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDivider);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("John Doe", "john@email.com"));
        contacts.add(new Contact("Jane Doe", "jane@email.com"));
        contacts.add(new Contact("John Doe", "john@email.com"));
        contacts.add(new Contact("Jane Doe", "jane@email.com"));
        contacts.add(new Contact("John Doe", "john@email.com"));
        contacts.add(new Contact("Jane Doe", "jane@email.com"));
        contacts.add(new Contact("John Doe", "john@email.com"));
        contacts.add(new Contact("Jane Doe", "jane@email.com"));
        contacts.add(new Contact("John Doe", "john@email.com"));
        contacts.add(new Contact("Jane Doe", "jane@email.com"));
        contacts.add(new Contact("John Doe", "john@email.com"));
        contacts.add(new Contact("Jane Doe", "jane@email.com"));
        return contacts;
    }

    @Override
    public void onItemClickListener(String email) {
        Intent intent = getIntent();
        intent.putExtra(MainActivity.KEY_EMAIL, email);
        setResult(RESULT_OK, intent);
        finish();
    }
}
