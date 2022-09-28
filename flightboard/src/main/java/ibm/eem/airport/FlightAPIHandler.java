package ibm.eem.airport;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")

public class FlightAPIHandler {

    //private static final Jsonb jsonb = JsonbBuilder.create();
    private FlightManager fm = new FlightManager();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GET
    @Path("/flights")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlights() {
        try {
            System.out.println("Getting all flights");
            Map<String, Flight> flightsDB = fm.getAllFlights();
            Collection<Flight> flights = flightsDB.values();
            ArrayList flightsList = new ArrayList(flights);
            Collections.sort(flightsList);
            System.out.println("Returning flights="+flightsList);
            return Response.ok(flightsList, MediaType.APPLICATION_JSON).build();
        } catch (Exception e){
            e.printStackTrace(System.err);
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @PATCH
    @Path("/flight/{date}/{number}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delayFlight(@PathParam("date") String date, @PathParam("number") String number, Flight f) {

        try {
            System.out.println("Delaying flight " + number + " on date " + date + " by " + f.getDelay() + " minutes");
            fm.delayFlight(LocalDate.parse(date, dtf), number, f.getDelay());
            return Response.ok().build();
        } catch (DateTimeParseException e) {
            return Response.status(400).entity("Invalid date for flight").build();
        }catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

}
