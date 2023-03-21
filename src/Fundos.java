public class Fundos implements Produto {

	@Override
	public double investir(double valor) {
		return valor * 1.05;
	}

}
