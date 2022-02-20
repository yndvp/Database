package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.database.data.DatabaseHandler;
import com.example.database.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        contactArrayList = new ArrayList<>();

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

//        db.addContact(new Contact("James", "213986"));
//        db.addContact(new Contact("Greg", "098765"));
//        db.addContact(new Contact("Helena", "40678765"));
//        db.addContact(new Contact("Carimo", "768345"));
//        db.addContact(new Contact("Silo", "3445"));
//        db.addContact(new Contact("Santos", "6665"));
//        db.addContact(new Contact("Litos", "5344"));
//        db.addContact(new Contact("Karate", "96534"));
//        db.addContact(new Contact("Guerra", "158285"));
//        db.addContact(new Contact("Gema", "78130"));

        List<Contact> contactList = db.getAllContacts();
        for(Contact contact: contactList) {
            Log.d("MainActivity", "onCreate: " + contact.getName());
            contactArrayList.add(contact.getName());
        }

        // Create array adapter
        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contactArrayList
        );

        // Add to our listview
        listView.setAdapter(arrayAdapter);

        // Attach eventlistener to listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("List", "onItemClick: " + contactArrayList.get(position));
            }
        });
    }
}