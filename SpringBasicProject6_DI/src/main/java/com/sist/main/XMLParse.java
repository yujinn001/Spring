package com.sist.main;
import java.lang.reflect.Method;
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class XMLParse extends DefaultHandler {
	private Map map =new HashMap();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("beans"))
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				String sabun=attributes.getValue("p:sabun");
				String name=attributes.getValue("p:name");
				String job=attributes.getValue("p:job");
				String dept=attributes.getValue("p:dept");
				String s=attributes.getQName(3);
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m :methods)
				{
					String mName=m.getName();
					if(mName.equalsIgnoreCase("set"+s.substring(s.indexOf(":")+1)))
					{
						m.invoke(obj, name);
					}
				}
				map.put(id, obj);
			}
		}catch(Exception ex) {}
	}
	
	
	
	
}
