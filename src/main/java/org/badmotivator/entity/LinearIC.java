package org.badmotivator.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * A Class to represent a discrete LinearIC
 *
 * @author jdoderer
 */
@Entity(name = "LinearIC")
@Table(name = "linear_ics")
public class LinearIC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * The Package type.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_type", insertable = false, updatable = false)
    PackageTypes packageType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_url", insertable = false, updatable = false)
    PartsImages partsImages;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "part_num")
    private String partNum;

    @Column(name = "descr")
    private String descr;

    @Column(name = "qty")
    private int qty;

    @Column(name = "package_type")
    private int packageName;

    @Column(name = "cost")
    private String cost;

    @Column(name = "datasheet_url")
    private String datasheetUrl;

    public LinearIC() {
    }

    public LinearIC(PackageTypes packageType,
                    String imageUrl,
                    String partNum,
                    String descr,
                    int qty,
                    int packageName,
                    String cost,
                    String datasheetUrl) {
        this.packageType = packageType;
        this.imageUrl = imageUrl;
        this.partNum = partNum;
        this.descr = descr;
        this.qty = qty;
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
     * Gets package name.
     *
     * @return the package name
     */
    public String getPackageName() {
        return packageType.getPackageName();

    }

    /**
     * Sets package name.
     *
     * @param packageName the package name
     */
    public void setPackageName(int packageName) {
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

    /**
     * Gets package type.
     *
     * @return the package type
     */

    public PackageTypes getPackageType() {
        return packageType;

    }

    /**
     * Sets package type.
     *
     * @param packageType the package type
     */

    public void setPackageType(PackageTypes packageType) {
        this.packageType = packageType;

    }


    @Override
    public String toString() {
        return "LinearIC{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", partNum='" + partNum + '\'' +
                ", descr='" + descr + '\'' +
                ", qty=" + qty +
                ", packageName='" + packageName + '\'' +
                ", cost='" + cost + '\'' +
                ", datasheetUrl='" + datasheetUrl + '\'' +
                '}';
    }
}
