package seedu.flirtfork;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Handles all user interfaces for FlirtFork, providing methods to display messages,
 * read user commands, and show lists of options like food, activities, and gifts.
 */
public class Ui {
    private static final String BOT_NAME = "Flirt and Fork";
    private static final String HORIZONTAL = "____________________________________________________________";
    private Scanner scanner;

    /**
     * Constructs a Ui object with a new Scanner for reading user input from the console.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays a greeting message to the user, optionally including the anniversary date if available.
     *
     * @param anniversary The user's anniversary date or "N.A" if not provided.
     */
    public void greetingMessage(String anniversary) {
        System.out.println(HORIZONTAL);
        System.out.println("Hungry for love? You've come to the right place.\n" +
                "Welcome to " + BOT_NAME + " - where Cupid meets the chef!\n\n" +
                "If you ever feel lost, just type 'help' for a guiding star!");
        if (!anniversary.equals("N.A")) {
            System.out.println("\nRemember, your anniversary is on " + anniversary + " :)");
        }
        System.out.println(HORIZONTAL);
    }

    /**
     * Displays a first setup message to the user when starting the application for the first time.
     */
    public void firstSetUpMessage() {
        System.out.println(HORIZONTAL);
        System.out.println("Hungry for love? You've come to the right place.\n" +
                "Welcome to " + BOT_NAME + " - where Cupid meets the chef!");
        System.out.println("Before we start, I would like to know you better!");
        System.out.println(HORIZONTAL);
    }

    /**
     * Displays an exit message to the user when they choose to terminate the application.
     */
    public void exitMessage() {
        System.out.println("Love, like a good meal, is all about timing.\n" +
                "Keep your love simmering and your fork ready, " +
                "see you at the next course!");
    }

