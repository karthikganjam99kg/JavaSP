package com.example.demo;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Service;

@Service
public class XMLToJsonService {

	public String convertXmlToJson(String xmlContent) throws IOException {
        // Parse the XML into a JsonNode using XmlMapper
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(xmlContent.getBytes());

        // Convert the JsonNode to JSON using ObjectMapper
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
    }
}
