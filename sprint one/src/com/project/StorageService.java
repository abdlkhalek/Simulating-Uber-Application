/**
 * 
 */
package com.project;

import java.util.List;

/**
 * @author Abdulkhalek Alalimi
 *
 */
public interface StorageService {
	
	public void store(User user) ;

//	public void storeUnActive(User user) ;

	// delete 
	public void delete(User user);
	
	// by the id which is mobie number here 
    public User getUser(String mobileNumber);
    
    // find by name
    public List<User> getByName(String name) ;

}
