package com.passPhrasePolicy;


public class PassPhrasePolicyFactory {
  private static final PassPhrasePolicyFactory factory = new PassPhrasePolicyFactory();

  protected PassPhrasePolicyFactory() {}

  public static PassPhrasePolicyFactory getInstance() {
    return factory;
  }

  public IPassPhrasePolicy getPasswordPolicy(String policyClassName) throws Exception {
    IPassPhrasePolicy passwordpolicy = null;
    try {
      if (!policyClassName.equalsIgnoreCase(null)) {
        Class<?> cls = Class.forName(policyClassName);
        passwordpolicy = (IPassPhrasePolicy) cls.newInstance();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return passwordpolicy;
  }
}
