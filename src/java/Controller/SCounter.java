/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Sachindra Rodrigo
 */
public class SCounter implements HttpSessionListener {

    private static int sessionCount=0;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        if(sessionCount>0)
            sessionCount--;
    }
    public static int getNumberOfSessions()
    {
        return sessionCount;
    }
    
}
