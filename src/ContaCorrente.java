import java.text.DecimalFormat;

public final class ContaCorrente extends Conta {
	private double saldoInvest;

	public ContaCorrente(Cliente cliente, int numero) {
		super(cliente, numero);
	}

	public void investimento(double valor, Produto produto) throws SaldoInsuficiente {
		boolean teste = this.sacar(valor);
		if(teste) {
			saldoInvest += produto.investir(valor);
		}
	}

	public void resgatar(double valor) throws SaldoInsuficiente{
		if(this.saldoInvest >= valor){
			saldoInvest -= valor;
			this.saldo += valor;
		}else {
			throw new SaldoInsuficiente("Resgate negado");
		}
	}

	@Override
	public void consultarSaldo() {
		DecimalFormat f = new DecimalFormat("R$###00.00");
		System.out.println("----------Consultar Saldo----------");
		System.out.println("Número da conta: " + this.numero);
		System.out.println("Data de Abertura: " + dateFormat.format(this.dataAbertura));
		System.out.println("Titular: " + this.cliente.getNome());
		System.out.println("Data de Nascimento: " + dateFormat.format(this.cliente.getDataNasc()));
		System.out.println("Saldo: " + f.format(this.saldo));
		System.out.println("Saldo Investimento: " + f.format(this.saldoInvest));
	}
}
