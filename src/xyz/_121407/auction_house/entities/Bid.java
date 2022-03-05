package xyz._121407.auction_house.entities;

public class Bid implements IIdentifiable<Integer> {
    private static Integer lastId = 0;

    private final Integer id;
    private Double sum;

    private User author;
    private Auction auction;

    public Bid(Double sum, User author) {
        this.id = ++lastId;
        this.sum = sum;
        this.author = author;
    }

    public Bid(Integer id, Double sum, User author) {
        this.id = id;
        this.sum = sum;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
