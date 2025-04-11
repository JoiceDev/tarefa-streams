package tarefaStreams; 

import java.util.ArrayList;
import java.util.List;

public class FiltroPessoasTest {
    public static void main(String[] args) {
        // Preparar os dados de teste
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Maria", "F"));
        pessoas.add(new Pessoa("João", "M"));
        pessoas.add(new Pessoa("Ana", "F"));
        pessoas.add(new Pessoa("Pedro", "M"));
        pessoas.add(new Pessoa("Julia", "f")); // Teste com minúscula
        
        // Executar o método de filtragem
        List<Pessoa> mulheres = FiltroPessoas.filtrarMulheres(pessoas);
        
        // Verificar resultados
        System.out.println("=== INICIANDO TESTES ===");
        
        // Teste 1: Verificar quantidade de mulheres
        System.out.println("Teste 1: Deve ter 3 mulheres");
        if (mulheres.size() == 3) {
            System.out.println("✓ PASSOU: Encontrou exatamente 3 mulheres");
        } else {
            System.out.println("✗ FALHOU: Encontrou " + mulheres.size() + " mulheres, mas deveriam ser 3");
        }
        
        // Teste 2: Verificar que só tem mulheres
        System.out.println("\nTeste 2: Todos os elementos devem ser mulheres");
        boolean apenasMultheres = true;
        for (Pessoa p : mulheres) {
            if (!p.getSexo().equalsIgnoreCase("F")) {
                apenasMultheres = false;
                System.out.println("✗ FALHOU: Encontrou pessoa com sexo " + p.getSexo());
                break;
            }
        }
        if (apenasMultheres) {
            System.out.println("✓ PASSOU: Todos os elementos são mulheres");
        }
        
        // Teste 3: Verificar nomes específicos
        System.out.println("\nTeste 3: Deve conter Maria, Ana e Julia");
        boolean contemMaria = false;
        boolean contemAna = false;
        boolean contemJulia = false;
        
        for (Pessoa p : mulheres) {
            if (p.getNome().equals("Maria")) contemMaria = true;
            if (p.getNome().equals("Ana")) contemAna = true;
            if (p.getNome().equals("Julia")) contemJulia = true;
        }
        
        if (contemMaria && contemAna && contemJulia) {
            System.out.println("✓ PASSOU: Contém todos os nomes esperados");
        } else {
            System.out.println("✗ FALHOU: Faltam nomes na lista");
            if (!contemMaria) System.out.println("  - Maria não encontrada");
            if (!contemAna) System.out.println("  - Ana não encontrada");
            if (!contemJulia) System.out.println("  - Julia não encontrada");
        }
        
        System.out.println("\n=== TESTES CONCLUÍDOS ===");
    }
}