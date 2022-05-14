package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.CsvReadable;
import xyz._121407.schoolmanagement.annotations.CsvWritable;

import java.time.LocalDate;

public abstract class User implements Identifiable {
    private int id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private LocalDate dateOfBirth;
    private int addressId;
    private Address address;

    @CsvWritable(field = "firstName")
    public String getFirstName() {
        return firstName;
    }

    @CsvReadable(field = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @CsvWritable(field = "lastName")
    public String getLastName() {
        return lastName;
    }

    @CsvReadable(field = "lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @CsvWritable(field = "nationalId")
    public String getNationalId() {
        return nationalId;
    }

    @CsvReadable(field = "nationalId")
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    @CsvWritable(field = "dateOfBirth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @CsvReadable(field = "dateOfBirth")
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @CsvWritable(field = "addressId")
    public int getAddressId() {
        return addressId;
    }

    @CsvReadable(field = "addressId")
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        this.addressId = address.getId();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    @CsvWritable(field = "id")
    public int getId() {
        return id;
    }

    @Override
    @CsvReadable(field = "id")
    public void setId(Integer id) {
        this.id = id;
    }
}
