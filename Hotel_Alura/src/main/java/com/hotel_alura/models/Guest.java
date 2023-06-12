package com.hotel_alura.models;


import com.hotel_alura.models.enums.JsonMaps;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("all")
@Entity
@Table(name="guests")
public class Guest {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private long document;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private long telephoneNum;
    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private List<Reserve> reserves;

    public Guest() {
    }

    public Guest(long document, String name, String lastName, LocalDate birthDate, long telephoneNum,String nationality) {

        this.document = document;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.telephoneNum = telephoneNum;
        setNationality(nationality);

    }

    @Override
    public String toString() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setNationality(String nationality) {
        for (ComboBoxKeyValue nationIterator :
                JsonMaps.NATION.getJsonList()) {
            if (nationIterator.getNationality().equals(nationality)){
                this.nationality = nationality;
                return;
            }
        }
        throw new RuntimeException("Nacionalidad no encontrada en la lista");

    }

    public void setTelephoneNum(long telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public void addReserve(Reserve newReserve) {
        this.reserves.add(newReserve);
    }



    public long getId() {
        return id;
    }

    public long getDocument() {
        return document;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public String getNationality() {
        return nationality;
    }
    public long getTelephoneNum() {
        return telephoneNum;
    }
    public List<Reserve> getReservesList() {
        return this.reserves;
    }
    public Reserve getReserve(long reserveId){
        Reserve reserveFound = null;
        for (Reserve reserve:
                this.reserves) {
            if (reserve.getId() == reserveId){
                reserveFound = reserve;
                break;
            }
        }
        return reserveFound;
    }
}
