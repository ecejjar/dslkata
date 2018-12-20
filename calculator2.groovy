class Memory extends Stack<Double> {
    Double value

    void ms () {
        push(value)
    }

    void mr () {
        value = pop()
    }
}

class Calculator {
    double result
 
    void sum ( double a ) {
        result += a
    }

    void subs ( double a ) {
        result -= a
    }

    void memorize ( Closure cl ) {
        def mem = new Memory()
        mem.value = result
        def code = cl.rehydrate(mem, this, this)
        code.resolveStrategy = Closure.DELEGATE_ONLY
        code()
        result = mem.value
    }
}

def calculate ( Closure cl ) {
    def calc = new Calculator()
    def code = cl.rehydrate(calc, this, this)
    code.resolveStrategy = Closure.DELEGATE_ONLY
    code()
}

