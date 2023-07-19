package co.com.bancopichincha.mambu.interactions.servicios.mambu;

import net.serenitybdd.screenplay.Interaction;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CallService {

    private CallService() {
    }

    /**
     * @param resource ruta del recurso a consumir
     */
    public static Interaction restGet(String resource) {
        return instrumented(Get.class, resource);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restGet(String resource, Map<String, String> header) {
        return instrumented(GetWithHeader.class, resource, header);
    }

    /**
     * @param resource ruta del recurso a consumir
     */
    public static Interaction restGetVerification(String resource) {
        return instrumented(GetStatusVerification.class, resource);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restGetVerification(String resource, Map<String, String> header) {
        return instrumented(GetWHStatusVerification.class, resource, header);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     */
    public static Interaction restPost(String resource, Object body) {
        return instrumented(Post.class, resource, body);
    }


	public static Interaction restPost(Object body, Map<String, String> headers) {
		return instrumented(Post.class, body, headers);
	}


    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     */
    public static Interaction restPostVerification(String resource, String body) {
        return instrumented(PostStatusVerification.class, resource, body);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restPost(String resource, Object body, Map<String, String> header) {
        return instrumented(PostWithHeader.class, resource, body, header);
    }


    /**
     * @param resource ruta del recurso a consumir
     * @param formdata List String con los parametros de tipo form Data del servicio a consumir
     * @param header   Map con las cabeceras del recurso a consumir
     */
    public static Interaction restPost(String resource, List<String> formdata, Map<String, String> header) {
        return instrumented(PostWithHeaderAndFormData.class, resource, formdata, header);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     */
    public static Interaction restPut(String resource, Object body) {
        return instrumented(Put.class, resource, body);
    }

    /**
     * @param resource ruta del recurso a consumir
     * @param body     String con el body del servicio a consumir
     * @param headers Map con las cabeceras del servicio a consumir
     */
    public static Interaction restPutWithHeaders(String resource, Object body, Map<String, String> headers) {
        return instrumented(PutWithHeaders.class, resource, body, headers);
    }

    /**
     * @param resource ruta del recurso a consumir
     */
    public static Interaction restDelete(String resource) {
        return instrumented(Delete.class, resource);
    }
}
