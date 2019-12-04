package com.example.activityforresultappexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CONTACT_CODE = 1;
    public static final String KEY_EMAIL = "key_email";
    @BindView(R.id.contact)
    TextView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sendTo)
    public void onClick() {
        Intent intent = new Intent(this,
                ContactsActivity.class);
        startActivityForResult(intent, REQUEST_CONTACT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CONTACT_CODE && resultCode == RESULT_OK) {
            String email = data.getStringExtra(KEY_EMAIL);
            if (!TextUtils.isEmpty(email)) {
                contact.setText(email);
            } else {
                contact.setText("");
            }
        }
    }
}
