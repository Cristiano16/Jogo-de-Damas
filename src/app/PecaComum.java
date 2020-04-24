//subClasse para representar peças comuns
package app;

public class PecaComum extends Pecas{
    //Construtor para peça comum
    PecaComum(char cor, int y, int x){
        super(cor, y, x );
    }
    //Metodos para peça comum

    //Metodo para determinar se existe um caminho valido da peça inicial ate a posição final
    boolean caminhoValido(Tabuleiro damas, int[] inicio, int[] fim){
        //Verifica se a posição inicial passada pertence ao tabuleiro
        if(inicio[0]<8 && inicio[1]<8 && inicio[0]>=0 && inicio[1]>=0){
            //Verifica se a peça ao lado é oposta e se sua seguite é um espaço vazio
            if((inicio[0]-1)>0 && (inicio[1]-1)>0 && damas.getPecas(inicio[0]-1,inicio[1]-1)!= null && getCor()!= damas.getPecas(inicio[0]-1,inicio[1]-1).getCor() && damas.getPecas(inicio[0]-2,inicio[1]-2)==null){
                //Verifica se a posição esperada foi alcançada
                if(inicio[0]-2 == fim[1] && inicio[1]-2 == fim[0]){
                    damas.eliminaPeca(inicio[0]-1,inicio[1]-1);
                    return true;
                }
            }   
            ////Verifica se a peça ao lado é oposta e se sua seguite é um espaço vazio
            if((inicio[0]-1)>0 && (inicio[1]+1)<7 && damas.getPecas(inicio[0]-1,inicio[1]+1)!=null && getCor()!= damas.getPecas(inicio[0]-1,inicio[1]+1).getCor() && damas.getPecas(inicio[0]-2,inicio[1]+2)==null){
                //Verifica se a posição esperada foi alcançada
                if(inicio[0]-2 == fim[1] && inicio[1]+2 == fim[0]){
                    damas.eliminaPeca(inicio[0]-1,inicio[1]+1);
                    return true;
                }
            }  
            //Verifica se a peça ao lado é oposta e se sua seguite é um espaço vazio
            if((inicio[0]+1)<7 && (inicio[1]-1)>0 && damas.getPecas(inicio[0]+1,inicio[1]-1)!=null && getCor()!= damas.getPecas(inicio[0]+1,inicio[1]-1).getCor() && damas.getPecas(inicio[0]+2,inicio[1]-2)==null){
                //Verifica se a posição esperada foi alcançada
                if(inicio[0]+2 == fim[1] && inicio[1]-2 == fim[0]){
                    damas.eliminaPeca(inicio[0]+1,inicio[1]-1);
                    return true;
                }
            } 
            //Verifica se a peça ao lado é oposta e se sua seguite é um espaço vazio
            if((inicio[0]+1)<7 && (inicio[1]+1)<7 && damas.getPecas(inicio[0]+1,inicio[1]+1)!=null && getCor()!= damas.getPecas(inicio[0]+1,inicio[1]+1).getCor() && damas.getPecas(inicio[0]+2,inicio[1]+2)==null){
                //Verifica se a posição esperada foi alcançada
                if(inicio[0]+2 == fim[1] && inicio[1]+2 == fim[0]){
                    damas.eliminaPeca(inicio[0]+1,inicio[1]+1);
                    return true;
                }
            }
        }
        return false;
    }
    //Metodo para verificar qual movimento será realizado
    public void movimento(Tabuleiro damas, int[] commands){
        int x2, y2;
        y2 = commands[3];
        x2 = commands[2];
        //Caso que simplesmente avança com a peça sem comer outra
        //Verifica se a posição de destino esta vazia e é vizinha a peça
        if((damas.getPecas(y2, x2)==null) && Math.abs(getX()-x2)==1){
            //Verifica o avanço de acordo com a cor, impede andar para tras
            if((getCor()=='P' && y2-getY()==1)||(getCor()=='B' && getY()-y2==1)){
                damas.setPecas(y2, x2, damas.getPecas(getY(), getX()));
                damas.eliminaPeca(getY(), getX());
                setCoordenada(y2, x2);
            } 
        }
        //Caso geral para comer uma peça
        else{
            int[] inicio = {getY(), getX()};
            int[] fim = {x2, y2};
            //Chama o metodo para verificar se existe um caminho valido
            if(caminhoValido(damas, inicio, fim)){
                damas.setPecas(y2, x2, damas.getPecas(getY(), getX()));
                damas.eliminaPeca(getY(), getX());
                setCoordenada(y2, x2);
            }
            else    
                System.out.println("Movimento Invalido");
        }
    }
}