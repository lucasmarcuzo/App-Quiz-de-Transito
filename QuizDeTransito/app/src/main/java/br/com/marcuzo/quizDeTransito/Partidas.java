package br.com.marcuzo.quizDeTransito;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class Partidas implements Serializable {

    private String nomeJogador;
    private int pontuacao;

    public Partidas(String nomeJogador, int pontuacao) {
        this.nomeJogador = nomeJogador;
        this.pontuacao = pontuacao;
    }

    ArrayList<Integer> idPlacas;
    EnumSet[] paises;

    public ArrayList<Integer> gerarOrdemPerguntas() {
        Random random = new Random();
        this.idPlacas = new ArrayList<>();
        for(int i = 0; i < 40; i++) {
            int num = 1 + random.nextInt(40);
            if(this.idPlacas.contains(num)) {
                i--;
            } else {
                this.idPlacas.add(num);
            }
        }
        return this.idPlacas;
    }

    public EnumPlacas retornarPlacas(int idPlacas) {
            switch(idPlacas){
                case 1:
                   return EnumPlacas.ACLIVE_ACENTUADO;
                case 2:
                    return EnumPlacas.ADVERTENCIA_LOMBADA;
                case 3:
                    return EnumPlacas.ANIMAIS;
                case 4:
                    return EnumPlacas.AREA_ESCOLAR;
                case 5:
                    return EnumPlacas.AREAS_DE_RECREACAO_PARQUE_DE_DIVERSOES;
                case 6:
                    return EnumPlacas.CONSERVE_SE_A_DIREITA;
                case 7:
                    return EnumPlacas.PARADA_OBRIGATORIA;
                case 8:
                    return EnumPlacas.PLACA_DE_SERVICOS_AUXILIARES_PRONTO_SOCORRO;
                case 9:
                    return EnumPlacas.PROIBIDO_ACIONAR_BUZINA_OU_SINAL_SONORO;
                case 10:
                    return EnumPlacas.PROIBIDO_PARAR_E_ESTACIONAR;
                case 11:
                    return EnumPlacas.CRUZAMENTO_DE_VIAS;
                case 12:
                    return EnumPlacas.DE_PREFERENCIA;
                case 13:
                    return EnumPlacas.ESTACIONAMENTO_REGULAMENTADO;
                case 14:
                    return EnumPlacas.PROIBIDO_RETORNAR_A_ESQUERDA;
                case 15:
                    return EnumPlacas.PROIBIDO_TRANSITO_DE_CAMINHOES;
                case 16:
                    return EnumPlacas.PROIBIDO_TRANSITO_DE_PEDESTRES;
                case 17:
                    return EnumPlacas.PROIBIDO_TRANSITO_DE_TRATORES_E_MAQUINAS_DE_OBRAS;
                case 18:
                    return EnumPlacas.PROIBIDO_TRANSITO_DE_VEICULOS_DE_TRACAO_ANIMAL;
                case 19:
                    return EnumPlacas.PROIBIDO_ULTRAPASSAR;
                case 20:
                    return EnumPlacas.SENTIDO_CIRCULAR_NA_ROTA;
                case 21:
                    return EnumPlacas.SENTIDO_DE_CIRCULACAO_DA_VIA_OU_PISTA;
                case 22:
                    return EnumPlacas.SENTIDO_PROIBIDO;
                case 23:
                    return EnumPlacas.SIGA_EM_FRENTE;
                case 24:
                    return EnumPlacas.SIGA_EM_FRENTE_OU_A_DIREITA;
                case 25:
                    return EnumPlacas.TRANSITO_PROIBIDO_A_CARROS_DE_MAO;
                case 26:
                    return EnumPlacas.USO_OBRIGATORIO_DE_CORRENTE;
                case 27:
                    return EnumPlacas.VELOCIDADE_MAXIMA_PERMITIDO;
                case 28:
                    return EnumPlacas.VENTO_LATERAL;
                case 29:
                    return EnumPlacas.VIRE_A_DIREITA;
                case 30:
                    return EnumPlacas.VIRE_A_ESQUERDA;
                case 31:
                    return EnumPlacas.ALFANDEGA;
                case 32:
                    return EnumPlacas.ANIMAIS_SELVAGENS;
                case 33:
                    return EnumPlacas.COMPRIMENTO_MAXIMO;
                case 34:
                    return EnumPlacas.JUNCOES_SUCESSIVAS_CONTRARIAS_PRIMEIRA_A_DIREITA;
                case 35:
                    return EnumPlacas.PASSAGEM_DE_NIVEL_COM_BARREIRA;
                case 36:
                    return EnumPlacas.PESO_MAXIMO_PERMITIDO;
                case 37:
                    return EnumPlacas.PISTA_IRREGULAR;
                case 38:
                    return EnumPlacas.PONTE_MOVEL;
                case 39:
                    return EnumPlacas.PROIBIDO_MUDAR_FAIXA_DIREITA_PARA_ESQUERDA;
                case 40:
                    return EnumPlacas.PROIBIDO_MUDAR_FAIXA_ESQUERDA_PARA_DIREITA;
            }
        return null;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
