package com.main.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2021-04-07T18:18:14.977-07:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "ShowTimeCreatorImplService",
                  wsdlLocation = "http://localhost:8080/CinemaBooker/showtimes?wsdl",
                  targetNamespace = "http://ws.main.com/")
public class ShowTimeCreatorImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.main.com/", "ShowTimeCreatorImplService");
    public final static QName ShowTimeCreatorImplPort = new QName("http://ws.main.com/", "ShowTimeCreatorImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/CinemaBooker/showtimes?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ShowTimeCreatorImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/CinemaBooker/showtimes?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ShowTimeCreatorImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ShowTimeCreatorImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ShowTimeCreatorImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ShowTimeCreatorImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ShowTimeCreatorImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ShowTimeCreatorImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ShowTimeCreator
     */
    @WebEndpoint(name = "ShowTimeCreatorImplPort")
    public ShowTimeCreator getShowTimeCreatorImplPort() {
        return super.getPort(ShowTimeCreatorImplPort, ShowTimeCreator.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ShowTimeCreator
     */
    @WebEndpoint(name = "ShowTimeCreatorImplPort")
    public ShowTimeCreator getShowTimeCreatorImplPort(WebServiceFeature... features) {
        return super.getPort(ShowTimeCreatorImplPort, ShowTimeCreator.class, features);
    }

}
