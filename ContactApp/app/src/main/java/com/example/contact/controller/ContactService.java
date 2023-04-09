package com.example.contact.controller;

import com.example.contact.entities.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ContactService {
    @GET("/contacts")
    Call<List<Contact>> getAllContacts();

    @POST("/contact")
    Call<Contact> createContact(@Body Contact newContact);

    @GET("/contacts/{id}")
    Call<Contact> getContact(@Path("id") Long id);

    @DELETE("/deleteContacts/{id}")
    Call<Void> deleteContact(@Path("id") Long id);

    @PUT("/contacts/{id}")
    Call<Contact> updateContact(@Path("id") Long id, @Body Contact contact);
}
