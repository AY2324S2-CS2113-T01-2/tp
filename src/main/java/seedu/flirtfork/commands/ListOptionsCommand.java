package seedu.flirtfork.commands;

import seedu.flirtfork.ActivityList;
import seedu.flirtfork.Command;
import seedu.flirtfork.FavouritesList;
import seedu.flirtfork.FoodList;
import seedu.flirtfork.GiftList;
import seedu.flirtfork.Storage;
import seedu.flirtfork.Ui;
import seedu.flirtfork.UserDetails;
import seedu.flirtfork.exceptions.FlirtForkException;

import java.util.Scanner;

/**
 * Represents a command to list options of a specified type (food, activities, or gifts).
 */
public class ListOptionsCommand extends Command {
    private static final String HORIZONTAL = "____________________________________________________________";
    private String optionType;

    public ListOptionsCommand() {
    }

    /**
     * Executes the list options command based on the specified option type.
     *
     * @param favourites The list of favourites.
     * @param foods The list of foods.
     * @param activities The list of activities.
     * @param ui The user interface.
     * @param storage The storage component.
     * @param userDetails The user details.
     * @param gifts The list of gifts.
     * @throws FlirtForkException If an invalid option type is provided.
     */
    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities,
                        Ui ui, Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {

        Scanner scanner = new Scanner(System.in);
        String optionType;
        Ui.listCommand();

        while (true) {

            optionType = scanner.nextLine().toLowerCase();

            switch (optionType) {
            case "food":
                printFoodList(ui, foods);
                System.out.println(HORIZONTAL);
                System.out.println("To discover exciting activities, type 'activities'");
                System.out.println("To view a curated list of gifts, type 'gifts'");
                System.out.println("To cancel this command, type 'cancel'");
                break;
            case "activities":
                printActivityList(ui, activities);
                System.out.println(HORIZONTAL);
                System.out.println("To list out delicious dining options, type 'food'");
                System.out.println("To view a curated list of gifts, type 'gifts'");
                System.out.println("To cancel this command, type 'cancel'");
                break;
            case "gifts":
                printGiftList(ui, gifts);
                System.out.println(HORIZONTAL);
                System.out.println("To list out delicious dining options, type 'food'");
                System.out.println("To discover exciting activities, type 'activities'");
                System.out.println("To cancel this command, type 'cancel'");
                break;
            case "cancel":
                System.out.println("Cancelling listings... \n" +
                        "Cancel success!");
                return;
            default:
                System.out.println("Invalid option! Please choose 'food', 'activities', 'gifts' or 'cancel'.");
            }
        }
    }

    /**
     * Prints the list of food items.
     *
     * @param ui The user interface.
     * @param foods The list of foods to print.
     */
    private void printFoodList(Ui ui, FoodList foods) {
        ui.listFood();
        for (int i = 0; i < foods.size(); i++) {
            System.out.println(i + 1 + ". " + foods.get(i));
        }
    }

    /**
     * Prints the list of activities.
     *
     * @param ui The user interface.
     * @param activities The list of activities to print.
     */
    private void printActivityList(Ui ui, ActivityList activities) {
        ui.listActivities();
        for (int i = 0; i < activities.size(); i++) {
            System.out.println(i + 1 + ". " + activities.get(i));
        }
    }

    /**
     * Prints the list of gifts.
     *
     * @param ui The user interface.
     * @param gifts The list of gifts to print.
     */
    private void printGiftList(Ui ui, GiftList gifts) {
        ui.listGifts();
        for (int i = 0; i < gifts.size(); i++) {
            System.out.println(i + 1 + ". " + gifts.get(i));
        }
    }
}
