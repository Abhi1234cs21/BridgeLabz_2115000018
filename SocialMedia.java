import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    UserNode next;

    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMedia {
    private UserNode head;

    public SocialMedia() {
        head = null;
    }

    public void addUser(int userID, String name, int age) {
        UserNode newUser = new UserNode(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    public void addFriendConnection(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            user1.friendIDs.add(userID2);
            user2.friendIDs.add(userID1);
        }
    }

    public void removeFriendConnection(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            user1.friendIDs.remove(Integer.valueOf(userID2));
            user2.friendIDs.remove(Integer.valueOf(userID1));
        }
    }

    public List<Integer> findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);

        List<Integer> mutualFriends = new ArrayList<>();

        if (user1 != null && user2 != null) {
            for (int friendID : user1.friendIDs) {
                if (user2.friendIDs.contains(friendID)) {
                    mutualFriends.add(friendID);
                }
            }
        }
        return mutualFriends;
    }

    public List<Integer> displayFriends(int userID) {
        UserNode user = findUserByID(userID);
        if (user != null) {
            return user.friendIDs;
        }
        return new ArrayList<>();
    }

    public UserNode findUserByID(int userID) {
        UserNode current = head;
        while (current != null) {
            if (current.userID == userID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public UserNode findUserByName(String name) {
        UserNode current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int countFriends(int userID) {
        UserNode user = findUserByID(userID);
        if (user != null) {
            return user.friendIDs.size();
        }
        return 0;
    }

    public void displayAllUsers() {
        UserNode current = head;
        while (current != null) {
            System.out.println("User ID: " + current.userID + ", Name: " + current.name + ", Age: " + current.age);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();

        socialMedia.addUser(1, "Alice", 25);
        socialMedia.addUser(2, "Bob", 30);
        socialMedia.addUser(3, "Charlie", 28);

        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(2, 3);

        System.out.println("Friends of Bob: " + socialMedia.displayFriends(2));
        System.out.println("Mutual friends between Alice and Bob: " + socialMedia.findMutualFriends(1, 2));

        socialMedia.removeFriendConnection(2, 3);
        System.out.println("Friends of Bob after removal: " + socialMedia.displayFriends(2));

        System.out.println("Count of Alice's friends: " + socialMedia.countFriends(1));
        System.out.println("Searching for user by Name (Bob): " + socialMedia.findUserByName("Bob"));
        System.out.println("Searching for user by ID (3): " + socialMedia.findUserByID(3));

        socialMedia.displayAllUsers();
    }
}
