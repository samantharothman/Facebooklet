package fbfinal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Keeps track of and manages all profiles in FaceBooklet.
 * @author Samantha Rothman
 * 3/8/2018
 * Tuesday 3:30-4:45pm lab
 *
 */

public class FaceBookletDataBase {
	
	 
	HashMap<String, FaceBookletProfile> database;
	
	/**
	 * Constructs a database for FaceBooklet.
	 */
	public FaceBookletDataBase() {
		database = new HashMap<String, FaceBookletProfile>();	
	}
	
	/**
	 * Creates a profile for the user and adds it to the database.
	 * @param s String with user's name
	 */
	public void createProfile(String s) {
		if (database.containsKey(s) == true) {
			removeProfile(s);
		}
		FaceBookletProfile n = new FaceBookletProfile(s);
		database.put(s, n);
	}
	
	/**
	 * Removes a profile from the database.
	 * @param s String with user's name.
	 */
	public void removeProfile(String s) {
		FaceBookletProfile i;
		FaceBookletNode person;
		if (database.containsKey(s) == true ) {
			i = database.get(s);
			for (int j = 0; j<i.friends.size(); j++) {
				person = i.friends.get(j);
				person.removeFriend(i);
			}
			database.remove(s);
		}
		else {
			return;
		}
		
	}
	
	/**
	 * Determines if a profile is in the database.
	 * @param s String with name of profile
	 * @return String that states if profile is found
	 */
	public String lookUp(String s) {
		if (database.containsKey(s) == true) {
			return "User found";
		}
		return "User not found";
	}
	
	/**
	 * Sets a status for the profile.
	 * @param s String with name of profile
	 * @param j String with their status
	 */
	public void newStatus(String s, String j) {
		FaceBookletProfile i;
		i = database.get(s);
		i.updatestatus(j);
	}
	
	/**
	 * Shows the status of a profile.
	 * @param s String with profile name
	 * @return String with status
	 */
	public String seeStatus(String s) {
		FaceBookletProfile i;
		i = database.get(s);
		return i.getStatus();
	}
	
	/**
	 * Shows name, status, and friends for desired profile.
	 * @param s String with name
	 * @return String with name, status, and friends
	 */
	public String getProfile(String s) {
		FaceBookletProfile i;
		i = database.get(s);
		return i.toString();
	}
	
	/**
	 * Allows a profile to become friends with another profile.
	 * @param s String with name of first profile
	 * @param z String with name of second profile
	 */
	public void newFriend(String s, String z) {
		FaceBookletProfile i, j;
		i = database.get(s);
		j = database.get(z);
		i.addFriend(j);
		j.addFriend(i);
	}
	
	/**
	 * Allows a profile to  unfriend another profile.
	 * @param s String with name of first profile
	 * @param z String with name of second profile
	 */
	public void deleteFriend(String s, String z) {
		FaceBookletProfile i, j;
		i = database.get(s);
		j = database.get(z);
		i.removeFriend(j);
		j.removeFriend(i);
	}
	
	/**
	 * Gets the list of friends for a profile.  The array will be used for 
	 * getting each profile picture.
	 * @param s String with name of profile
	 * @return 
	 * @return Array of friends
	 */
	public ArrayList<FaceBookletNode> allFriends(String s) {
		FaceBookletProfile i;
		i = database.get(s);
		return i.getFriends();
	}
	
	/**
	 * Turns all the data in the HashMap to a user-friendly string with 
	 * names, statuses, and friends.
	 */
	@Override
	public String toString() {
		String finalstring = "";
		for (String key : database.keySet()) {
			FaceBookletProfile i;
			i = database.get(key);
			finalstring = finalstring + i.toString() + "\n";
		}
		return finalstring;
	}
	
	/**
	 * Updates the profile picture of a user.
	 */
	public void updatePicture(String s, String p) {
		FaceBookletProfile i;
		i = database.get(s);
		i.profpic(p);
	}
	
	/**
	 * Gets the path of the profile picture for the given user.
	 * @param s String with name of user
	 * @return String with path to picture
	 */
	public String getPicture(String s) {
		FaceBookletProfile i;
		i = database.get(s);
		return i.getprofpic();
	}
	
	/**
	 * Takes all users in the database and puts them into a user-freindly string.
	 * @return String with all names in the database
	 */
	public String seeAllUsers() {
		String users = "";
		for (String key : database.keySet()) {
			FaceBookletProfile i;
			i = database.get(key);
			users = users + i.getName() + "\n";
		}
		return users;
	}
	
	/**
	 * Takes the database and saves it to a file.
	 */
	public void exportToFile(String n) {
		try {
			FileOutputStream fileOut = new FileOutputStream(n);
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(database);
	        out.close();
	        fileOut.close();
	     }
		catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	/**
	 * Imports a file and saves it as a database.
	 */
	public void importFromFile(String n) {
		try {
			FileInputStream fis = new FileInputStream(n);
	        ObjectInputStream ois = new ObjectInputStream(fis);
	        HashMap<String, FaceBookletProfile> readObject = (HashMap<String, FaceBookletProfile>) ois.readObject();
			database = readObject;
	        ois.close();
	        fis.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
			return;
		}
		catch(ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
	}

	
}


