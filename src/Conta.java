import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Conta {
	protected Cliente cliente;
	protected long numero;
	protected double saldo;
	private static long contador;
	protected Date dataAbertura = Calendar.getInstance().getTime();
	protected DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	
	public Conta(Cliente cliente, int numero) {
		this.cliente = cliente;
		this.numero = numero;
		this.dataAbertura = new Date();
		System.out.println("Conta número: " + this.numero + " criada!");
		contador++;
	}
	
	public static void exibirContador(){
		System.out.println("Contas: " + contador);
	}
	
	public boolean sacar(double valor) throws SaldoInsuficiente {
		if (this.saldo > 0) {
			if (this.saldo >= valor) {
				this.saldo -= valor;
				System.out.println("----------Saque Sucesso----------");
				return true;
			}
		}
		throw new SaldoInsuficiente("Saque negado");
	}


	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("----------Depósito Sucesso----------");
		} else {
			System.out.println("----------Depósito Falha----------");
		}

	}

	public void transferir(Conta conta, double valor) throws SaldoInsuficiente {
		boolean teste;
		teste = this.sacar(valor);
		if (teste) {
			conta.depositar(valor);
			System.out.println("----------Transferência Sucesso----------");
		} else {
			System.out.println("----------Transferência Falha----------");
		}

	}

	public abstract void consultarSaldo();

}
