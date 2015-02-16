package net.pannenko.bo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private String email;

  public String getName() {
    return name;
  }

  @XmlElement
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  @XmlElement
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User [name=" + name + ", email=" + email + "]";
  }

}
