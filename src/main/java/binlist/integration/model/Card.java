package binlist.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @Column(name = "bin_id", unique = true, nullable = false)
    private long binId;

    private String scheme;
    @Column(name = "card_type")
    private String type;
    private String brand;
    private boolean prepaid;

    @JsonProperty(value = "number")
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CardNumber cardNumber;
    @JsonProperty(value = "country")
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Country country;
    @JsonProperty(value = "bank")
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Bank bank;

    public long getBinId() {
        return binId;
    }

    public void setBinId(long binId) {
        this.binId = binId;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isPrepaid() {
        return prepaid;
    }

    public void setPrepaid(boolean prepaid) {
        this.prepaid = prepaid;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
