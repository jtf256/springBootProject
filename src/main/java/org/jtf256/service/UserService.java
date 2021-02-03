package org.jtf256.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import org.jtf256.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//CRUD Operations
@Service
public class UserService 
{
	public static  final String COL_NAME="Users";
	
	public User getUser(String name) throws InterruptedException, ExecutionException
	{
		System.out.println("Searching for: " +  name);
		Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        User user = null;

        if(document.exists()) 
        {
        	user = document.toObject(User.class);
            return user;
        }
        else 
        {
        	user = new User("wrong username", "null");
            return user;
        }
	}
}
