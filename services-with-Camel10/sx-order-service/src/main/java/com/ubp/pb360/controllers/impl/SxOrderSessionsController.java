package com.ubp.pb360.controllers.impl;

import com.backbase.ubp.pb360.rest.spec.v1.sxordersessions.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.json.simple.JsonObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;

@RestController
public class SxOrderSessionsController implements SXOrderSessionsApi {

    private static final Logger logger = LoggerFactory.getLogger(SxOrderSessionsController.class);
    private static final String ERROR_ON_PARSING_RESPONSE_BODY = "Error on parsing response body";
    private static final String ERROR_ON_WRITING_REQUEST_BODY = "Error on writing request body";
    private static final String ERROR_ON_CALLING_ENDPOINT = "Error on calling the endpoint";

    private  RestTemplate template;

    @Value("${pms-url}")
    private String pmsUrl;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public SxOrderSessionsController() {
        template=template();
    }

    /**
     * Controller for /sxordersessions/init endpoint
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return object InitPostResponseBody
     */
    @Override
    public InitPostResponseBody postInit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("sxOrderSessions INIT controller");
        InitPostResponseBody responseBody = null;

        try {
            String portfolioCode = httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity entity = new HttpEntity(portfolioCode,headers);

          //  KerberosRestTemplate  restTemplate=createKerberosRestTemplate(httpServletRequest);

            ResponseEntity<InitPostResponseBody> out = template.exchange(pmsUrl+"/sxordersessions/init", HttpMethod.POST, entity
                    , InitPostResponseBody.class);

            responseBody=out.getBody();
        } catch (IOException ioException) {
            logger.error(ERROR_ON_PARSING_RESPONSE_BODY, ioException);
        }catch (Exception Exception) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, Exception);
        }

        return responseBody;
    }

    /**
     * Controller for /sxordersessions/control endpoint
     *
     * @param controlPutRequestBody
     * @param httpServletRequest
     * @param httpServletResponse
     * @return object CompletePostResponseBody
     */
    @Override
    public ControlPutResponseBody putControl(@RequestBody @Valid ControlPutRequestBody controlPutRequestBody, @PathVariable("sxOrderSessionId") String sxOrderSessionId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("sxOrderSessions CONTROL controller");
        ControlPutResponseBody responseBody = null;

        Map<String, Object> headers = new WeakHashMap<>();
        headers.put("sxOrderSessionId", sxOrderSessionId);
        HttpEntity<ControlPutRequestBody> httpEntity = new HttpEntity<>(controlPutRequestBody);

        try {
            HttpEntity<ControlPutResponseBody> response =template.exchange(pmsUrl+"/sxordersessions/"+sxOrderSessionId+"/control", HttpMethod.PUT,httpEntity,ControlPutResponseBody.class);
            responseBody=response.getBody();
        } catch (Exception Exception) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, Exception);
        }

        return responseBody;
    }

    /**
     * Controller for /sxordersessions/remove endpoint
     *
     * @param removePostRequestBody
     * @param httpServletRequest
     * @param httpServletResponse
     * @return object RemovePostResponseBody
     */
    @Override
    public RemovePostResponseBody postRemove(@RequestBody @Valid RemovePostRequestBody removePostRequestBody, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("Delete Sx Order Session");
        RemovePostResponseBody responseBody = null;

        try {
            ResponseEntity<RemovePostResponseBody> response =template.postForEntity(pmsUrl+"/sxordersessions/remove",removePostRequestBody,RemovePostResponseBody.class);
            responseBody=response.getBody();
        } catch (Exception Exception) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, Exception);
        }

        return responseBody;
    }

    /**
     * Controller for /sxordersessions/{sxOrderSessionId}/sxorders/init endpoint
     *
     * @param sxOrderSessionId
     * @param instrumentCode
     * @param portfolioCode
     * @param httpServletRequest
     * @param httpServletResponse
     * @return object SxordersinitPostResponseBody
     */
    @Override
    public SxordersinitPostResponseBody postSxordersinit(@PathVariable("sxOrderSessionId") String sxOrderSessionId, @RequestParam(value = "instrumentCode", required = true) String instrumentCode, @RequestParam(value = "portfolioCode", required = true) String portfolioCode, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("sxOrder INIT controller");
        SxordersinitPostResponseBody responseBody = new SxordersinitPostResponseBody();
        Map<String, String> queryParams = new WeakHashMap<>();
        queryParams.put("instrumentCode", instrumentCode);
        queryParams.put("portfolioCode", portfolioCode);
        String queryParamsString = queryParams.entrySet().stream()
                .filter(header -> StringUtils.isNotBlank(header.getValue()))
                .map(Object::toString)
                .collect(joining("&"));

        Map<String, Object> headers = new WeakHashMap<>();
        headers.put(Exchange.HTTP_QUERY, queryParamsString);
        headers.put("sxOrderSessionId", sxOrderSessionId);

        try {
            //String response = template.postForObject(pmsUrl+"/sxordersessions/"+sxOrderSessionId+"/sxorders/init?"+queryParamsString,String.class);

            ///responseBody = mapper.readValue(response, SxordersinitPostResponseBody.class);
            ResponseEntity<SxordersinitPostResponseBody> response =template.postForEntity(pmsUrl+"/sxordersessions/"+sxOrderSessionId+"/sxorders/init?"+queryParamsString,null,SxordersinitPostResponseBody.class);
            responseBody=response.getBody();
        } catch (Exception Exception) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, Exception);
        }

        return responseBody;
    }

    /**
     * Controller for /sxordersessions/{sxOrderSessionId}/execute endpoint
     *
     * @param sxOrderSessionId
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @Override
    public void postExecute(@PathVariable("sxOrderSessionId") String sxOrderSessionId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("postExecute controller");

        Map<String, Object> headers = new WeakHashMap<>();
        headers.put("sxOrderSessionId", sxOrderSessionId);

        try {
            String response = template.getForObject(pmsUrl + "sxordersessions/" + sxOrderSessionId + "/execute", String.class);
            JsonObject responseEntity = mapper.readValue(response, JsonObject.class);
        } catch (Exception e) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, e);
        }
    }

    /**
     * Controller for /sxordersessions/{sxOrderSessionId}/warning endpoint
     *
     * @param sxOrderSessionId
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @Override
    public WarningsGetResponseBody getWarnings(@PathVariable("sxOrderSessionId") String sxOrderSessionId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("getWarnings controller");

        WarningsGetResponseBody responseBody = new WarningsGetResponseBody();
        Map<String, Object> headers = new WeakHashMap<>();
        headers.put("sxOrderSessionId", sxOrderSessionId);

            ResponseEntity<WarningsGetResponseBody> response = template.getForEntity(pmsUrl+"/sxordersessions/"+sxOrderSessionId+"/warnings",WarningsGetResponseBody.class);
            responseBody=response.getBody();

        return responseBody;
    }

    /**
     * Controller for /sxordersessions/{sxOrderSessionId}/warning/clarify endpoint
     *
     * @param warning
     * @param sxOrderSessionId
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @Override
    public ClarifyPostResponseBody postClarify(@RequestBody List<Warning> warning, String sxOrderSessionId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("postClarify controller");
        ClarifyPostResponseBody responseBody = new ClarifyPostResponseBody();
        System.out.println("warning=="+warning);
        try {

            ResponseEntity<ClarifyPostResponseBody> response = template.postForEntity(pmsUrl+"/sxordersessions/"+sxOrderSessionId+"/warnings/clarify",warning,ClarifyPostResponseBody.class);
            responseBody=response.getBody();
        } catch (Exception Exception) {
            logger.error(ERROR_ON_PARSING_RESPONSE_BODY, Exception);
        }
        return responseBody;
    }



    /**
     * Controller for /sxordersessions/{sxOrderSessionId} endpoint with POST method
     *
     * @param sxOrderSessionIdPostRequestBody
     * @param sxOrderSessionId
     * @param httpServletRequest
     * @param httpServletResponse
     */
    @Override
    public SxOrderSessionIdPostResponseBody postSxOrderSessionId(@RequestBody @Valid SxOrderSessionIdPostRequestBody sxOrderSessionIdPostRequestBody, @PathVariable("sxOrderSessionId") String sxOrderSessionId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("postSxOrderSessionId controller");

        SxOrderSessionIdPostResponseBody responseBody = new SxOrderSessionIdPostResponseBody();
        Map<String, Object> headers = new WeakHashMap<>();
        headers.put("sxOrderSessionId", sxOrderSessionId);

        try {
            ResponseEntity<SxOrderSessionIdPostResponseBody> response = template.postForEntity(pmsUrl+"/sxordersessions/"+sxOrderSessionId,sxOrderSessionIdPostRequestBody,SxOrderSessionIdPostResponseBody.class);
                    //requestBodyAndHeaders(SxOrderSessionsRoute.DIRECT_SX_ORDER_POST, mapper.writeValueAsString(sxOrderSessionIdPostRequestBody), headers, String.class);
           // responseBody = mapper.readValue(response, SxOrderSessionIdPostResponseBody.class);
            responseBody=response.getBody();
        } catch (Exception ioException) {
            logger.error(ERROR_ON_PARSING_RESPONSE_BODY, ioException);
        }
        return responseBody;
    }

    public RestTemplate template(){
        return new RestTemplate();
    }
}
