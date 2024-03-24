package seedu.duke;

import seedu.duke.exceptions.FlirtForkException;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Duke {
    private static final String FILE_PATH = "./data/FlirtFork.txt";

    private static final String HORIZONTAL = "____________________________________________________________";
    private FavouritesList favourites;
    private FoodList foods;
    private ActivityList activities;
    private Ui ui;
    private Storage storage;
    private UserDetails userDetails;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            favourites = new FavouritesList(storage.loadFavourites());
            foods = new FoodList(storage.loadFood());
            activities = new ActivityList(storage.loadActivity());
            userDetails = storage.loadUserDetails();
        } catch (FileNotFoundException e) {
            ui.errorMessage("File not found. Starting with an empty task list :)");
            favourites = new FavouritesList(new ArrayList<>());
        }
    }

    public void run() {
        if (userDetails.getName().equals("NOT SET")) {
            ui.firstSetUpMessage();
            UserDetailsCommand userDetailsCommand = new UserDetailsCommand();
            userDetailsCommand.execute(favourites, foods, activities, ui, storage, userDetails);
        } else {
            ui.greetingMessage(userDetails.getAnniversary());
        }

        boolean isExit = false;
        while(!isExit) {
            String userInput = ui.readCommand();
            try {
                Command command = Parser.parseCommand(userInput, userDetails);
                command.execute(favourites, foods, activities, ui, storage, userDetails);
                if(command instanceof ExitCommand) {
                    isExit = true;
                }
                System.out.println(HORIZONTAL);
            } catch (FlirtForkException e) {
                ui.errorMessage(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Duke flirtFork = new Duke(FILE_PATH);
        flirtFork.run();
    }
}
