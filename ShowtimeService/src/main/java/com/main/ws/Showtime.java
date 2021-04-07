
package com.main.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for showtime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="showtime"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="movie_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="screen_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="showing_date" type="{http://ws.main.com/}date" minOccurs="0"/&gt;
 *         &lt;element name="showing_time" type="{http://ws.main.com/}time" minOccurs="0"/&gt;
 *         &lt;element name="showtime_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="theater_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "showtime", propOrder = {
    "movieId",
    "screenId",
    "showingDate",
    "showingTime",
    "showtimeId",
    "theaterId"
})
public class Showtime {

    @XmlElement(name = "movie_id")
    protected int movieId;
    @XmlElement(name = "screen_id")
    protected int screenId;
    @XmlElement(name = "showing_date")
    protected Date showingDate;
    @XmlElement(name = "showing_time")
    protected Time showingTime;
    @XmlElement(name = "showtime_id")
    protected int showtimeId;
    @XmlElement(name = "theater_id")
    protected int theaterId;

    /**
     * Gets the value of the movieId property.
     * 
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * Sets the value of the movieId property.
     * 
     */
    public void setMovieId(int value) {
        this.movieId = value;
    }

    /**
     * Gets the value of the screenId property.
     * 
     */
    public int getScreenId() {
        return screenId;
    }

    /**
     * Sets the value of the screenId property.
     * 
     */
    public void setScreenId(int value) {
        this.screenId = value;
    }

    /**
     * Gets the value of the showingDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getShowingDate() {
        return showingDate;
    }

    /**
     * Sets the value of the showingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setShowingDate(Date value) {
        this.showingDate = value;
    }

    /**
     * Gets the value of the showingTime property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getShowingTime() {
        return showingTime;
    }

    /**
     * Sets the value of the showingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setShowingTime(Time value) {
        this.showingTime = value;
    }

    /**
     * Gets the value of the showtimeId property.
     * 
     */
    public int getShowtimeId() {
        return showtimeId;
    }

    /**
     * Sets the value of the showtimeId property.
     * 
     */
    public void setShowtimeId(int value) {
        this.showtimeId = value;
    }

    /**
     * Gets the value of the theaterId property.
     * 
     */
    public int getTheaterId() {
        return theaterId;
    }

    /**
     * Sets the value of the theaterId property.
     * 
     */
    public void setTheaterId(int value) {
        this.theaterId = value;
    }

}
