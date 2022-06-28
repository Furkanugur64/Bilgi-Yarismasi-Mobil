package com.furkan_64.proje_bilgi_yarisma;

public class Scores {
    String name;
    String surname;
    String age;
    String score;

    public Scores(String name, String surname, String age, String score) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
