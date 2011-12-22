package de.lightful.testing.xslt.internal;

public interface ConfigurableService<CONFIG_DATA_TYPE> {

  void configure(CONFIG_DATA_TYPE configurationData);
}
