public class CDB implements Produto {
	
	protected double renda = 1.01;

	@Override
	public double investir(double valor) {
		return valor * 1.01;
	}
	
	
}
