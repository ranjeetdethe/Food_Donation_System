package com.ngo_food.dashboard;
/*
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

public class UserDao {
    public static Firestore c2w_pi_db;

    public void addData(String c2w_pi_collection, String c2w_pi_document, Map<String, Object> data)
            throws ExecutionException, InterruptedException {
        DocumentReference c2w_pi_docRef = c2w_pi_db.collection(c2w_pi_collection).document(c2w_pi_document);
        ApiFuture<WriteResult> c2w_pi_result = c2w_pi_docRef.set(data); // Set data in the document
        c2w_pi_result.get();
    }

    public UserDetail getData(String c2w_pi_collection, String c2w_pi_document)
            throws ExecutionException, InterruptedException {

        try {
            DocumentReference c2w_pi_docRef =

                    c2w_pi_db.collection(c2w_pi_collection).document(c2w_pi_document); // Reference to the document

            ApiFuture<DocumentSnapshot> c2w_pi_future =

                    c2w_pi_docRef.get(); // Asynchronously retrieve document snapshot

            return

            c2w_pi_future.get().toObject(UserDetail.class);
        } catch (Exception e) {
            e.printStackTrace();

            throw e;

        }
    }
}*/