package com.example.contact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contact.controller.ContactService;
import com.example.contact.entities.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //Button btnAdd;
    //EditText firstName;
    //ListView listContacts;
    private FloatingActionButton btnAdd;
    private RecyclerView listContacts;
    private AdapterContact adapterContact;
    String url = "http://192.168.1.13:8082/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContacts = findViewById(R.id.contactRv);
        btnAdd = findViewById(R.id.fablab);
       // firstName = findViewById(R.id.contact_name);
        listContacts.setHasFixedSize(true);
        // add listener

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // move to new activity to add contact
                Intent intent = new Intent(MainActivity.this,AddEditContact.class);
                intent.putExtra("isEditMode",false);
                startActivity(intent);
            }
        });

        loadData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( resultCode == Activity.RESULT_OK) {
            if (data != null && data.getBooleanExtra("data_updated", false)) {
                // reload the data
                loadData();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData(); // refresh data
    }
    public  void loadData(){
        Retrofit retrofit = new Retrofit.Builder( ).baseUrl(url).addConverterFactory(GsonConverterFactory.create( )).build( );
        ContactService api = retrofit.create(ContactService.class);

        Call<List<Contact>> call = api.getAllContacts();
        call.enqueue(new Callback<List<Contact>>( ) {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                //Log.println(Log.ASSERT,"d",response.body().toString());
                List<Contact> data = response.body( );
               // Log.println(Log.ASSERT,"d",data.get(0).getFirstName().toString());
                adapterContact = new AdapterContact(MainActivity.this, Listin(data));
                listContacts.setAdapter(adapterContact);
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {

            }
        });

    }
    public void process() {
       /* Retrofit retrofit = new Retrofit.Builder( )
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create( ))
                .build( );

        ContactService api = retrofit.create(ContactService.class);
        Contact c=new Contact();
        c.setFirstName(firstName.getText( ).toString( ));
        Call<Contact> call = api.createContact(c);
        call.enqueue(new Callback<Contact>( ) {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                firstName.setText("");
                Toast.makeText(getApplicationContext( ), "process onResponse", Toast.LENGTH_LONG).show( );
                getAll();
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Toast.makeText(getApplicationContext( ), "process onFailure", Toast.LENGTH_LONG).show( );
            }
        });

*/
    }


    ArrayList Listin(List<Contact> l) {
        ArrayList<Contact> maliste = new ArrayList<>( );
        for (int i = 0; i < l.size( ); i++) {
            Contact c=new Contact(l.get(i));
            maliste.add(c);
        }
        return maliste;
    }
}





