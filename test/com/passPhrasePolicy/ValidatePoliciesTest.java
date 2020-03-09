package com.passPhrasePolicy;

import java.util.List;
import junit.framework.TestCase;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.passPhrasePolicy.IResponse;
import com.passPhrasePolicy.IResponseCode;
import com.passPhrasePolicy.IValidatePolicies;
import com.passPhrasePolicy.PassPhrasePolicyHelper;
import com.passPhrasePolicy.ValidatePolicies;

@RunWith(JUnit4.class)
public class ValidatePoliciesTest extends TestCase {

	@Test
	public void testValidateLengthPolicy() throws Exception {
		IValidatePolicies vp = new ValidatePolicies();

		// --------------- CASE 1: Minimum length requirement fail ---------------
		PassPhrasePolicyHelper policyHelper = new PassPhrasePolicyHelper();
		List<? extends IResponse> responses = vp.validatePassPhrasePolicies("1234",
				policyHelper.getAllConfiguredPolicies());
		if (CollectionUtils.isNotEmpty(responses)) {
			for (IResponse response : responses) {
				System.out
						.println("Code: " + response.getResponseCode() + ", Message: " + response.getResponseMessage());
				assertTrue(IResponseCode.ERR_LENGTH_POLICY_FAIL.equals(response.getResponseCode()));
			}
		}

		// --------------- CASE 2: Minimum length requirement pass ---------------
		responses = vp.validatePassPhrasePolicies("12345678", policyHelper.getAllConfiguredPolicies());
		if (CollectionUtils.isNotEmpty(responses)) {
			for (IResponse response : responses) {
				System.out
						.println("Code: " + response.getResponseCode() + ", Message: " + response.getResponseMessage());
				assertTrue(IResponseCode.SUCCESS.equals(response.getResponseCode()));
			}
		}
	}
}
