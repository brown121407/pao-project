package xyz._121407.school_management.entities;

public class Profile extends Identifiable {
    private ProfileType type;
    private Subject intensive;

    public ProfileType getType() {
        return type;
    }

    public void setType(ProfileType type) {
        this.type = type;
    }

    private Subject getIntensive() {
        return intensive;
    }

    public void setIntensive(Subject intensive) {
        this.intensive = intensive;
    }
}
