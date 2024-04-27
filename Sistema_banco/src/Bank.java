import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Lock lock = new ReentrantLock();

    public synchronized void transfer(Account originAccount, Account destinyAccount, double valor) {
        lock.lock();
        try {
            // verificando se o valor do saldo da conta de origem é suficiente para reliazar a tranferencia
            if (originAccount.getBalance() >= valor) {
                originAccount.withdraw(valor);
                originAccount.deposit(valor);
                System.out.println("A conta" + originAccount + "realizou uma tranferencia de R$" + valor + " para a conta " + destinyAccount);
            } else {
                System.out.println("O saldo da conta " + originAccount + " é insuficiente para realizar uma transferencia do valor de R$" + valor + "para a conta " + destinyAccount);
            }
        } finally {
            lock.unlock();
        }
    }
}
