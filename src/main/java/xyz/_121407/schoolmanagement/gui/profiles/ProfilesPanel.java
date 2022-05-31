package xyz._121407.schoolmanagement.gui.profiles;

import xyz._121407.schoolmanagement.entities.Profile;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;

public class ProfilesPanel extends EntityManagerPanel<Profile> {
    public ProfilesPanel() {
        super(Profile.class, new ProfileForm());

        configureUI();
        configureFormEvents();
    }
}
