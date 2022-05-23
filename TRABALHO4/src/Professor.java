
public class Professor {
	int CPF;
	String Nome;
	int TotalAulas;
	double ValorAula;

	public double SB() {
		double salario;

		salario = ValorAula * 4.5 * TotalAulas;

		return salario;
	}
	
	public double HA() {
		return SB() * 0.05;
	}
	
	public double DSR() {
		return (SB() + HA())/6;
	}
}
