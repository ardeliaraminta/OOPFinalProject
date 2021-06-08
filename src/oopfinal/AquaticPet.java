package oopfinal;

public abstract class AquaticPet implements PetDetails {
    protected String sickness;
    protected String behaviour;
    String petOwner;
    String petSpecies;

    // constructor
    public AquaticPet() {

    }

    //overloading
    public AquaticPet(String petOwner, String petSpecies) {
        this.petOwner = petOwner;
        this.petSpecies = petSpecies;
    }

    // getter & setter

    public abstract void setPetOwner(String petOwner);

    public abstract void setPetSpecies(String petSpecies);

    public abstract String getPetOwner();

    public abstract String getPetSpecies();

    public abstract void setBehaviour();

    public abstract void setSickness();
}
