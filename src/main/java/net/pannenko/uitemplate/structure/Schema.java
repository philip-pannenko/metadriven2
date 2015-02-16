package net.pannenko.uitemplate.structure;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Schema implements Serializable {
  private static final long serialVersionUID = 1L;
  private String type;
  private String title;
  private Map<String, SchemaProperty> properties = new LinkedHashMap<String, SchemaProperty>();
  private String[] required;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Map<String, SchemaProperty> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, SchemaProperty> properties) {
    this.properties = properties;
  }

  public String[] getRequired() {
    return required;
  }

  public void setRequired(String[] required) {
    this.required = required;
  }

}