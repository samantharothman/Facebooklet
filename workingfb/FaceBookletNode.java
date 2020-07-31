package fbfinal;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Abstract class that creates a node for a user.
* @author Samantha Rothman
 * 3/8/2018
* Tuesday 3:30-4:45pm lab
*
*/
public abstract class FaceBookletNode implements Serializable {
		
	private String profile;
		
	public ArrayList<FaceBookletNode> friends = new ArrayList<FaceBookletNode>();
		
	/**
	* Constructs a node with a name.
	* @param name user's name
	*/
	public FaceBookletNode(String name) {
		profile = name;
	}
		
	/**
	* Getter for profile name.
	* @return String with profile name
	*/
	public String getName() {
		return profile;
	}

	/**
	* Adds a profile to friends list.
	* @param s FacebookletNode for friend
	*/
	public void addFriend(FaceBookletNode s) {
		if (friends.contains(s) != true) {
			friends.add(s);
		}
	}
		
	/**
	 * Removes a profile from friends list.
	 * @param s FaceBookletNode for friend removed
	 */
	public void removeFriend(FaceBookletNode s) {
		if (friends.contains(s) == true) {
			friends.remove(s);
		}
		else {
			return;
		}
			
	}
		
	/**
	 * Determines if the profile is friends with a given profile.
	 * @param s FaceBookletNode for profile being searched
	 * @return String that states whether profile is friends with given profile
	 */
	public String lookupFriend(FaceBookletNode s) {
		for (int i=0; i<friends.size(); i++) {
			if (friends.get(i) == s) {
				return "Friends"; 
			}
		}
		return "	Not friends";
	}
		
	/**
	 * Prints a list of all the profile's friends.
	 * @return String with list of friends
	*/
	public String seeFriends() {
		String friendslist = "";
			
		for (int i=0; i< friends.size(); i++) {
			if (i == friends.size()-1) {
				friendslist = friendslist + friends.get(i).getName();
			}
			else {
				friendslist = friendslist + friends.get(i).getName() + ", ";
			}
		}
		return friendslist;
	}
		
	/**
	 * Getter for the array of friends
	 * @return array of FaceBookletNodes
	 */
	public ArrayList<FaceBookletNode> getFriends() {
		return friends;
	}
		
	@Override
	/**
	 * Returns a user-friendly string of the profile and their friends.
	 */
	public String toString() {
		return getName() + " is friends with " + seeFriends();
	}
		
			
}

