/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.virgo.server;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.X509TrustManager;


/**
 *
 * @author pramoth
 */
public class MyEmptyX509TrustManager implements X509TrustManager {

    private X509Certificate[] xcs;

    @Override
    public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        this.xcs = xcs;
        Logger.getLogger(MyEmptyX509TrustManager.class.getName()).log(Level.INFO, "checkClientTrusted");

    }

    @Override
    public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        this.xcs = xcs;
        Logger.getLogger(MyEmptyX509TrustManager.class.getName()).log(Level.INFO, "checkServerTrusted");
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {

        Logger.getLogger(MyEmptyX509TrustManager.class.getName()).log(Level.INFO, "getAcceptedIssuers");
        return null;
    }

}
