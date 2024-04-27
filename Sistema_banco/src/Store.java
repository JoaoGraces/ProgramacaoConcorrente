import java.util.Random;

public class Store {
    private Account account;
    private Employee firstEmployee;
    private Employee secondEmployee;
    private Bank bank;
    private Random random = new Random();
    private String storeName;

    public Store(Account account, Bank bank, Employee firstEmployee, Employee secondEmployee, String storeName) {
        this.account = account;
        this.firstEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;
        this.bank = bank;
        this.storeName = storeName;
    }

    public Account getAccount() {
        return account;
    }

    public synchronized void paySalaries() {
        if (account.getBalance() >= 1400) {
            // garantindo que nao seja sempre o primeiro funcionario que vai receber o primeiro salario
            if (this.firstEmployee.getSalaryAccount().getBalance() == 0 && this.secondEmployee.getSalaryAccount().getBalance() == 0) {
                // caso os dois nao tenham recebido ainda ele escolhe randomicamente
                Employee randomEmployee = random.nextInt(2) == 0 ? this.firstEmployee : this.secondEmployee;
                System.out.println(storeName + "pagou o " + secondEmployee.getExmployeeName());
                bank.transfer(this.account, randomEmployee.getSalaryAccount(), randomEmployee.getSalary());
                randomEmployee.investir();
            } else {
                // varifica qual dos funcionario tem mais valor na conta para os dois ficarem com os valores iguais - problema enviado pelo email
                if (this.firstEmployee.getSalaryAccount().getBalance() > this.secondEmployee.getSalaryAccount().getBalance()) {
                    bank.transfer(this.account, this.secondEmployee.getSalaryAccount(), secondEmployee.getSalary());
                    System.out.println(storeName + "pagou o " + secondEmployee.getExmployeeName());
                    this.secondEmployee.investir();
                } else {
                    bank.transfer(this.account, this.firstEmployee.getSalaryAccount(), firstEmployee.getSalary());
                    System.out.println(storeName + "pagou o " + firstEmployee.getExmployeeName());
                    this.firstEmployee.investir();
                }
            }
        } else {
            System.out.println("O dinheiro na conta da loja é insuficiente para pagar os funcionarios");
        }
    }
}