    /**
     * Displays the help message with a list of available commands and their functions.
     */
    public void helpMessage() {
        System.out.println(
            "----------------------------------------- \n" +
            "| Command to type | Function of feature | \n" +
            "----------------------------------------- \n" +
            "1. list: Take a look at potential restaurants, activities, or gifts \n\n" +
            "2. me: Let me know more about yourself \n\n" +
            "3. idea: Generate a randomised date idea \n\n" +
            "4. itinerary LOCATION, PRICE: Generate a suitable date itinerary based on your preferences \n\n" +
            "5. smart: Generate a smart itinerary, based on your user profile \n\n" +
            "6. gift: Generate a randomised gift idea \n\n" +
            "7. food NAME_OF_EATERY, LOCATION, PRICE, CUISINE: Add a restaurant to your favourites \n\n" +
            "8. activity NAME_OF_ACTIVITY, LOCATION, PRICE: Add an activity to your favourites \n\n" +
            "9. favourites: List out all your favourites \n\n" +
            "10. delete INDEX_OF_ENTRY: Delete an entry from your favourites \n\n" +
            "11. find KEYWORD: Find an entry from your favourites, based off keyword \n\n" +
            "12. history: List out all your past date locations and restaurants \n\n" +
            "13. exit: Exit the program \n\n" +

            "LEGEND (prices):\n" +
            "C: Cheap\n" +
            "B: Budget\n" +
            "A: Affordable\n" +
            "P: Pricey\n" +
            "S: Special Ocassions Only\n\n" +

            "LEGEND (cuisines):\n" +
            "W: Western\n" +
            "F: Fusion\n" +
            "J: Japanese\n" +
            "C: Chinese\n" +
            "T: Thai\n" +
            "K: Korean\n" +
            "I: Italian\n" +
            "S: Spanish\n\n" +

            "LEGEND (locations):\n" +
            "E: East\n" +
            "W: West\n" +
            "C: Central\n" +
            "S: South\n" +
            "NE: NorthEast\n" +
            "ACC: Accessible (found in multiple places around SG)"
        );
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to be displayed.
     */
    public void errorMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads the user's command input.
     *
     * @return The user's command input as a String.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays a single favourite item.
     *
     * @param favourite The favourite item to be displayed.
     */
    public void showFavourite(String favourite) {
        System.out.println(favourite);
    }

    /**
     * Lists all favourites in a formatted manner.
     *
     * @param favouritesList The list of favourites to be displayed.
     */
    public void listFavourites(FavouritesList favouritesList) {
        System.out.println("Drumroll, please! Presenting the stars of your romantic sky: ");
        System.out.println(favouritesList.getFormattedFavourites());
    }

    /**
     * Displays the search results for user's favourite items based on the given keyword.
     * If matches are found, it lists all the matching favourites.
     * Otherwise, it prompts the user to try another search term.
     *
     * @param matchingFavourites A list of Favourites entries that match the search keyword.
     */
    public void showMatchingFavourites(ArrayList<Favourites> matchingFavourites) {
        if (matchingFavourites.isEmpty()) {
            System.out.println("No treasures found this time. Let's try another clue?");
        } else {
            System.out.println("Eureka! Your cupid's arrow hit the target! We found these matches for you:");
            for (int i = 0; i < matchingFavourites.size(); i++) {
                System.out.println((i + 1) + ". " + matchingFavourites.get(i));
            }
        }
    }

    /**
     * Displays the search results for food items based on the given keyword.
     * If matches are found, it lists all the matching foods.
     * Otherwise, it prompts the user to try another search term.
     *
     * @param matchingFoods A list of Food entries that match the search keyword.
     */
    public void showMatchingFoods(ArrayList<Food> matchingFoods) {
        if (matchingFoods.isEmpty()) {
            System.out.println("No food found this time:( Let's try another clue?");
        } else {
            System.out.println("Eureka! Your cupid's arrow hit the target! We found these matches for you:");
            for (int i = 0; i < matchingFoods.size(); i++) {
                System.out.println((i + 1) + ". " + matchingFoods.get(i));
            }
        }
    }

    /**
     * Displays the search results for activities items based on the given keyword.
     * If matches are found, it lists all the matching activities.
     * Otherwise, it prompts the user to try another search term.
     *
     * @param matchingActivities A list of Activity entries that match the search keyword.
     */
    public void showMatchingActivities(ArrayList<Activity> matchingActivities) {
        if (matchingActivities.isEmpty()) {
            System.out.println("No activity found this time:( Let's try another clue?");
        } else {
            System.out.println("Eureka! Your cupid's arrow hit the target! We found these matches for you:");
            for (int i = 0; i < matchingActivities.size(); i++) {
                System.out.println((i + 1) + ". " + matchingActivities.get(i));
            }
        }
    }

    /**
     * Displays the search results for gift items based on the given keyword.
     * If matches are found, it lists all the matching gifts.
     * Otherwise, it prompts the user to try another search term.
     *
     * @param matchingGifts A list of Gift entries that match the search keyword.
     */
    public void showMatchingGifts(ArrayList<Gift> matchingGifts) {
        if (matchingGifts.isEmpty()) {
            System.out.println("No gifts found this time:( Let's try another clue?");
        } else {
            System.out.println("Eureka! Your cupid's arrow hit the target! We found these matches for you:");
            for (int i = 0; i < matchingGifts.size(); i++) {
                System.out.println((i + 1) + ". " + matchingGifts.get(i));
            }
        }
    }

    public static void listFood() {
        System.out.println("HMMMM Let's see what food is theree: ");
    }

    public static void listActivities() {
        System.out.println("What are some activities you can do as a couple? Let's see.." );
    }

    public static void listGifts() {
        System.out.println("Peek into Cupid's own gift collection!" );
    }

    /**
     * Displays the list command menu to the user, providing options for listing foods,
     * activities, and gifts, or cancelling the command.
     */
    public static void listCommand() {
        System.out.println("Looking for ideas to spice up your date night?");
        System.out.println("Choose from the following options:");
        System.out.println("1. List out delicious dining options (type 'food')");
        System.out.println("2. Discover exciting activities to do together (type 'activities')");
        System.out.println("3. Unwrap joy with our curated list of gifts that'll make hearts flutter! (type 'gifts')");
        System.out.println("4. Changed your mind? Feel free to cancel this command! (type 'cancel')");
        System.out.println("What's your pleasure?");
        System.out.println(HORIZONTAL);
    }

    public static void findCommand(){
        System.out.println("What are you searching for in this enchanting realm?");
        System.out.println("Choose from the following options:");
        System.out.println("1. What delicious food are you craving for today? (type 'food')");
        System.out.println("2. What exciting activity are you interested in? (type 'activities')");
        System.out.println("3. On the hunt for the perfect gift? What are you looking for? (type 'gifts')");
        System.out.println("4. Finding within your own treasures? (type 'favourites')");
        System.out.println("5. Changed your mind? Feel free to cancel this command! (type 'cancel')");
        System.out.println("What's on your mind?");
        System.out.println(HORIZONTAL);
    }

    public void ideaSatisfiedErrorMessage() {
        System.out.println("Sorry, I didn't quite understand that :(");
        System.out.println("Please enter either yes or no or cancel the generation process");
    }

    /**
     * Displays a general message to the user.
     *
     * @param message The message to be displayed.
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads and validates the user's location input.
     *
     * @return The user's validated location input (E, W, C, S, or NE).
     */
    public String readUserLocation() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("E") || input.equals("W") || input.equals("C")
                || input.equals("S") || input.equals("NE");

        while (!isValid) {
            showMessage("Invalid location, please enter E, W, C, S or NE.");
            input = readCommand();
            isValid = input.equals("E") || input.equals("W") || input.equals("C")
                    || input.equals("S") || input.equals("NE");
        }
        return input;
    }

