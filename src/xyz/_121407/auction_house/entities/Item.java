package xyz._121407.auction_house.entities;

public class Item implements IIdentifiable<Integer> {
    private static Integer lastId = 0;

    private final Integer id;
    private String name;
    private Integer quantity;

    private Auction auction;

    public Item(String name, Integer quantity) {
        this.id = ++lastId;
        this.name = name;
        this.quantity = quantity;
    }

    public Item(Integer id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
