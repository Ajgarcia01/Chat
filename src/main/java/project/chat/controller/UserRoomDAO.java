package project.chat.controller;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import project.chat.Utils.XMLManager;
import project.chat.model.UserRoom;

public class UserRoomDAO extends UserRoom{
	private static UserRoom _Instance;
	
	public static UserRoom getInstance(File f) throws JAXBException {
		if(f!=null) {
			try {
				_Instance= XMLManager.unmarshal("chat.xml");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			try {
				XMLManager.marshal(_Instance, new File("chat.xml"));
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return _Instance;
	}

}
