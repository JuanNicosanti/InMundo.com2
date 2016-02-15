package xtrest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class JSONPropertyUtils {
  public String getPropertyValue(final String json, final String property) {
    try {
      String _xblockexpression = null;
      {
        ObjectMapper _objectMapper = new ObjectMapper();
        final Object properties = _objectMapper.<Object>readValue(json, 
          new TypeReference<HashMap<String, String>>() {
          });
        _xblockexpression = ((Map<String, String>) properties).get(property);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
