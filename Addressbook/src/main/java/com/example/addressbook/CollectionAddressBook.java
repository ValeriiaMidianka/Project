package com.example.addressbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CollectionAddressBook implements AddressBook{
    @Override
    public void add(Person person) {
        personList.add(person);

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);

    }

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public void print(){
        int number = 0;

        for (Person person: personList){
            number++;
            System.out.println(number + ". PIP: " + person.getPip() + "; Phone:" + person.getPhone());
        }
    }

    public void fillTestData(){
        personList.add(new Person("Valeriia", "+380642848536"));
        personList.add(new Person("Olya", "+38014278536"));
        personList.add(new Person("Mark", "+380358848536"));
        personList.add(new Person("Stiv", "+380992848536"));

    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }
}
