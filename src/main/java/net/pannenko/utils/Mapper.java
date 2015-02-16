package net.pannenko.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import net.pannenko.uitemplate.UserForm;

import com.altova.io.Input;
import com.altova.io.Output;
import com.altova.io.StreamInput;
import com.altova.io.StreamOutput;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mapforce.MappingMapToUser;

public class Mapper {

  public static Object map(Object from, Class<?> to) throws Exception {

    JAXBContext jaxbContext = JAXBContext.newInstance(from.getClass());
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    // Write the Java object to a byte array output stream
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    jaxbMarshaller.marshal(from, outputStream);

    // Give that byte array output stream to altova to read
    Input input1 = new StreamInput(new ByteArrayInputStream(
        outputStream.toByteArray()));

    // Provide a byte array output stream for altova to write to
    ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
    Output output1 = new StreamOutput(outputStream2);

    // Perform the mapping using altova generated code
    MappingMapToUser test = new MappingMapToUser();
    test.run(input1, output1);

    // Unmarshal the byte array that altova wrote to.
    JAXBContext jaxbContext2 = JAXBContext.newInstance(to);
    Unmarshaller unmarshaller = jaxbContext2.createUnmarshaller();
    InputStream inputStream = new ByteArrayInputStream(
        outputStream2.toByteArray());
    return unmarshaller.unmarshal(inputStream);

  }

  public static void generateXSD(Object o, String filename)
      throws JAXBException, IOException {

    JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
    jaxbContext.generateSchema(new MySchemaOutputResolver(filename));
  }

  public static void makeXML(UserForm object) throws JAXBException {
    File file = new File("file.xml");
    JAXBContext jaxbContext = JAXBContext.newInstance(UserForm.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    // output pretty printed
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    jaxbMarshaller.marshal(object, file);
    jaxbMarshaller.marshal(object, System.out);
  }

  public static void makeJSON(UserForm object) throws JsonProcessingException {
    ObjectMapper myObjectMapper = new ObjectMapper();
    myObjectMapper.setSerializationInclusion(Include.NON_NULL);

    ObjectWriter ow = myObjectMapper.writer().withDefaultPrettyPrinter();

    String json = ow.writeValueAsString(object);
    System.out.println(object);
    System.out.println(json);
  }

  static class MySchemaOutputResolver extends SchemaOutputResolver {

    private String filename;

    public MySchemaOutputResolver(String filename) {
      this.filename = filename;
    }

    public Result createOutput(String namespaceURI, String suggestedFileName)
        throws IOException {
      File file = new File(filename);
      StreamResult result = new StreamResult(file);
      result.setSystemId(file.toURI().toURL().toString());
      return result;
    }

  }
}
