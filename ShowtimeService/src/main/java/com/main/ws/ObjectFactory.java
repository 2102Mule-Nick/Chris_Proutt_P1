
package com.main.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.main.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateShowtime_QNAME = new QName("http://ws.main.com/", "createShowtime");
    private final static QName _CreateShowtimeResponse_QNAME = new QName("http://ws.main.com/", "createShowtimeResponse");
    private final static QName _FindShowtimeByMovieId_QNAME = new QName("http://ws.main.com/", "findShowtimeByMovieId");
    private final static QName _FindShowtimeByMovieIdResponse_QNAME = new QName("http://ws.main.com/", "findShowtimeByMovieIdResponse");
    private final static QName _FindShowtimeByShowtimeId_QNAME = new QName("http://ws.main.com/", "findShowtimeByShowtimeId");
    private final static QName _FindShowtimeByShowtimeIdResponse_QNAME = new QName("http://ws.main.com/", "findShowtimeByShowtimeIdResponse");
    private final static QName _ShowtimeNotFound_QNAME = new QName("http://ws.main.com/", "ShowtimeNotFound");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.main.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateShowtime }
     * 
     */
    public CreateShowtime createCreateShowtime() {
        return new CreateShowtime();
    }

    /**
     * Create an instance of {@link CreateShowtimeResponse }
     * 
     */
    public CreateShowtimeResponse createCreateShowtimeResponse() {
        return new CreateShowtimeResponse();
    }

    /**
     * Create an instance of {@link FindShowtimeByMovieId }
     * 
     */
    public FindShowtimeByMovieId createFindShowtimeByMovieId() {
        return new FindShowtimeByMovieId();
    }

    /**
     * Create an instance of {@link FindShowtimeByMovieIdResponse }
     * 
     */
    public FindShowtimeByMovieIdResponse createFindShowtimeByMovieIdResponse() {
        return new FindShowtimeByMovieIdResponse();
    }

    /**
     * Create an instance of {@link FindShowtimeByShowtimeId }
     * 
     */
    public FindShowtimeByShowtimeId createFindShowtimeByShowtimeId() {
        return new FindShowtimeByShowtimeId();
    }

    /**
     * Create an instance of {@link FindShowtimeByShowtimeIdResponse }
     * 
     */
    public FindShowtimeByShowtimeIdResponse createFindShowtimeByShowtimeIdResponse() {
        return new FindShowtimeByShowtimeIdResponse();
    }

    /**
     * Create an instance of {@link ShowtimeNotFound }
     * 
     */
    public ShowtimeNotFound createShowtimeNotFound() {
        return new ShowtimeNotFound();
    }

    /**
     * Create an instance of {@link Showtime }
     * 
     */
    public Showtime createShowtime() {
        return new Showtime();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link Time }
     * 
     */
    public Time createTime() {
        return new Time();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateShowtime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateShowtime }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.main.com/", name = "createShowtime")
    public JAXBElement<CreateShowtime> createCreateShowtime(CreateShowtime value) {
        return new JAXBElement<CreateShowtime>(_CreateShowtime_QNAME, CreateShowtime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateShowtimeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateShowtimeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.main.com/", name = "createShowtimeResponse")
    public JAXBElement<CreateShowtimeResponse> createCreateShowtimeResponse(CreateShowtimeResponse value) {
        return new JAXBElement<CreateShowtimeResponse>(_CreateShowtimeResponse_QNAME, CreateShowtimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShowtimeByMovieId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindShowtimeByMovieId }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.main.com/", name = "findShowtimeByMovieId")
    public JAXBElement<FindShowtimeByMovieId> createFindShowtimeByMovieId(FindShowtimeByMovieId value) {
        return new JAXBElement<FindShowtimeByMovieId>(_FindShowtimeByMovieId_QNAME, FindShowtimeByMovieId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShowtimeByMovieIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindShowtimeByMovieIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.main.com/", name = "findShowtimeByMovieIdResponse")
    public JAXBElement<FindShowtimeByMovieIdResponse> createFindShowtimeByMovieIdResponse(FindShowtimeByMovieIdResponse value) {
        return new JAXBElement<FindShowtimeByMovieIdResponse>(_FindShowtimeByMovieIdResponse_QNAME, FindShowtimeByMovieIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShowtimeByShowtimeId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindShowtimeByShowtimeId }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.main.com/", name = "findShowtimeByShowtimeId")
    public JAXBElement<FindShowtimeByShowtimeId> createFindShowtimeByShowtimeId(FindShowtimeByShowtimeId value) {
        return new JAXBElement<FindShowtimeByShowtimeId>(_FindShowtimeByShowtimeId_QNAME, FindShowtimeByShowtimeId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindShowtimeByShowtimeIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindShowtimeByShowtimeIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.main.com/", name = "findShowtimeByShowtimeIdResponse")
    public JAXBElement<FindShowtimeByShowtimeIdResponse> createFindShowtimeByShowtimeIdResponse(FindShowtimeByShowtimeIdResponse value) {
        return new JAXBElement<FindShowtimeByShowtimeIdResponse>(_FindShowtimeByShowtimeIdResponse_QNAME, FindShowtimeByShowtimeIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowtimeNotFound }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ShowtimeNotFound }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.main.com/", name = "ShowtimeNotFound")
    public JAXBElement<ShowtimeNotFound> createShowtimeNotFound(ShowtimeNotFound value) {
        return new JAXBElement<ShowtimeNotFound>(_ShowtimeNotFound_QNAME, ShowtimeNotFound.class, null, value);
    }

}
