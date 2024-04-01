package seedu.duke.commands;

import seedu.duke.Activity;
import seedu.duke.ActivityList;
import seedu.duke.Command;
import seedu.duke.FavouritesList;
import seedu.duke.Food;
import seedu.duke.FoodList;
import seedu.duke.GiftList;
import seedu.duke.Idea;
import seedu.duke.Storage;
import seedu.duke.Ui;
import seedu.duke.UserDetails;
import seedu.duke.exceptions.FlirtForkException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerateIdeaCommand extends Command {

    private static Logger logger = Logger.getLogger("IdeaLogger");

    @Override
    public void execute(FavouritesList favourites, FoodList foods, ActivityList activities, Ui ui,
                        Storage storage, UserDetails userDetails, GiftList gifts) throws FlirtForkException {
        String userSatisfied;

        Food food = foods.getRandomFood();
        Activity activity = activities.getRandomActivity();
        Idea idea = new Idea(food, activity);
        System.out.println(idea);

        System.out.println("Are you satisfied with the date idea? [Yes/No]");
        userSatisfied = ui.readCommand().toLowerCase();
        if (userSatisfied.equalsIgnoreCase("yes")) {
            System.out.println("That's great! Enjoy your date!");
            food.markComplete();
            activity.markComplete();
            storage.saveFood(foods);
            storage.saveActivity(activities);
            return;
        } else if (userSatisfied.equalsIgnoreCase("no")) {
            System.out.println("We apologise! Perhaps you could try again?");
        } else {
            ui.ideaSatisfiedErrorMessage();
            logger.log(Level.WARNING, "input error");
        }
    }
}
