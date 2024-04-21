package com.itzul.invoiceapplication.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice {
    private int folio;
    private String description;
    private Date date;
    private Client client;
    private InvoiceItem[] items;
    private int indexItems;
    public static final int MAX_ITEMS = 12;
    private static int lastFolio;

    public Invoice(String description, Client client) {
        this.description = description;
        this.client = client;
        this.items = new InvoiceItem[MAX_ITEMS];
        this.folio = ++lastFolio;
        this.date = new Date();
    }

    public int getFolio() {
        return folio;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public InvoiceItem[] getItems() {
        return items;
    }
    public void addInvoiceItem(InvoiceItem item){
        if (indexItems < MAX_ITEMS) {
           this.items[indexItems++] = item; 
        }
    }

    public float totalInvoice(){
        float total = 0.0f;
        for (int i = 0; i < indexItems; i++) {
            InvoiceItem item = this.items[i];
            total += item.total();
        }
        return total;
    }

    public String getDetails(){
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(folio)
                .append("\nClient: ")
                .append(this.client.getName())
                .append("\nNIF: ")
                .append(this.client.getNif())
                .append("\nDescription: ")
                .append(this.description)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");

        sb.append("Emision Date: ")
                .append(df.format(this.date))
                .append("\n")
                .append("\n#\tName\t$\tQuantity\tTotal\n");


        for (int i = 0; i < indexItems; i++) {
            InvoiceItem item = this.items[i];
            sb.append(item)
                .append("\n");           
        }
        sb.append("\nTOTAL: ")
                .append(totalInvoice());

        return sb.toString();
    }

    @Override
    public String toString() {
        return getDetails();
    }

    
}
