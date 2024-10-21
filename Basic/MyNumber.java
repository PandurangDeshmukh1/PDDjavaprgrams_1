class MyNumber {
    private int number;

    public MyNumber() {
        this.number = 0;
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public boolean isNegative() {
        return number < 0;
    }

    public boolean isPositive() {
        return number > 0;
    }

    public boolean isOdd() {
        return number % 2 != 0;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int value = Integer.parseInt(args[0]);
                MyNumber myNumber = new MyNumber(value);

                System.out.println("Number: " + value);
                System.out.println("Is Negative: " + myNumber.isNegative());
                System.out.println("Is Positive: " + myNumber.isPositive());
                System.out.println("Is Odd: " + myNumber.isOdd());
                System.out.println("Is Even: " + myNumber.isEven());
            } catch (NumberFormatException e) {
                System.out.println("Please provide a valid integer value.");
            }
        } else {
            System.out.println("Please provide a number as a command line argument.");
        }
    }
}
