package oopfinal;

public class AppointmentDetails implements PetDetails {

    private int id;
    private String petOwner;
    private String petSpecies;
    private String reasonOfVisit;
    private String dateTime;
    private String behaviour;
    private String allergies;


    public AppointmentDetails(){}
    public AppointmentDetails(int i, String own, String spec, String reason, String date){
        id = i;
        petOwner = own;
        petSpecies = spec;
        reasonOfVisit = reason;
        dateTime = date;

    }

//setters
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

    @Override
    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public String getBehaviour() {
        return behaviour;
    }

    @Override
    public void setAllergies(String allergies) {
        this.allergies = allergies;

    }

    @Override
    public String getAllergies() {
        return allergies;
    }
}


