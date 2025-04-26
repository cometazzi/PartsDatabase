package org.badmotivator.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * A Class to represent a discrete Resistor
 *
 * @author jdoderer
 */
@Entity(name = "Resistor")
@Table(name = "resistors")
public class Resistor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * The Package type.
     */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_url", insertable = false, updatable = false)
    PartsImages partsImages;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "value")
    private String partNum;

    @Column(name = "qty")
    private String qty;

    @Column(name = "cost")
    private String cost;

    public Resistor() {
    }

    public Resistor(PackageTypes packageType,
                    String imageUrl,
                    String partNum,
                    String qty,
                    String cost) {

        this.imageUrl = imageUrl;
        this.partNum = partNum;
        this.qty = qty;
        this.cost = cost;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets image url.
     *
     * @return the image url
     */
    public String getImageUrl() {
        return partsImages.getThumbImageUrl();
    }

    /**
     * Sets image url.
     *
     * @param imageUrl the image url
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Gets part num.
     *
     * @return the part num
     */
    public String getPartNum() {
        return partNum;
    }

    /**
     * Sets part num.
     *
     * @param partNum the part num
     */
    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }


    /**
     * Gets qty.
     *
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * Sets qty.
     *
     * @param qty the qty
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public String getCost() {
        return cost;
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(String cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Resistor{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", partNum='" + partNum + '\'' +
                ", qty=" + qty +
                ", cost='" + cost + '\'' +
                '}';
    }
}
