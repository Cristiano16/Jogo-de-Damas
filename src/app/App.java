//Cristiano Sampaio Pinheiro    RA:256352

/*
O codigo foi inicialmente pensado para receber somente a posição inicial e final das peças, mesmo no caso de multiplos saltos.
Apos a informação de que os saltos seriam passados por partes, modificações foram feitas, isso explica melhor a organição dos metodos.
A representação usada é a seguinte:
P para peças comuns pretas
B para peças comuns brancas
C para damas brancas
Q para damas pretas
Movimento multiplos são feitos por multiplos movimentos "unitarios"
*/
package app;

public class App {  //throws Exception entre ){
    public static void main(String[] args){
        //Cria tabuleiro para guardar as peças
        Tabuleiro damas = new Tabuleiro();
        System.out.println("Estado Inicial do Tabuleiro");
        damas.imprimir();
        
        //Lê comandos e os tranforma em um vetor de strings
        CSVReader csv = new CSVReader();
        csv.setDataSource("/home/cristiano/Documents/f3.csv");
        String commands[] = csv.requestCommands();

        //Laço para executar os camandos recebidos pela arquivo csv
        for(int i=0; i<commands.length; i++){
            //Converte String em um vetor de inteiros
            int cood[] = damas.converte(commands[i]);
            //Verifica se é a vez desse jogador(assumindo que a cor branca inicial o jogo), verifica se existe uma peça na posição inicial. Para evitar erros de acesso no vetor de string também é verificado se a primeira peça a ser movimentada é branca
            if(i==0 && damas.getPecas(cood[1],cood[0]).getCor()=='P')
                System.out.println("Movimento Invalido");
            else if(damas.getPecas(cood[1],cood[0])!=null && (damas.getPecas(cood[1],cood[0]).vez() || commands[i-1].substring(3, 5).equalsIgnoreCase(commands[i].substring(0, 2)))){
                //Realixa o movimento, partindo da peça de coordenada inicial
                damas.getPecas(cood[1],cood[0]).movimento(damas, cood);
                //Imprime a posição inicial e final do movimento
                System.out.println("Source: " + commands[i].substring(0, 2));
                System.out.println("Target: "+ commands[i].substring(3, 5));
                //Imprime o tabuleiro
                damas.imprimir();
            }
            else
                System.out.println("Movimento Invalido");
        }
    }
}