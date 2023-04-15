package Core;


import io.restassured.http.ContentType;

public interface Const {

    //Definindo a URL base de uma API que será acessada pela nossa aplicação.
    String APP_BASE_URL = "https://reqres.in/api/";

    //É passado um número inteiro para definir a porta usada para acessar a API.
    Integer APP_PORT =443;

    //Essa String define um caminho base para os endpoints da API.
    String APP_BASE_PATH = "";

    //Objeto do tipo ContentType, usado para definir o tipo do conteúdo que será enviado e recebido pela aplicação.
    //Nesse caso, temos um tipo JSON.
    ContentType APP_CONTENT_TYPE = ContentType.JSON;

    //Um número do tipo 'long' que define o tempo de espera para uma resposta da API, em milissegundos.
    // Nesse caso, 9 segundos.
    long MAX_TIMEOUT = 9000L;
}
