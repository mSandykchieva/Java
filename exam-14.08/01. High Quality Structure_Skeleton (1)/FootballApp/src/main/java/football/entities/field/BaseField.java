package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public BaseField(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        int sum = 0;
        for (Supplement supplement : this.getSupplement()) {
            sum += supplement.getEnergy();
        }
        return sum;
    }

    @Override
    public void addPlayer(Player player) {
        if (capacity > this.getPlayers().size()) {
            this.getPlayers().add(player);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removePlayer(Player player) {
        if (this.getPlayers().contains(player.getName())) {
            this.getPlayers().remove(player);
        }
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.getSupplement().add(supplement);

    }

    @Override
    public void drag() {
        for (Player player : this.getPlayers()) {
            player.stimulation();
        }

    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%s (%s):%n", this.getName(), this.getClass().getSimpleName()));
        builder.append("Player: ");
        if (this.getPlayers().isEmpty()) {
            builder.append("none");
        } else {

            builder.append(this.getPlayers().stream().map(Player::getName).collect(Collectors.joining(" ")).trim());
            builder.append(System.lineSeparator());
            builder.append(String.format("Supplement: %d%n", this.getSupplement().size()));
            builder.append(String.format("Energy: %d", sumEnergy()));
        }
        return builder.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
