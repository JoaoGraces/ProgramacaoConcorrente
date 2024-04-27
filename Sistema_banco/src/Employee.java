public class Employee extends Thread {
    // criando o salario visivel para todas as classes
    public static final double salary = 1400.0;
    private Account salaryAccount;
    public Account investmentAccount;

    public Employee(Account salaryAccount, Account investmentAccount) {
        this.salaryAccount = salaryAccount;
        this.investmentAccount = investmentAccount;
    }

    // gerar o get para conseguir visualizar o salario e poder manipula-lo
    public Account getSalaryAccount() {
        return salaryAccount;
    }

    public void investir() {
        double investmentAmount = salary * 0.2;
        salaryAccount.transfer(investmentAccount, investmentAmount);
        System.out.println(Thread.currentThread().getName() + " investiu R$" + investmentAmount + "(20% do total) na conta de investimentos.");
    }


}