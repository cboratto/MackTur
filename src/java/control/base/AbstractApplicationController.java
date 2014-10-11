/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.base;

/**
 *
 * @author caioboratto
 */
import javax.servlet.http.HttpServletRequest;

public abstract class AbstractApplicationController implements ApplicationController {

    private HttpServletRequest request;
    protected String returnPage;

    @Override
    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }

    public void setReturnPage(String page) {
        returnPage = page;
    }

    @Override
    public String getReturnPage() {
        return returnPage;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
