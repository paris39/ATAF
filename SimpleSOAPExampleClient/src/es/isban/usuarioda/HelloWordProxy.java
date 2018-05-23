package es.isban.usuarioda;

public class HelloWordProxy implements es.isban.usuarioda.HelloWord {
  private String _endpoint = null;
  private es.isban.usuarioda.HelloWord helloWord = null;
  
  public HelloWordProxy() {
    _initHelloWordProxy();
  }
  
  public HelloWordProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloWordProxy();
  }
  
  private void _initHelloWordProxy() {
    try {
      helloWord = (new es.isban.usuarioda.HelloWordServiceLocator()).getHelloWord();
      if (helloWord != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloWord)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloWord)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloWord != null)
      ((javax.xml.rpc.Stub)helloWord)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public es.isban.usuarioda.HelloWord getHelloWord() {
    if (helloWord == null)
      _initHelloWordProxy();
    return helloWord;
  }
  
  public java.lang.Object sayHelloWorld(java.lang.String name) throws java.rmi.RemoteException{
    if (helloWord == null)
      _initHelloWordProxy();
    return helloWord.sayHelloWorld(name);
  }
  
  
}