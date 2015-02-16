package net.pannenko.uitemplate.structure;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class FormElement implements Serializable {
  private static final long serialVersionUID = 1L;
  private String key;
  private String type;
  private String placeholder;
  private String style;
  private String title;

  public FormElement(String key) {
    this.key = key;
  }

  public FormElement(String key, String type, String placeholder, String style,
      String title) {
    super();
    this.key = key;
    this.type = type;
    this.placeholder = placeholder;
    this.style = style;
    this.title = title;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getType() {
    return type;
  }

  @XmlElement
  public void setType(String type) {
    this.type = type;
  }

  public String getPlaceholder() {
    return placeholder;
  }

  @XmlElement
  public void setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}