package oopfinal;

public abstract class AquaticPet {
    protected String behaviour;
    protected String allergies;
    String petOwner;
    String petSpecies;

    // constructor
    public AquaticPet() {

    }

    // getter & setter

    public abstract void setPetOwner(String petOwner);

    public abstract void setPetSpecies(String petSpecies);

    public abstract String getPetOwner();

    public abstract String getPetSpecies();

}
