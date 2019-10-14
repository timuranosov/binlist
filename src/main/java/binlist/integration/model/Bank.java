package binlist.integration.model;

import javax.persistence.*;

@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @Column(name = "bin_id", nullable = false)
    private long binId;

    private String name;
    private String url;
    private String phone;
    private String city;

    @OneToOne(mappedBy="bank", cascade=CascadeType.ALL)
    private Card card;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getBinId() {
        return binId;
    }

    public void setBinId(long binId) {
        this.binId = binId;
    }
}
