package pera.trip_planner.controller.bean;

public class ViewTripBean {
    public final String tripname;

    public ViewTripBean(String tripname) {
        this.tripname = tripname;
    }

    public String getTripname() {
        return tripname;
    }
}
