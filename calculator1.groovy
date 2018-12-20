class Calculator {
    double result
 
    void sum ( double a ) {
        result += a
    }

    void subs ( double a ) {
        result -= a
    }
}

def calculate ( Closure cl ) {
    def calc = new Calculator()
    def code = cl.rehydrate(calc, this, this)
    code.resolveStrategy = Closure.DELEGATE_ONLY
    code()
}

