package com.moi.passPhrasePolicy;

import net.sf.json.JSONObject;

public class LengthPolicyConfiguration implements IPolicyConfiguration {
  private String policyCode;
  private JSONObject configuration;

  public String getPolicyCode() {
    return policyCode;
  }

  public void setPolicyCode(String policyCode) {
    this.policyCode = policyCode;
    System.out.println("hello");
  }
  
  public JSONObject getConfiguration() {
    return configuration;
  }

  public void setConfiguration(JSONObject configuration) {
    this.configuration = configuration;
  }
}
