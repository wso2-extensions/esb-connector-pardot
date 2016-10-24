/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.connector.integration.test.pardot;

import org.apache.axiom.om.OMElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.connector.integration.test.base.ConnectorIntegrationTestBase;
import org.wso2.connector.integration.test.base.RestResponse;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Sample integration test
 */
public class PardotConnectorIntegrationTest extends ConnectorIntegrationTestBase {

    private Map<String, String> esbRequestHeadersMap = new HashMap<String, String>();
    private Map<String, String> apiRequestHeadersMap = new HashMap<String, String>();

    @BeforeClass(alwaysRun = true)
    public void setEnvironment() throws Exception {
        init("pardot-connector-1.0.0");
        esbRequestHeadersMap.put("Accept-Charset", "UTF-8");
        esbRequestHeadersMap.put("Content-Type", "application/xml");
    }

    /**
     * Positive test case for createCompany method with mandatory parameters.
     */
    @Test(priority = 1, description = "Pardot {getUsers} integration test with mandatory parameters.")
    public void testgetUsersWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getUsers");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getUsers_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for createCompany method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetUsersWithMandatoryParameters"}, description = "Pardot {getUsers} integration test with optional parameters.")
    public void testgetUsersWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getUsers");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getUsers_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getCampaigns method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetUsersWithOptionalParameters"}, description = "Pardot {getCampaigns} integration test with mandatory parameters.")
    public void testgetCampaignsWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getCampaigns");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getCampaigns_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getCampaigns method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetCampaignsWithMandatoryParameters"}, description = "Pardot {getCampaigns} integration test with optional parameters.")
    public void testgetCampaignsWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getCampaigns");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getCampaigns_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getEmailClicks method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetCampaignsWithOptionalParameters"}, description = "Pardot {getEmailClicks} integration test with mandatory parameters.")
    public void testgetEmailClicksWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getEmailClicks");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getEmailClicks_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getEmailClicks method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetEmailClicksWithMandatoryParameters"}, description = "Pardot {getEmailClicks} integration test with optional parameters.")
    public void testgetEmailClicksWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getEmailClicks");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getEmailClicks_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getForms method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetEmailClicksWithOptionalParameters"}, description = "Pardot {getForms} integration test with mandatory parameters.")
    public void testgetFormsWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getForms");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getForms_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getForms method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetFormsWithMandatoryParameters"}, description = "Pardot {getForms} integration test with optional parameters.")
    public void testgetFormsWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getForms");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getForms_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getLifecycleHistories method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetFormsWithOptionalParameters"}, description = "Pardot {getLifecycleHistories} integration test with mandatory parameters.")
    public void testgetLifecycleHistoriesWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getLifecycleHistories");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getLifecycleHistories_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getLifecycleHistories method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetLifecycleHistoriesWithMandatoryParameters"}, description = "Pardot {getLifecycleHistories} integration test with optional parameters.")
    public void testgetLifecycleHistoriesWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getLifecycleHistories");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getLifecycleHistories_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getLifecycleStages method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetLifecycleHistoriesWithOptionalParameters"}, description = "Pardot {getLifecycleStages} integration test with mandatory parameters.")
    public void testgetLifecycleStagesWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getLifecycleStages");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getLifecycleStages_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getLifecycleStages method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetLifecycleStagesWithMandatoryParameters"}, description = "Pardot {getLifecycleStages} integration test with optional parameters.")
    public void testgetLifecycleStagesWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getLifecycleStages");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getLifecycleStages_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getLists method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetLifecycleStagesWithOptionalParameters"}, description = "Pardot {getLists} integration test with mandatory parameters.")
    public void testgetListsWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getLists");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getLists_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getLists method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetListsWithMandatoryParameters"}, description = "Pardot {getLists} integration test with optional parameters.")
    public void testgetListsWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getLists");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getLists_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getOpportunities method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetListsWithOptionalParameters"}, description = "Pardot {getOpportunities} integration test with mandatory parameters.")
    public void testgetOpportunitiesWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getOpportunities");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getOpportunities_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getOpportunities method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetOpportunitiesWithMandatoryParameters"}, description = "Pardot {getOpportunities} integration test with optional parameters.")
    public void testgetOpportunitiesWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getOpportunities");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getOpportunities_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getProspectAccounts method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetOpportunitiesWithOptionalParameters"}, description = "Pardot {getProspectAccounts} integration test with mandatory parameters.")
    public void testgetProspectAccountsWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getProspectAccounts");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getProspectAccounts_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getLists method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetProspectAccountsWithMandatoryParameters"}, description = "Pardot {getProspectAccounts} integration test with optional parameters.")
    public void testgetProspectAccountsWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getProspectAccounts");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getProspectAccounts_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getProspects method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetProspectAccountsWithOptionalParameters"}, description = "Pardot {getProspects} integration test with mandatory parameters.")
    public void testgetProspectsWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getProspects");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getProspects_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getProspects method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetProspectsWithMandatoryParameters"}, description = "Pardot {getProspects} integration test with optional parameters.")
    public void testgetProspectsWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getProspects");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getProspects_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }




    /**
     * Positive test case for getTags method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetProspectsWithOptionalParameters"}, description = "Pardot {getTags} integration test with mandatory parameters.")
    public void testgetTagsWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getTags");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getTags_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getTags method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetTagsWithMandatoryParameters"}, description = "Pardot {getTags} integration test with optional parameters.")
    public void testgetTagsWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getTags");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getTags_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getVisitorActivities method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetTagsWithOptionalParameters"}, description = "Pardot {getVisitorActivities} integration test with mandatory parameters.")
    public void testgetVisitorActivitiesWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getVisitorActivities");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getVisitorActivities_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getVisitorActivities method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetVisitorActivitiesWithMandatoryParameters"}, description = "Pardot {getVisitorActivities} integration test with optional parameters.")
    public void testgetVisitorActivitiesWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getVisitorActivities");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getVisitorActivities_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getVisitors method with mandatory parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetVisitorActivitiesWithOptionalParameters"}, description = "Pardot {getVisitors} integration test with mandatory parameters.")
    public void testgetVisitorsWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getVisitors");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getVisitors_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getVisitors method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetVisitorsWithMandatoryParameters"}, description = "Pardot {getVisitors} integration test with optional parameters.")
    public void testgetVisitorsWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getVisitors");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getVisitors_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getVisits method with mandatory parameters.
     */
    @Test(priority = 1,dependsOnMethods = {"testgetVisitorsWithOptionalParameters"},  description = "Pardot {getVisits} integration test with mandatory parameters.")
    public void testgetVisitsWithMandatoryParameters() throws Exception {

        esbRequestHeadersMap.put("Action", "urn:getVisits");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getVisits_mandatory.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

    /**
     * Positive test case for getVisits method with optional parameters.
     */
    @Test(priority = 1, dependsOnMethods = {"testgetVisitsWithMandatoryParameters"}, description = "Pardot {getVisits} integration test with optional parameters.")
    public void testgetVisitsWithOptionalParameters() throws Exception {

        String action = esbRequestHeadersMap.put("Action", "urn:getVisits");
        RestResponse<OMElement> esbRestResponse = sendXmlRestRequest(proxyUrl, "POST", esbRequestHeadersMap, "esb_getVisits_optional.xml");
        assertEquals(esbRestResponse.getHttpStatusCode(), 200);
        Assert.assertTrue(Integer.parseInt(getValueByExpression("//total_results", esbRestResponse.getBody())) > 0);
        Assert.assertEquals("ok", getValueByExpression("//rsp/@stat", esbRestResponse.getBody()));
    }

}
