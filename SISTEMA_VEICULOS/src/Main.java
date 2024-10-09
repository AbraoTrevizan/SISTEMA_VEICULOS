import java.util.Scanner;

// Classe veiculo
abstract class Veiculo {
    private String modelo;           // Modelo 
    private int anoFabricacao;       // Ano de fabricação
    private String montadora;        // Montadora 
    private String cor;              // Cor 
    private double kilometragem;      // KM

    // Constroi a classe veiculo
    public Veiculo(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem) {
        setModelo(modelo);           // Verifica o modedlo do veiculo
        setAnoFabricacao(anoFabricacao); // Veridica o ano de fabricacao
        this.montadora = montadora;  // Inicia a montadora
        this.cor = cor;              // Inicia a cor
        this.kilometragem = kilometragem; // Inicia kilometragem
    }

    // Vai estar verificando o modelo 
    public void setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty()) {
            throw new IllegalArgumentException("Modelo é obrigatório");
        }
        this.modelo = modelo;
    }

    // Vai estar verificando o ano de fabricacao
    public void setAnoFabricacao(int anoFabricacao) {
        if (anoFabricacao < 1886 || anoFabricacao > 2024) {
            throw new IllegalArgumentException("Ano de fabricação inválido");
        }
        this.anoFabricacao = anoFabricacao;
    }

    // Vai estar lendo o valor dos atributos
    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getMontadora() {
        return montadora;
    }

    public String getCor() {
        return cor;
    }

    public double getKilometragem() {
        return kilometragem;
    }

// Faz com que deva ser implementado pelas subclasses para gerar um comando SQL
// correspondente ao tipo específico de veículo. Cada subclasse deve fornecer sua própria
// logica para construir a instrução SQL

public abstract String gerarInsert();
}

// Classe automovel
class Automovel extends Veiculo {
    private int maxPassageiros;     // Máximo de passageiros
    private String tipoFreio;        // Tipo do freio
    private boolean airbag;          // airbag true/false

    // Criando a classe automovel 
    public Automovel(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem,
                     int maxPassageiros, String tipoFreio, boolean airbag) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem); // PUca o criador da classe mae
        this.maxPassageiros = maxPassageiros; // Inicia a quantidade de passageiros
        this.tipoFreio = tipoFreio; // Inicia o tipo de freio
        this.airbag = airbag; // Inicia se a airbag ou nao
    }

    // Coloca o gerarInsert na classe Automovel
    @Override
    public String gerarInsert() {
        return String.format("INSERT INTO Automovel (modelo, anoFabricacao, montadora, cor, kilometragem, maxPassageiros, tipoFreio, airbag) " +
                             "VALUES ('%s', %d, '%s', '%s', %.2f, %d, '%s', %b);",
                             getModelo(), getAnoFabricacao(), getMontadora(), getCor(), getKilometragem(),
                             maxPassageiros, tipoFreio, airbag);
    }
}

// Classe motocicleta
class Motocicleta extends Veiculo {
    private int cilindrada;         // Cilindrada da motocicleta
    private double torque;          // Torque da motocicleta

    // Criando a classe Motocicleta
    public Motocicleta(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem,
                       int cilindrada, double torque) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem); // puxa a criacao da classe mae
        this.cilindrada = cilindrada; // Inicia a cilindrada
        this.torque = torque; // Inicia o torque
    }

    // Coloca o gerarInsert na classe motocicleta
    @Override
    public String gerarInsert() {
        return String.format("INSERT INTO Motocicleta (modelo, anoFabricacao, montadora, cor, kilometragem, cilindrada, torque) " +
                             "VALUES ('%s', %d, '%s', '%s', %.2f, %d, %.2f);",
                             getModelo(), getAnoFabricacao(), getMontadora(), getCor(), getKilometragem(),
                             cilindrada, torque);
    }
}

// Classe caminhao
class Caminhao extends Veiculo {
    private int quantidadeEixos;     // eixos do caminhao
    private double pesoBruto;        // Peso maximo de caminhao

    // Criando a classe Caminhao
    public Caminhao(String modelo, int anoFabricacao, String montadora, String cor, double kilometragem,
                    int quantidadeEixos, double pesoBruto) {
        super(modelo, anoFabricacao, montadora, cor, kilometragem); // puxa a criacao da classe mae
        this.quantidadeEixos = quantidadeEixos; // Inicia a quantidade de eixos
        this.pesoBruto = pesoBruto; // Inicia o peso maximo
    }

    // Coloca o gerarInsert na classe caminhao
    @Override
    public String gerarInsert() {
        return String.format("INSERT INTO Caminhao (modelo, anoFabricacao, montadora, cor, kilometragem, quantidadeEixos, pesoBruto) " +
                             "VALUES ('%s', %d, '%s', '%s', %.2f, %d, %.2f);",
                             getModelo(), getAnoFabricacao(), getMontadora(), getCor(), getKilometragem(),
                             quantidadeEixos, pesoBruto);
    }
}

// Classe bicicleta
class Bicicleta extends Veiculo {
    private String marca;             // marca 
    private String material;          // material 
    private int quantidadeMarchas;    // quantidade de marchas
    private boolean amortecedor;      // se tem  amortecedor

    // Criando a classe Bicicleta
    public Bicicleta(String modelo, int anoFabricacao, String marca, String cor, double kilometragem,
                     String material, int quantidadeMarchas, boolean amortecedor) {
        super(modelo, anoFabricacao, "N/A", cor, kilometragem); // puxa a criacao da classe mae
        this.marca = marca; // Inicia a marca
        this.material = material; // Inicia o material
        this.quantidadeMarchas = quantidadeMarchas; // Iniciaa quantidade de marchas
        this.amortecedor = amortecedor; // Inicia o amortecedor
    }

