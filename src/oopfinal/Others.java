package oopfinal;

public class Others extends AquaticPet implements PetDetails  {

    String petName;
    int petAge;

    public Others(){

    };

    // construct Others
    public Others(String petName, int petAge, String pOwner, String pSpec ){
        super.petOwner = pOwner;
        super.petSpecies = pSpec;
        this.petName = petName;
        this.petAge = petAge;

    }

    public void setPetName(String petName){
        this.petName = petName;
    }

    public void setPetAge(int petAge){
        this.petAge = petAge;
    }

    public String getPetName(){
        return petName;
    }

    public int getPetAge(){
        return petAge;
    }

    @Override
    public void setPetOwner(String petOwner) {
        this.petOwner = petOwner;

    }

    @Override
    public void setPetSpecies(String petSpecies) {
        this.petSpecies = petSpecies;

    }

    @Override
    public String getPetOwner() {
        return petOwner;
    }

    @Override
    public String getPetSpecies() {
        return petSpecies;
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
