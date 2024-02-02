package ch05_pjt_01.contact.dao;

import java.util.HashMap;
import java.util.Map;

import ch05_pjt_01.contact.ContactSetDTO;

public class ContactDao {
	
	private Map<String, ContactSetDTO> contactDB = new HashMap<String, ContactSetDTO>();
	
	public void insert(ContactSetDTO contactSetDTO) {
		contactDB.put(contactSetDTO.getName(), contactSetDTO);
	}
	
	public ContactSetDTO select(String name) {
		return contactDB.get(name);
	}
	
	public Map<String, ContactSetDTO> getContactDB(){
		return contactDB;
	}
}
