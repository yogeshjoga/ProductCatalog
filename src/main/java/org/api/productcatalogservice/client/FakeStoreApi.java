package org.api.productcatalogservice.client;



import org.api.productcatalogservice.dto.RequestProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Component
public class FakeStoreApi {

    @Autowired
    private RestTemplateBuilder builder;

    private <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request,
                                               Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate template = builder.build();
        RequestCallback requestCallback = template.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = template.responseEntityExtractor(responseType);
        return template.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public RequestProductDto validateResposeEntity(ResponseEntity<RequestProductDto> responseEntity){
        if(responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null){
            return responseEntity.getBody();
        }
        return null;
    }


    /**
     * Retrieves product details from an external API based on the given product ID.
     *
     * @param id the unique identifier of the product to be retrieved
     * @return a {@code RequestProductDto} object containing the product details, or {@code null} if the response
     *         is not successful or does not contain a body
     */

    public RequestProductDto getProductById(Long id){
        ResponseEntity<RequestProductDto> responseEntity = requestForEntity("https://fakestoreapi.com/products/{id}", HttpMethod.GET, null, RequestProductDto.class,id);
        return validateResposeEntity(responseEntity);
    }


}