    // Coloca o gerarInsert na classe bicicleta
    @Override
    public String gerarInsert() {
        return String.format("INSERT INTO Bicicleta (modelo, anoFabricacao, marca, cor, kilometragem, material, quantidadeMarchas, amortecedor) " +
                             "VALUES ('%s', %d, '%s', '%s', %.2f, '%s', %d, %b);",
                             getModelo(), getAnoFabricacao(), marca, getCor(), getKilometragem(),
                             material, quantidadeMarchas, amortecedor);
    }
}

// Classe skate
class Skate extends Veiculo {
    private String marca;             // marca d
    private String tipoRodas;         // rodas do skate

    // Criando a classe Skate
    public Skate(String modelo, int anoFabricacao, String marca, String cor, double kilometragem, String tipoRodas) {
        super(modelo, anoFabricacao, "N/A", cor, kilometragem); // Chama o construtor da classe pai
        this.marca = marca; // Inicia a marca
        this.tipoRodas = tipoRodas; // Inicia o tipo de rodas
    }

    // Coloca o gerarInsert na classe skate
    @Override
    public String gerarInsert() {
        return String.format("INSERT INTO Skate (modelo, anoFabricacao, marca, cor, kilometragem, tipoRodas) " +
                             "VALUES ('%s', %d, '%s', '%s', %.2f, '%s');",
                             getModelo(), getAnoFabricacao(), marca, getCor(), getKilometragem(), tipoRodas);
    }
}

// Classe principal d
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializa o scanner para entrada das respotas das perguntas
        System.out.println("Escolha o tipo de veículo (1-Automóvel, 2-Motocicleta, 3-Caminhão, 4-Bicicleta, 5-Skate): ");
        int tipo = scanner.nextInt(); // ve o tipo de veiculo escolhido
        scanner.nextLine(); // Vai estar limpando o buffer

        // dados comuns
        String modelo, cor, montadora;
        int anoFabricacao;
        double kilometragem;

        // vai estar pegando os dados comuns
        System.out.print("Modelo: ");
        modelo = scanner.nextLine();

        System.out.print("Ano de Fabricação: ");
        anoFabricacao = scanner.nextInt();

        System.out.print("Cor: ");
        cor = scanner.next();

        System.out.print("Kilometragem: ");
        kilometragem = scanner.nextDouble();

        // Switch que vai criar o veículo escolhido
        switch (tipo) {
            case 1: // automovel
                System.out.print("Montadora: ");
                montadora = scanner.next();

                System.out.print("Max. Passageiros: ");
                int maxPassageiros = scanner.nextInt();

                System.out.print("Tipo de Freio: ");
                String tipoFreio = scanner.next();

                System.out.print("Tem Airbag (true/false): ");
                boolean airbag = scanner.nextBoolean();

                // Cria o objeto Automovel e mostra o SQL
                Automovel carro = new Automovel(modelo, anoFabricacao, montadora, cor, kilometragem,
                        maxPassageiros, tipoFreio, airbag);
                System.out.println(carro.gerarInsert());
                break;

            case 2: // motocicleta
                System.out.print("Montadora: ");
                montadora = scanner.next();

                System.out.print("Cilindrada: ");
                int cilindrada = scanner.nextInt();

                System.out.print("Torque: ");
                double torque = scanner.nextDouble();

                // Cria o objeto motocicleta e mostra o SQL
                Motocicleta moto = new Motocicleta(modelo, anoFabricacao, montadora, cor, kilometragem,
                        cilindrada, torque);
                System.out.println(moto.gerarInsert());
                break;

            case 3: // caminhao
                System.out.print("Montadora: ");
                montadora = scanner.next();

                System.out.print("Quantidade de Eixos: ");
                int quantidadeEixos = scanner.nextInt();

                System.out.print("Peso Bruto: ");
                double pesoBruto = scanner.nextDouble();

                // Cria o objeto caminhao e mostra o SQL
                Caminhao caminhao = new Caminhao(modelo, anoFabricacao, montadora, cor, kilometragem,
                        quantidadeEixos, pesoBruto);
                System.out.println(caminhao.gerarInsert());
                break;

            case 4: // bicicleta
                System.out.print("Marca: ");
                String marca = scanner.next();

                System.out.print("Material: ");
                String material = scanner.next();

                System.out.print("Quantidade de Marchas: ");
                int quantidadeMarchas = scanner.nextInt();

                System.out.print("Tem Amortecedor (true/false): ");
                boolean amortecedor = scanner.nextBoolean();

                // Cria o objeto bicicleta e mostra o SQL
                Bicicleta bicicleta = new Bicicleta(modelo, anoFabricacao, marca, cor, kilometragem,
                        material, quantidadeMarchas, amortecedor);
                System.out.println(bicicleta.gerarInsert());
                break;

            case 5: // skate
                System.out.print("Marca: ");
                String marcaSkate = scanner.next();

                System.out.print("Tipo das Rodas: ");
                String tipoRodas = scanner.next();

                // Cria o objeto skate e mostra o SQL
                Skate skate = new Skate(modelo, anoFabricacao, marcaSkate, cor, kilometragem, tipoRodas);
                System.out.println(skate.gerarInsert());
                break;

            default: // Opção invalida mostra quando usario escolher algo que nao poderia 
                System.out.println("Tipo de veículo inválido.");
        }

        scanner.close(); // Fecha o scanner
    }
}
