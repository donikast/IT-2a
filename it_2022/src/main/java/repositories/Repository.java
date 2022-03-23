package repositories;

import java.util.HashSet;
import java.util.Set;

import models.User;

public class Repository {
	
	private static Repository instance = null;
	private static Set<User> collection;
	
	private Repository() {}
	
	public static Repository getInstance() {
		if(instance == null) {
			instance = new Repository();
			collection = new HashSet<User>();
		}
		return instance;
	}
	
	public void addUser(User user) {
		collection.add(user);
	}
	
	public User getUserByUsername(String username) {
		for(User u:collection) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}
	
	public boolean ifExist(User user) {
		return collection.contains(user);
	}
	
}
