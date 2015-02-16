import net.pannenko.bo.User;
import net.pannenko.uitemplate.UserForm;
import net.pannenko.utils.Mapper;

public class Driver {

  public static void main(String[] args) throws Exception {

    UserForm originalObject = new UserForm();
    User mappedObject = new User();

    Mapper.generateXSD(originalObject, "UserForm.xsd");
    Mapper.generateXSD(mappedObject, "User.xsd");
    
    // Mapper.makeXML(originalObject);
    // Mapper.makeJSON(originalObject);

  }
}
