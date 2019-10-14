package binlist.integration.model;

import javax.persistence.*;

@Entity
@Table(name = "card_lengths")
public class CardNumber {
    @Id
    @Column(name = "bin_id", nullable = false)
    private long binId;

    private String length;
    private boolean luhn;

    @OneToOne(mappedBy="cardNumber", cascade=CascadeType.ALL)
    private Card card;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public boolean isLuhn() {
        return luhn;
    }

    public void setLuhn(boolean luhn) {
        this.luhn = luhn;
    }

    public long getBinId() {
        return binId;
    }

    public void setBinId(long binId) {
        this.binId = binId;
    }
}
