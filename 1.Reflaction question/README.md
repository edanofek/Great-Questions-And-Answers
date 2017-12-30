"# Great-Questions-And-Answers" 
	
	Great interview question about reflection.
	--------------------------------------------

	Implement a utility that will use Java reflection APIs to print "struct" objects. These "structs" are defined as follows:

o   They have only public attributes

o   Each attribute can be of the following types:

·         "Structs"

·         Collection or array of "Structs"

·         Primitive (e.g. int), primitive wrapper (e.g. Integer) or String

 

The program should navigate the object structure and print the structure.

 

 

General guidelines:

·         Start with a basic working implementation and then extend.

o   Phase 1: without collection and array

o   Phase 2: Add handling of collection

o   Phase 3: Add handling of array

·         Provide testing code to each phase

·         Make sure exceptions are handled properly

·         Make sure the API to use this utility is convenient to use

·         Write the code as though you are writing production code

 

Examples
Here's an example: 

class Name {

    public String firstName;
    public String lastName;    

}


class Person {
    public int age; 
    public Name name;

}
 
Name n = new Name();

n.firstName = "Idan";
n.lastName = "Ofek";

Person p = new Person();
p.age = 35;
p.name = n;

 

The output of your utility when run on instance p above should be something like this:


    Object of Class "Person"

    ----------------------------------------
    age = 31
    name =  

                 Object of Class "Name"

                 ----------------------------------

                 firstName = "Idan"

                 lastName = "Ofek"