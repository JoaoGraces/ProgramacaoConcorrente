import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Criar banco
        Bank bank = new Bank();
        // Criar contas das lojas
        Account accountStore1 = new Account(0);
        Account accountStore2 = new Account(0);
        // Criar contas para os funcionários
        Account accountEmployee1Store1 = new Account(0);
        Account accountEmployee2Store1 = new Account(0);
        Account accountEmployee1Store2 = new Account(0);
        Account accountEmployee2Store2 = new Account(0);
        // Criar contas para clientes
        List<Account> accountList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Account account = new Account(1000);
            accountList.add(account);
        }
        // Criar funcionários
        Employee employee1Store1 = new Employee(accountEmployee1Store1, new Account(0), 1400.0, "Funcionario 1 - Rubi");
        Employee employee2Store1 = new Employee(accountEmployee2Store1, new Account(0), 1400.0, "Funcionario 2 - Safira");
        Employee employee1Store2 = new Employee(accountEmployee1Store2, new Account(0), 1400.0, "Funcionario 1 - Ametista");
        Employee employee2Store2 = new Employee(accountEmployee2Store2, new Account(0), 1400.0, "Funcionario 2 - Topazio");
        // Criar lojas
        Store store1 = new Store(accountStore1, bank, employee1Store1, employee2Store1, "Loja 1");
        Store store2 = new Store(accountStore2, bank, employee1Store2, employee2Store2, "Loja 2");
        //Criar Clientes
        Client client1 = new Client(accountList.get(0), store1, store2, bank, "Cliente 1 - Joao");
        Client client2 = new Client(accountList.get(1), store1, store2, bank, "Cliente 2 - Maria");
        Client client3 = new Client(accountList.get(2), store1, store2, bank, "Cliente 3 - Carlos");
        Client client4 = new Client(accountList.get(3), store1, store2, bank, "Cliente 4 - Claudia");
        Client client5 = new Client(accountList.get(4), store1, store2, bank, "Cliente 5 - Marcos");

        // Iniciar threads dos funcionarios
        employee1Store1.start();
        employee2Store1.start();
        employee1Store2.start();
        employee2Store2.start();

        // Iniciar threads dos clientes
        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();

        // adicionando os clientes na pilha de espera e operaçoes
        try {
            client1.join();
            client2.join();
            client3.join();
            client4.join();
            client5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Erro no join dos clientes" + e);
        }

        // adicionando os funcionarios na pilha de espera e operaçoes
        try {
            employee1Store1.join();
            employee2Store1.join();
            employee1Store2.join();
            employee2Store2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Erro no join dos clientes" + e);
        }
        System.out.println("\n\nSaldo final das lojas: ");
        System.out.println("Saldo da loja 1:" + store1.getAccount().getBalance());
        System.out.println("Saldo da loja 2:" + store2.getAccount().getBalance());
        System.out.println("-------------------------------------------------------");
        System.out.println("Saldo final dos funcionarios: ");
        System.out.println("Saldo da conta Salario do funcionario 1 da loja 1:" + employee1Store1.getSalaryAccount().getBalance());
        System.out.println("Saldo da conta Salario do funcionario 2 da loja 1:" + employee2Store1.getSalaryAccount().getBalance());
        System.out.println("Saldo da conta Salario do funcionario 1 da loja 2:" + employee1Store2.getSalaryAccount().getBalance());
        System.out.println("Saldo da conta Salario do funcionario 2 da loja 2:" + employee2Store2.getSalaryAccount().getBalance());
        System.out.println("-------------------------------------------------------");
        System.out.println("Saldo final dos funcionarios: ");
        System.out.println("Saldo da conta Investimento do funcionario 1 da loja 1:" + employee1Store1.getInvestmentAccount().getBalance());
        System.out.println("Saldo da conta Investimento do funcionario 2 da loja 1:" + employee2Store1.getInvestmentAccount().getBalance());
        System.out.println("Saldo da conta Investimento do funcionario 1 da loja 2:" + employee1Store2.getInvestmentAccount().getBalance());
        System.out.println("Saldo da conta Investimento do funcionario 2 da loja 2:" + employee2Store2.getInvestmentAccount().getBalance());
        System.out.println("-------------------------------------------------------");
        System.out.println("Saldo do " + client1.getClientNameName() + ":" + client1.account.getBalance());
        System.out.println("Saldo do " + client2.getClientNameName() + ":" + client2.account.getBalance());
        System.out.println("Saldo do " + client3.getClientNameName() + ":" + client3.account.getBalance());
        System.out.println("Saldo do " + client4.getClientNameName() + ":" + client4.account.getBalance());
        System.out.println("Saldo do " + client5.getClientNameName() + ":" + client5.account.getBalance());


    }
}