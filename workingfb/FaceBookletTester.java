package fbfinal;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * This is a JUnit Tester for FaceBooklet.
 * @author Samantha Rothman
 * 3/8/2018
 * Tuesday 3:30-4:45pm lab
 *
 */
public class FaceBookletTester extends TestCase {
	
	//create FaceBookletProfiles
	private FaceBookletProfile s;
	private FaceBookletProfile d;
	private FaceBookletProfile f;
	
	//create names for the profiles
	private String name1 = "Samantha";
	private String name2 = "Jessica";
	private String name3 = "Julia";

	public static void main(String [] args) {
		junit.textui.TestRunner.main(new String [] {"FaceBookletTester"});	
	}
	
	//set up FaceBookletProfiles
	@Override
	protected void setUp() {
		s = new FaceBookletProfile(name1);
		d = new FaceBookletProfile(name2);
		f = new FaceBookletProfile(name3);
	}
	
	//tear down after tests
	@Override
	protected void tearDown() {
		s = null;
		d = null;
		f = null;
	}
	
	
	//test getName function
	public void testgetName() {
		assertEquals("Samantha", s.getName());
		assertEquals("Jessica", d.getName());
		assertEquals("Julia", f.getName());
	}
	
	//test addFriend function
	public void testaddFriend() {
		ArrayList<FaceBookletNode> friends1 = new ArrayList<>();
		ArrayList<FaceBookletNode> friends2 = new ArrayList<>();
		ArrayList<FaceBookletNode> friends3 = new ArrayList<>();
		friends1.add(d);
		friends2.add(f);
		friends3.add(s);
		s.addFriend(d);
		d.addFriend(f);
		f.addFriend(s);
		assertEquals(s.friends, friends1);
		assertEquals(d.friends, friends2);
		assertEquals(f.friends, friends3);
	}
		
	//test removeFriend function	
	public void testremoveFriend() {
		ArrayList<FaceBookletNode> friends1 = new ArrayList<>();
		ArrayList<FaceBookletNode> friends2 = new ArrayList<>();
		ArrayList<FaceBookletNode> friends3 = new ArrayList<>();
		s.addFriend(d);
		d.addFriend(f);
		f.addFriend(s);
		s.removeFriend(d);
		d.removeFriend(f);
		f.removeFriend(s);
		assertEquals(s.friends, friends1);
		assertEquals(d.friends, friends2);
		assertEquals(f.friends, friends3);
	}
	
	//test lookupFriend function
	public void testlookupFriend() {
		String truth = "Friends";
		s.addFriend(d);
		d.addFriend(s);
		d.addFriend(f);
		f.addFriend(s);
		assertEquals(truth, s.lookupFriend(d));
		assertEquals(truth, d.lookupFriend(s));
		assertEquals(truth, f.lookupFriend(s));
		assertNotSame(truth, s.lookupFriend(f));
	}
	
	//test seeFriends function
	public void testseeFriends() {
		String friends1 = "Samantha, Julia";
		String friends2 = "Samantha";
		String friends3 = "Jessica, Julia";
		s.addFriend(d);
		s.addFriend(f);
		d.addFriend(s);
		d.addFriend(f);
		f.addFriend(s);
		assertEquals(friends1, d.seeFriends());
		assertEquals(friends2, f.seeFriends());
		assertEquals(friends3, s.seeFriends());
	}
	
	//test getStatus function
	public void testgetStatus() {
		String status1 = "hey";
		String status2 = "coding";
		String status3 = "i'm tired";
		s.updatestatus("hey");
		d.updatestatus("coding");
		f.updatestatus("i'm tired");
		assertEquals(status1, s.getStatus());
		assertEquals(status2, d.getStatus());
		assertEquals(status3, f.getStatus());	
	}
	
	//test toString function
	public void testString() {
		String profile1 = "Samantha (hey): Jessica";
		String profile2 = "Jessica (coding): Samantha, Julia";
		String profile3 = "Julia (i'm tired): Samantha, Jessica";
		s.addFriend(d);
		s.updatestatus("hey");
		d.addFriend(s);
		d.addFriend(f);
		d.updatestatus("coding");
		f.addFriend(s);
		f.addFriend(d);
		f.updatestatus("i'm tired");
		assertEquals(profile1, s.toString());
		assertEquals(profile2, d.toString());
		assertEquals(profile3, f.toString());
	}
	
	//test profpic function
	public void testgetprofpic() {
		String prof = "pic";
		String prof2 = "profile";
		String prof3 = "profilepic";
		s.profpic("pic");
		d.profpic("profile");
		f.profpic("profilepic");
		assertEquals(prof, s.getprofpic());
		assertEquals(prof2, d.getprofpic());
		assertEquals(prof3, f.getprofpic());
	}
	
	
	
}
