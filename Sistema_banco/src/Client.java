import java.util.Random;

public class Client extends  Thread {

    // valores possiveis de compra em cada loja
    private static final double[] salesPrice = {100, 200};
    public Account account;
    private Store store1;
    private Store store2;
    private Bank bank;
    private Store[] stores;
    private String clientName;

    public Client(Account account, Store store1, Store store2, Bank bank, String clientName) {
        this.account = account;
        this.store1 = store1;
        this.store2 = store2;
        this.bank = bank;
        // criando uma array de lojas para conseguir escolher entre uma das duas randomicamente
        this.stores = new Store[]{store1, store2};
        this.clientName = clientName;
    }


    public String getClientNameName() {
        return clientName;
    }

    @Override
    public void run() {
        // enquanto tiver valor na conta ele faz as compras
        while (account.getBalance() > 0) {
            System.out.println("Saldo atual da conta: R$" + account.getBalance());
            Random random = new Random();
            // pegando o indice do aray e passando ele para o valor double
            int transferRandom = random.nextInt(salesPrice.length);
            Double transferAmmount = salesPrice[transferRandom];
            // if ternário que verifica o indice que foi selecionado - forma mais facil de fazer quando se usa apenas dois inicies
            Store randomStore = random.nextInt(2) == 0 ? this.store1 : this.store2;
            synchronized (account) { // fazendo a compra de forma segura
                bank.transfer(this.account, randomStore.getAccount(), transferAmmount);
                System.out.println("Compra no valor de R$" + transferAmmount + " foi feita pelo" + this.clientName + "na loja " + randomStore);
                if (randomStore.getAccount().getBalance() >= 1400) {
                    randomStore.paySalaries();
                }
            }
        }
    }
}
