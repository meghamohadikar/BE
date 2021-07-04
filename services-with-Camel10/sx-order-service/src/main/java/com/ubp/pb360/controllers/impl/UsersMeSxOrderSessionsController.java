package com.ubp.pb360.controllers.impl;

import com.backbase.ubp.pb360.rest.spec.v1.users.me.sxordersessions.SxOrderSessionApi;
import com.backbase.ubp.pb360.rest.spec.v1.users.me.sxordersessions.SxOrderSessionGetResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import static java.util.stream.Collectors.joining;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.client.RestTemplate;

@RestController
public class UsersMeSxOrderSessionsController implements SxOrderSessionApi {
    private static final Logger logger = LoggerFactory.getLogger(SxOrderSessionsController.class);

    public static final String ERROR_ON_WRITING_REQUEST_BODY = "Error on writing request body";
    public static final String ERROR_ON_PARSING_RESPONSE_BODY = "Error on parsing response body";
    private static final String ERROR_ON_CALLING_ENDPOINT = "Error on calling the endpoint";

    private  RestTemplate template;

    @Value("${pms-url}")
    private String pmsUrl;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public UsersMeSxOrderSessionsController() {
       template=template();
    }

    /**
     * @param status
     * @param httpServletRequest
     * @param httpServletResponse
     * @return object SxOrderSessionGetResponseBody
     */
    @Override
    public List<SxOrderSessionGetResponseBody> getSxOrderSession(@RequestParam String status, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("within UsersMeSxOrderSessionsController getSxOrderSession");
        List<SxOrderSessionGetResponseBody> sxOrderSessionGetResponseBody = new ArrayList<>();
        Map<String, String> queryParams = new WeakHashMap<>();
        queryParams.put("status", status);
        String queryParamsString = queryParams.entrySet().stream().map(Object::toString).collect(joining("&"));

        try {
            String response = template.getForObject(pmsUrl+"/users/me/sxordersessions?"+queryParamsString,String.class);
            sxOrderSessionGetResponseBody = mapper.readValue(response, new TypeReference<List<SxOrderSessionGetResponseBody>>(){});
        } catch (IOException ioException) {
            logger.error(ERROR_ON_PARSING_RESPONSE_BODY, ioException);
        }catch (Exception Exception) {
            logger.error(ERROR_ON_CALLING_ENDPOINT, Exception);
        }
        return sxOrderSessionGetResponseBody;
    }

    public RestTemplate template(){
        return new RestTemplate();
    }
}
