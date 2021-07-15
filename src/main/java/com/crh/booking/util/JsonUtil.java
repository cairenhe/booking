package com.crh.booking.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static final ObjectMapper mapper = new ObjectMapper();
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String EMPTY_JSON = "{}";
    public static final byte[] EMPTY_JSON_BYTES = new byte[] {'{','}'};

    static {
        mapper.setSerializationInclusion(Inclusion.NON_EMPTY); //null和空字符串不参与序列化
        mapper.getSerializationConfig().withDateFormat(new SimpleDateFormat(DATE_FORMAT));
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, false);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * json转对象
     *
     * @param jsonStr   json串
     * @param classType 对象类型
     * @return 对象
     */
    public static <T> T fromJson(String jsonStr, Class<T> classType) {

        if (StringUtil.isEmpty(jsonStr)) {
            return null;
        }

        try {
            return mapper.readValue(jsonStr, classType);
        } catch (IOException e) {
            logger.error("failed to parse object from json.");
            return null;
        }
    }


    /**
     * 对象转json
     *
     * @param obj 对象
     * @return json串
     */
    public static String toJson(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (IOException e) {
            logger.error("failed to parse to json.");
            return null;
        }

    }

}

