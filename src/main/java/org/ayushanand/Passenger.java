package org.ayushanand;

public class Passenger {
    private String name;
    private int age;
    private Gender gender;
    private BerthPreference berthPreference;

    public Passenger(String name,int age,Gender gender,BerthPreference berthPreference) {
        setName(name);
        setAge(age);
        setGender(gender);
        this.berthPreference=berthPreference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is invalid");
        }
        this.name = name;


    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 & 120");
        }

        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if(gender == null) {
            throw new IllegalArgumentException("Gender is required");
        }
        this.gender = gender;

    }

    public BerthPreference getBerthPreference() {
        return berthPreference;
    }

    public void setBerthPreference(BerthPreference berthPreference) {
        this.berthPreference = berthPreference;
    }
}
