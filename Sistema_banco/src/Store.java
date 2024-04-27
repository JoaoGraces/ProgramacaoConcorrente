public class Store {
    private Account account;
    private Employee firstEmployee;
    private Employee secondEmployee;
    private Bank bank;

    public Store(Account account, Bank bank, Employee firstEmployee, Employee secondEmployee) {
        this.account = account;
        this.firstEmployee = firstEmployee
        this.secondEmployee = secondEmployee;
        this.bank = bank;
    }

    public synchronized void pagarSalarios() {
        if (account.getBalance() >= 1400) {
            bank.transfer(account, firstEmployee.getSalaryAccount(), firstEmployee.getSalary());
            firstEmployee.investir();
            System.out.println("Funcionario: " + firstEmployee.getName() + "recebeu seu salario");
            // colocando os valores para o segundo funcinario tambem
            Employee temp = firstEmployee;
            firstEmployee = secondEmployee;
            secondEmployee = temp;
        } else {
            System.out.println("O dinheiro na conta da loja é insuficiente para pagar os funcionarios");
        }
    }
}
