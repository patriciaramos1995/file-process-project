package com.file.reader.fileProcessProject.utils;

/**
 * Classe responsavel por catalogar as mensagens de retorno ao usuario final
 *
 * @author patriciaramos1995
 * date: 15/12/2020 16:57
 */
public abstract class MessagesUtils {

    public static final String MESSAGE_ERROR_CREATE_FILE = "Ocorreu um erro ao criar seu arquivo. Descrição: {}";
    public static final String MESSAGE_ERROR_READ = "Ocorreu um erro ao processar seu arquivo. Descrição: {}";
    public static final String MESSAGE_EXTENSION_INVALID_UPLOAD = "Extensão do arquivo inválida";
    public static final String MESSAGE_FOLDER_EMPTY = "Pasta vazia ou inexistente";
    public static final String MESSAGE_TEXT_NOT_MATCH_CATEGORY = "O texto não se encaixa nas categorias disponíveis. Texto: {}";
}
