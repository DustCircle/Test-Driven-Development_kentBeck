public class Sum implements Expression {
    Expression augend;
    Expression addend;

    Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to){
        int amount = augend.reduce(bank,to).amount
                + addend.reduce(bank,to).amount;
        return new Money(amount, to);
    }

    public Expression plus(Expression addend) {
        return null;
    }

    public Expression times(int amout){
        return null;
    }

    Money reduce(Expression source, String to) {
        if(source instanceof Money)
            return (Money) source.reduce(null, to);
        Sum sum = (Sum) source;
        return sum.reduce(new Bank(), to);
    }
}
