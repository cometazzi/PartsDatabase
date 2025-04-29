package org.badmotivator.entity;


import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * The parts images.
 */
@Entity(name = "PartsImages")
@Table(name = "partsImages")
public class PartsImages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transistor> transistors = new ArrayList<>();

    @Column(name = "largeImage")
    private String largeImageUrl;

    @Column(name = "thumbImage")
    private String thumbImageUrl;

    /**
     * Instantiates a new PartImage type.
     */
    public PartsImages() {
    }

    /**
     * Instantiates a new PartImage type.
     *
     * @param transistors   the transistors
     * @param largeImageUrl the URL for the large image
     * @param thumbImageUrl the URL for the thumbnail image
     */
    public PartsImages(List<Transistor> transistors, String largeImageUrl, String thumbImageUrl) {
        this.transistors = transistors;
        this.largeImageUrl = largeImageUrl;
        this.thumbImageUrl = thumbImageUrl;
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
     * Gets Url of large image.
     *
     * @return the URL
     */
    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    /**
     * Sets large Image URL.
     *
     * @param largeImageUrl the URL of the large image
     */
    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    /**
     * Gets thumbnail URL.
     *
     * @return the thumbnail URL
     */
    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    /**
     * Sets thumbImageUrl.
     *
     * @param thumbImageUrl the thumbnail URL
     */
    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    @Override
    public String toString() {
        return "PartsImages{" +
                "id=" + id +
                //", transistors=" + transistors +
                ", largeImageUrl='" + largeImageUrl + '\'' +
                ", thumbImageUrl='" + thumbImageUrl + '\'' +
                '}';
    }
}
