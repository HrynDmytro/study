//0.2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //create a counter to control registered users
        int count = 0;

        //ask what size to create an array of User class and create it
        System.out.println("list size for accounts:");
        int listValue = Integer.parseInt(reader.readLine());
        User[] usersList = new User[listValue];

        //we offer to add 5 users to test the functionality of the program
        System.out.println("Add five users to the database for testing the program? y/n");
        if (reader.readLine().equals("y")) count = count + addFiveUsers(usersList, count);
        System.out.println(" / test count = " + count); // test

        //create a while cycle for the main admin menu
        boolean menu = true;
        while (menu) {
            switch (manipulationCapabilities(reader)){
                case 1:
                    System.out.println("Most adult: ");
                    System.out.println("index: " + getMostAdult(usersList, count));
                    userDateDisplay(usersList, getMostAdult(usersList, count));

                    break;
                case 2:
                    System.out.println("Most Highest: ");
                    System.out.println("index: " + getHighest(usersList, count));
                    userDateDisplay(usersList, getHighest(usersList, count));
                    System.out.println("Most Heaviest: ");
                    System.out.println("index: " + getHeaviest(usersList, count));
                    userDateDisplay(usersList, getHeaviest(usersList, count));
                    break;
                case 3:
                    System.out.println("array size: " + usersList.length);
                    System.out.println("registered users: " + count);
                    System.out.println("enter index: ");
                    userDateDisplay(usersList, Integer.parseInt(reader.readLine()));
                    break;
                case 4:
                    usersList[count] = createNewUser(reader);
                    userDateDisplay(usersList, count);
                    count++;
                    System.out.println(" / test count = " + count); // test
                    break;
                case 5:
                    System.out.println("Ciao!");
                    menu = false;
            }
        }

    }

    //method for displaying the main menu on the screen
    public static int manipulationCapabilities (BufferedReader reader) throws IOException {
        System.out.println("Database manipulation capabilities:");
        System.out.println("1" + "\t" + "Display the most adult user."+"\n"
                + "2" + "\t" + "Display the highest and heaviest users " + "\n"
                + "3" + "\t" + "Displaying user data by index on the screen" + "\n"
                + "4" + "\t" + "Add new user" + "\n"
                + "5" + "\t" + "EXIT" + "\n");
        int n = Integer.parseInt(reader.readLine());
        switch (n){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            default:
                return 6;
        }

    }

    //method for creating new user and manual data entry from the keyboard (using setters)
    public static User createNewUser (BufferedReader reader) throws IOException {
        User newUser = new User();
        System.out.println("New User Registration");
        System.out.println("Enter your name:");
        newUser.setName(reader.readLine());
        System.out.println("Enter your last name:");
        newUser.setLastName(reader.readLine());
        System.out.println("Enter your enter your city of residence:");
        newUser.setCityResidence(reader.readLine());
        System.out.println("Enter your age: ");
        newUser.setAge(Integer.parseInt(reader.readLine()));
        System.out.println("Enter height in centimeters");
        newUser.setHeight(Integer.parseInt(reader.readLine()));
        System.out.println("Enter full kilogram weight");
        newUser.setWeight(Integer.parseInt(reader.readLine()));
        System.out.println("Registration is completed!");
        return newUser;
    }

    //method for displaying user data by index on the screen
    public static void userDateDisplay (User[] usersList,int index) {
        System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + usersList[index].getName() + " " + usersList[index].getLastName() + "\n"
                + "City of residence: " + "\t" + usersList[index].getCityResidence() + "\n"
                + "Age: " + "\t" + "\t" + "\t" + "\t" + usersList[index].getAge() + "\n"
                + "Height: " + "\t" + "\t" + "\t" + usersList[index].getHeight() + "\n"
                + "Weight: " + "\t" + "\t" + "\t" + usersList[index].getWeight()+ "\n");
    }

    //method for displaying most adult user on the screen
    public static int getMostAdult(User[] usersList, int count) {
        int cont = 0;
        int index = 0;

        for (int i = 0; i < count; i++) {
            if (usersList[i].getAge() > cont) {
                index = i;
                cont = usersList[i].getAge();
            }
        }
        return index;
    }

    //method for displaying heaviest user on the screen
    public static int getHeaviest(User[] usersList, int count) {
        int cont = 0;
        int index = 0;

        for (int i = 0; i < count; i++) {
            if (usersList[i].getWeight() > cont) {
                index = i;
                cont = usersList[i].getWeight();
            }
        }
        return index;
    }

    //method for displaying heaviest user on the screen
    public static int getHighest(User[] usersList, int count) {
        int cont = 0;
        int index = 0;

        for (int i = 0; i < count; i++) {
            if (usersList[i].getHeight() > cont) {
                index = i;
                cont = usersList[i].getHeight();
            }
        }
        return index;
    }
    //method for automatically add 5 users an array
    public static int addFiveUsers (User usersList[], int count) {
        int methodCount = count;

        User u1 = new User("Andrea", "Alonso", "Bologna", 46, 178, 79);
        usersList[methodCount] = u1;
        userDateDisplay(usersList, methodCount);
        methodCount++;

        User u2 = new User("Eduardo", "Notte", "Milano", 18, 160, 107);
        usersList[methodCount] = u2;
        userDateDisplay(usersList, methodCount);
        methodCount++;

        User u3 = new User("Andrea", "Alonso", "Bologna", 46, 176, 58);
        usersList[methodCount] = u3;
        userDateDisplay(usersList, methodCount);
        methodCount++;

        User u4 = new User("Anna", "Kuila", "Milano", 45, 169, 52);
        usersList[methodCount] = u4;
        userDateDisplay(usersList, methodCount);
        methodCount++;

        User u5 = new User("Eleonora", "Pante", "Breshia", 79, 162, 54);
        usersList[methodCount] = u5;
        userDateDisplay(usersList, methodCount);
        methodCount++;

        return methodCount;
    }
}

// create a class for creating constructors
class User {
    private String name;
    private String lastName;
    private String cityResidence;
    private int age;
    private int height;
    private int weight;

    public User(String name, String lastName, String cityResidence, int age, int height, int weight) {
        this.name = name;
        this.lastName = lastName;
        this.cityResidence = cityResidence;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public User(){

    }

    //create setters and getters for the possibility of manipulating user object data
    public String getName() {return name;}
    public String getLastName() {return lastName;}
    public String getCityResidence() {return cityResidence;}
    public int getAge() {return age;}
    public int getHeight() {return height;}
    public int getWeight() {return weight;}

    public void setName(String name) {this.name = name;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setCityResidence(String cityResidence) {this.cityResidence = cityResidence;}
    public void setAge(int age) {this.age = age;}
    public void setHeight(int height) {this.height = height;}
    public void setWeight(int weight) {this.weight = weight;}
}
