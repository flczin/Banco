import java.text.ParseException;

public class Execute {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException, SaldoInsuficiente {
		Cliente fagner = new Cliente("Fagner", "Rua Azul", "12/03/1993");
		Cliente paulo = new Cliente("Paulo", "Rua Vermelha", "23/10/1999");
		Cliente pedro = new Cliente("Pedro", "Rua Amarela", "10/02/2000");
		ContaCorrente contaFagner = new ContaCorrente(fagner, 1);
		ContaCorrente contaPaulo = new ContaCorrente(paulo, 2);
		ContaCorrente contaPedro = new ContaCorrente(pedro, 3);
		CDB cdb = new CDB();
		LCI lci = new LCI();
		LCA lca = new LCA();
		Fundos fundos = new Fundos();

		contaPaulo.depositar(1000);
		contaPaulo.investimento(100, fundos);
		try{
			contaPaulo.resgatar(205);
		}catch (Exception e){
			System.out.println(e);
		}
		contaPaulo.consultarSaldo();

	}

}
