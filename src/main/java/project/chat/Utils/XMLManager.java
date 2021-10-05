package project.chat.Utils;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.jar.JarException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import project.chat.model.UserRoom;

public class XMLManager {
	public static void marshal1(UserRoom ur) throws IOException, JAXBException{
		marshal(ur, "chat.xml");
	}
	
	
	public static void marshal(UserRoom ur, String f)throws JAXBException, IOException  {
		marshal(ur,new File(f));
	}
	
	public static void marshal(UserRoom ur, File f) throws IOException, JAXBException {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(f))){
			JAXBContext context = JAXBContext.newInstance(UserRoom.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
			m.marshal(ur, writer);
			//writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static UserRoom unmarshal(File f) throws IOException {
		
		try {
			JAXBContext jc = JAXBContext.newInstance(UserRoom.class);
			Unmarshaller u = jc.createUnmarshaller();
			//u.setProperty(jc.JAXB_CONTEXT_FACTORY, true);
			UserRoom ur = (UserRoom) u.unmarshal(f);
			System.out.println(ur);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		
		return null;
	}
	
	
	/*
	try {
		JAXBManager.marshal(lista, new File("ejemplo.xml"));
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
}
