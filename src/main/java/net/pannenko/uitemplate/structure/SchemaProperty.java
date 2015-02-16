package net.pannenko.uitemplate.structure;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class SchemaProperty implements Serializable {
  private static final long serialVersionUID = 1L;
  private String title;
  private String type = "string";
  private String pattern;
  private String description;
  private Integer maxLength;
  private String validationMessage;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  @XmlElement
  public void setType(String type) {
    this.type = type;
  }

  public String getPattern() {
    return pattern;
  }

  @XmlElement
  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getMaxLength() {
    return maxLength;
  }

  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }

  public String getValidationMessage() {
    return validationMessage;
  }

  public void setValidationMessage(String validationMessage) {
    this.validationMessage = validationMessage;
  }

}
