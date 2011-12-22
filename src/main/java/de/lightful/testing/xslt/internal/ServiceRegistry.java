package de.lightful.testing.xslt.internal;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceRegistry {

  public static <T> T getServiceInstance(Class<T> serviceInterface) {
    ServiceLoader<T> loader = ServiceLoader.load(serviceInterface);
    Iterator<T> serviceInterator = loader.iterator();
    return serviceInterator.next();
  }

  public static <CONFIG_DATA_TYPE, T extends ConfigurableService<CONFIG_DATA_TYPE>> T getServiceInstance(Class<T> serviceInterface, CONFIG_DATA_TYPE configurationData) {
    ServiceLoader<T> loader = ServiceLoader.load(serviceInterface);
    T serviceInstance = loader.iterator().next();
    serviceInstance.configure(configurationData);
    return serviceInstance;
  }
}
