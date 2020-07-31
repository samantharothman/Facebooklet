package fbfinal;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates a GUI for the FaceBooklet program.
 * @author Samantha Rothman
 * 3/8/2018
 * Tuesday 3:30-4:45pm lab
 *
 */
public class FaceBooklet extends JFrame implements ActionListener{
	
	public static FaceBookletDataBase friends;
	private JTextField feed, createprofile, addprofile, budprofile, oldprof,
	person, badperson, see, statusProf, username, saveto, openfrom, pic, picAddress;
	private JButton create, add, remove, delete, open, save, search, status, create2, add2,
	delete2, remove2, search2, status2, save2, open2, picture, picture2, seeAll;
	public JFrame frame;
	private JPanel createProfile, addFriend, removeProfile, removeFriend, seeProfile, updateStatus, 
	file, export, profpic, friendspics;
	private JLabel allpics, title;
	
	/**
	 * Constructor of the JFrame.
	 */
	public FaceBooklet() {
		JFrame frame = new JFrame();
		frame.setTitle("FaceBooklet");
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		
		feed = new JTextField("Choose what you would like to do");
		feed.setEditable(false);
		
		// create buttons for main frame
		create = new JButton("Create a profile");
		create.addActionListener(this);
		
		add = new JButton("Add a friend");
		add.addActionListener(this);
		
		remove = new JButton("Remove a profile");
		remove.addActionListener(this);
		
		delete = new JButton("Unfriend a profile");
		delete.addActionListener(this);
		
		open = new JButton("Open saved FaceBooklet");
		open.addActionListener(this);
		
		save = new JButton("Save FaceBooklet");
		save.addActionListener(this);
		
		search = new JButton("Look up a profile");
		search.addActionListener(this);
		
		status = new JButton("Update status");
		status.addActionListener(this);
		
		picture = new JButton("Add picture");
		picture.addActionListener(this);
		
		seeAll = new JButton("See all users");
		seeAll.addActionListener(this);
		
		GridBagConstraints layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		frame.add(feed, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		frame.add(create, layoutConst);

		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		frame.add(remove, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 1;
		frame.add(add, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 3;
		layoutConst.gridy = 1;
		frame.add(delete, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 4;
		layoutConst.gridy = 1;
		frame.add(search, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		frame.add(status, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 2;
		frame.add(open, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 2;
		frame.add(save, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 3;
		layoutConst.gridy = 2;
		frame.add(picture, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 4;
		layoutConst.gridy = 2;
		frame.add(seeAll, layoutConst);
		
		//create a profile
		createProfile = new JPanel(new GridBagLayout());
		createProfile.setBackground(Color.BLUE);
		
		JLabel createname = new JLabel("Enter your name:");
		createprofile = new JTextField(20);
		createprofile.setEditable(true);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		createProfile.add(createname, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		createProfile.add(createprofile, layoutConst);
		
		create2 = new JButton("Create");
		create2.addActionListener(this);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		createProfile.add(create2, layoutConst);
	
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		frame.add(createProfile, layoutConst);
		createProfile.setVisible(false);
		
		//add a friend
		addFriend = new JPanel(new GridBagLayout());
		addFriend.setBackground(Color.blue);
		
		JLabel addname = new JLabel("Enter your name:");
		JLabel addfriend = new JLabel("Who would you like to add?");
		addprofile = new JTextField(20);
		addprofile.setEditable(true);
		budprofile = new JTextField(20);
		
		add2 = new JButton("Add friend");
		add2.addActionListener(this);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		addFriend.add(addname, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		addFriend.add(addfriend, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		addFriend.add(addprofile, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		addFriend.add(budprofile, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		layoutConst.insets = new Insets(10,10,10,10);
		addFriend.add(add2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		layoutConst.insets = new Insets(10,10,10,10);
		addFriend.setVisible(false);
		frame.add(addFriend, layoutConst);
		
		//remove profile panel
		removeProfile = new JPanel(new GridBagLayout());
		removeProfile.setBackground(Color.BLUE);
		
		remove2 = new JButton("Remove profile");
		remove2.addActionListener(this);
		
		JLabel removename = new JLabel("Enter your name:");
		oldprof = new JTextField(20);
		oldprof.setEditable(true);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		removeProfile.add(removename, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		removeProfile.add(oldprof, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 2;
		removeProfile.add(remove2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		frame.add(removeProfile, layoutConst);
		removeProfile.setVisible(false);
		
		//remove friend
		removeFriend = new JPanel(new GridBagLayout());
		removeFriend.setBackground(Color.BLUE);
				
		JLabel me = new JLabel("Enter your name:");
		JLabel bad = new JLabel("Who would you like to unfriend");
		person = new JTextField(20);
		badperson = new JTextField(20);
				
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		removeFriend.add(me, layoutConst);
				
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		removeFriend.add(person, layoutConst);
				
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		removeFriend.add(bad, layoutConst);
				
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		removeFriend.add(badperson, layoutConst);
				
		delete2 = new JButton("Delete friend");
		delete2.addActionListener(this);
				
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 2;
		removeFriend.add(delete2, layoutConst);
				
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		frame.add(removeFriend, layoutConst);
		removeFriend.setVisible(false);
		
		//see profile panel
		seeProfile = new JPanel(new GridBagLayout());
		seeProfile.setBackground(Color.BLUE);
		
		JLabel lookup = new JLabel("Who would you like to look up?");
		see = new JTextField(20);
		see.setEditable(true);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		seeProfile.add(lookup, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		seeProfile.add(see, layoutConst);
		
		search2 = new JButton("Search");
		search2.addActionListener(this);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		seeProfile.add(search2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		frame.add(seeProfile, layoutConst);
		seeProfile.setVisible(false);
				
		//status panel
		updateStatus = new JPanel(new GridBagLayout());
		updateStatus.setBackground(Color.BLUE);
		
		status2 = new JButton("Update");
		status2.addActionListener(this);
		
		JLabel user = new JLabel("Enter your name:");
		username = new JTextField(20);
		username.setEditable(true);
		JLabel updatestat = new JLabel("Enter your status:");
		statusProf = new JTextField(20);
		statusProf.setEditable(true);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		updateStatus.add(user, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		updateStatus.add(username, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		updateStatus.add(updatestat, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		updateStatus.add(statusProf, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 3;
		updateStatus.add(status2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		frame.add(updateStatus, layoutConst);
		updateStatus.setVisible(false);
		
		//save panel
		export = new JPanel();
		export.setBackground(Color.BLUE);
		
		JLabel save = new JLabel("Enter the name of the file you want to save to:");
		saveto = new JTextField(20);
		
		save2 = new JButton("Save file");
		save2.addActionListener(this);
		
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		export.add(save, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		export.add(saveto, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		export.add(save2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		frame.add(export, layoutConst);
		export.setVisible(false);
		
		//open file
		file = new JPanel();
		file.setBackground(Color.BLUE);
		
		JLabel open = new JLabel("Enter the name of the file you want to open:");
		openfrom = new JTextField(20);

		open2 = new JButton("Open file");
		open2.addActionListener(this);
	
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		file.add(open, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		file.add(openfrom, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		file.add(open2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 6;
		frame.add(file, layoutConst);
		file.setVisible(false);
		
		//profile picture
		profpic = new JPanel(new GridBagLayout());
		profpic.setBackground(Color.BLUE);
		
		JLabel prof = new JLabel("Enter your name:");
		pic = new JTextField(20);
		pic.setEditable(true);
		JLabel path = new JLabel("Enter your picture:");
		picAddress = new JTextField(20);
		picAddress.setEditable(true);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		profpic.add(prof, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		profpic.add(pic, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		profpic.add(path, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		profpic.add(picAddress, layoutConst);
		
		picture2 = new JButton("Make profile picture");
		picture2.addActionListener(this);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		profpic.add(picture2, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 5;
		frame.add(profpic, layoutConst);
		profpic.setVisible(false);
		
		
		//place for profile picture
		allpics = new JLabel();
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 2;
		layoutConst.gridy = 0;
		frame.add(allpics, layoutConst);
		
		//panel for friends pictures
		friendspics = new JPanel();
		friendspics.setLayout(new FlowLayout());
		title = new JLabel("Profile pictures of user's friends:");
		
		friendspics.add(title);
		
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 3;
		layoutConst.gridy = 0;
		frame.add(friendspics, layoutConst);
		friendspics.setVisible(false);
		
		
		frame.setSize(1350, 800);
		frame.setResizable(false);	
		frame.setVisible(true);
	}
	
	@Override
	/**
	 * Instructions for what happens when a button is clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			createProfile.setVisible(true);
		}
		if (e.getSource() == create2) {
			String name = createprofile.getText();
			friends.createProfile(name);
			feed.setText("A profile for " + name + " was created!");
			createprofile.setText("");
			createProfile.setVisible(false);
		}
		if (e.getSource() == add) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			addFriend.setVisible(true);
		}
		if (e.getSource() == add2) {
			String name = addprofile.getText();
			String bud = budprofile.getText();
			if (friends.lookUp(bud).equals("User found")) {
				friends.newFriend(name, bud);
				feed.setText(name + " is now friends with " + bud);
			}
			else {
				feed.setText(bud + " is not in the database.");
			}
			addprofile.setText("");
			budprofile.setText("");
			addFriend.setVisible(false);
		}
		if (e.getSource() == remove) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			removeProfile.setVisible(true);
		}
		if (e.getSource() == remove2) {
			String delete = oldprof.getText();
			friends.removeProfile(delete);
			feed.setText(delete + " was removed from the database.");
			oldprof.setText("");
			removeProfile.setVisible(false);
		}
		if (e.getSource() == delete) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			removeFriend.setVisible(true);
		}
		if (e.getSource() == delete2) {
			String good = person.getText();
			String bad = badperson.getText();
			friends.deleteFriend(good, bad);
			feed.setText(good + " is not friends with "
			+ bad);
			person.setText("");
			badperson.setText("");
			removeFriend.setVisible(false);
		}
		if (e.getSource() == search) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			seeProfile.setVisible(true);
		}
		if (e.getSource() == search2) {
			String stalk = see.getText();
			if (friends.lookUp(stalk).equals("User found")) {
				feed.setText(friends.getProfile(stalk));
				
				ImageIcon icon = new ImageIcon(friends.getPicture(stalk));
				Image image = icon.getImage(); // transform it to image
				Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				icon = new ImageIcon(newimg);  // transform it back
				allpics.setIcon(icon);
				
				for (int i=0; i<friends.allFriends(stalk).size(); i++) {
					FaceBookletProfile name = (FaceBookletProfile) friends.allFriends(stalk).get(i);
					String prof = name.getprofpic();
					JLabel fun = new JLabel();
					ImageIcon pic = new ImageIcon(prof);
					Image img = pic.getImage(); // transform it to image
					Image set = img.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					pic = new ImageIcon(set);  // transform it back
					fun.setIcon(pic);
					friendspics.add(fun);
				}
				friendspics.setVisible(true);
					
				
			}
			else {
				feed.setText(stalk + " is not on FaceBooklet.");
			}
			see.setText("");
			seeProfile.setVisible(false);
			
		}
		if (e.getSource() == status) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			updateStatus.setVisible(true);
		}
		if (e.getSource() == status2) {
			String user = username.getText();
			String words = statusProf.getText();
			friends.newStatus(user,  words);
			feed.setText(user + "'s status is now " + words);
			username.setText("");
			statusProf.setText("");
			updateStatus.setVisible(false);
		}
		if (e.getSource() == save) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			export.setVisible(true);
		}
		if (e.getSource() == save2) {
			String file2 = saveto.getText();
			friends.exportToFile(file2);
			feed.setText("FaceBooklet saved to " + file2);
			saveto.setText("");
			export.setVisible(false);
		}
		if (e.getSource() == open) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			file.setVisible(true);
		}
		if (e.getSource() == open2) {
			String file1 = openfrom.getText();
			friends.importFromFile(file1);
			feed.setText("FaceBooklet opened");
			openfrom.setText("");
			file.setVisible(false);
		}
		if (e.getSource() == picture) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			friendspics.add(title);
			profpic.setVisible(true);
		}
		if (e.getSource() == picture2) {
			String user = pic.getText();
			String address = picAddress.getText();
			
			friends.updatePicture(user, address);
			
			ImageIcon icon = new ImageIcon(address);
			Image image = icon.getImage(); // transform it to image
			Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			icon = new ImageIcon(newimg);  // transform it back
			
			allpics.setIcon(icon);
		
			feed.setText("This is " +  user + "'s picture");
			pic.setText("");
			picAddress.setText("");
			profpic.setVisible(false);
		}
		if (e.getSource() == seeAll) {
			allpics.setIcon(null);
			friendspics.setVisible(false);
			friendspics.removeAll();
			feed.setText(friends.seeAllUsers());
			
			
		}
		
		
	}
	
	
	public static void main(String [] args) {
		friends = new FaceBookletDataBase();
		FaceBooklet test = new FaceBooklet();
	}
}


