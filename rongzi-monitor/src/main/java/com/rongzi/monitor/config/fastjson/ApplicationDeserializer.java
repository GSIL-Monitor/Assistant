package com.rongzi.monitor.config.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import de.codecentric.boot.admin.model.Application;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * 使用 Fastjson 自定义 Application 类的反序列化
 *
 * @author liujunwei
 * @date 2018-10-15 13:56
 */
public class ApplicationDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        JSONObject node = (JSONObject) parser.parse();
        Application.Builder builder = Application.create(node.get("name").toString());
        if (node.containsKey("url")) {
            String url = node.get("url").toString();
            builder.withHealthUrl(url.replaceFirst("/+$", "") + "/health").withManagementUrl(url);
        } else {
            if (node.containsKey("healthUrl")) {
                builder.withHealthUrl(node.get("healthUrl").toString());
            }

            if (node.containsKey("managementUrl")) {
                builder.withManagementUrl(node.get("managementUrl").toString());
            }

            if (node.containsKey("serviceUrl")) {
                builder.withServiceUrl(node.get("serviceUrl").toString());
            }
        }

        if (node.containsKey("metadata")) {
            JSONObject map = (JSONObject) node.get("metadata");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                builder.addMetadata(entry.getKey(), entry.getValue().toString());
            }
        }

        return (T) builder.build();
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
