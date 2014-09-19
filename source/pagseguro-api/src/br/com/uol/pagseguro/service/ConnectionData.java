/*
 ************************************************************************
 Copyright [2011] [PagSeguro Internet Ltda.]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ************************************************************************
 */
package br.com.uol.pagseguro.service;

import br.com.uol.pagseguro.domain.Credentials;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.helper.PagSeguroUtil;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.properties.PagSeguroSystem;

public class ConnectionData {

    private Credentials credentials;

    private String webServiceUrl;

    private String wsPaymentRequestUrl;

    private String wsPaymentRequestFindByCodeUrl;

    private String wsPreApprovalUrl;

    private String wsPreApprovalFindByCodeUrl;

    private String wsPreApprovalCancelByCodeUrl;

    private String paymentSessionUrl;

    private String installmentsUrl;

    private String directPayment;

    private String paymentMethodsUrl;

    private String checkoutServicePath;

    private String serviceTimeout;

    private String charset;

    public ConnectionData(Credentials credentials) {
        this.credentials = credentials;

        this.webServiceUrl = validUrlWebService();
        this.wsPaymentRequestUrl = validUrlWSPaymentRequest();
        this.wsPaymentRequestFindByCodeUrl = validUrlWSPaymentRequestFindByCode();
        this.wsPreApprovalUrl = validUrlWSPreApproval();
        this.wsPreApprovalFindByCodeUrl = validUrlWSPreApprovalFindByCode();
        this.wsPreApprovalCancelByCodeUrl = validUrlWSPreApprovalCancelByCode();
        this.charset = PagSeguroConfig.getApplicationCharset();
        this.serviceTimeout = PagSeguroSystem.getServiceTimeout();

        this.paymentSessionUrl = PagSeguroSystem.getUrlPaymentSession();
        this.installmentsUrl = PagSeguroSystem.getUrlInstallments();
        this.directPayment = PagSeguroSystem.getUrlDirectPayment();
        this.paymentMethodsUrl = PagSeguroSystem.getUrlPaymentMethods();

        this.checkoutServicePath = PagSeguroSystem.getCheckoutServicePath();
    }

    /**
     * Get Service Url
     * 
     * @return string
     */
    public String getServiceUrl() {
        return this.getWebServiceUrl() + this.getServicePath();
    }

    /**
     * Get Payment Session Url
     * 
     * @return string
     */
    public String getPaymentSessionUrl() {
        return this.paymentSessionUrl;
    }

    /**
     * Get Installments Url
     * 
     * @return string
     */
    public String getInstallmentsUrl() {
        return this.installmentsUrl;
    }

    /**
     * Get Direct Payment Url
     * 
     * @return string
     */
    public String getDirectPaymentUrl() {
        return this.directPayment;
    }

    /**
     * @return the paymentMethodsUrl
     */
    public String getPaymentMethodsUrl() {
        return paymentMethodsUrl;
    }

    /**
     * Create url
     * 
     * @return string
     * @throws PagSeguroServiceException
     */
    public String getCredentialsUrlQuery() throws PagSeguroServiceException {
        return PagSeguroUtil.urlQuery(this.getCredentials().getAttributes());
    }

    /**
     * Valid url web service production or development
     * 
     * @return string
     */
    private String validUrlWebService() {

        String url = PagSeguroSystem.getUrlProduction();

        return url + PagSeguroSystem.getCheckoutServicePath();

    }

    /**
     * Valid url web service production or development for payment request
     * 
     * @return string
     */
    private String validUrlWSPaymentRequest() {
        return PagSeguroSystem.getUrlProduction() + PagSeguroSystem.getPaymentRequestServicePath();
    }

    /**
     * Valid url web service production or development for finding a payment request transaction
     * 
     * @return string
     */
    private String validUrlWSPaymentRequestFindByCode() {
        return PagSeguroSystem.getUrlProduction() + PagSeguroSystem.getPaymentRequestFindByCodePath();
    }

