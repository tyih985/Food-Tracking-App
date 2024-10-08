package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// ListOfDishLog represents past dishes the user has logged.
// User's DishLogs are stored in ListOfDishLog as List<DishLog>.
public class ListOfDishLog implements Writable {
    private List<DishLog> listOfDishLog;

    // EFFECTS: Makes a new ListOfDishLog with given name and empty listOfDishLog
    public ListOfDishLog() {
        this.listOfDishLog = new ArrayList<>();
    }

    // MODIFIES: this, EventLog
    // EFFECTS: adds DishLog at end of listOfDishLog
    public void addDishLog(DishLog dishLog) {
        listOfDishLog.add(dishLog);
        EventLog.getInstance().logEvent(new Event(dishLog.getName() + ": added to list of Dish Logs."));
    }

    // REQUIRES: !listOfDishLog.isEmpty() and index in [0, listOfDishLog.size())
    // MODIFIES: this, EventLog
    // EFFECTS: removes DishLog at given index from listOfDishLog
    public void removeDishLog(int index) {
        DishLog removed = listOfDishLog.get(index);
        listOfDishLog.remove(index);
        EventLog.getInstance().logEvent(new Event(removed.getName() + ": removed from list of Dish Logs."));
    }

    // EFFECTS: returns List<DishLog> with DishLog(s) in listOfDishLog that contain given name (not case-sensitive)
    public List<DishLog> filterByName(String name) {
        List<DishLog> filteredListOfDishLog = new ArrayList<>();
        for (DishLog dishLog : listOfDishLog) {
            if (dishLog.getName().toLowerCase().contains(name.toLowerCase())) {
                filteredListOfDishLog.add(dishLog);
            }
        }
        return filteredListOfDishLog;
    }

    // EFFECTS: returns List<DishLog> with DishLog(s) in listOfDishLog that have given restaurant (not case-sensitive)
    public List<DishLog> filterByRestaurant(String restaurant) {
        List<DishLog> filteredListOfDishLog = new ArrayList<>();
        for (DishLog dishLog : listOfDishLog) {
            if (dishLog.getRestaurant().equalsIgnoreCase(restaurant)) {
                filteredListOfDishLog.add(dishLog);
            }
        }
        return filteredListOfDishLog;
    }

    // EFFECTS: returns List<DishLog> with DishLog(s) in listOfDishLog that have price in range [lower, upper]
    public List<DishLog> filterByPrice(double lowerBound, double upperBound) {
        List<DishLog> filteredListOfDishLog = new ArrayList<>();
        for (DishLog dishLog : listOfDishLog) {
            if (lowerBound <= dishLog.getPrice() && dishLog.getPrice() <= upperBound) {
                filteredListOfDishLog.add(dishLog);
            }
        }
        return filteredListOfDishLog;
    }

    // EFFECTS: returns List<DishLog> with DishLog(s) in listOfDishLog that have given enjoymentLevel
    public List<DishLog> filterByEnjoymentLevel(int enjoymentLevel) {
        List<DishLog> filteredListOfDishLog = new ArrayList<>();
        for (DishLog dishLog : listOfDishLog) {
            if (dishLog.getEnjoymentLevel() == enjoymentLevel) {
                filteredListOfDishLog.add(dishLog);
            }
        }
        return filteredListOfDishLog;
    }

    // EFFECTS: returns List<DishLog> with DishLog(s) in listOfDishLog that are favourites
    public List<DishLog> filterByFavourite() {
        List<DishLog> filteredListOfDishLog = new ArrayList<>();
        for (DishLog dishLog : listOfDishLog) {
            if (dishLog.getFavourite()) {
                filteredListOfDishLog.add(dishLog);
            }
        }
        return filteredListOfDishLog;
    }

    @Override
    // MODIFIES: EventLog
    // EFFECT: converts list of dish logs to json object and returns it
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("dish logs", dishLogsToJason());
        EventLog.getInstance().logEvent(new Event("Data saved to file."));
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray dishLogsToJason() {
        JSONArray jsonArray = new JSONArray();

        for (DishLog dl : listOfDishLog) {
            jsonArray.put(dl.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns DishLog in listOfDishLog at given index
    public DishLog getDishLog(int index) {
        return this.listOfDishLog.get(index);
    }

    // EFFECTS: returns true if listOfDishLog is empty
    public boolean isEmpty() {
        return this.listOfDishLog.isEmpty();
    }

    // EFFECTS: return listOfDishLog
    public List<DishLog> getListOfDishLog() {
        return listOfDishLog;
    }
}
