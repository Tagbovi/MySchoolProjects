package com.example.CRUD;

public class Books {
    private String scienceBooks;
    private String englishBooks;
    private  Double priceLists;
    public Books(){
        scienceBooks="";
        englishBooks="";
        priceLists=0.00;
    }
    public Books(String scienceBooks,String englishBooks, Double priceLists){
        this.scienceBooks=scienceBooks;
        this.englishBooks=englishBooks;
        this.priceLists=priceLists;
    }


    public String getScienceBooks() {
        return scienceBooks;
    }
    public void setEnglishBooks(String englishBooks) {
        this.englishBooks = englishBooks;
    }

    public String getEnglishBooks() {
        return englishBooks;
    }





    public void setPriceLists(double priceLists) {
        this.priceLists = priceLists;
    }
    public double getPriceLists() {
        return priceLists;
    }


    public void setScienceBooks(String scienceBooks) {
       this.scienceBooks=scienceBooks;
    }


}
