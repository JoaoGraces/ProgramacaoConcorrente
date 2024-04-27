import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    // criando o lock
    private Lock lock = new ReentrantLock();
    private double balance;

    public Account(double inicialBalance) {
        this.balance = inicialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // deposita um valor novo no saldo da conta - garente o lock e apos realizar o deposito libera o lock
    public void deposit(double valor) {
        lock.lock();
        try {
            balance += valor;
        } finally {
            lock.unlock();
        }
    }

    // saca valor da conta e muda o saldo - garente o lock e apos realizar o deposito libera o lock
    public void withdraw(double valor) {
        lock.lock();
        try {
            balance -= valor;
        } finally {
            lock.unlock();
        }
    }

    // tranfer dinheiro para uma conta de destino - retira dinheiro por meio da funcao de sacar e depois deosita o valor na conta destino
    public void transfer(Account destiny, double value) {
        lock.lock();
        try {
            withdraw(value);
            destiny.deposit(value);
        } finally {
            lock.unlock();
        }
    }
}