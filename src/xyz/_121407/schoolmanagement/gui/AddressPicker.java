package xyz._121407.schoolmanagement.gui;

import xyz._121407.schoolmanagement.entities.Address;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.InMemoryStore;
import xyz._121407.schoolmanagement.utils.English;

import javax.swing.*;

public class AddressPicker extends FormPanel<Address> {
    private JTextField countyField = new JTextField(DEFAULT_COLUMNS);
    private JTextField cityField = new JTextField(DEFAULT_COLUMNS);
    private JTextField postCodeField = new JTextField(DEFAULT_COLUMNS);
    private JTextField streetLineField = new JTextField(DEFAULT_COLUMNS);

    public AddressPicker() {
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

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Address.class);
    }

    @Override
    protected IRepository<Address> getRepository() {
        return InMemoryStore.getInstance().getAddressRepository();
    }
}
