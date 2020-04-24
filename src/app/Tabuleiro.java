//Classe para representar tabuleiro e seus metodos
package app;

public class Tabuleiro {
    //Cria uma matriz de paças
    private Pecas[][] tab;
    //Construtor para tabuleiro
    Tabuleiro(){
        //Define tamanho do tabuleiro
        tab = new Pecas[8][8];
        //Percorre a matriz posicionando a peça correta em cada posição
        int x, y;
        for(y = 0; y<8; y++){
            for(x = 0; x<8;x++){
                if((y==0||y==2) && x%2==1){
                    tab[y][x] = new PecaComum('P', y, x); 
                }
                else if(y==1 && x%2==0){
                    tab[y][x] = new PecaComum('P', y, x); 
                }
                else if((y==5||y==7) && x%2==0){
                    tab[y][x] = new PecaComum('B', y, x); 
                }
                else if(y==6 && x%2==1){
                    tab[y][x] = new PecaComum('B', y, x); 
                }
                else {
                    tab[y][x] = null;
                }
            }
        }
    }
    //Metodo para recuperar uma peça
    public Pecas getPecas(int y, int x){
        return tab[y][x];
    }
    //Metodo para posicionar uma peça
    public void setPecas(int y, int x, Pecas peca){
        //Cria dama caso a peça chegue ao outro lado do tabuleiro
        if((peca.getCor()=='P'&& y==7)||(peca.getCor()=='B' && y==0))
            tab[y][x] = new Dama(peca.getCor(), y, x);
        else
            tab[y][x] = peca;  
    }
    //Metodo para verificar se existe uma peça em determinada posição
    public boolean existePeca(int y, int x){
        if(tab[y][x] == null)
            return false;
        return true;
    }
    //Metodo para eliminar uma peca de um determinada posição
    public void eliminaPeca(int y, int x){
        tab[y][x] = null;
    }
    //Metodo para converte a String recebida em uma vetor de inteiros
    int[] converte(String commands){
        //Converte os movimentos recebidos em coordenadas para a matriz
        int x1, x2, y1, y2;
        y1 = 7-((int)commands.charAt(1)-49);
        x1 = (int)commands.charAt(0)-97;
        y2 = 7-((int)commands.charAt(4)-49);
        x2 = (int)commands.charAt(3)-97;
        int vet[] = {x1, y1, x2, y2};
        return vet;
    }
    //Metodo para imprimir o tabuleiro
    void imprimir(){
        //Percorre a matriz imprimindo as peças
        int x, y;
        for(y = 0; y<8;y++){
            System.out.print((8-y) + "  ");
            for(x = 0; x<8; x++){
                if(tab[y][x]!=null)
                    System.out.print(tab[y][x].getRepresenta() + "  ");
                else
                    System.out.print('-' + "  ");
            }
            System.out.println("\n");
        }
        System.out.println("   a  b  c  d  e  f  g  h");
    }
}