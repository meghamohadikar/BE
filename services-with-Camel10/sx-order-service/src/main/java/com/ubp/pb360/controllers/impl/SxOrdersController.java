package com.ubp.pb360.controllers.impl;

import com.backbase.ubp.pb360.rest.spec.v1.sxorders.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class SxOrdersController implements SXOrdersApi {

    private static final Logger logger = LoggerFactory.getLogger(SxOrdersController.class);
    private static final String ERROR_ON_PARSING_RESPONSE_BODY = "Error on parsing response body";
    private static final String ERROR_ON_CALLING_ENDPOINT = "Error on calling the endpoint";

    private  RestTemplate template;

    @Value("${pms-url}")
    private String pmsUrl;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public SxOrdersController(){
        template=template();
    }

    /**
     * Controller for /sxorders/remove endpoint
     *
     * @param removePostRequestBody
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @Override
    public RemovePostResponseBody postRemove(@RequestBody RemovePostRequestBody removePostRequestBody, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.error("delete SXOrders controller");

        RemovePostResponseBody responseBody = new RemovePostResponseBody();

        try {
            String response = template.postForObject(pmsUrl+"/sxorders/remove",removePostRequestBody,String.class);
            responseBody = mapper.readValue(response, new TypeReference<RemovePostResponseBody>(){});
        } catch (IOException ioException) {
            logger.error(ERROR_ON_PARSING_RESPONSE_BODY, ioException);
        } catch (Exception Exception) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, Exception);
        }

        return responseBody;
    }



    /**
     * Controller for /sxorders/cancel endpoint
     *
     * @param cancelPostRequestBody
     * @param httpServletRequest
     * @param httpServletResponse
     * @return object CancelPatchResponseBody
     */
    @Override
    public CancelPostResponseBody postCancel(@RequestBody @Valid CancelPostRequestBody cancelPostRequestBody, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.error("delete postCancel controller");
        CancelPostResponseBody responseBody = new CancelPostResponseBody();
        try {
            ResponseEntity<CancelPostResponseBody> response = template.postForEntity(pmsUrl+"/sxorders/cancel",cancelPostRequestBody,CancelPostResponseBody.class);
            responseBody = response.getBody();
        } catch (Exception Exception) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, Exception);
        }
        return responseBody;
    }

    /**
     * Controller for /sxorders/complete endpoint
     *
     * @param completePutRequestBody
     * @param httpServletRequest
     * @param httpServletResponse
     * @return object SxorderidcancelPostResponseBody
     */
    @Override
    public CompletePutResponseBody putComplete(@RequestBody @Valid CompletePutRequestBody completePutRequestBody, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("within putComplete controller");
        HttpEntity<CompletePutRequestBody> httpEntity= new HttpEntity<>(completePutRequestBody);

        CompletePutResponseBody responseBody = null;
        try {
           ResponseEntity<CompletePutResponseBody> response = template.exchange(pmsUrl+"/sxorders/complete", HttpMethod.PUT,httpEntity, CompletePutResponseBody.class);
            responseBody=response.getBody();
           } catch (Exception Exception) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, Exception);
        }
        return responseBody;
    }

    public RestTemplate template(){
        return new RestTemplate();
    }
}

