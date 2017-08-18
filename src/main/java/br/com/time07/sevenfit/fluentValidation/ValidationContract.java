package br.com.time07.sevenfit.fluentValidation;

import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationContract<T extends Notifiable> {
    private T validatable;

    public ValidationContract(T validatable) {
        this.validatable = validatable;
    }

    public ValidationContract<T> eObrigatorio(String field ,Function<T, String> selector){
        String valor = selector.apply(validatable);

        if(verificarSeStringENulaOuVazia(valor));
        validatable.addNotification(field, mensagemDaNotificacao("Campo %s � obrigatorio", field));

        return this;
    }

    public ValidationContract<T> possuiOTamanhoMinimo(String field, Function<T, String> selector, int minimo){
        String valor = selector.apply(validatable);

        if(!verificarSeStringENulaOuVazia(valor) && valor.length() < minimo) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s n�o pode ter menos que %s caracteres", field, minimo));
        }
        return this;
    }

    public ValidationContract<T> possuiOTamanhoMaximo(String field, Function<T, String> selector, int maximo){
        String valor = selector.apply(validatable);

        if(!verificarSeStringENulaOuVazia(valor) && valor.length() > maximo) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s n�o pode ter mais que %s caracteres", field, maximo));
        }
        return this;
    }

    public ValidationContract<T> eDoTamanhoFixo(String field, Function<T, String> selector, int tamanho){
        String valor = selector.apply(validatable);

        if(!verificarSeStringENulaOuVazia(valor) && valor.length() != tamanho) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ter %s caracteres", field, tamanho));
        }
        return this;
    }

    public ValidationContract<T> eEmail(String field, Function<T, String> selector){
        String valor = selector.apply(validatable);
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";


        if(!verificarSeStringEDeDeterminadoPadrao(regex, valor)) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser uma valor de E-mail valido", field));
        }
        return this;
    }

    public ValidationContract<T> eUrl(String field, Function<T, String> selector){
        String valor = selector.apply(validatable);
        String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        if(!verificarSeStringEDeDeterminadoPadrao(regex, valor)) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser uma valor de URL valido", field));
        }
        return this;
    }

    public ValidationContract<T> eMaiorQue(String field, Function<T, Integer> selector, int number){
        int valor = selector.apply(validatable);

        if(valor < number) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, number));
        }
        return this;
    }

    public ValidationContract<T> eMaiorOuIgualQue(String field, Function<T, Integer> selector, int number){
        int valor = selector.apply(validatable);

        if(valor < number && valor != number) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, number));
        }
        return this;
    }

    public ValidationContract<T> eMaiorQue(String field, Function<T, Double> selector, double number){
        double valor = selector.apply(validatable);

        if(valor < number) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, number));
        }
        return this;
    }

    public ValidationContract<T> eMaiorOuIgualQue(String field, Function<T, Double> selector, double number){
        double valor = selector.apply(validatable);

        if(valor < number && valor != number) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, number));
        }
        return this;
    }

    public ValidationContract<T> eMaiorQue(String field, Function<T, BigDecimal> selector, BigDecimal number){
        BigDecimal valor = selector.apply(validatable);

        if(valor.compareTo(number) < 0) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, number));
        }
        return this;
    }

    public ValidationContract<T> eMaiorOuIgualQue(String field, Function<T, BigDecimal> selector, BigDecimal number){
        BigDecimal valor = selector.apply(validatable);

        if(valor.compareTo(number) < 0 && valor.compareTo(number) == 0) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, number));
        }
        return this;
    }

    public ValidationContract<T> eMaiorQue(String field, Function<T, Date> selector, Date date){
        Date valor = selector.apply(validatable);

        if(valor.compareTo(date) < 0) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, formatarData(date, "dd/MM/yyyy")));
        }
        return this;
    }

    public ValidationContract<T> eMaiorOuIgualQue(String field, Function<T, Date> selector, Date date){
        Date valor = selector.apply(validatable);

        if(valor.compareTo(date) < 0 && valor.compareTo(date) == 0) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, formatarData(date, "dd/MM/yyyy")));
        }
        return this;
    }

    public ValidationContract<T> eMaiorQue(String field, Function<T, Calendar> selector, Calendar date){
        Calendar valor = selector.apply(validatable);

        if(valor.compareTo(date) < 0) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, formatarData(date, "dd/MM/yyyy")));
        }
        return this;
    }

    public ValidationContract<T> eMaiorOuIgualQue(String field, Function<T, Calendar> selector, Calendar date){
        Calendar valor = selector.apply(validatable);

        if(valor.compareTo(date) < 0 && valor.compareTo(date) == 0) {
            validatable.addNotification(field, mensagemDaNotificacao("Campo %s deve ser maior que %s", field, formatarData(date, "dd/MM/yyyy")));
        }
        return this;
    }

    private boolean verificarSeStringENulaOuVazia(String valor) {
        return valor == null || valor.isEmpty();
    }

    private String mensagemDaNotificacao(String mensagem, Object ...args) {
        return String.format(mensagem, args);
    }

    private boolean verificarSeStringEDeDeterminadoPadrao(String regex, String valor) {
        Pattern patter = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = patter.matcher(valor);
        return matcher.find();
    }

    private String formatarData(Object data, String format) {
        Format formatador = new SimpleDateFormat(format);
        return formatador.format(data);
    }
}
