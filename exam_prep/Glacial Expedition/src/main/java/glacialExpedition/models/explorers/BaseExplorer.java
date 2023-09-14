package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;

import static glacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public abstract class BaseExplorer implements Explorer{


    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        setName(name);
        setEnergy(energy);
    }

    @Override
    public  void search(){
        if(this.energy<=15){
            this.energy=0;
        }else{
            this.energy-=15;
        }
    }
    protected void setName(String name){
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name=name;
    }

    private void setEnergy(double energy) {
        if(energy<0){
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy=energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public  boolean canSearch(){
        if(energy>0){
            return true;
        }
        return false;
    }

    @Override
    public Suitcase getSuitcase() {
        return null;
    }


}
