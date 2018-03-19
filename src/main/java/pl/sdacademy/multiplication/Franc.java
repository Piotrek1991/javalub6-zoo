package pl.sdacademy.multiplication;

public class Franc {

    private int amount;

    public Franc(int amount){
        this.amount = amount;
    }

    public Franc times(int multiplayer){
        return new Franc(amount * multiplayer);
    }

    public boolean equals(Object object){
        Franc franc = (Franc) object;
        return amount == franc.amount;
    }

}

