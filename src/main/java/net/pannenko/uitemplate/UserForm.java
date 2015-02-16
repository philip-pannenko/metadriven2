package net.pannenko.uitemplate;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.pannenko.uitemplate.structure.FormElement;
import net.pannenko.uitemplate.structure.Schema;
import net.pannenko.uitemplate.structure.SchemaProperty;

@XmlRootElement
public class UserForm implements Serializable {

  private static final long serialVersionUID = 1L;

  // Model objects Variables (Scroll down for Form variables)
  // Used to move data from UI to Jersey.
  // Jersey automatically makes a UserForm with these values populated from
  // the JSON model object pased from AngularJS

  private String fname;
  private String lname;
  private String email;
  private String comment;

  public String getFname() {
    return fname;
  }

  @XmlElement
  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  @XmlElement
  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getEmail() {
    return email;
  }

  @XmlElement
  public void setEmail(String email) {
    this.email = email;
  }

  public String getComment() {
    return comment;
  }

  @XmlElement
  public void setComment(String comment) {
    this.comment = comment;
  }

  // Form builder variables.
  // Used to build the UI form. I'm certain there's a way to share these two
  // I'm still not certain what the difference is between Schema and Form data fields, but
  //  one has to deal with the model and the other with the form. Once we know this difference,
  //  we can use that field as the getter/setter that Jersey uses when it converts a JSON value to an object.
  //  Jesery may not do this natively so we can add a converter that interprets a FormElement<String> or 
  //  SchemaProperty<String> as a string and we can start simplifing these UIClasses.
  // This is what we've been wanted to do with our Transaction object partly. We want to send the UI a model
  //  that we want filled in and then the java side inteprets it the way it expects to instead of 
  //  having to manually build the Transaction object from the angularjs side.
  private Schema schema;
  private FormElement[] form;

  public Schema getSchema() {
    return schema;
  }

  public void setSchema(Schema schema) {
    this.schema = schema;
  }

  public FormElement[] getForm() {
    return form;
  }

  public void setForm(FormElement[] form) {
    this.form = form;
  }

  public UserForm() {
    form = new FormElement[5];
    form[0] = new FormElement("fname");
    form[1] = new FormElement("lname");
    form[2] = new FormElement("email");
    form[3] = new FormElement("comment", "textarea", "Make a comment", null,
        null);
    form[4] = new FormElement(null, "submit", null, "btn-info", "OK");

    
    schema = new Schema();
    schema.setType("object");
    schema.setTitle("Comment");
    schema.setRequired(new String[] { "fname", "lname", "email", "comment" });

    SchemaProperty fname = new SchemaProperty();
    fname.setTitle("First Name");

    SchemaProperty lname = new SchemaProperty();
    lname.setTitle("Last Name");

    SchemaProperty email = new SchemaProperty();
    email.setTitle("Email");
    email.setPattern("^\\S+@\\S+$");
    email.setDescription("Email will be used for evil.");

    SchemaProperty comment = new SchemaProperty();
    comment.setTitle("Comment");
    comment.setMaxLength(20);
    comment.setValidationMessage("Don't be greedy!");

    schema.getProperties().put("fname", fname);
    schema.getProperties().put("lname", lname);
    schema.getProperties().put("email", email);
    schema.getProperties().put("comment", comment);

  }

  @Override
  public String toString() {
    return "UserForm [fname=" + fname + ", lname=" + lname + ", email=" + email
        + ", comment=" + comment + "]";
  }

}
