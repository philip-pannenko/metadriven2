# metadriven2

Summary:

The object in uitemplate directory serves four purposes.
1. build the ui layer
2. act as a contract for the UI to bind data to
3. allow jersey to populate a java object from the json request
4. a 'from' source that ALTOVA uses 

The object in the bo directory serves two purposes
1. a 'to' source that ALTOVA uses
2. however we end up using the object in our business logic

There are 4 pieces to the ALTOVA element.
1. the 'from' source XML that is generated from uitemplate using JAXB
2. the 'to' source XML that is generated from the bo using JAXB
3. the transformation file which is manually created using the ALTOVA software
4. the transformation java jar file which is generated from step 3

The Mapper class does the ALTOVA transformation.

The HelloWorldResource uses the Mapper class as a demonstration.

The Driver main method creates an XSD of the uitemplate and bo objects.
