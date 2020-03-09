package com.passPhrasePolicy;

import java.util.HashMap;
import java.util.Map;

public class AppParamUtil {
  private static Map<String, String> policyMap = new HashMap<String, String>();

  static {
    policyMap.put("MIN_LENGTH",
        "{\"enabled\": \"true\",\"length\": \"80\",Ópasswordmeasure\":[{ \"characterlength\": \"0 to 1\", \"regex\": \" regexPattern \" },{ \"characterlength\": \"0 to 1\", \"regex\": \"regexPattern\" }]}}");
  }

  public String getValue(String key) {
    return policyMap.get(key);
  }

}
