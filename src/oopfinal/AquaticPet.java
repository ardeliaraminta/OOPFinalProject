package oopfinal;

public abstract class AquaticPet {
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
}
