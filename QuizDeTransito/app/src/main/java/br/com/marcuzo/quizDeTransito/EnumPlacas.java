package br.com.marcuzo.quizDeTransito;

public enum EnumPlacas {

    ACLIVE_ACENTUADO(R.drawable.aclive_acentuado, "B", new String[] {"Advertência Lombada", "Aclive Acentuado", "Animais", "Área Escolar"}),
    ADVERTENCIA_LOMBADA(R.drawable.advertencia_lombada, "D", new String[] {"Áreas de Recreacao Parque de Diversões", "Animais", "Parada Obrigatoria", "Advertência de Lombada"}),
    ANIMAIS(R.drawable.animais, "A", new String[] {"Animais", "Advertência de Lombada", "Áreas de Recreacao Parque de Diversões", "Área Escolar"}),
    AREA_ESCOLAR(R.drawable.area_escolar, "C", new String[] {"Proibido Acionar Buzina ou Sinal Sonoro", "Animais", "Área Escolar", "Animais"}),
    AREAS_DE_RECREACAO_PARQUE_DE_DIVERSOES(R.drawable.areas_de_recreacao_parque_de_diversoes, "C", new String[] {"Conserve-se a Direita", "Advertência Lombada", "Áreas de Recreacao Parque de Diversões", "Proibido Acionar Buzina ou Sinal Sonoro"}),
    CONSERVE_SE_A_DIREITA(R.drawable.conserve_se_a_direita, "B", new String[] {"Advertência de Lombada", "Conserve-se a Direita", "Proibido Acionar Buzina ou Sinal Sonoro", "Animais"}),
    CRUZAMENTO_DE_VIAS(R.drawable.cruzamento_de_vias, "A", new String[] {"Cruzamento de Vias", "Advertência de Lombada", "Área Escolar", "Parada Obrigatória"}),
    DE_PREFERENCIA(R.drawable.de_preferencia, "A", new String[] {"De Preferencia", "Advertência de Lombada", "Área Escolar", "Parada Obrigatória"}),
    ESTACIONAMENTO_REGULAMENTADO(R.drawable.estacionamento_regulamentado, "A", new String[] {"Estacionamento Regulamentado", "Advertência de Lombada", "Área Escolar", "Parada Obrigatória"}),
    PARADA_OBRIGATORIA(R.drawable.parada_obrigatoria, "D", new String[] {"Proibido Acionar Buzina ou Sinal Sonoro", "Advertência de Lombada", "Área Escolar", "Parada Obrigatória"}),
    PLACA_DE_SERVICOS_AUXILIARES_PRONTO_SOCORRO(R.drawable.placa_de_servicos_auxiliares_pronto_socorro, "D", new String[] {"Estacionamento Regulamentado", "Área Escolar", "Proibido Parar e Estacionar", "Placa De Serviços Auxiliares Pronto Socorro"}),
    PLACA_DE_SERVICOS_AUXILIARES_RESTAURANTE(R.drawable.placa_de_servicos_auxiliares_restaurante, "D", new String[] {"Conserve-se a Direita", "Proibido Parar e Estacionar", "Animais", "Placa De Servicos Auxiliares Restaurante"}),
    PROIBIDO_ACIONAR_BUZINA_OU_SINAL_SONORO(R.drawable.proibido_acionar_buzina_ou_sinal_sonoro, "A", new String[] {"Proibido Acionar Buzina ou Sinal Sonoro", "Área Escolar", "Aclive Acentuado", "Advertência de Lombada"}),
    PROIBIDO_PARAR_E_ESTACIONAR(R.drawable.proibido_parar_e_estacionar, "A", new String[] {"Proibido Parar e Estacionar", "Animais", "Aclive Acentuado", "Placa de Serviços Auxiliares Pronto Socorro"}),
    PROIBIDO_RETORNAR_A_ESQUERDA(R.drawable.proibido_retornar_a_esquerda, "B", new String[] {"Proibido Parar e Estacionar", "Proibido Retornar a Esquerda", "Proibido o Transito de Caminhões", "Proibido Retornar a Direita"}),
    PROIBIDO_TRANSITO_DE_CAMINHOES(R.drawable.proibido_transito_de_caminhoes, "A", new String[] {"Proibido o Transito de Caminhões", "Animais", "Aclive Acentuado", "Proibido Parar e Estacionar"}),
    PROIBIDO_TRANSITO_DE_PEDESTRES(R.drawable.proibido_transito_de_pedestres, "C", new String[] {"Conserve-se a Direita", "Animais", "Proibido o Transito de Pedestres", "Placa De Servicos Auxiliares Restaurante"}),
    PROIBIDO_TRANSITO_DE_TRATORES_E_MAQUINAS_DE_OBRAS(R.drawable.proibido_transito_de_tratores_e_maquinas_de_obras, "D", new String[] {"Proibido Retornar a Esquerda", "Animais", "Aclive Acentuado", "Proibido o Transito de Tratores e Maquinas de Obras"}),
    PROIBIDO_TRANSITO_DE_VEICULOS_DE_TRACAO_ANIMAL(R.drawable.proibido_transito_de_veiculos_de_tracao_animal, "D", new String[] {"Permitido Andar a Cavalo", "Animais", "Aclive Acentuado", "Proibido o Transito de Veiculos de Tração Animal"}),
    PROIBIDO_ULTRAPASSAR(R.drawable.proibido_ultrapassar, "A", new String[] {"Proibido Ultrapassar", "Animais", "Proibido o Transito de Caminhões", "Permitido a Ultrapassagem"}),
    SENTIDO_CIRCULAR_NA_ROTA(R.drawable.sentido_circular_na_rota, "A", new String[] {"Sentido Circular na Rota", "Animais", "Proibido o Transito de Pedestres", "Permitido a Ultrapassagem"}),
    SENTIDO_DE_CIRCULACAO_DA_VIA_OU_PISTA(R.drawable.sentido_de_circulacao_da_via_ou_pista, "B", new String[] {"Cruzamento de Vias", "Sentido de Circulação da Via ou Pista", "Proibido o Transito de Pedestres", "Proibido Retornar a Direita"}),
    SENTIDO_PROIBIDO(R.drawable.sentido_proibido, "B", new String[] {"Sentido Permitido", "Sentido Proibido", "Siga em Frente", "Proibido o Transito de Pedestres"}),
    SIGA_EM_FRENTE(R.drawable.siga_em_frente, "B", new String[] {"Cruzamento de Vias", "Siga em Frente", "Aclive Acentuado", "Animais"}),
    SIGA_EM_FRENTE_OU_A_DIREITA(R.drawable.siga_em_frente_ou_a_direita, "C", new String[] {"Proibido Ultrapassar", "Animais", "Siga em Frente ou a Direita", "Placa de Serviços Auxiliares Pronto Socorro"}),
    TRANSITO_PROIBIDO_A_CARROS_DE_MAO(R.drawable.transito_proibido_a_carros_de_mao, "C", new String[] {"Animais", "Proibido o Transito de Pedestres", "Transito Proibido a Carros de Mão", "Animais"}),
    USO_OBRIGATORIO_DE_CORRENTE(R.drawable.uso_obrigatorio_de_corrente, "D", new String[] {"Permitido Usar Pneu", "Proibido o Transito de Pedestres", "Sentido Circular na Rota", "Uso Obrigatorio de Corrente"}),
    VELOCIDADE_MAXIMA_PERMITIDO(R.drawable.velocidade_maxima_permitido, "A", new String[] {"Velocidade Máxima Permitido", "Proibido o Transito de Pedestres", "Proibido Ultrapassar", "Cruzamento de Vias"}),
    VENTO_LATERAL(R.drawable.vento_lateral, "B", new String[] {"Velocidade Máxima Permitido", "Vento Lateral", "Aclive Acentuado", "Proibido o Transito de Pedestres"}),
    VIRE_A_DIREITA(R.drawable.vire_a_direita, "C", new String[] {"Proibido Virar a Esquerda", "Velocidade Máxima Permitido", "Vire a Direita", "Proibido o Transito de Pedestres"}),
    VIRE_A_ESQUERDA(R.drawable.vire_a_esquerda, "C", new String[] {"Proibido Virar a Direita", "Proibido Ultrapassar", "Vire a Esquerda", "Cruzamento de Vias"}),
    ALFANDEGA(R.drawable.alfandega, "A", new String[] {"Alfandega", "Proibido Ultrapassar", "Vire a Esquerda", "Cruzamento de Vias"}),
    ANIMAIS_SELVAGENS(R.drawable.animais_selvagens, "B", new String[] {"Animais na Pista", "Animais Selvagens", "Animais Saltitantes", "Cruzamento de Vias"}),
    COMPRIMENTO_MAXIMO(R.drawable.comprimento_maximo, "B", new String[] {"Cumprimento Mínimo", "Cumprimento Máximo", "Vire a Esquerda", "Cruzamento de Vias"}),
    JUNCOES_SUCESSIVAS_CONTRARIAS_PRIMEIRA_A_DIREITA(R.drawable.juncoes_sucessivas_contrarias_primeira_a_direita, "C", new String[] {"Proibido Virar a Direita", "Proibido Ultrapassar", "Junções Sucessivas Contraria Primeira a Direita", "Cruzamento de Vias"}),
    PASSAGEM_DE_NIVEL_COM_BARREIRA(R.drawable.passagem_de_nivel_com_barreira, "A", new String[] {"Passagem de Nível com Barreira", "Proibido Ultrapassar", "Ponte Móvel", "Cruzamento de Vias"}),
    PESO_MAXIMO_PERMITIDO(R.drawable.peso_maximo_permitido, "B", new String[] {"Proibido Virar a Direita", "Peso Máximo Permitido", "Vire a Esquerda", "Cruzamento de Vias"}),
    PISTA_IRREGULAR(R.drawable.pista_irregular, "C", new String[] {"Proibido Virar a Direita", "Proibido Ultrapassar", "Pista Irregular", "Cruzamento de Vias"}),
    PONTE_MOVEL(R.drawable.ponte_movel, "D", new String[] {"Pista Irregular", "Proibido Ultrapassar", "Vire a Esquerda", "Ponte Móvel"}),
    PROIBIDO_MUDAR_FAIXA_DIREITA_PARA_ESQUERDA(R.drawable.proibido_mudar_de_faixa_ou_pista_de_transito_da_direita_para_esquerda, "D", new String[] {"Proibido Virar a Direita", "Proibido Ultrapassar", "Junções Sucessivas Contraria Primeira a Direita", "Proibido Mudar de Faixa ou Pista de Trânsito da Direita para Esquerda"}),
    PROIBIDO_MUDAR_FAIXA_ESQUERDA_PARA_DIREITA(R.drawable.proibido_mudar_de_faixa_ou_pista_de_transito_da_esquerda_para_direita, "B", new String[] {"Junções Sucessivas Contraria Primeira a Direita", "Proibido Mudar de Faixa ou Pista de Trânsito da Esquerda para Direita", "Vire a Esquerda", "Proibido Mudar de Faixa ou Pista de Trânsito da Direita para Esquerda"});

    private int CodImgPais;
    private String respostaCorreta;
    private String alternativas[];

    EnumPlacas(int CodImgPais, String respostaCorreta, String alternativas[]) {
        this.CodImgPais = CodImgPais;
        this.respostaCorreta = respostaCorreta;
        this.alternativas = alternativas.clone();
    }

    public int getCodImgPais() {
        return CodImgPais;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public String[] getAlternativas() {
        return alternativas;
    }
}
