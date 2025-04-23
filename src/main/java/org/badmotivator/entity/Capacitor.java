package org.badmotivator.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * A Class to represent a Capacitor
 *
 * @autho jdoderer
 */
@Entity(name = "Capacitor")
@Table(name = "capacitors")
public class Capacitor {

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

    @Column(name = "descr")
    private String descr;

    @Column(name = "qty")
    private int qty;

    @Column(name = "cost")
    private String cost;

    public Capacitor() {
    }

    public Capacitor(PackageTypes packageType,
                      String imageUrl,
                      String partNum,
                      int qty,
                      String cost) {
        this.imageUrl = imageUrl;
        this.partNum = partNum;
        this.descr = descr;
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
     * Gets descr.
     *
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * Sets descr.
     *
     * @param descr the descr
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * Gets qty.
     *
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * Sets qty.
     *
     * @param qty the qty
     */
    public void setQty(int qty) {
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
        return "Capacitor{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", partNum='" + partNum + '\'' +
                ", descr='" + descr + '\'' +
                ", qty=" + qty +
                ", cost='" + cost + '\'' +
                '}';
    }
}
