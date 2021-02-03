package org.jtf256.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import org.jtf256.entity.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//CRUD Operations
@Service
public class CardService
{

	public static final String COL_NAME="Cards";
	
	
	public String saveCardDetatils(Card card) throws InterruptedException, ExecutionException  
	{
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(card.getName())
				.set(card);
		return collectionsApiFuture.get().getUpdateTime().toString();
		
	}
	
	public List<Card> getAllCards() throws InterruptedException, ExecutionException
	{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		List<Card> cardList  =  new ArrayList<Card>();
		CollectionReference card_col = dbFirestore.collection(COL_NAME);
		ApiFuture<QuerySnapshot> query = card_col.get();
		for(DocumentSnapshot doc: query.get().getDocuments())
		{
			Card card = doc.toObject(Card.class);
			cardList.add(card);
		}
		return cardList;
	}
	
	public Card getCardDetails(String name) throws InterruptedException, ExecutionException
	{
		System.out.println("Searching for: " +  name);
		Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Card card = null;

        if(document.exists()) 
        {
        	card = document.toObject(Card.class);
            return card;
        }
        else 
        {
        	card = new Card("Card not found", -1);
            return card;
        }
	}
	
    public String updateCard(Card card) throws InterruptedException, ExecutionException 
    {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(card.getName()).set(card);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCard(String name) 
    {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Document with Patient ID "+name+" has been deleted";
    }


	
}
