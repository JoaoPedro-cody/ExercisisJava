package exercise07.ent;

public class Individual extends Payers {
    private Double healthExpend;

    public Individual() {
        super();
    }

    public Individual(String name, Double anualIncome, Double healthExpend) {
        super(name, anualIncome);
        this.healthExpend = healthExpend;
    }

    public Double getHealthExpend() {
        return healthExpend;
    }

    public void setHealthExpend(Double healthExpend) {
        this.healthExpend = healthExpend;
    }

    @Override
    public double tax() {
        double taxes = 0.0;

        if (getAnualIncome() > 20000.00){
            return getAnualIncome() * 0.25 - healthExpend * 0.5;
        }else {
            return getAnualIncome() * 0.15 - healthExpend * 0.5;
        }
    }
}
