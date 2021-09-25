package com.example.kitappp;

public class CartView {

    protected String bookID;
    private String book_name;
    private String author;
    protected Float price;
    protected Float totprice;
    protected int quantity;
    private String description;


    public CartView() {
    }

    public CartView(String book_name, Float price, Float totprice) {
        this.book_name = book_name;
        this.price = price;
        this.totprice = totprice;
    }

    public CartView(String book_name, Float price) {
        this.book_name = book_name;
        this.price = price;

    }

    public CartView(String bookID, String book_name, String author, Float price, int quantity, String description,Float totprice ) {
        this.bookID = bookID;
        this.book_name = book_name;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.totprice = totprice;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getTotprice() {
        return totprice;
    }

    public void setTotprice(Float totprice) {
        this.totprice = totprice;
    }
}
