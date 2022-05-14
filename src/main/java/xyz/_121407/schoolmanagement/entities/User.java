package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.*;

import java.time.LocalDate;

public abstract class User implements Identifiable {
    @Field(primaryKey = true)
    protected int id;

    @Field
    protected String firstName;

    @Field
    protected String lastName;

    @Field
    protected String nationalId;

    @Field
    protected LocalDate dateOfBirth;

    @Field
    @References(table = Address.class, field = "id")
    protected int addressId;

    protected Address address;

    @FieldWriter(field = "firstName")
    public String getFirstName() {
        return firstName;
    }

    @FieldReader(field = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @FieldWriter(field = "lastName")
    public String getLastName() {
        return lastName;
    }

    @FieldReader(field = "lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @FieldWriter(field = "nationalId")
    public String getNationalId() {
        return nationalId;
    }

    @FieldReader(field = "nationalId")
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    @FieldWriter(field = "dateOfBirth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @FieldReader(field = "dateOfBirth")
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @FieldWriter(field = "addressId")
    public int getAddressId() {
        return addressId;
    }

    @FieldReader(field = "addressId")
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
    @FieldWriter(field = "id")
    public int getId() {
        return id;
    }

    @Override
    @FieldReader(field = "id")
    public void setId(Integer id) {
        this.id = id;
    }
}