    /**
     * Valid url web service production or development for pre-approval
     * 
     * @return string
     */
    private String validUrlWSPreApproval() {
        return PagSeguroSystem.getUrlProduction() + PagSeguroSystem.getPreApprovalServicePath();
    }

    /**
     * Valid url web service production or development for finding a pre-approval transaction
     * 
     * @return string
     */
    private String validUrlWSPreApprovalFindByCode() {
        return PagSeguroSystem.getUrlProduction() + PagSeguroSystem.getPreApprovalFindByCodePath();
    }

    /**
     * Valid url web service production or development for canceling a pre-approval transaction
     * 
     * @return string
     */
    private String validUrlWSPreApprovalCancelByCode() {
        return PagSeguroSystem.getUrlProduction() + PagSeguroSystem.getPreApprovalCancelByCodePath();
    }

    /**
     * @return the credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * @param credentials
     *            the credentials to set
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * @return the webServiceUrl
     */
    public String getWebServiceUrl() {
        return webServiceUrl;
    }

    /**
     * @return the wsPaymentRequestUrl
     */
    public String getWSPaymentRequestUrl() {
        return wsPaymentRequestUrl;
    }

    /**
     * @return the wsPaymentRequestFindByCodeUrl
     */
    public String getWSPaymentRequestFindByCodeUrl() {
        return wsPaymentRequestFindByCodeUrl;
    }

    /**
     * @return the wsPreApprovalUrl
     */
    public String getWSPreApprovalUrl() {
        return wsPreApprovalUrl;
    }

    /**
     * @return the wsPreApprovalFindByCodeUrl
     */
    public String getWSPreApprovalFindByCodeUrl() {
        return wsPreApprovalFindByCodeUrl;
    }

    /**
     * @return the wsPreApprovalCancelByCodeUrl
     */
    public String getWSPreApprovalCancelByCodeUrl() {
        return wsPreApprovalCancelByCodeUrl;
    }

    /**
     * @param webServiceUrl
     *            the webServiceUrl to set
     */
    public void setWebServiceUrl(String webServiceUrl) {
        this.webServiceUrl = webServiceUrl;
    }

    /**
     * @param wsPaymentRequestFindByCodeUrl
     *            the wsPaymentRequestFindByCodeUrl to set
     */
    public void setWSPaymentRequestFindByCodeUrl(String wsPaymentRequestFindByCodeUrl) {
        this.wsPaymentRequestFindByCodeUrl = wsPaymentRequestFindByCodeUrl;
    }

    /**
     * @param wsPaymentRequestUrl
     *            the wsPaymentRequestUrl to set
     */
    public void setWSPaymentRequestUrl(String wsPaymentRequestUrl) {
        this.wsPaymentRequestUrl = wsPaymentRequestUrl;
    }

    /**
     * @param wsPreApprovalUrl
     *            the wsPreApprovalUrl to set
     */
    public void setWSPreApprovalUrl(String wsPreApprovalUrl) {
        this.wsPreApprovalUrl = wsPreApprovalUrl;
    }

    /**
     * @return the charset
     */
    public String getCharset() {
        return charset;
    }

    /**
     * @param charset
     *            the charset to set
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * @return the servicePath
     */
    public String getServicePath() {
        return checkoutServicePath;
    }

    /**
     * @param servicePath
     *            the servicePath to set
     */
    public void setServicePath(String servicePath) {
        this.checkoutServicePath = servicePath;
    }

    /**
     * @return the serviceTimeout
     */
    public String getServiceTimeout() {
        return serviceTimeout;
    }

    /**
     * @param serviceTimeout
     *            the serviceTimeout to set
     */
    public void setServiceTimeout(String serviceTimeout) {
        this.serviceTimeout = serviceTimeout;
    }

    public String getCheckoutUrl() {
        return PagSeguroSystem.getCheckoutUrl();
    }

    public String getTransactionSearchUrl() {
        return PagSeguroSystem.getTransactionSearchUrl();
    }
}
