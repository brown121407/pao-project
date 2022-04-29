package xyz._121407.schoolmanagement.gui.profiles;

import xyz._121407.schoolmanagement.entities.Profile;
import xyz._121407.schoolmanagement.gui.FormPanel;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.Store;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

import javax.swing.*;

public class ProfileForm extends FormPanel<Profile> {
    private final JTextField nameField = new JTextField();

    public ProfileForm() {
        super(Profile.class);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name: ");
        nameField.setColumns(DEFAULT_COLUMNS);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        add(namePanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Profile profile) {
        nameField.setText(profile.getName());

        super.fill(profile);
    }

    @Override
    public void clear() {
        nameField.setText("");

        super.clear();
    }

    @Override
    public Profile getValue() {
        Profile profile = new Profile();
        profile.setName(nameField.getText());

        if (selectedId != null) {
            profile.setId(selectedId);
        }

        return profile;
    }
}
