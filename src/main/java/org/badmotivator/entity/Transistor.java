package org.badmotivator.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * A Class to represent a discrete Transistor
 *
 * @autho jdoderer
 */
@Entity
@Table(name = "transistors")
public class Transistor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "part_num")
    private String partNum;

    @Column(name = "technology")
    private String technology;

    @Column(name = "descr")
    private String descr;

    @Column(name = "qty")
    private int qty;

    @Column(name = "package")
    private String packageName;

    @Column(name = "cost")
    private String cost;

    @Column(name = "datasheet_url")
    private String datasheetUrl;


    /**
     * Instantiate new Transistor object
     */
    public Transistor() {}

    /**
     * Instantiate new Transistor with pre-loaded values
     *
     * @param imageUrl     the image url
     * @param partNum      the part num
     * @param technology   the technology
     * @param descr        the descr
     * @param qty          the qty
     * @param packageName  the package name
     * @param cost         the cost
     * @param datasheetUrl the datasheet url
     */
    public Transistor(
            String imageUrl,
            String partNum,
            String technology,
            String descr,
            String qty,
            String packageName,
            String cost,
            String datasheetUrl) {
        this.imageUrl = imageUrl;
        this.partNum = partNum;
        this.technology = technology;
        this.descr = descr;
        this.qty = Integer.parseInt(qty);
        this.packageName = packageName;
        this.cost = cost;
        this.datasheetUrl = datasheetUrl;
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
        return imageUrl;
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
     * Gets technology.
     *
     * @return the technology
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * Sets technology.
     *
     * @param technology the technology
     */
    public void setTechnology(String technology) {
        this.technology = technology;
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
     * Gets package name.
     *
     * @return the package name
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Sets package name.
     *
     * @param packageName the package name
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
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

    /**
     * Gets datasheet url.
     *
     * @return the datasheet url
     */
    public String getDatasheetUrl() {
        return datasheetUrl;
    }

    /**
     * Sets datasheet url.
     *
     * @param datasheetUrl the datasheet url
     */
    public void setDatasheetUrl(String datasheetUrl) {
        this.datasheetUrl = datasheetUrl;
    }

    @Override
    public String toString() {
        return "Transistor{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", partNum='" + partNum + '\'' +
                ", technology='" + technology + '\'' +
                ", descr='" + descr + '\'' +
                ", qty=" + qty +
                ", packageName='" + packageName + '\'' +
                ", cost='" + cost + '\'' +
                ", datasheetUrl='" + datasheetUrl + '\'' +
                '}';
    }
}
