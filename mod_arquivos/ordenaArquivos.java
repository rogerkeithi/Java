package org.example;
//          ^^^     Padrão do IntelliJ
import java.io.*;
import java.nio.file.Files;
import java.util.Random;
/*      Abre cada um dos arquivos existentes no conjunto de pastas/arquivos
        Lê o arquivo e armazena seus dados em um vetor
        Ordena o vetor
        Grava os dados desse vetor em um novo arquivo (na mesma pasta) acrescentando "_ord" em seu nome. Exemplo: arq1.txt -> arq1_ord.txt*/

public class Main {
    public static int N[] = new int[]{100, 1000, 10000, 50000, 100000};

    public static void main(String[] args) throws IOException {
        //criando arquivos...
        criar_arquivos();

        for (int i = 0; i < 5; i++) {
            dirPasta(N[i]);
        }

    }
    //Este método cria os primeiros arquivos em suas respectivas pastas, com valores aleatórios;
    public static void criar_arquivos() throws IOException {
        for (int i = 0; i < 5; i++) {
            File pasta = new File(String.valueOf(N[i]));

            if (!pasta.exists()) {
                pasta.mkdir();
            }
            int max = N[i];
            int min = 0;
            //pasta.getAbsolutePath() retorna o caminho absoluto da pasta,
            //adicione o string com o nome do arquivo a ser criado
            System.out.println(pasta.getAbsolutePath());
            for(int j = 1; j <= 10; j++){
                String arqCriacao = pasta.getAbsolutePath()+ "/arq" + j + ".txt";
                BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqCriacao, false));

                for(int k = 0; k < N[i]; k++){
                    Random aleatorio = new Random();
                    int valor = aleatorio.nextInt(max - min) + min;
                    buffWrite.append(valor + "\n");
                }
                buffWrite.close();

                max = max + max;
                min = min + N[i];
            }
        }
    }
    //Este método é usado para acessar os arquivos dentro das pastas;
    private static void dirPasta(int x) throws IOException {
        String dirName = String.valueOf(x);

        Files.list(new File(dirName).toPath())
                .limit(10)
                .forEach(path -> {
                    System.out.println(path);
                    try {
                        criarOrd(ordenarVetor(lerArquivo("./"+path)),"./" + path);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

    }
    //Este método lê o arquivo e retorna os valores convertidos para inteiros;
    public static int[] lerArquivo(String arqLendo) throws IOException {
        File arq = new File(arqLendo);
        String arqDir = arq.getAbsolutePath();
        BufferedReader buffRead = new BufferedReader(new FileReader(arqDir));

        int N = 0;

        while(buffRead.readLine() != null){
            N += 1;
        }
        buffRead.close();

        BufferedReader br = new BufferedReader(new FileReader(arqDir));

        String[] res = new String[N];

        int[] toVet = new int[N];

        for(int i = 0; i < N; i++){
            res[i] = br.readLine();
            toVet[i] = Integer.parseInt(res[i]);
        }

        br.close();

        return toVet;
    }

    //Após Ler o vetor, é chamado o método para ordenar o vetor, retornando o vetor com os valores na ordem crescente;
    public static int[] ordenarVetor(int[] vet){
        int temp;

        for(int i = 0; i < vet.length; i++){
            for(int j = 0; j < i; j++){
                if(vet[i] < vet[j]){
                    temp = vet[i];
                    vet[i] = vet[j];
                    vet[j] = temp;
                }
            }
        }
            return vet;
    }
    //Após a ordenação, este método é chamado para criar os arquivos com "_ord.txt" nos seus respectivos nomes;
    public static void criarOrd(int[] vet, String arqEscrevendo) throws IOException {
        int tam = arqEscrevendo.length();

        // removendo ".txt" do arquivo
        arqEscrevendo = arqEscrevendo.substring(0,tam-4);

        // adicionando "_ord" ao nome do arquivo
        arqEscrevendo += "_ord.txt";

        File arq = new File(arqEscrevendo);
        String arqDir = arq.getAbsolutePath();

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqDir, true));

        for(int i = 0; i < vet.length; i++){
            buffWrite.append(vet[i] + "\n");
        }

        buffWrite.close();
    }
}
