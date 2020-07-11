package com.example.mday;

public class Answer {

    private int image;
    private String textView;

    public Answer(int image, String textView){
        this.image = image;
        this.textView = textView;
    }

    public int getImage(){
        return image;
    }

    public String getTextView(){
        return textView;
    }
}
