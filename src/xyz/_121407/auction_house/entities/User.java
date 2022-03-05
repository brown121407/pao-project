package xyz._121407.auction_house.entities;

import java.util.HashSet;
import java.util.Set;

public class User implements IIdentifiable<String> {
    protected String username;
    // TODO Use hash passwords.
    protected String password;

    private final Set<Auction> authoredAuctions = new HashSet<>();
    private final Set<Auction> wonAuctions = new HashSet<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getId() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
