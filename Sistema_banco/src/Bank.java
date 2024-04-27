import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private Lock lock = new ReentrantLock();

    public synchronized void transfer(Account originAccount, Account destinyAccount, double ammount) {
        lock.lock();
        try {
            // verificando se o valor do saldo da conta de origem é suficiente para reliazar a tranferencia
            if (originAccount.getBalance() >= ammount) {
                originAccount.withdraw(ammount);
                destinyAccount.deposit(ammount);
                System.out.println("Conta de origem(remetente): " + originAccount);
                System.out.println("Conta de destino(destinatário): " + destinyAccount);
                System.out.println("Valor da transferencia: "  + ammount);
                System.out.println("-------------------------------------------------------");
            } else {
                System.out.println("O saldo da conta " + originAccount + " é insuficiente para realizar uma transferencia do valor de R$" + ammount + "para a conta " + destinyAccount);
            }
        } finally {
            lock.unlock();
        }
    }
}
