package com.example.examen_examen_mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;


public class ConexionNube {
    ConnectionString connectionString = new ConnectionString("mongodb+srv://yovanirodri20:Yovani2002" +
            "@cluster0.xokz20x.mongodb.net/?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("CRUD_Automovil");

    public boolean save(Automovil automovil){
        MongoCollection<Document> collection=database.getCollection("automovil");
        Document document = new Document("idAutomovil", automovil.getIdAutomovil())
                .append("pais", automovil.getPais())
                .append("precio", automovil.getPrecio())
                .append("marca", automovil.getMarca())
                .append("modelo", automovil.getModelo())
                .append("marca", automovil.getMarca())
                .append("transmicion", automovil.getTrasmision())
                .append("cilindraje", automovil.getCilindraje())
                .append("tipo", automovil.getTipo());
        collection.insertOne(document);
        return true;
    }

    public boolean actualizar(Automovil autoViejo, Automovil autoNuevo){
        MongoCollection<Document> collection = database.getCollection("automovil");
        Bson filter = Filters.eq("idAutomovil", autoViejo.getIdAutomovil());
        Document document = new Document("idAutomovil", autoNuevo.getIdAutomovil())
                .append("pais", autoNuevo.getPais())
                .append("precio", autoNuevo.getPrecio())
                .append("marca", autoNuevo.getMarca())
                .append("modelo", autoNuevo.getModelo())
                .append("marca", autoNuevo.getMarca())
                        .append("transmicion", autoNuevo.getTrasmision())
                        .append("cilindraje", autoNuevo.getCilindraje())
                        .append("tipo", autoNuevo.getTipo());
        Bson update = new Document("$set", document);
        UpdateResult result = collection.updateOne(filter, update);
        System.out.println(result.getModifiedCount() + " documentos modificados");
        return true;
    }

    public boolean show() {
        try {
            MongoCollection<Document> collection = database.getCollection("automovil");
            FindIterable<Document> documents = collection.find();
            for (Document document : documents) {

                System.out.println(document.toJson());
            }
            return true;
        } catch (Exception e){
            System.out.println("Hubo un error");
            return false;
        }
    }
    public boolean delete(int idAutomovil){
        MongoCollection<Document> collection = database.getCollection("automovil");
        Bson filter = Filters.eq("idAutomovil", idAutomovil);
        DeleteResult result = collection.deleteOne(filter);
        System.out.println(result.getDeletedCount() + " documentos eliminados");
        return true;
    }

}
