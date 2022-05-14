package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.CsvReadable;
import xyz._121407.schoolmanagement.annotations.CsvWritable;

public class Address implements Identifiable {
    private int id;
    private String county;
    private String city;
    private String postcode;
    private String streetLine;

    @CsvWritable(field = "country")
    public String getCounty() {
        return county;
    }

    @CsvReadable(field = "country")
    public void setCounty(String county) {
        this.county = county;
    }

    @CsvWritable(field = "city")
    public String getCity() {
        return city;
    }

    @CsvReadable(field = "city")
    public void setCity(String city) {
        this.city = city;
    }

    @CsvWritable(field = "postcode")
    public String getPostcode() {
        return postcode;
    }

    @CsvReadable(field = "postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @CsvWritable(field = "streetLine")
    public String getStreetLine() {
        return streetLine;
    }

    @CsvReadable(field = "streetLine")
    public void setStreetLine(String streetLine) {
        this.streetLine = streetLine;
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
