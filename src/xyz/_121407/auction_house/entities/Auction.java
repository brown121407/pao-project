package xyz._121407.auction_house.entities;

import java.time.Duration;
import java.util.*;

public class Auction implements IIdentifiable<Integer> {
    private static Integer lastId = 0;

    private final Integer id;
    private Date endsAt;

    private User author;
    private User winner;
    private final Set<Item> items = new HashSet<>();
    private final Set<Bid> bids = new HashSet<>();

    public Auction(User author) {
        this.id = ++lastId;
        this.author = author;
    }

    public Auction(Integer id, User author) {
        this.id = id;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public Date getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Date endsAt) {
        this.endsAt = endsAt;
    }
}
