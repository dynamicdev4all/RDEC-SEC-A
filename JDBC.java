package com.rdec.config;

import java.sql.Connection;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class DatabaseConnection {
	
	MongoClient client;
	
	public DatabaseConnection() {
		try {
			String URL = "mongodb+srv://piebytwo014:piebytwo014@cluster0.sy8lt.mongodb.net/rdec?retryWrites=true&w=majority&appName=Cluster0";
			ConnectionString string = new ConnectionString(URL);
			MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(string).build();
			client = MongoClients.create(clientSettings);
			System.out.println("Database Connection Success");
		} catch (Exception e) {
			System.out.println("Connection Failed");
			// TODO: handle exception
		}
		
	}
	
	private static void main(String args[]) {
		// TODO Auto-generated method stub
		new DatabaseConnection();
	}
}
