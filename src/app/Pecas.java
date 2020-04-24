//Super classe para representar as peças do tabuleiro
package app;

public class Pecas {
    //coranterior é usado para fazer o controle de jogadas, não permitindo um jogador fazer duas jogas seguidas
    //Supondo que as peças brancas são as primeiras a se movimentar, o movimento anterios a ela seria das peças pretas
    static char coranterior = 'P';
    //Atributos das peças
    private char cor;
    private int x, y;
    //reprenseta é usado para a impressão das peças, pois mesmo existindo somente 2 cores há 4 representações possiveis
    private char representa;
    //Construtor para peça
    Pecas(char cor, int y, int x){
        this.cor = cor;
        //inicialmente a representação da peça e simplesmente sua propria cor
        this.representa = cor;
        this.x = x;
        this.y = y;
    }
    //Metodos para peças
    public void setCor(char cor){
        this.cor = cor;
    }
    public char getCor(){
        return cor;
    }
    public void setCoordenada(int y, int x){
        this.y = y;
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public char getRepresenta(){
        return representa;
    }
    public void setRepresenta(char representa){
        this.representa = representa;
    }
    //Metodo para controlar a vez de cada jogador
    public boolean vez(){
        //Verifica se a cor da peça movida e diferente da cor da peça movida anteriormente
        if(cor!=coranterior){
            //Guarda a cor da peça movida nessa jogada para compara-la com a proxima
            coranterior = cor;
            return true;
        }
        else
            return false;
    }
    //Declaração do metodo movimento implementado em PecaComum e Dama
    public void movimento(Tabuleiro damas, int[] commands){
    }
}

