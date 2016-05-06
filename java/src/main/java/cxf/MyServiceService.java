package cxf;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2016-05-07T01:46:14.032+08:00
 * Generated source version: 3.1.6
 * 
 */
@WebServiceClient(name = "MyServiceService", 
                  wsdlLocation = "http://localhost:7777/fuck?wsdl",
                  targetNamespace = "http://webservice/") 
public class MyServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservice/", "MyServiceService");
    public final static QName MyServicePort = new QName("http://webservice/", "MyServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:7777/fuck?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MyServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:7777/fuck?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MyServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MyServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MyServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public MyServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public MyServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public MyServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns IMyService
     */
    @WebEndpoint(name = "MyServicePort")
    public IMyService getMyServicePort() {
        return super.getPort(MyServicePort, IMyService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMyService
     */
    @WebEndpoint(name = "MyServicePort")
    public IMyService getMyServicePort(WebServiceFeature... features) {
        return super.getPort(MyServicePort, IMyService.class, features);
    }

}
