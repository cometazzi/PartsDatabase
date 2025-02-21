package org.badmotivator.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Package types.
 */
@Entity(name = "PackageTypes")
@Table(name = "package_types")
public class PackageTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToMany(mappedBy = "packageType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transistor> transistors = new ArrayList<Transistor>();

    @Column(name = "package_name")
    private String packageName;

    @Column(name = "package_descr")
    private String packageDescr;

    /**
     * Instantiates a new Package types.
     */
    public PackageTypes() {
    }

    /**
     * Instantiates a new Package types.
     *
     * @param transistors  the transistors
     * @param packageName  the package name
     * @param packageDescr the package descr
     */
    public PackageTypes(List<Transistor> transistors, String packageName, String packageDescr) {
        this.transistors = transistors;
        this.packageName = packageName;
        this.packageDescr = packageDescr;
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
     * Gets transistors.
     *
     * @return the transistors
     */

    public List<Transistor> getTransistors() {
        return transistors;
    }

    /**
     * Sets transistors.
     *
     * @param transistors the transistors
     */

    public void setTransistors(List<Transistor> transistors) {
        this.transistors = transistors;
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
     * Gets package descr.
     *
     * @return the package descr
     */
    public String getPackageDescr() {
        return packageDescr;
    }

    /**
     * Sets package descr.
     *
     * @param packageDescr the package descr
     */
    public void setPackageDescr(String packageDescr) {
        this.packageDescr = packageDescr;
    }

    @Override
    public String toString() {
        return "PackageTypes{" +
                "id=" + id +
                //", transistors=" + transistors +
                ", packageName='" + packageName + '\'' +
                ", packageDescr='" + packageDescr + '\'' +
                '}';
    }
}
