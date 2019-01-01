
package gc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GiftCardWebService", targetNamespace = "http://gc/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GiftCardWebService {


    /**
     * 
     * @param name
     * @return
     *     returns float
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccountValue", targetNamespace = "http://gc/", className = "gc.GetAccountValue")
    @ResponseWrapper(localName = "getAccountValueResponse", targetNamespace = "http://gc/", className = "gc.GetAccountValueResponse")
    @Action(input = "http://gc/GiftCardWebService/getAccountValueRequest", output = "http://gc/GiftCardWebService/getAccountValueResponse")
    public float getAccountValue(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     * @throws SQLException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "pay", targetNamespace = "http://gc/", className = "gc.Pay")
    @ResponseWrapper(localName = "payResponse", targetNamespace = "http://gc/", className = "gc.PayResponse")
    @Action(input = "http://gc/GiftCardWebService/payRequest", output = "http://gc/GiftCardWebService/payResponse", fault = {
        @FaultAction(className = SQLException_Exception.class, value = "http://gc/GiftCardWebService/pay/Fault/SQLException")
    })
    public Boolean pay(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws SQLException_Exception
    ;

}