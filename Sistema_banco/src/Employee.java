public class Employee extends Thread {
    // criando o salario pois cada funcionario pode ter um salario (em um caso mais real)
    private double salary = 1400.0;
    private Account salaryAccount;
    private Account investmentAccount;

    public Employee(Account salaryAccount, Account investmentAccount, Double salary) {
        this.salaryAccount = salaryAccount;
        this.investmentAccount = investmentAccount;
        this.salary = salary;

    }

    // gerar o get para conseguir visualizar o salario e poder manipula-lo
    public Account getSalaryAccount() {
        return salaryAccount;
    }

    public Account getInvestmentAccount() {
        return investmentAccount;
    }

    public Double getSalary() {
        return salary;
    }

    public void investir() {
        double investmentAmount = salary * 0.2; // 20% do salario
        salaryAccount.transfer(investmentAccount, investmentAmount);
        System.out.println(Thread.currentThread().getName() + " investiu R$" + investmentAmount + "(20% do total) na conta de investimentos.");
    }


}