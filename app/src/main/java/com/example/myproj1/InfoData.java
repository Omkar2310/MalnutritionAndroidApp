package com.example.myproj1;


public class InfoData {

    private String quotes;
    private int image;
    public InfoData(){

    }
    public InfoData(String quotes,int image){
        this.quotes = quotes;

        this.image = image;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
