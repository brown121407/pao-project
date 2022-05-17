package xyz._121407.schoolmanagement.gui;

import xyz._121407.schoolmanagement.entities.Address;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.Store;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

import javax.swing.*;

public class AddressPicker extends FormPanel<Address> {
    private final JTextField countyField = new JTextField(DEFAULT_COLUMNS);
    private final JTextField cityField = new JTextField(DEFAULT_COLUMNS);
    private final JTextField postCodeField = new JTextField(DEFAULT_COLUMNS);
    private final JTextField streetLineField = new JTextField(DEFAULT_COLUMNS);

    public AddressPicker() {
        super(Address.class);

        JPanel countyPanel = makeFieldPanel("County:", countyField);
        JPanel cityPanel = makeFieldPanel("City:", cityField);
        JPanel postCodePanel = makeFieldPanel("Post code:", postCodeField);
        JPanel streetLinePanel = makeFieldPanel("Street address:", streetLineField);

        add(countyPanel);
        add(cityPanel);
        add(postCodePanel);
        add(streetLinePanel);
        remove(statusLabel);
    }

    @Override
    public Address getValue() {
        Address address = new Address();
        address.setCounty(countyField.getText());
        address.setCity(cityField.getText());
        address.setPostcode(postCodeField.getText());
        address.setStreetLine(streetLineField.getText());

        if (selectedId != null) {
            address.setId(selectedId);
        }

        return address;
    }

    @Override
    public void fill(Address obj) {
        super.fill(obj);

        countyField.setText(obj.getCounty());
        cityField.setText(obj.getCity());
        postCodeField.setText(obj.getPostcode());
        streetLineField.setText(obj.getStreetLine());
    }

    @Override
    public void clear() {
        super.clear();

        countyField.setText("");
        cityField.setText("");
        postCodeField.setText("");
        streetLineField.setText("");
    }
}
