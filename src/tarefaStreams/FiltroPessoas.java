mport java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FiltroPessoas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma lista de pessoas no formato nome,sexo;nome,sexo;... (exemplo: Maria,F;João,M;Ana,F):");
        
        String entrada = scanner.nextLine();
        scanner.close();
        
        // Dividir a entrada por ponto e vírgula para obter cada pessoa
        String[] pessoasArray = entrada.split(";");
        
        // Criar uma lista de pessoas
        List<Pessoa> listaPessoas = new ArrayList<>();
        
        // Processar cada pessoa e adicionar à lista
        for (String pessoaStr : pessoasArray) {
            String[] dados = pessoaStr.split(",");
            if (dados.length == 2) {
                String nome = dados[0].trim();
                String sexo = dados[1].trim();
                listaPessoas.add(new Pessoa(nome, sexo));
            }
        }
        
        // Usar lambda para filtrar apenas as mulheres (sexo "F" ou "f")
        List<Pessoa> mulheres = listaPessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());
        
        // Imprimir o resultado
        System.out.println("\nLista de mulheres:");
        if (mulheres.isEmpty()) {
            System.out.println("Nenhuma mulher encontrada na lista.");
        } else {
            mulheres.forEach(mulher -> System.out.println(mulher.getNome()));
        }
    }
}