public class Sum implements Expression {
    Money augend;
    Money addend;

    Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        int amount = augend.amount + addend.amount;
        return new Money (amount, to);
    }



    Money reduce(Expression source, String to) {
        if(source instanceof Money)
            return (Money) source.reduce(null, to);
        Sum sum = (Sum) source;
        return sum.reduce(new Bank(), to);
    }
}
