package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.Field;
import xyz._121407.schoolmanagement.annotations.FieldReader;
import xyz._121407.schoolmanagement.annotations.FieldWriter;
import xyz._121407.schoolmanagement.annotations.Table;

@Table
public class Address implements Identifiable {
    @Field(primaryKey = true)
    private int id;

    @Field
    private String county;

    @Field
    private String city;

    @Field
    private String postcode;

    @Field
    private String streetLine;

    @FieldWriter(field = "country")
    public String getCounty() {
        return county;
    }

    @FieldReader(field = "country")
    public void setCounty(String county) {
        this.county = county;
    }

    @FieldWriter(field = "city")
    public String getCity() {
        return city;
    }

    @FieldReader(field = "city")
    public void setCity(String city) {
        this.city = city;
    }

    @FieldWriter(field = "postcode")
    public String getPostcode() {
        return postcode;
    }

    @FieldReader(field = "postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @FieldWriter(field = "streetLine")
    public String getStreetLine() {
        return streetLine;
    }

    @FieldReader(field = "streetLine")
    public void setStreetLine(String streetLine) {
        this.streetLine = streetLine;
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
