/**
 * Class FacebookCircles: calculates the statistics about the friendship circles in facebook data.
 *
 * @author Patrick O'Boyle
 *
 * @version 01/12/15 02:03:28
 */
public class FacebookCircles {
    // Declare arrays
    int[] users;
    int[] size;

    // Declare largest circle & number of users
    int largestCircle;
    int numUsers;

    /**
     * Constructor
     * @param numberOfFacebookUsers : the number of users in the sample data.
     * Each user will be represented with an integer id from 0 to numberOfFacebookUsers-1.
     */
    public FacebookCircles(int numberOfFacebookUsers) {
        numUsers = numberOfFacebookUsers;
        // Initialise the largest circle to 1, as all circles are of size 1 initially
        largestCircle = 1;

        // Initialise each array to the number of facebook users passed
        users = new int[numberOfFacebookUsers];
        size = new int[numberOfFacebookUsers];

        // Set each array value of the user as their ID (users) or size of circles (size)
        for(int i = 0; i < numberOfFacebookUsers; i++){
            users[i] = i;
            size[i] = 1;
        }
    }

    /**
     * creates a friendship connection between two users, represented by their corresponding integer ids.
     * @param user1 : int id of first user
     * @param user2 : int id of second  user
     */
    public void friends( int user1, int user2 ) {
        int i = find(user1);
        int j = find(user2);

        if (i == j){
            //TODO replace this with better stuff

        } else if (size[i] < size[j]) {
            users[i] = j;
            size[j] += size[i];
            if(size[j] > largestCircle){
                largestCircle = size[j];
            }
        } else {
            users[j] = i;
            size[i] += size[j];

            if(size[i] > largestCircle){
                largestCircle = size[i];
            }
        }
    }

    private int find(int user){
        while (user != users[user]) {
            users[user] = users[users[user]];
            user = users[user];
        }

        return user;
    }

    /**
     * @return the number of friend circles in the data already loaded.
     */
    public int numberOfCircles() {
        int numOfCircles = 0;
        for(int i = 0; i < numUsers; i++){
            if(users[i] == i){
                numOfCircles++;
            }
        }

        return numOfCircles;
    }

    /**
     * @return the size of the largest circle in the data already loaded.
     */
    public int sizeOfLargestCircle() {
        return largestCircle;
    }

    /**
     * @return the size of the median circle in the data already loaded.
     */
    public int sizeOfAverageCircle() {
        int numOfCircles = 0;
        int totalSize = 0;
        for(int i = 0; i < numUsers; i++){
            if(users[i] == i){
                numOfCircles++;
                totalSize += size[i];
            }
        }

        return totalSize/numOfCircles;
    }

    /**
     * @return the size of the smallest circle in the data already loaded.
     */
    public int sizeOfSmallestCircle() {
        int smallestCircle = numUsers;
        for(int i = 0; i < numUsers; i++){
            if(users[i] == i) {
                if (size[i] < smallestCircle) {
                    smallestCircle = size[i];
                }
            }
        }

        return smallestCircle;
    }
}