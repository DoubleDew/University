package com.lab3;

public class Author {
    private String name;
    private University university;
    private Publication publications[] = new Publication[100];
    private int noPublications;
    
    public Author(String name, University university) {
        this.name = name;
        this.university = university;
        this.noPublications = 0;
    }

    public void addPublication(Publication p){
        this.noPublications++;
        this.publications[noPublications] = p;
    }

    public double calculateScore(){
        double sum = 0;

        for(int i = 1; i <= noPublications; i++){
            sum += this.publications[i].calculateScore();
        }

        return sum;
    }
}