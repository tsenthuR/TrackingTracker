package com.example.kisho.trackingtracker.admin;

public class BookingItems {
    private final String numberofBikes,startdate,enddate,Nic;

    public String getNumberofBikes() {
        return numberofBikes;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getNic() {
        return Nic;
    }

    public BookingItems(String numberofBikes, String startdate, String enddate, String nic) {
        this.numberofBikes = numberofBikes;
        this.startdate = startdate;
        this.enddate = enddate;
        Nic = nic;
    }
}
