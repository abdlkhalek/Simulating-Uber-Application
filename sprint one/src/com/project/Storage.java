package com.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storage implements StorageService{

	
	private static final Map<String, User> store = new HashMap<>();
//	private static final Map<String, User> pinnedDriver = new HashMap<>(); // for didn't approved user yet
	private static volatile Storage storage ;
	
	private Storage() {}
	
	public static Storage getInstance() { // get instance of the object 
		if (storage==null) {
			synchronized (Storage.class) {
				if (storage==null) {
					storage =  new Storage();
				}
			}
		}
		return storage;
	}
	
	@Override
	public void store(User user) {
        synchronized(store) {
        	store.put(user.getMobileNumber(), user);
        }
    }

	// delete 
	@Override
	public void delete(User user) {
		synchronized(store) {
        	store.remove(user.getMobileNumber());
        }
	}
	
	// by the id which is mobile number here 
	@Override
    public User getUser(String mobileNumber) {
        synchronized(store) {
            return store.get(mobileNumber);
        }
    }
    
    // find by name
	@Override
    public List<User> getByName(String name) {
    	synchronized (store) {
			return store.values().stream().filter(u->u.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		}
    }
	
	public Map<String, User> search(User user , Ride ride) {
		Map<String, User> response = new HashMap<>();
		for (Map.Entry<String, User> entry : store.entrySet()) {
			if (entry.getValue() instanceof Driver && !((Driver)entry.getValue()).isPinned()) {
				((Driver) entry.getValue()).update(user , ride);
				response.put(entry.getKey(),entry.getValue());
			}
		}
		return response;
	}
	

}