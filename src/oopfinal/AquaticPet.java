package oopfinal;

public abstract class AquaticPet {
    public String behaviour;
    public String allergies;
    public String petOwner;
    public String petSpecies;

    // constructor
    public AquaticPet() {

    }

    // getter & setter

    public abstract void setPetOwner(String petOwner);

    public abstract void setPetSpecies(String petSpecies);

    public abstract String getPetOwner();

    public abstract String getPetSpecies();

}
