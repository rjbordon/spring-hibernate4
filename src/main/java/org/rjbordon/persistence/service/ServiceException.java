package org.rjbordon.persistence.service;

/**
 * Created by rjbordon on 7/21/14.
 */
public class ServiceException extends Exception {
    public ServiceException(){
        super("Error when invoking Service layer");
    }
}