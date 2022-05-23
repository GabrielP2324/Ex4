import javax.swing.JOptionPane;

public class Menu {
	Professor[] profs = new Professor[5];
	int escolha;
	int posicao = 0;

	public void menu() {

		do {
			escolha = Integer.parseInt(JOptionPane
					.showInputDialog("1. Registrar \n 2. Consultar \n 3. Remover \n 4. Exibir Dados \n 5. Sair"));

			switch (escolha) {
			case 1:
				Registrar();
				break;
			case 2:
				Consultar();
				break;
			case 3:
				Remover();
				break;
			case 4:
				Exibir();
				break;
			}
		} while (escolha != 5);

	}

	public void Exibir() {
		String aux = "";
		if (posicao < 1) {
			aux += "Não tem ninguém cadastrado!";
		} else {
			for (int i = 0; i < posicao; i++) {
				aux += "Nome professor " + (i + 1) + ": " + profs[i].Nome + "\n";
				aux += "CPF professor " + (i + 1) + ": " + profs[i].CPF + "\n";
				aux += "Total de aulas do professor " + (i + 1) + ": " + profs[i].TotalAulas + "\n";
				aux += "Valor das aulas do professor " + (i + 1) + ": " + profs[i].ValorAula + "\n";
				aux += "Salário base do professor " + (i + 1) + ": " + profs[i].SB() + "\n";
				aux += "Valor hora atividade do professor " + (i + 1) + ": " + profs[i].HA() + "\n";
				aux += "Descanso semanal remunerado do professor " + (i + 1) + ": " + profs[i].DSR() + "\n\n";

			}
		}
		JOptionPane.showMessageDialog(null, aux);
	}

	public void Remover() {
		int index = Consultar();
		if (index != -1) {
			for (int i = index; i < profs.length; i++) {
				profs[index] = profs[index + 1];
			}
			posicao--;
		}
	}

	public int Consultar() {
		if (posicao < 1) {
			JOptionPane.showMessageDialog(null, "Não tem ninguém cadastrado!");
			return -1;
		} else {
			int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF a pesquisar"));

			for (int i = 0; i < posicao; i++) {
				if (profs[i].CPF == cpf) {
					JOptionPane.showMessageDialog(null, cpf + " encontrado no índice " + (i+1));
					return i;
				}
			}
			JOptionPane.showMessageDialog(null, cpf + " não encontrado!");
			return -1;
		}
	}

	public void Registrar() {
		int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF a registrar"));
		boolean encontrado = false;
		for (int i = 0; i < posicao; i++) {
			if (cpf == profs[i].CPF) {
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			profs[posicao] = new Professor();
			profs[posicao].CPF = cpf;
			profs[posicao].Nome = JOptionPane.showInputDialog("Nome:");
			profs[posicao].TotalAulas = Integer.parseInt(JOptionPane.showInputDialog("Total de aulas semanais"));
			profs[posicao].ValorAula = Double.parseDouble(JOptionPane.showInputDialog("Valor da aula"));
			posicao++;

		} else {
			JOptionPane.showMessageDialog(null, cpf + " já está registrado a outro professor!");
		}
	}
}
