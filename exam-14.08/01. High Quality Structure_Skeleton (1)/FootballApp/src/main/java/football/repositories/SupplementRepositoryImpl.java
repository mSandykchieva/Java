package football.repositories;

import football.entities.supplement.Supplement;

import java.util.Collection;

public class SupplementRepositoryImpl implements SupplementRepository{

    private Collection<Supplement> supplements;

    public SupplementRepositoryImpl() {

    }


    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    public void setSupplements(Collection<Supplement> supplements) {
        this.supplements = supplements;
    }

    public SupplementRepositoryImpl(Collection<Supplement> supplements) {
        this.supplements = supplements;
    }

    @Override
    public void add(Supplement supplement) {
        this.supplements.add(supplement);

    }

    @Override
    public boolean remove(Supplement supplement) {
        return supplements.remove(supplement);
    }

    @Override
    public Supplement findByType(String type) {
        return this.supplements.stream().filter(supplement->supplement.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
