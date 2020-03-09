package com.passPhrasePolicy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.collections.MapUtils;

import net.sf.json.JSONObject;

public class PassPhrasePolicyHelper {
  private Map<String, String> registeredPolicies = new HashMap<String, String>();

  // Read the Policies from Policy.properties and register them to the Map.
  public Map<String, String> getAvailablePolicies() throws Exception {
    if (MapUtils.isEmpty(registeredPolicies)) {
      Properties prop = new Properties();
      FileInputStream inputStream = new FileInputStream(new File("Policy.properties"));
      // InputStream inputStream =
      // this.getClass().getClassLoader().getResourceAsStream("Policy.properties");
      if (!inputStream.equals(null))
        try {
          prop.load(inputStream);
        } catch (IOException e) {

        }
      Set<Object> keySet = prop.keySet();
      for (Object obj : keySet) {
        registeredPolicies.put((String) obj, prop.getProperty((String) obj));
      }

    }
    return registeredPolicies;
  }

  public List<IPolicyConfiguration> getAllConfiguredPolicies() {
    List<IPolicyConfiguration> pcs = new ArrayList<IPolicyConfiguration>();
    LengthPolicyConfiguration lpc = new LengthPolicyConfiguration();
    lpc.setPolicyCode("MIN_LENGTH");
    String s = "{\"minLength\":\"8\"}";
    JSONObject jObject = JSONObject.fromObject(s);
    lpc.setConfiguration(jObject);
    pcs.add(lpc);
    return pcs;
  }
}
