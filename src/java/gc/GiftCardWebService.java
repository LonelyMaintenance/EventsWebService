/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gc;

import bean.GiftCardBean;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author nikolaj
 */
@WebService(serviceName = "GiftCardWebService")
@Stateless()
public class GiftCardWebService {
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getAccountValue")
    public float getAccountValue(@WebParam(name = "name") String email) {
        GiftCardBean gcb = new GiftCardBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        gcb.init();
        float accountValue = gcb.getAccountValueStatement(email);
        gcb.closeConnection();
        return accountValue;
    }
    
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "pay")
    public Boolean pay(String email, String eventCost) throws SQLException {
        //TODO write your implementation code here:
        
        GiftCardBean agb = new GiftCardBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        agb.init();
        
        boolean check = agb.getAccountStatement(email, eventCost);
        if(check==true){
            agb.withdrawFromUserStatement(email, eventCost);
            agb.closeConnection();
            
            return true;
        }
        agb.closeConnection();
        
        return false;
    }
    
    
    
}
