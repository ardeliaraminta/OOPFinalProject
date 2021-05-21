package oopfinal;

public class AppointmentDetails {

    private int id;
    private String petOwner;
    private String petSpecies;
    private String reasonOfVisit;
    private String dateTime;



    public AppointmentDetails(){}
    public AppointmentDetails(int i, String own, String spec, String reason, String date){
        id = i;
        petOwner = own;
        petSpecies = spec;
        reasonOfVisit = reason;
        dateTime = date;

    }

//setters
    public void setId(int i){
        id = i;
    }

    public void setPetOwner(String own){
        petOwner = own;
    }
    public void setPetSpecies(String spec){
        petSpecies = spec;

    }
    public void setReasonOfVisit(String reason){
        reasonOfVisit = reason;

    }

    public void setDateTime(String date){
        dateTime = date;
    }

    public int getId(){
        return id;
    }

    public String getPetOwner(){
        return petOwner;
    }

    public String getPetSpecies(){
        return petSpecies;
    }

    public String getReasonOfVisit(){
        return reasonOfVisit;
    }

    public String getDateTime(){
        return dateTime;
    }
}


