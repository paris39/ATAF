/**
 * HelloWordServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package es.isban.usuarioda;

public class HelloWordServiceLocator extends org.apache.axis.client.Service implements es.isban.usuarioda.HelloWordService {

    public HelloWordServiceLocator() {
    }


    public HelloWordServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloWordServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloWord
    private java.lang.String HelloWord_address = "http://localhost:8090/SimpleSOAPExample/services/HelloWord";

    public java.lang.String getHelloWordAddress() {
        return HelloWord_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloWordWSDDServiceName = "HelloWord";

    public java.lang.String getHelloWordWSDDServiceName() {
        return HelloWordWSDDServiceName;
    }

    public void setHelloWordWSDDServiceName(java.lang.String name) {
        HelloWordWSDDServiceName = name;
    }

    public es.isban.usuarioda.HelloWord getHelloWord() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloWord_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloWord(endpoint);
    }

    public es.isban.usuarioda.HelloWord getHelloWord(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            es.isban.usuarioda.HelloWordSoapBindingStub _stub = new es.isban.usuarioda.HelloWordSoapBindingStub(portAddress, this);
            _stub.setPortName(getHelloWordWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloWordEndpointAddress(java.lang.String address) {
        HelloWord_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (es.isban.usuarioda.HelloWord.class.isAssignableFrom(serviceEndpointInterface)) {
                es.isban.usuarioda.HelloWordSoapBindingStub _stub = new es.isban.usuarioda.HelloWordSoapBindingStub(new java.net.URL(HelloWord_address), this);
                _stub.setPortName(getHelloWordWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HelloWord".equals(inputPortName)) {
            return getHelloWord();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://usuarioda.isban.es", "HelloWordService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://usuarioda.isban.es", "HelloWord"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloWord".equals(portName)) {
            setHelloWordEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
