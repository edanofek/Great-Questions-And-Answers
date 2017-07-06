
package src;


import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Struct.*;


public class AssignmentReflactionUtilityTests {
 
	private String firstName1="firstName1",lastName1="lastName1";
	private String firstName2="firstName2",lastName2="lastName2";
	private String firstName3="firstName3",lastName3="lastName3";
	
	//mock Structs objects
	private String prefix="";

	private Name n,n1,n2;
	private Person p,p1,p2;
	
	//Collections mock objects
	private NameCollection nameCollection;
	private PersonCollection personCollection;
	//Arrays mock objects
	private NamesMockArray namesMockArray;
	private PersonMockArray personMockArray;
	
	@Before
	public void initMockStructsObjects()
	{
		n = new Name();

		n.firstName = firstName1;
		n.lastName = lastName1;
		
		n1 = new Name();
		n1.firstName = firstName2;
		n1.lastName = lastName2;
		
		n2 = new Name();
		n2.firstName = firstName3;
		n2.lastName = lastName3;

		p = new Person();
		p.age = 30;
		p.name = n;
		
		p1 = new Person();
		p1.age = 28;
		p1.name = n1;
		
		p2 = new Person();
		p2.age = 37;
		p2.name = n2;
		
		nameCollection = new NameCollection();
		nameCollection.namesStack = new Stack<Name>();
		
		nameCollection.namesStack.add(n2);
		nameCollection.namesStack.add(n1);
		nameCollection.namesStack.add(n);
		

		nameCollection.namesQueue = new LinkedList<Name>();
		nameCollection.namesQueue.add(n2);
		nameCollection.namesQueue.add(n1);
		nameCollection.namesQueue.add(n);

		
		personCollection = new PersonCollection();
		personCollection.personsStack = new Stack<Person>();
		personCollection.personsStack.add(p);
		personCollection.personsStack.add(p1);
		personCollection.personsStack.add(p2);
		
		
		personCollection.personsQueue = new LinkedList<Person>();
		personCollection.personsQueue.add(p);
		personCollection.personsQueue.add(p1);
		personCollection.personsQueue.add(p2);
		
		namesMockArray = new NamesMockArray();
		namesMockArray.names = new Name[3];
		namesMockArray.names[0] = n;
		namesMockArray.names[1] = n1;
		namesMockArray.names[2] = n2;
		
		personMockArray = new PersonMockArray();
		personMockArray.persons = new Person[3];
		personMockArray.persons[0] = p;
		personMockArray.persons[1] = p1;
		personMockArray.persons[2] = p2;
	}
	
	@After
	public void DeleteMockStructsObjects()
	{
		//clean primitive value
		p= null;
		n= null;
		
		nameCollection = null;
		personCollection = null;
		
		namesMockArray = null;
		personMockArray = null;
	}
	
