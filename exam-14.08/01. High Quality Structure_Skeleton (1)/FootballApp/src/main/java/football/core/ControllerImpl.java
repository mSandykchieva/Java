package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepositoryImpl supplement;
    private Collection<Field> fields;





    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }
    public SupplementRepository getSupplement() {
        return this.supplement;
    }

    public Collection<Field> getFields() {
        return this.fields;
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
            this.getFields().add(field);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
            this.getFields().add(field);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE,fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        if(type.equals("Powdered")){
            supplement=new Powdered();
            this.supplement.add(supplement);
        }else if(type.equals("Liquid")){
            supplement=new Liquid();
            this.supplement.add(supplement);
        } else{
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE,type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = this.getSupplement().findByType(supplementType);

        if(supplement==null){
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND,supplementType));
        }
        Field field = getFieldByName(fieldName);
        field.addSupplement(supplement);
        this.getSupplement().remove(supplement);
        return String.format("SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD",supplementType,fieldName);
    }

    private Field getFieldByName(String fieldName) {
        return this.getFields().stream().filter(field -> field.getName().equals(fieldName))
                .findFirst().get();
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        Field currentField=getFieldByName(fieldName);
        if(playerType.equals("Men")){
           player=new Men(playerName,nationality,strength) ;
           //currentField.addPlayer(player);
        }else if(playerType.equals("Women")){
            player=new Women(playerName,nationality,strength);
            //currentField.addPlayer(player);
        }else{
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        String output = "";

        if(currentField.getClass().getSimpleName().startsWith("Artificial") && player.getClass().getSimpleName().startsWith("Women")){
            currentField.addPlayer(player);
            output=String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType,fieldName);
        } else if (currentField.getClass().getSimpleName().startsWith("Natural") && player.getClass().getSimpleName().startsWith("Men")){
            currentField.addPlayer(player);
            output=String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType,fieldName);
        } else {
            return FIELD_NOT_SUITABLE;
        }

        return output;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = getFieldByName(fieldName);
        field.drag();

        return String.format(PLAYER_DRAG,field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String areaName) {
        Field field = getFieldByName(areaName);
        int value = 0;
        for (Player player:field.getPlayers()) {
            value+=player.getStrength();
        }
        return String.format(STRENGTH_FIELD,areaName,value);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (Field field:this.fields) {
            builder.append(field.getInfo());
            builder.append(System.lineSeparator());

        }
        return builder.toString();
    }
}
