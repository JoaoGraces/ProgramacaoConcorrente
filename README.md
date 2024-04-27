# ProgramacaoConcorrente
Este projeto em Java 17 representa um sistema bancário que utiliza threads e os conceitos de concorrência vistos em sala de aula. O sistema simula as interações entre um banco, lojas, funcionários, clientes e contas, garantindo a consistência dos saldos das contas durante as transações.

## Entidades do Sistema

O sistema é composto pelas seguintes entidades:

Banco: Representa a instituição financeira que coordena as transações entre as contas.
Loja: Representa estabelecimentos onde os clientes realizam compras.
Funcionário: Representa os colaboradores das lojas, responsáveis por receber salários e realizar investimentos.
Cliente: Representa os usuários que possuem contas bancárias e realizam compras.
Conta: Representa as contas bancárias dos clientes e lojas.
## Configuração do Sistema

O sistema contém os seguintes componentes:

1 banco.
2 lojas.
4 funcionários (2 por loja).
5 clientes.
Cada cliente é uma thread que possui uma conta com um saldo inicial de R$ 1.000,00. Os clientes realizam compras alternando entre as lojas até que o saldo da conta esteja vazio.

Cada loja possui uma conta para receber os pagamentos dos clientes e paga os funcionários assim que possuir o valor dos salários (R$ 1.400,00).

Cada funcionário é uma thread que possui duas contas: uma para receber o salário da loja e outra de investimentos. Eles investem 20% do salário na conta de investimentos logo após o recebimento.

O banco intermediar as transações de forma síncrona e coordenada, garantindo a consistência dos saldos das contas.