	//test Primitive type 
	@Test 
	public void testPrintPrimitiveWithoutInnerStructObject()
	{
		StringBuilder outPutStructPrimitive = new StringBuilder();
		StringBuilder outPutStructInnerPrimitive = new StringBuilder();
		try {
			outPutStructPrimitive = AssignmentReflactionUtility.ReturnStructObj(n,prefix);
			outPutStructInnerPrimitive = AssignmentReflactionUtility.ReturnStructObj(p,prefix);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		
		//check for classes names
		assertNotEquals("class name 'Name' is not return by print",outPutStructPrimitive.indexOf("Name"),-1);
		
		assertNotEquals("class name 'Person' is not return by print",outPutStructInnerPrimitive.indexOf("Person"),-1);
		assertNotEquals("class name 'Name' is not return by print",outPutStructInnerPrimitive.indexOf("Name"),-1);

		//check for fields values in only primitive properties class returned print
		assertNotEquals("class Name First name value is not mock value '"+firstName1+"'",outPutStructPrimitive.indexOf(firstName1),-1);
		assertNotEquals("class Name Last name value is not mock value '"+lastName1+"' ",outPutStructPrimitive.indexOf(lastName1),-1);
		
		//check for fields values in only primitive properties class returned print 
		assertNotEquals("class Name First name value is not mock value '"+firstName1+"'",outPutStructInnerPrimitive.indexOf(firstName1),-1);
		assertNotEquals("class Name Last name value is not mock value '"+lastName1+"'",outPutStructInnerPrimitive.indexOf(lastName1),-1);
		
	}
	
	
//	test Print Struct With Collections
	@Test
	public void testPrintStructWithCollections()
	{
		StringBuilder outPutStructNamesStackCollection = new StringBuilder();
		StringBuilder outPutStructNamesQueueCollection = new StringBuilder();

		StringBuilder outPutStructPersonStackCollection = new StringBuilder();
		StringBuilder outPutStructPersonQueueCollection = new StringBuilder();
		
		try{
			
			outPutStructNamesStackCollection = AssignmentReflactionUtility.ReturnStructObjCollection(nameCollection.namesStack);
			outPutStructNamesQueueCollection = AssignmentReflactionUtility.ReturnStructObjCollection(nameCollection.namesQueue);
			
			outPutStructPersonStackCollection = AssignmentReflactionUtility.ReturnStructObjCollection(personCollection.personsStack);
			outPutStructPersonQueueCollection = AssignmentReflactionUtility.ReturnStructObjCollection(personCollection.personsQueue);
			
		}catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		
		//names collection 
		//stack
		assertNotEquals(" Collections names Stack data does not contain '"+firstName1+"' ",outPutStructNamesStackCollection.indexOf(firstName1),-1);
		assertNotEquals(" Collections names Stack data does not contain '"+lastName1+"' ",outPutStructNamesStackCollection.indexOf(lastName1),-1);
		
		assertNotEquals(" Collections names Stack data does not contain '"+firstName2+"' ",outPutStructNamesStackCollection.indexOf(firstName2),-1);
		assertNotEquals(" Collections names Stack data does not contain '"+lastName2+"' ",outPutStructNamesStackCollection.indexOf(lastName2),-1);
		
		assertNotEquals(" Collections names Stack data does not contain '"+firstName3+"' ",outPutStructNamesStackCollection.indexOf(firstName3),-1);
		assertNotEquals(" Collections names Stack data does not contain '"+lastName3+"'",outPutStructNamesStackCollection.indexOf(lastName3),-1);
		
		//queue (linked list)
		assertNotEquals(" Collections names Queue data does not contain '"+firstName1+"' ",outPutStructNamesQueueCollection.indexOf(firstName1),-1);
		assertNotEquals(" Collections names Queue data does not contain '"+lastName1+"' ",outPutStructNamesQueueCollection.indexOf(lastName1),-1);
		
		assertNotEquals(" Collections names Queue data does not contain '"+firstName2+"' ",outPutStructNamesQueueCollection.indexOf(firstName2),-1);
		assertNotEquals(" Collections names Queue data does not contain '"+lastName2+"' ",outPutStructNamesQueueCollection.indexOf(lastName2),-1);
		
		assertNotEquals(" Collections names Queue data does not contain '"+firstName3+"' ",outPutStructNamesQueueCollection.indexOf(firstName1),-1);
		assertNotEquals(" Collections names Queue data does not contain '"+lastName3+"' ",outPutStructNamesQueueCollection.indexOf(lastName3),-1);
		
		//person collection
		//stack
		assertNotEquals(" Collections person Stack data does not contain age 30",outPutStructPersonStackCollection.indexOf("30"),-1);
		assertNotEquals(" Collections person Stack data does not contain age 28 ",outPutStructPersonStackCollection.indexOf("28"),-1);
		assertNotEquals(" Collections person Stack data does not contain age 37 ",outPutStructPersonStackCollection.indexOf("37"),-1);
		
		
		//queue (linked list)
		assertNotEquals(" Collections person Queue data does not contain age 30",outPutStructPersonQueueCollection.indexOf("30"),-1);
		assertNotEquals(" Collections person Queue data does not contain age 28 ",outPutStructPersonQueueCollection.indexOf("28"),-1);
		assertNotEquals(" Collections person Queue data does not contain age 37 ",outPutStructPersonQueueCollection.indexOf("37"),-1);
	}
	
	
	@Test
	public void testPrintStructWithArrayOfSturct()
	{
		StringBuilder outPutStructNamesArray = new StringBuilder();
		StringBuilder outPutStructPersonsArray = new StringBuilder();
		
		try{		
			
			outPutStructNamesArray = AssignmentReflactionUtility.ReturnStructObjArray(namesMockArray.names);
			outPutStructPersonsArray = AssignmentReflactionUtility.ReturnStructObjArray(personMockArray.persons);
			
		}catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
		
		assertNotEquals(" Array names data does not contain first name '"+firstName1+"'",outPutStructNamesArray.indexOf(firstName1),-1);
		assertNotEquals(" Array names data does not contain last name '"+lastName1+"'",outPutStructNamesArray.indexOf(lastName1),-1);
		
		assertNotEquals(" Array names data does not contain first name '"+firstName2+"'",outPutStructNamesArray.indexOf(firstName2),-1);
		assertNotEquals(" Array names data does not contain last name '"+lastName2+"'",outPutStructNamesArray.indexOf(lastName2),-1);
	
		assertNotEquals(" Array person data does not contain '"+firstName1+"' age 30",outPutStructPersonsArray.indexOf("30"),-1);
		assertNotEquals(" Array person data does not contain '"+firstName2+"' age 28",outPutStructPersonsArray.indexOf("28"),-1);
		

	}
}
