package net.oauth2.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CommaDelimitedScopeDeserializer extends JsonDeserializer<Collection<String>>{

	@Override
	public Collection<String> deserialize(JsonParser parser, DeserializationContext ctxt)throws IOException, JsonProcessingException {
		String enumerationStr = parser.getText();
		String[] enumerationArr = enumerationStr.split("\\s*,\\s*");
		Collection<String> enumList = new ArrayList<>(enumerationArr.length);
		for (String entry : enumerationArr) {
			enumList.add(entry.trim());
		}
		Collection<String> list = Collections.unmodifiableCollection(enumList);
		return list;
	}
	
}