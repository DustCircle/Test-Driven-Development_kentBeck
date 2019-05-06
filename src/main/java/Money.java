public class Money implements  Expression {

    protected int amount;
    protected String currency;

    Money(int amount, String currnecy){
        this.amount = amount;
        this.currency = currnecy;
    }

    public final Expression times(int multiplier){
        return new Money(amount * multiplier,currency);
    }

    public final boolean equals(Object object){
        Money money = (Money) object;
        return this.amount == money.amount &&
                currency().equals(money.currency());
    }

    public Expression plus(Expression addend){
        return new Sum (this, addend);
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.reduce(currency,to);
        return new Money(amount / rate, to);
    }

    public static final Money dollar(int amount){
        return new Money(amount,"USD");
    }

    public static final Money franc(int amount){
        return new Money(amount,"CHF");
    }

    public String currency(){
        return currency;
    }
}
