package fbfinal;

import java.io.Serializable;

/**
 * Subclass of FaceBookletNode that deals with personal information
 * @author Samantha Rothman
 * 3/8/2018
 * Tuesday 3:30-4:45pm lab
 *
 */

public class FaceBookletProfile extends FaceBookletNode implements Serializable  {
	
	private String status;
	private String pic;
	
	/**
	 * Creates a FaceBookletProfile with a name and status.
	 * @param name String with name of profile
	 */
	public FaceBookletProfile(String name) {
		super(name);
		status = "";
		
	}

	/**
	 * Updates the status of a profile.
	 * @param i String with status
	 */
	public void updatestatus(String i) {
		status = i;
	}
	
	/**
	 * Getter for status.
	 * @return String with status
	 */
	public String getStatus() {
		return status;
	}
	
	@Override
	/**
	 * Returns a user-friendly string with name, status, and friends.
	 */
	public String toString() {
		return getName() + " (" + getStatus() + "): " + seeFriends();
	}
	
	/**
	 * Updates the profile picture of a profile.
	 * @param s String with path to picture
	 */
	public void profpic(String s) {
		pic = s;
	}
	
	/**
	 * Getter for profile picture.
	 * @return String with path to profile picture
	 */
	public String getprofpic() {
		return pic;
	}
	
	

}


