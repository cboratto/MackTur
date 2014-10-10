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

public interface ApplicationController {

    public void execute();

    public void init(HttpServletRequest request);

    public String getReturnPage();
}
