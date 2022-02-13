package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.database.data.DatabaseHandler;
import com.example.database.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Contact jeremy = new Contact();
        jeremy.setName("Jeremy");
        jeremy.setPhoneNumber("4445556666");

        Contact json = new Contact();
        json.setName("Jason");
        json.setPhoneNumber("1112223333");


//        Contact c = db.getContact(1);
//        c.setName("NewJeremy");
//        c.setPhoneNumber("9998887777");

//        int updatedRow = db.updateContact(c);
//        Log.d("RowId", "onCreate: " + updatedRow);

//        db.addContact(json);

//        db.deleteContact(c);

        List<Contact> contactList = db.getAllContacts();
        for(Contact contact: contactList) {
            Log.d("MainActivity", "onCreate: " + contact.getName());
        }

        Log.d("Count", "onCreate: " + db.getContactsCount());

    }
}