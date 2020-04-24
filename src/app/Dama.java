//subClasse para representar damas
package app;

public class Dama extends Pecas{
    //Construtor para Damas
    Dama(char cor, int y, int x){
        super(cor, y, x);
        //Altera a representação da peça recebida de acordo com sua cor
        if(cor=='B' && y==0)
            setRepresenta('C');
        if(cor=='P' && y==7)
            setRepresenta('Q');

    }
    //Metodos para dama 
    //Verifica se existe um caminho valido para alcançar a posição final recebida partindo da peça acessada
    boolean caminhoValido(Tabuleiro damas, int[] inicio, int[] fim){
        int i=1;
        int j=0;
        //Verifica se a posição inicial passada pertence ao tabuleiro
        if(inicio[0]<8 && inicio[1]<8 && inicio[0]>=0 && inicio[1]>=0){
            //Cria caminho ate uma possivel peça que possa ser comida
            while((inicio[0]+i)<7 && (inicio[1]+i)<7 && damas.getPecas(inicio[0]+i, inicio[1]+i)==null){
                i++;
            }
            //Verifica se a peça encontrada e difente dessa, se o caminho não acabou fora do tabuleiro ou se não ha duas peças juntas
            if((inicio[0]+i)<7 && (inicio[1]+i)<7 && damas.getPecas(inicio[0]+i,inicio[1]+i)!= null && getCor()!= damas.getPecas(inicio[0]+i,inicio[1]+i).getCor() && damas.getPecas(inicio[0]+i+1,inicio[1]+i+1)==null){
                int[] inicionovo = {inicio[0]+i+1,inicio[1]+i+1};
                //Novo laço procurando as possiveis posições de parada da peça
                while(damas.getPecas(inicionovo[0]+j, inicionovo[1]+j)==null){
                    //Verifica se a posição de parada atual bate com a posição final recebida
                    if(inicionovo[0]+j == fim[1] && inicionovo[1]+j == fim[0]){
                        //Elimina a unica peça no capinho percorrido
                        damas.eliminaPeca(inicio[0]+i,inicio[1]+i);
                        return true;
                    }
                    j++;
                    //Encerra laço quanto os valores saem do tabuleiro
                    if((inicionovo[0]+j)>7 || (inicionovo[1]+j)>7)
                        break;
                }
            }
            i = 1;
            j=0;
            //Cria caminho ate uma possivel peça que possa ser comida
            while((inicio[0]-i)>0 && (inicio[1]-i)>0 && damas.getPecas(inicio[0]-i, inicio[1]-i)==null){
                i++;
            }
            //Verifica se a peça encontrada e difente dessa, se o caminho não acabou fora do tabuleiro ou se não ha duas peças juntas
            if((inicio[0]-i)>0 && (inicio[1]-i)>0 && damas.getPecas(inicio[0]-i,inicio[1]-i)!= null && getCor()!= damas.getPecas(inicio[0]-i,inicio[1]-i).getCor() && damas.getPecas(inicio[0]-i-1,inicio[1]-i-1)==null){
                int[] inicionovo = {inicio[0]-i-1,inicio[1]-i-1};
                //Novo laço procurando as possiveis posições de parada da peça
                while(damas.getPecas(inicionovo[0]-j, inicionovo[1]-j)==null){
                    //Verifica se a posição de parada atual bate com a posição final recebida
                    if(inicionovo[0]-j == fim[1] && inicionovo[1]-j == fim[0]){
                        //Elimina a unica peça no capinho percorrido
                        damas.eliminaPeca(inicio[0]-i,inicio[1]-i);
                        return true;
                    }
                    j++;
                    //Encerra laço quanto os valores saem do tabuleiro
                    if((inicionovo[0]+j)<0|| (inicionovo[1]+j)<0)
                        break;
                }
            }
            i=1;
            j=0;
            //Cria caminho ate uma possivel peça que possa ser comida
            while((inicio[0]+i)<7 && (inicio[1]-i)>0 && damas.getPecas(inicio[0]+i, inicio[1]-i)==null){
                i++;
            }
            //Verifica se a peça encontrada e difente dessa, se o caminho não acabou fora do tabuleiro ou se não ha duas peças juntas
            if((inicio[0]+i)<7 && (inicio[1]-i)>0 && damas.getPecas(inicio[0]+i,inicio[1]-i)!= null && getCor()!= damas.getPecas(inicio[0]+i,inicio[1]-i).getCor() && damas.getPecas(inicio[0]+i+1,inicio[1]-i-1)==null){
                int[] inicionovo = {inicio[0]+i+1,inicio[1]-i-1};
                //Novo laço procurando as possiveis posições de parada da peça
                while(damas.getPecas(inicionovo[0]+j, inicionovo[1]-j)==null){
                    //Verifica se a posição de parada atual bate com a posição final recebida
                    if(inicionovo[0]+j == fim[1] && inicionovo[1]-j == fim[0]){
                        //Elimina a unica peça no capinho percorrido
                        damas.eliminaPeca(inicio[0]+i,inicio[1]-i);
                        return true;
                    }
                    j++;
                    //Encerra laço quanto os valores saem do tabuleiro
                    if((inicionovo[0]+j)>7 || (inicionovo[1]+j)<0)
                        break;
                } 
            }
            i=1;
            j=0;
            //Cria caminho ate uma possivel peça que possa ser comida
            while((inicio[0]-i)>0 && (inicio[1]+i)<7 && damas.getPecas(inicio[0]-i, inicio[1]+i)==null){
                i++;
            }
            //Verifica se a peça encontrada e difente dessa, se o caminho não acabou fora do tabuleiro ou se não ha duas peças juntas
            if((inicio[0]-i)>0 && (inicio[1]+i)<7 && damas.getPecas(inicio[0]-i,inicio[1]+i)!= null && getCor()!= damas.getPecas(inicio[0]-i,inicio[1]+i).getCor() && damas.getPecas(inicio[0]-i-1,inicio[1]+i+1)==null){
                int[] inicionovo = {(inicio[0]-i-1),(inicio[1]+i+1)};
                //Novo laço procurando as possiveis posições de parada da peça           
                while(damas.getPecas(inicionovo[0]-j, inicionovo[1]+j)==null){
                    //Verifica se a posição de parada atual bate com a posição final recebida                    
                    if(inicionovo[0]-j == fim[1] && inicionovo[1]+j == fim[0]){
                        //Elimina a unica peça no capinho percorrido
                        damas.eliminaPeca(inicio[0]-i,inicio[1]+i);
                        return true;
                    }
                    j++;
                    //Encerra laço quanto os valores saem do tabuleiro
                    if((inicionovo[0]+j)<0 || (inicionovo[1]+j)>7)
                        break;
                }
            }
        }
        return false;
    }
    //Metodo para verificar qual movimento será realizado
    public void movimento(Tabuleiro damas, int[] commands){
        //Caso que simplesmente avança com a peça sem comer outra
        boolean permite = true;
        int x2, y2;
        y2 = commands[3];
        x2 = commands[2];
        //Verifica em qual diagonal se encontra a posição final e inicial
        if(getX()+getY()==x2+y2){
            if(x2>getX()){
                for(int i=1;i<=(Math.abs(x2-getX())) && permite;i++){
                    if (damas.getPecas(getY()-i, getX()+i)!=null)
                        permite = false;
                }
            }
            else{
                for(int i=1;i<=(Math.abs(x2-getX())) && permite;i++){
                    if (damas.getPecas(getY()+i, getX()-i)!=null)
                        permite = false;
                }
            }
            if(permite){
                damas.setPecas(y2, x2, damas.getPecas(getY(), getX()));
                damas.eliminaPeca(getY(), getX());
                setCoordenada(y2, x2);
            }
        }
        //Verifica em qual diagonal se encontra a posição final e inicial
        else if(getY()-getX()==y2-x2){
            if(x2>getX()){
                for(int i=1;i<=(Math.abs(x2-getX())) && permite;i++){
                    if (damas.getPecas(getY()+i, getX()+i)!=null)
                        permite = false;
                }
            }
            else{
                for(int i=1;i<=(Math.abs(x2-getX())) && permite;i++){
                    if (damas.getPecas(getY()-i, getX()-i)!=null){
                        permite = false;
                    }
                }
            }
            if(permite){
                damas.setPecas(y2, x2, damas.getPecas(getY(), getX()));
                damas.eliminaPeca(getY(), getX());
                setCoordenada(y2, x2);
            }
        }
        //Quanto a peça come alguma peça
        else
            permite=false;
        //Caso geral para comer uma peça
        if(!permite){
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