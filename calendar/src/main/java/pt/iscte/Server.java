package pt.iscte;

import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

/**
 * The server class is responsible for handling requests from the front end.
 * The requests are mainly Event requests.
 *
 * @author Jose Soares
 */
public class Server {
    //TODO: can passing personal calendars be optimized?
    private List<PersonalCalendar> personalCalendarObjects = new ArrayList<PersonalCalendar>();

    public Server(List<PersonalCalendar> personalCalendars) {
        this.personalCalendarObjects = personalCalendars;
        staticFiles.location("/calendarWeb");
        setupEndpoints();
    }


    public Object getEventsByDay(Request req, Response res) {
        /*
        TODO: make sure there is a specific format for the requested day
        TODO: Make if-elses with error responses the format is wrong
        TODO: Get the calendar of a SPECIFIED user, by passing ID in params or any other way
        */

        return personalCalendarObjects.get(0).getEvents();
    }

    public void setupEndpoints() {
        System.out.println("[Server] setting up routes");

        get("/", (req, res) -> {
            res.redirect("/Site.html");
            return null;
        });

        get("/getEvents/:userId/:year/:month/:day", this::getEventsByDay);
    }

}
