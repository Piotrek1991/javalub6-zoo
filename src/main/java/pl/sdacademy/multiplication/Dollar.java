package pl.sdacademy.multiplication;

public class Dollar {
    private int amount;

    public Dollar( int amount){
        this.amount = amount;
    }

    public Dollar times(int multiplayer){
        return new Dollar(amount * multiplayer);
    }

    public boolean equals(Object object){
        Dollar dollar = (Dollar) object;
        return amount == dollar.amount;
    }

}