    /**
     * Reads and validates the user's age input.
     *
     * @return The user's validated age input as a String.
     */
    public String readAge() {
        int age;
        while (true) {
            try {
                String input = readCommand();
                age = Integer.parseInt(input);
                if (age <= 0) {
                    showMessage("Age cannot be negative or zero. Please enter a valid age.");
                } else if (age >= 120) {
                    showMessage("I don't think you're older than the oldest person alive...re-enter your age!");
                } else {
                    return input; // Valid age
                }
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid integer age.");
            }
        }
    }

    /**
     * Reads and validates the user's name input, ensuring it's not empty and doesn't contain numbers.
     *
     * @return The user's validated name input as a String.
     */
    public String readName() {
        while (true) {
            String name = readCommand();
            if (name.trim().isEmpty()) {
                showMessage("Name cannot be empty. Please enter a valid name.");
            } else if (name.matches(".*\\d+.*")) {
                showMessage("Name cannot contain numbers. Please re-enter without numbers.");
            } else {
                return name;
            }
        }
    }

    /**
     * Reads and validates the user's cuisine preference input.
     *
     * @return The user's validated cuisine preference input (W, F, J, C, T, K, I, or S).
     */
    public String readUserCuisine() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("W") || input.equals("F") || input.equals("J") || input.equals("C")
                || input.equals("T") ||input.equals("K") || input.equals("I") || input.equals("S");

        while (!isValid) {
            showMessage("Please enter your preferences in this format.\n");
            showMessage("W: Western");
            showMessage("F: Fusion");
            showMessage("J: Japanese");
            showMessage("C: Chinese");
            showMessage("T: Thai");
            showMessage("K: Korean");
            showMessage("I: Italian");
            showMessage("S: Spanish");
            input = readCommand();
            isValid = input.equals("W") || input.equals("F") || input.equals("J") || input.equals("C")
                    || input.equals("T") ||input.equals("K") || input.equals("I") || input.equals("S");
        }
        return input;
    }

    /**
     * Reads and validates the user's relationship status input.
     *
     * @return The user's validated relationship status input (M, R, F, D, S, or X).
     */
    public String readUserStatus() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("M") || input.equals("R") || input.equals("F")
                || input.equals("D") || input.equals("S") ||input.equals("X");

        while(!isValid) {
            showMessage("Please enter your status in this format.\n");
            showMessage("Enter 'M' if you are Married");
            showMessage("Enter 'R' if you are in a serious relationship");
            showMessage("Enter 'F' if you are having a fling");
            showMessage("Enter 'D' if you are dating/testing the waters");
            showMessage("Enter 'S' if you are single and ready to mingle");
            showMessage("Enter 'X' if you are single and only looking to hangout with friends");
            input = readCommand();
            isValid = input.equals("M") || input.equals("R") || input.equals("F")
                    || input.equals("D") || input.equals("S") ||input.equals("X");
        }
        return input;
    }

    /**
     * Reads and validates the user's gender input.
     *
     * @return The user's validated gender input (Male, Female, or Other).
     */
    public String readUserGender() {
        String input = readCommand();
        boolean isValid;

        isValid = input.equals("Male") || input.equals("Female") || input.equals("Other");

        while(!isValid) {
            showMessage("Please enter your gender in this format strictly. Please adhere to the capitalisation\n");
            showMessage("'Male' if you are a male");
            showMessage("'Female' if you are a female");
            showMessage("'Other' if its none of the above");

            input = readCommand();
            isValid = input.equals("Male") || input.equals("Female") || input.equals("Other");
        }
        return input;
    }

    /**
     * Reads and validates the user's anniversary date input.
     * The date must be in this format: dd/mm/yyyy
     *
     * @return The user's validated anniversary date input (String).
     */
    public String readAnniversaryDate() {
        String input = readCommand();
        while (!isValidDate(input)) {
            input = readCommand();
        }
        return input;
    }

    /**
     * Checks if the given input string represents a valid date in the format 'dd/mm/yyyy'.
     *
     * @param input The input string to be validated as a date.
     * @return true if the input string represents a valid date, false otherwise.
     */
    public boolean isValidDate(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date inputDate = dateFormat.parse(input);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1; // Calendar.MONTH is zero-based
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            if (!isDateInRange(day, month, year)) {
                showMessage("The day and month entered do not correspond to a valid date.");
                return false;
            }

            Date currentDate = new Date();
            if (inputDate.after(currentDate)) {
                showMessage("Do note that the date cannot be later than the current date!");
                return false;
            }
            return true;
        } catch (ParseException e) {
            showMessage("Please enter a valid date in dd/mm/yyyy format.");
            return false;
        }
    }

    /**
     * Checks if the given year, month, and day constitute a valid date.
     *
     * @param day   The day to be checked.
     * @param month The month to be checked (1-12).
     * @param year  The year to be checked.
     * @return true if the date is valid, false otherwise.
     */
    public boolean isDateInRange(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonths = { 31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        return day >= 1 && day <= daysInMonths[month - 1];
    }

    /**
     * Determines whether the given year is a leap year.
     *
     * @param year The year to be checked.
     * @return true if the year is a leap year, false otherwise.
     */
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}
