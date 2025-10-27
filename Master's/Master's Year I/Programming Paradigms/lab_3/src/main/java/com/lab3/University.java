package com.lab3;

public class University {
    private String name;
    private String location;
    private Author authors[] = new Author[100];
    private int noAuthors;

    public University(String name, String location, int noAuthors) {
        this.name = name;
        this.location = location;
        this.noAuthors = 0;
    }

    public void addAuthors(Author a){
        this.noAuthors++;
        this.authors[noAuthors] = a;
    }

    public double calculateScore(){
        double sum = 0;

        for(int i = 1; i <= noAuthors; i++){
            sum += this.authors[i].calculateScore();
        }

        return sum;
    }
}