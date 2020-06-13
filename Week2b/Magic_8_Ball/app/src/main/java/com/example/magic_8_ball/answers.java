package com.example.magic_8_ball;

public class answers {

    private int image;
    private String text;

    public answers(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
